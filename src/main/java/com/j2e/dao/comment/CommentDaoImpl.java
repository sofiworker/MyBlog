package com.j2e.dao.comment;

import com.j2e.entities.CommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
}
