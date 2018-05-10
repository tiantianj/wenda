package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 用户数据库操作
 * @author Xing.Jiejian
 */
public interface UserDao {
    /**
     * 新增用户
     * @param u
     * @return
     */
    void save(User u) throws DaoException;

    /**
     * 修改用户信息
     * @param u
     */
    void update(User u) throws DaoException;

    /**
     * 根据Id删除用户
     * @param id
     */
    void deleteById(int id) throws DaoException;

    /**
     * 根据编号查询用户
     * @param id
     * @return
     */
    User getUser(int id) throws DaoException;

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    User getUser(String loginName) throws DaoException;

    /**
     * 查询所有的用户
     * @return
     */
    List<User> findUsers() throws DaoException;

}
