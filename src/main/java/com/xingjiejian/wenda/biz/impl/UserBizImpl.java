package com.xingjiejian.wenda.biz.impl;

import com.xingjiejian.wenda.biz.UserBiz;
import com.xingjiejian.wenda.dao.UserDao;
import com.xingjiejian.wenda.dao.impl.UserDaoImpl;
import com.xingjiejian.wenda.entity.User;
import com.xingjiejian.wenda.exception.DaoException;
import com.xingjiejian.wenda.exception.UserException;
import com.xingjiejian.wenda.utils.JdbcUtils;
import com.xingjiejian.wenda.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户相关业务实现类
 * @author Xing.Jiejian
 */
public class UserBizImpl implements UserBiz {
    //日志对象
    private static final Logger logger = LoggerFactory.getLogger(UserBizImpl.class);

    private UserDao userDao = new UserDaoImpl();


    @Override
    public boolean register(User user) {
        try {
            userDao.save(user);
            logger.debug("用户"+ user.getLoginName()+"注册成功。");
        } catch (DaoException e) {
            logger.error("用户注册失败/n"+ LogUtils.getStackTrace(e));
        }
        return true;
    }

    @Override
    public User login(String loginName, String password) throws UserException {
        User user = null;
        try {
            user = userDao.getUser(loginName);
        } catch (DaoException e) {
            logger.error("用户查询失败/n"+ LogUtils.getStackTrace(e));
        }
        if(user==null){
            throw new UserException("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
            throw new UserException("密码不正确");
        }
        return user;
    }

}
