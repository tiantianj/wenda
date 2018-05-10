package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.AnswerDao;
import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.entity.Answer;
import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 * 问题持久化操作实现类
 */
public class AnswerDaoImpl extends BaseDao<Answer> implements AnswerDao {
    private final static Logger logger = LoggerFactory.getLogger(AnswerDaoImpl.class);

    @Override
    public void save(Answer answer) {
        String sql = "INSERT INTO answer(content,userid,questionid,time) VALUES(?,?,?,?)";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId(),answer.getTime()};
        super.save(sql,params);
    }

    @Override
    public void update(Answer answer) {
        String sql = "UPDATE answer SET content=?,userid=?,questionid=?,time=? WHERE id=?";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId(),answer.getTime(),answer.getId()};
       super.update(sql,params);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM answer WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public Answer getAnswer(int id) {
        String sql = "SELECT id,content,userid,questionid,time FROM answer WHERE id=?";
        return super.getById(sql,id);
    }
}
