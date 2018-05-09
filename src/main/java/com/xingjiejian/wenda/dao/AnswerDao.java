package com.xingjiejian.wenda.dao;

import com.xingjiejian.wenda.entity.Answer;

/**
 * 问题持久化操作接口
 * @author Xing.Jiejian
 */
public interface AnswerDao {
    /**
     * 新增问题
     * @param answer
     */
    void save(Answer answer);

    /**
     * 修改问题内容
     * @param answer
     */
    void update(Answer answer);

    /**
     * 根据Id删除问题
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据编号查询问题
     * @param id
     * @return
     */
    Answer getAnswer(int id);
}
