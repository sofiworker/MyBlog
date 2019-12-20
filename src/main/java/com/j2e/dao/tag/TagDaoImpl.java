package com.j2e.dao.tag;

import com.j2e.entities.TagBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:14
 * @description dao实现层
 */
@Repository
public class TagDaoImpl implements TagDao {

    private HibernateTemplate template;

    @Autowired
    public TagDaoImpl(HibernateTemplate template){
        this.template = template;
    }

    @Override
    public List<TagBean> findTagByKeyWord() {
        return (List<TagBean>)template.find("from TagBean");
    }
}
