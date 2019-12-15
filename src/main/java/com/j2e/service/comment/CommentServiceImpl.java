package com.j2e.service.comment;

import com.j2e.Constants;
import com.j2e.dao.comment.CommentDao;
import com.j2e.dto.CommentDto;
import com.j2e.dto.UserDto;
import com.j2e.entities.CommentBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 14:19
 * @description 实现类
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao dao;

    @Autowired
    public CommentServiceImpl(CommentDao dao){
        this.dao = dao;
    }

    @Override
    public void saveOneComment(CommentDto dto) {
        CommentBean bean = new CommentBean();
        bean.setcContent(dto.getContent());
        bean.setcLevel(dto.getLevel());
        bean.setCeid(dto.getEid());
        bean.setCuid(getUid());
        dao.saveOneComment(bean);
    }

    private String getUid(){
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        return user.getUid();
    }
}
