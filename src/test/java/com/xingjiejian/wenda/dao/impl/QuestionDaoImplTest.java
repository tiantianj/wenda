package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.QuestionDao;
import com.xingjiejian.wenda.exception.DaoException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionDaoImplTest {
    private QuestionDao dao;

    @Before
    public void before(){
        dao = new QuestionDaoImpl();
    }

    @Test
    public void getById() throws DaoException {
        System.out.println(dao.getById(1));
    }

    @Test
    public void testGetCount() throws DaoException {
        assertEquals(1,dao.getCount());
    }
}