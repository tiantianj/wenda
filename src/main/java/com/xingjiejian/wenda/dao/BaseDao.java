package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.exception.DaoException;
import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 * 持久化操作基类
 * @author Xing.Jiejian
 */
public abstract class BaseDao<T> {

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
    public BigInteger save(String sql,Object...params) throws DaoException {
        try {
            QueryRunner qr = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            int count = qr.update(conn,sql,params);
            return qr.query(conn,"select last_insert_id()", new ScalarHandler<BigInteger>(1));
        } catch (SQLException e) {
            throw new DaoException("插入数据失败",e);
        }
    }

    /**
     * 通用的修改方法
     * @param sql
     * @param params
     */
    public void update(String sql,Object...params) throws DaoException {
        try{
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,params);
        }catch (SQLException e){
            throw new DaoException("修改数据失败",e);
        }
    }

    /**
     * 通用的根据主键删除数据操作
     * @param sql
     * @param id
     */
    public void deleteById(String sql,int id) throws DaoException {
        try {
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,id);
        } catch (SQLException e) {
            throw new DaoException("根据主键删除数据失败",e);
        }
    }

    /**
     * 根据id查询对象
     * @param sql
     * @param id
     * @return
     */
    public T getById(String sql,int id) throws DaoException {
        T t = null;
        try {
            t = new QueryRunner().query(JdbcUtils.getConnection(),sql, new BeanHandler<T>(clazz),id);
        } catch (SQLException e) {
            throw new DaoException("根据Id查询对象失败",e);
        }
        return t;
    }

    /**
     * 带条件查询集合
     * @param sql
     * @param params
     * @return
     */
    public List<T> find(String sql,Object...params) throws DaoException {
        List<T> ts = null;
        try {
            ts = new QueryRunner().query(JdbcUtils.getConnection(),sql, new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new DaoException("带条件查询集合失败",e);
        }
        return ts;
    }

    /**
     * 获取唯一结果集查询
     * @param sql
     * @param params
     * @return
     * @throws DaoException
     */
    public Object uniqueResult(String sql,Object...params) throws DaoException{
        Object result = null;
        try {
            result = new QueryRunner().query(JdbcUtils.getConnection(),sql,new ScalarHandler(),params);
        }catch (SQLException e){
            throw new DaoException(e);
        }
        return result;
    }

    /**
     * 获取分页偏移量
     * @param pageNo
     * @param pageSize
     * @return
     */
    public int getOffset(int pageNo,int pageSize){
        return (pageNo-1)*pageSize;
    }


}
