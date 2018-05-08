package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void save() throws SQLException {
        User u = new User();
        u.setLoginName("admin");
        u.setPassword("123456");
        u.setNickName("管理员");
        UserDao dao = new UserDaoImpl();
        dao.save(u);
    }
}