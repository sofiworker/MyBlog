package com.j2e.service;

import com.j2e.entities.UserBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 21:25
 * @description 用户注册接口
 */
public interface RegisterService {

    boolean findUserExist(String uid);
    boolean saveUser(UserBean user);
}
