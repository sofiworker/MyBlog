package com.j2e.service;

import com.j2e.dao.UserDao;
import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/6 18:47
 * @description 登录服务页面
 */

@Service
public class LoginServiceImpl implements LoginService{

    private UserDao mUserDao;

    @Autowired
    public LoginServiceImpl(UserDao dao){
        this.mUserDao = dao;
    }

    @Override
    public boolean findUserExist(String uid) {
        return mUserDao.findUserById(uid);
    }

    @Override
    public UserBean loginSuccess(UserBean user) {
        return mUserDao.validatePassword(user);
    }
}
