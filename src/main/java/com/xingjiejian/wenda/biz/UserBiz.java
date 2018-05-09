package com.xingjiejian.wenda.biz;

import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.UserException;

/**
 * 用户相关业务接口
 * @author Xing.Jiejian
 */
public interface UserBiz {
    /**
     * 注册功能
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 登录功能
     * @param loginName 用户名
     * @param password 密码
     * @return 登录成功的用户
     * @throws UserException 登录失败
     */
    User login(String loginName,String password) throws UserException;
}
