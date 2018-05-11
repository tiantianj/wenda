package com.xingjiejian.wenda.dao.impl;

import com.xingjiejian.wenda.dao.BaseDao;
import com.xingjiejian.wenda.dao.CategoryDao;
import com.xingjiejian.wenda.entity.Category;
import com.xingjiejian.wenda.exception.DaoException;

import java.util.List;

/**
 * 分类相关数据访问实现类
 * @author Xing.Jiejian
 */
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {
    @Override
    public void save(Category c) throws DaoException {
        String sql = "INSERT INTO category(name,pid) VALUES(?,?)";
        Object[] params = {c.getName(),c.getPid()};
        super.save(sql,params);
    }

    @Override
    public void update(Category c) throws DaoException {
        String sql = "UPDATE category SET name=?,pid=? WHERE id=?";
        Object[] params = {c.getName(),c.getPid(),c.getId()};
        super.update(sql,params);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        String sql = "DELETE FROM category WHERE id=?";
        super.deleteById(sql,id);
    }

    @Override
    public Category getById(int id) throws DaoException {
        String sql = "SELECT id,name,pid FROM category WHERE id=?";
        return super.getById(sql,id);
    }

    @Override
    public List<Category> findPages(int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT c.id, c.`name`, c.pid FROM category AS c LEFT JOIN question AS q ON c.id = q.categoryId " +
                "LEFT JOIN answer AS a ON q.id = a.questionId GROUP BY c.id ORDER BY COUNT(1) DESC LIMIT ?,?";
        return super.find(sql,super.getOffset(pageNo,pageSize),pageSize);
    }



    @Override
    public List<Category> findPagesByPid(int pid, int pageNo, int pageSize) throws DaoException {
        String sql = "SELECT id,name,pid FROM category WHERE pid=? LIMIT ?,?";
        return super.find(sql,pid,super.getOffset(pageNo,pageSize),pageSize);
    }

    @Override
    public long getCount() throws DaoException {
        String sql = "SELECT COUNT(1) FROM category";
        return (Long)super.uniqueResult(sql);
    }
}
