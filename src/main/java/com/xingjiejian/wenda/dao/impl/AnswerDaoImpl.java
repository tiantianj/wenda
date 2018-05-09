package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.AnswerDao;
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
public class AnswerDaoImpl implements AnswerDao {
    private final static Logger logger = LoggerFactory.getLogger(AnswerDaoImpl.class);

    @Override
    public void save(Answer answer) {
        String sql = "INSERT INTO answer(content,userid,questionid,time) VALUES(?,?,?,?)";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId(),answer.getTime()};
        try {
            QueryRunner qr = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            int count = qr.update(conn,sql,params);
            BigInteger answerId = qr.query(conn,"select last_insert_id()", new ScalarHandler<BigInteger>(1));
            logger.debug("新增" + count + "条Answert数据=>Id："+answerId);
        } catch (SQLException e) {
            logger.error("插入"+answer+"失败");
            logger.error(LogUtils.getStackTrace(e));
        }
    }

    @Override
    public void update(Answer answer) {
        String sql = "UPDATE answer SET content=?,userid=?,questionid=?,time=? WHERE id=?";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId(),answer.getTime(),answer.getId()};
        try{
            int count = new QueryRunner().update(JdbcUtils.getConnection(),sql,params);
            logger.debug("更新"+count+"条数据=>"+answer);
        }catch (SQLException e){
            logger.error("修改"+answer+"失败");
            logger.error(LogUtils.getStackTrace(e));
        }

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Answer getAnswer(int id) {
        return null;
    }
}
