package com.j2e.service.store;


import com.j2e.dao.user.UserDao;
import com.j2e.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 收藏接口实现
 */

@Service
@Transactional(rollbackFor = {Exception.class})
public class StoreListServiceImpl implements StoreListService{

    private UserDao userdao;

    @Autowired
    public StoreListServiceImpl(UserDao userdao){
        this.userdao=userdao;
    }

    @Override
    public List<StoreDto> findstore(){
        return userdao.findStore();
    }
}
