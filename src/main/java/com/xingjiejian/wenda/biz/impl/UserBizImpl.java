package com.xingjiejian.wenda.biz.impl;

import com.xingjiejian.wenda.biz.UserBiz;
import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.dao.impl.UserDaoImpl;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.UserException;

/**
 * 用户相关业务实现类
 * @author Xing.Jiejian
 */
public class UserBizImpl implements UserBiz {
    private UserDao userDao = new UserDaoImpl();


    @Override
    public boolean register(User user) {
        userDao.save(user);
        return true;
    }

    @Override
    public User login(String loginName, String password) throws UserException {
        User user = userDao.getUser(loginName);
        if(user==null){
            throw new UserException("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
            throw new UserException("密码不正确");
        }
        return user;
    }

}
