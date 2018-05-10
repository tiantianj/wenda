package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.Question;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 问题相关持久化操作接口
 * @author Xing.Jiejian
 */
public interface QuestionDao {
    /**
     * 新增问题
     * @param question
     */
    void save(Question question) throws DaoException;

    /**
     * 修改问题
     * @param question
     */
    void update(Question question) throws DaoException;

    /**
     * 根据ID删除问题
     * @param id
     */
    void deleteById(int id) throws DaoException;

    /**
     * 根据ID查询问题
     * @param id
     * @return
     */
    Question getById(int id) throws DaoException;

    /**
     * 查询问题分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Question> findPages(int pageNo,int pageSize) throws DaoException;

    /**
     * 根据问题标题模糊查询问题分页
     * @param likeTitle
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Question> findPagesByTitle(String likeTitle, int pageNo,int pageSize) throws DaoException;

    /**
     * 根据分类ID查询问题分页
     * @param categoryId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Question> findPagesByCategoryId(int categoryId,int pageNo,int pageSize) throws DaoException;

    /**
     * 获取问题总数量
     * @return
     */
    long getCount() throws DaoException;

    /**
     * 根据标题模糊查询问题总数量
     * @return
     */
    long getCountByTitle(String likeTitle) throws DaoException;


    /**
     * 获取问题总数量
     * @return
     */
    long getCountByCategoryId(int categoryId) throws DaoException;
}
