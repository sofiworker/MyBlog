package com.j2e.dao;

import com.j2e.entities.EssayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 9:27
 * @description 文章dao层的实现类
 */
@Repository
public class EssayDaoImpl implements EssayDao {

    private HibernateTemplate template;

    @Autowired
    public EssayDaoImpl(HibernateTemplate template){
        this.template = template;
    }

    @Override
    public boolean saveEssay(EssayBean essay) {
        return template.save(essay) != null;
    }
}
