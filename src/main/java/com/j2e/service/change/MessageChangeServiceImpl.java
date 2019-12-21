package com.j2e.service.change;

import com.j2e.dao.user.UserDao;
import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/7 21:25
 * @description 修改服务
 */

@Service
@Transactional(rollbackFor = {Exception.class})
public class MessageChangeServiceImpl implements MessageChangeService {
    private UserDao userdao;
    @Autowired
    public MessageChangeServiceImpl(UserDao userdao) {
        this.userdao=userdao;
    }

    @Override
    public boolean savechange(UserBean user){

        return userdao.savechange(user);
    }
}
