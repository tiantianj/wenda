package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 用户数据库操作实现类
 *
 * @author
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void save(User u) {
        String sql = "INSERT INTO user(loginName,nickName,password,icon,email,phone,introduction) VALUES(?,?,?,?,?,?,?)";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction()};
        super.save(sql,params);
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE user SET loginName=?,nickName=?,password=?,icon=?,email=?,phone=?,introduction=? WHERE " +
                "id=?";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction(),u.getId()};
        super.update(sql,params);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public User getUser(int id) {
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user WHERE id=?";
        return super.getById(sql,id);
    }

    @Override
    public User getUser(String loginName) {
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user WHERE loginName=?";
        User user = null;
        try {
            user = new QueryRunner().query(JdbcUtils.getConnection(),sql, new BeanHandler<User>(User.class),loginName);
            logger.debug("根据登录名查询用户成功："+user);
        } catch (SQLException e) {
            logger.error("查询loginName为"+loginName+"的user失败");
            logger.error(LogUtils.getStackTrace(e));
        }
        return user;
    }

    @Override
    public List<User> findUsers() {
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user";
        List<User> users = null;
        try {
            users = new QueryRunner().query(JdbcUtils.getConnection(),sql, new BeanListHandler<User>(User.class));
            logger.debug("查询所有用户成功，查询数量=>"+users.size());
        } catch (SQLException e) {
            logger.error("查询所有用户失败");
            logger.error(LogUtils.getStackTrace(e));
        }
        return users;
    }
}
