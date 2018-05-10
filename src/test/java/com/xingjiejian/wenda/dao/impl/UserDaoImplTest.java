package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.DaoException;
import com.xingjiejian.wenda.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDao dao;


    @Before
    public void before(){
        dao = new UserDaoImpl();
    }


    @Test
    public void save() throws DaoException {
        User u = new User();
        u.setLoginName("admin");
        u.setPassword("123456");
        u.setNickName("管理员");

        dao.save(u);
    }

    @Test
    public void getById() throws DaoException {
        User user = dao.getUser(1);
        assertEquals("admin",user.getLoginName());
    }

    @Test
    public void testFindUsers() throws DaoException {
        List<User> users = dao.findUsers();
        for (User u:
             users) {
            System.out.println(u);
        }
    }

}