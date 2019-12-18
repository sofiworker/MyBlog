package com.j2e.service.change;

import com.j2e.entities.UserBean;


/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/18 12:33
 * @description 修改用户信息接口
 */
public interface MessageChangeService {
    boolean savechange(UserBean user);
}
