package com.j2e.service.message;

import com.j2e.Constants;
import com.j2e.dao.user.UserDao;
import com.j2e.dto.UserDto;
import com.j2e.entities.UserBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/18 21:25
 * @description 修改服务层
 */

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserMessageServiceImpl implements UserMessageService {
    private UserDao mUserDao;

    @Autowired
    public UserMessageServiceImpl(UserDao dao){
        this.mUserDao = dao;
    }

    @Override
    public UserBean usermesssage(){
        System.out.println();
       UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
       return mUserDao.findUser(user.getUid());
    }
}
