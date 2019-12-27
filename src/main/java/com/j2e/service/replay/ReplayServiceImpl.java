package com.j2e.service.replay;

import com.j2e.Constants;
import com.j2e.dao.replay.ReplayDao;
import com.j2e.dto.UserDto;
import com.j2e.entities.CommentBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:53
 * @description 实现类
 */
@Service
public class ReplayServiceImpl implements ReplayService {

    private ReplayDao dao;

    @Autowired
    public ReplayServiceImpl(ReplayDao dao){
        this.dao = dao;
    }

    @Override
    public List<CommentBean> getReplay() {
        return dao.getCommentList(getUid());
    }

    private String getUid(){
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        return user.getUid();
    }
}
