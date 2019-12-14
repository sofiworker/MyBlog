package com.j2e.service;

import com.j2e.entities.UserBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 15:28
 * @description 用户服务接口
 */
public interface LoginService {

    boolean findUserExist(String uid);

    UserBean loginSuccess(String uid, String password);
}
