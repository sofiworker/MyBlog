package com.j2e.dao.user;

import com.j2e.entities.UserBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 19:43
 * @description 用户dao层接口
 */
public interface UserDao {
    boolean findUserById(String uid);
    UserBean validatePassword(String uid, String password);
    boolean saveUser(UserBean user);
}
