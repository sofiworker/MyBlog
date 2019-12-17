package com.j2e.dao.comment;

import com.j2e.dto.CommentItemDto;
import com.j2e.entities.CommentBean;
import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 14:18
 * @description 实现类
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    private HibernateTemplate template;

    @Autowired
    public CommentDaoImpl(HibernateTemplate template){
        this.template = template;
    }

    @Override
    public void saveOneComment(CommentBean comment) {
        template.save(comment);
    }

    @Override
    public List<CommentItemDto> getCommentList(String eId) {
        return getData(eId);
    }

    private List<CommentItemDto> getData(String eId){
        CommentBean bean = new CommentBean();
        bean.setCeid(eId);
        List<CommentBean> commentList = template.findByExample(bean);
        List<CommentItemDto> itemList = new ArrayList<>();
        for (CommentBean commentBean : commentList) {
            UserBean userBean = template.get(UserBean.class, commentBean.getCuid());
            CommentItemDto dto = new CommentItemDto();
            dto.setUid(userBean.getUid());
            dto.setUsername(userBean.getUsername());
            dto.setPhoto(userBean.getPhoto());
            dto.setLevel(commentBean.getcLevel());
            dto.setContent(commentBean.getcContent());
            dto.setEid(commentBean.getCeid());
            dto.setCreateTime(commentBean.getCreateTime());
            itemList.add(dto);
        }
        return itemList;
    }
}
