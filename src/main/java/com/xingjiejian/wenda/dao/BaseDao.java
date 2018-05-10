package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 * 持久化操作基类
 * @author Xing.Jiejian
 */
public abstract class BaseDao<T> {
    //日志类
    private final static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    //当前类的泛型类型
    private Class clazz;


    public BaseDao(){
        clazz = (Class)((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /**
     * 通用的新增操作
     * @param sql
     * @param params
     */
    public void save(String sql,Object...params){
        try {
            QueryRunner qr = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            int count = qr.update(conn,sql,params);
            BigInteger id = qr.query(conn,"select last_insert_id()", new ScalarHandler<BigInteger>(1));
            logger.debug("新增" + count + "条数据=>Id："+id);
        } catch (SQLException e) {
            logger.error("新增失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    /**
     * 通用的修改方法
     * @param sql
     * @param params
     */
    public void update(String sql,Object...params){
        try{
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,params);
            logger.debug("更新"+count+"条数据");
        }catch (SQLException e){
            logger.error("更新失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    /**
     * 通用的根据主键删除数据操作
     * @param sql
     * @param id
     */
    public void deleteById(String sql,int id) {
        try {
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,id);
            logger.debug("删除"+count+"条数据，id=>"+id);
        } catch (SQLException e) {
            logger.error("删除失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    /**
     * 根据id查询对象
     * @param sql
     * @param id
     * @return
     */
    public T getById(String sql,int id){
        T t = null;
        try {
            t = new QueryRunner().query(JdbcUtils.getConnection(),sql, new BeanHandler<T>(clazz),id);
            logger.debug("查询对象成功："+t);
        } catch (SQLException e) {
            logger.error("查询失败");
            logger.error(LogUtils.getStackTrace(e));
        }
        return t;
    }
}
