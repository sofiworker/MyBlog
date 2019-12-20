package com.j2e.service.myeassy;

import com.j2e.dao.user.UserDao;
import com.j2e.dto.MyEassyItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 文章接口实现
 */

@Service
public class MyEassyServicelmpl implements MyEassyService {

    private UserDao userdao;

    @Autowired
    public MyEassyServicelmpl(UserDao userdao){
        this.userdao=userdao;
    }

    @Override
    public List<MyEassyItemDto> myeassy(){
        return userdao.findEassy();
    }
}
