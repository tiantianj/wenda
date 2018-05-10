package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.dao.QuestionDao;
import com.xingjiejian.wenda.entity.Question;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 问题数据库操作实现类
 * @author Xing.Jiejian
 */
public class QuestionDaoImpl extends BaseDao<Question> implements QuestionDao {
    @Override
    public void save(Question question) throws DaoException {
        String sql ="INSERT INTO question(title,description,userId,picture,categoryId,time) VALUES(?,?,?,?,?,now())";
        Object[] params = {question.getTitle(),question.getDescription(), question.getUserId(), question.getPicture(), question.getCategoryId()};
        super.save(sql,params);
    }

    @Override
    public void update(Question question) throws DaoException {
        String sql = "UPDATE question SET title=?,description=?,userId=?,picture=?,categoryId=?,time=now() WHERE id=?";
        Object[] params = {question.getTitle(),question.getDescription(), question.getUserId(), question.getPicture(), question.getCategoryId(), question.getId()};
        super.update(sql,params);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        String sql = "DELETE FROM question WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public Question getById(int id) throws DaoException {
        String sql = "SELECT id,title,description,userId,picture,categoryId,time FROM question WHERE id=?";
        return super.getById(sql,id);
    }

    @Override
    public List<Question> findPages(int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,title,description,userId,picture,categoryId,time FROM question LIMIT ?,?";
        Object[] params = {getOffset(pageNo,pageSize),pageSize};
        return super.find(sql,params);
    }

    @Override
    public List<Question> findPagesByTitle(String likeTitle, int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,title,description,userId,picture,categoryId,time FROM question WHERE title LIKE ? LIMIT ?,?";
        Object[] params = {"%"+likeTitle+"%",getOffset(pageNo,pageSize),pageSize};
        return super.find(sql,params);
    }

    @Override
    public List<Question> findPagesByCategoryId(int categoryId, int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,title,description,userId,picture,categoryId,time FROM question WHERE categoryId=? LIMIT ?,?";
        Object[] params = {categoryId,getOffset(pageNo,pageSize),pageSize};
        return super.find(sql,params);
    }

    @Override
    public long getCount() throws DaoException {
        String sql = "SELECT COUNT(1) FROM question";
        return (Long) super.uniqueResult(sql);
    }

    @Override
    public long getCountByTitle(String likeTitle) throws DaoException {
        String sql = "SELECT COUNT(1) FROM question WHERE title LIKE ?";
        return (Long) super.uniqueResult(sql,"%"+likeTitle+"%");
    }

    @Override
    public long getCountByCategoryId(int categoryId) throws DaoException {
        String sql = "SELECT COUNT(1) FROM question WHERE categoryId=?";
        return (Long) super.uniqueResult(sql,categoryId);
    }
}
