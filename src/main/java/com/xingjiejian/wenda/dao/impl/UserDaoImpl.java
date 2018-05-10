package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.DaoException;
import org.slf4j.Logger;

import java.util.List;

/**
 * 用户数据库操作实现类
 *
 * @author Xing.Jiejian
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public void save(User u) throws DaoException {
        String sql = "INSERT INTO user(loginName,nickName,password,icon,email,phone,introduction) VALUES(?,?,?,?,?,?,?)";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction()};
        super.save(sql,params);
    }

    @Override
    public void update(User u) throws DaoException {
        String sql = "UPDATE user SET loginName=?,nickName=?,password=?,icon=?,email=?,phone=?,introduction=? WHERE " +
                "id=?";
        Object[] params = {u.getLoginName(),u.getNickName(),u.getPassword(),u.getIcon(),u.getEmail(),u.getPhone(),u
                .getIntroduction(),u.getId()};
        super.update(sql,params);
    }

    @Override
    public void deleteById(int id) throws DaoException{
        String sql = "DELETE FROM user WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public User getUser(int id) throws DaoException{
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user WHERE id=?";
        return super.getById(sql,id);
    }

    @Override
    public User getUser(String loginName) throws DaoException{
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user WHERE loginName=?";
        List<User> users = super.find(sql,loginName);
        if(users!=null&&users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> findUsers() throws DaoException{
        String sql = "SELECT id,loginName,nickName,password,icon,email,phone,introduction FROM user";
        return super.find(sql);
    }
}
