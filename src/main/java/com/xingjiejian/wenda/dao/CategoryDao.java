package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.Category;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 分类相关数据访问接口
 * @author Xing.Jiejian
 */
public interface CategoryDao {
    /**
     * 新增分类
     * @param c
     * @exception DaoException
     */
    void save(Category c) throws DaoException;

    /**
     * 修改分类
     * @param c
     * @throws DaoException
     */
    void update(Category c) throws DaoException;

    /**
     * 根据ID删除分类
     * @param id
     * @throws DaoException
     */
    void deleteById(int id) throws DaoException;

    /**
     * 根据ID查询分类
     * @param id
     * @return
     * @throws DaoException
     */
    Category getById(int id) throws DaoException;

    /**
     * 分页查询分类(按照问题、回答数量降序排序)
     * @param pageNo
     * @param pageSize
     * @return
     * @throws DaoException
     */
    List<Category> findPages(int pageNo,int pageSize) throws DaoException;

    /**
     * 根据父分类ID查询分类数据
     * @param pid
     * @param pageNo
     * @param pageSize
     * @return
     * @throws DaoException
     */
    List<Category> findPagesByPid(int pid ,int pageNo,int pageSize) throws DaoException;

    /**
     * 查询分类总数量
     * @return
     * @throws DaoException
     */
    long getCount() throws DaoException;



}
