package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.DaoException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDaoTest extends BaseDao<User> {

    @Test
    public void testUniqueResult() throws DaoException {
        String sql = "SELECT COUNT(1) FROM user";
        System.out.println(super.uniqueResult(sql));
    }
}