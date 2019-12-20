package com.j2e.service.change;

import com.j2e.dao.user.UserDao;
import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/7 21:25
 * @description 修改服务
 */

@Service
public class MessageChangeServicelmpl implements MessageChangeService {
    private UserDao userdao;
    @Autowired
    public MessageChangeServicelmpl(UserDao userdao) {
        this.userdao=userdao;
    }

    @Override
    public boolean savechange(UserBean user){

        return userdao.savechange(user);
    }
}
