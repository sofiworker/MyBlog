package com.j2e.dao.replay;

import com.j2e.entities.CommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:56
 * @description 实现类
 */
@Repository
public class ReplayDaoImpl implements ReplayDao {

    private HibernateTemplate template;

    @Autowired
    public ReplayDaoImpl(HibernateTemplate template){
        this.template = template;
    }

    @Override
    public List<CommentBean> getCommentList(String uid) {
        return (List<CommentBean>) template.find("from CommentBean where replayId = "+uid);
    }
}
