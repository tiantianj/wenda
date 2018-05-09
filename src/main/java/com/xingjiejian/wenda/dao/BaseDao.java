package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 * 持久化操作基类
 * @author Xing.Jiejian
 */
public abstract class BaseDao {
    //日志类
    private final static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    /**
     * 通用的新增操作
     * @param o
     * @param sql
     * @param params
     */
    public void save(Object o,String sql,Object...params){
        try {
            QueryRunner qr = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            int count = qr.update(conn,sql,params);
            BigInteger answerId = qr.query(conn,"select last_insert_id()", new ScalarHandler<BigInteger>(1));
            logger.debug("新增" + count + "条"+o.getClass().getSimpleName()+"数据=>Id："+answerId);
        } catch (SQLException e) {
            logger.error("插入"+o+"失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    /**
     * 通用的修改方法
     * @param o
     * @param sql
     * @param params
     */
    public void update(Object o,String sql,Object...params){
        try{
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,params);
            logger.debug("更新"+count+"条数据=>"+o);
        }catch (SQLException e){
            logger.error("修改"+o+"失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    /**
     * TODO
     * 通用的根据主键删除数据操作
     * @param sql
     * @param id
     */
    public void deleteById(String sql,int id) {

        try {
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,id);
            logger.debug("删除"+count+"条user数据，id=>"+id);
        } catch (SQLException e) {
            logger.error("删除id为"+id+"的user失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }
}