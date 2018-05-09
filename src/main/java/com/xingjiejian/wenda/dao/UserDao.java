package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.User;

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
    void save(User u);

    /**
     * 修改用户信息
     * @param u
     */
    void update(User u);

    /**
     * 根据Id删除用户
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据编号查询用户
     * @param id
     * @return
     */
    User getUser(int id);

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    User getUser(String loginName);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> findUsers();

}
