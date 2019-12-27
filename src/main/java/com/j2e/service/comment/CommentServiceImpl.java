package com.j2e.service.comment;

import com.j2e.Constants;
import com.j2e.dao.comment.CommentDao;
import com.j2e.dao.essay.EssayDao;
import com.j2e.dto.CommentDto;
import com.j2e.dto.CommentItemDto;
import com.j2e.dto.EssayDto;
import com.j2e.dto.UserDto;
import com.j2e.entities.CommentBean;
import com.j2e.entities.EssayBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 14:19
 * @description 实现类
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class CommentServiceImpl implements CommentService {

    private CommentDao dao;
    private EssayDao essayDao;

    @Autowired
    public CommentServiceImpl(CommentDao dao, EssayDao dao1){
        this.dao = dao;
        this.essayDao = dao1;
    }

    @Override
    public void saveOneComment(CommentDto dto) {
        CommentBean bean = new CommentBean();
        bean.setcContent(dto.getContent());
        bean.setcLevel(dto.getLevel());
        bean.setCeid(dto.getEid());
        bean.setCuid(getUid());
        bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
        bean.setReplayId(dto.getReplayId());
        dao.saveOneComment(bean);
        EssayBean essayBean = essayDao.getBean(dto.getEid());
        essayBean.seteComment(essayBean.geteComment() + 1);
        essayDao.updateEssay(essayBean);
    }

    @Override
    public List<CommentItemDto> getEssayCommentList(String eId) {
        return dao.getCommentList(eId);
    }

    private String getUid(){
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        return user.getUid();
    }
}
