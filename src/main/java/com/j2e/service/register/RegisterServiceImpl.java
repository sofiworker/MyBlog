package com.j2e.service.register;

import com.j2e.dao.user.UserDao;
import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 21:26
 * @description 注册服务层
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private UserDao userDao;

    @Autowired
    public RegisterServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean findUserExist(String uid) {
        return userDao.findUserById(uid);
    }

    @Override
    public boolean saveUser(UserBean user) {
        return userDao.saveUser(user);
    }
}
