package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * 用户数据库操作实现类
 *
 * @author
 */
public class UserDaoImpl implements UserDao {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void save(User u) {
        String sql = "INSERT INTO user(loginName,nickName,password,icon,email,phone,introduction) VALUES(?,?,?,?,?,?,?)";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction()};
        try {
            QueryRunner qr = JdbcUtils.getQueryRuner();
            int count = qr.update(sql,params);
            BigInteger userId = qr.query("select last_insert_id()", new ScalarHandler<BigInteger>(1));
            logger.debug("新增" + count + "条User数据=>Id："+userId);
        } catch (SQLException e) {
            logger.error("插入"+u+"失败");
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE user SET loginName=?,nickName=?,password=?,icon=?,email=?,phone=?,introduction=? WHERE " +
                "id=?";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction(),u.getId()};
        try{
            int count = JdbcUtils.getQueryRuner().update(sql,params);
            logger.debug("更新"+count+"条数据=>"+u);
        }catch (SQLException e){
            logger.error("修改"+u+"失败");
            logger.error(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        //TODO
    }

    @Override
    public User getUser(int id) {
        //TODO
        return null;
    }

    @Override
    public User getUser(String loginName) {
        //TODO
        return null;
    }
}
