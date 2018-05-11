package com.xingjiejian.wenda.biz;

import com.xingjiejian.wenda.entity.Category;

import java.util.List;

/**
 * 分类相关的业务方法
 * @author Xing.Jiejian
 */
public interface CategoryBiz {
    // TODO

    /**
     * 获取分类分页数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Category> findPages(int pageNo,int pageSize);
}
