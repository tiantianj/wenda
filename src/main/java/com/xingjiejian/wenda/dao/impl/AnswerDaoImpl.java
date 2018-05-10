package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.AnswerDao;
import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.entity.Answer;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 回答持久化操作实现类
 * @author Xing.Jiejian
 */
public class AnswerDaoImpl extends BaseDao<Answer> implements AnswerDao {

    @Override
    public void save(Answer answer) throws DaoException {
        String sql = "INSERT INTO answer(content,userId,questionId,time) VALUES(?,?,?,now())";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId()};
        super.save(sql,params);
    }

    @Override
    public void update(Answer answer) throws DaoException {
        String sql = "UPDATE answer SET content=?,userId=?,questionId=?,time=now() WHERE id=?";
        Object[] params = {answer.getContent(),answer.getUserId(),answer.getQuestionId(),answer.getId()};
       super.update(sql,params);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        String sql = "DELETE FROM answer WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public Answer getAnswer(int id) throws DaoException {
        String sql = "SELECT id,content,userId,questionId,time FROM answer WHERE id=?";
        return super.getById(sql,id);
    }

    @Override
    public List<Answer> findPagesByUserId(int userId, int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,content,userId,questionId,time FROM answer WHERE userId=? LIMIT ?,?";
        int offset = (pageNo-1)*pageSize;
        return super.find(sql,userId,offset,pageSize);
    }

    @Override
    public List<Answer> findPagesByQuestionId(int questionId, int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,content,userId,questionId,time FROM answer WHERE questionId=? LIMIT ?,?";
        int offset = (pageNo-1)*pageSize;
        return super.find(sql,questionId,offset,pageSize);
    }

    @Override
    public long getCountByUserId(int userId) throws DaoException {
        String sql = "SELECT COUNT(1) FROM answer WHERE userId=?";
        return (Long)super.uniqueResult(sql,userId);
    }

    @Override
    public long getCountByQuestionId(int questionId) throws DaoException {
        String sql = "SELECT COUNT(1) FROM answer WHERE questionId=?";
        return (Long)super.uniqueResult(sql,questionId);
    }
}
