package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.Answer;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 回答持久化操作接口
 * @author Xing.Jiejian
 */
public interface AnswerDao {
    /**
     * 新增回答
     * @param answer
     */
    void save(Answer answer) throws DaoException;

    /**
     * 修改回答内容
     * @param answer
     */
    void update(Answer answer) throws DaoException;

    /**
     * 根据Id删除回答
     * @param id
     */
    void deleteById(int id) throws DaoException;

    /**
     * 根据编号查询回答
     * @param id
     * @return
     */
    Answer getAnswer(int id) throws DaoException;

    /**
     * 根据用户ID分页查询回答
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Answer> findPagesByUserId(int userId,int pageNo,int pageSize) throws DaoException;

    /**
     * 根据问题ID分页查询回答
     * @param questionId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Answer> findPagesByQuestionId(int questionId,int pageNo,int pageSize) throws DaoException;

    /**
     * 根据用户id获取回答总数量
     * @param userId
     * @return
     * @throws DaoException
     */
    long getCountByUserId(int userId) throws DaoException;

    /**
     * 根据问题id获取回答总数量
     * @param questionId
     * @return
     * @throws DaoException
     */
    long getCountByQuestionId(int questionId) throws DaoException;
}
