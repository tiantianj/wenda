package com.xingjiejian.wenda.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * 使用ThreadLocal类保证线程安全以及启用事务操作
 *
 * 注：ThreadLocal使用场合主要解决多线程中数据因并发产生不一致问题（解决线程安全）。
 * ThreadLocal为每个线程中并发访问的数据提供一个独立副本，副本之间相互独立(独立操作),
 * 这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。
 * 通过访问副本来运行业务，这样的结果是耗费了内存，单大大减少了线程同步所带来性能消耗，也减少了线程并发控制的复杂度。
 *
 * （ThreadLocal和Synchonized都用于解决多线程并发访问，
 * synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。
 * 而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，
 * 这样就隔离了多个线程对数据的数据共享）
 *
 * Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。
 *
 * @author Xing.Jiejian
 */
public class JdbcUtils {
    //日志对象
    private final static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);

    private static DataSource dataSource;

    //使用ThreadLocal存储当前线程中的Connection对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //在静态代码块中创建数据库连接池
    static {
        try {
            //通过读取C3P0的xml配置文件创建数据源，C3P0的xml配置文件c3p0-config.xml必须放在Java源代码根目录下
            dataSource = new ComboPooledDataSource();
        }catch (Exception e){
            logger.error("数据源初始化失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }


    /**
     * 从数据源中获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        //从当前线程中获取Connection
        Connection conn = threadLocal.get();

        if(conn==null){
            //从数据源中获取数据库连接
            conn = getDataSource().getConnection();
            //将conn绑定到当前线程
            threadLocal.set(conn);
        }
        return conn;
    }

    /**
     * 开启事务
     */
    public static void startTransaction(){
        try{
            Connection conn =  threadLocal.get();
            if(conn==null){
                conn = getConnection();
                //把 conn绑定到当前线程上
                threadLocal.set(conn);
            }
            //开启事务
            conn.setAutoCommit(false);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback(){
        try{
            //从当前线程中获取Connection
            Connection conn = threadLocal.get();
            if(conn!=null){
                //回滚事务
                conn.rollback();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 提交事务
     */
    public static void commit(){
        try{
            //从当前线程中获取Connection
            Connection conn = threadLocal.get();
            if(conn!=null){
                //提交事务
                conn.commit();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库连接(注意，并不是真的关闭，而是把连接还给数据库连接池)
     */
    public static void close(){
        try{
            //从当前线程中获取Connection
            Connection conn = threadLocal.get();
            if(conn!=null){
                conn.close();
                //解除当前线程上绑定conn
                threadLocal.remove();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static DataSource getDataSource() {
        return dataSource;
    }

}
