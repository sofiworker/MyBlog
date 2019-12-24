package com.j2e.dao.essay;

import com.j2e.entities.EssayBean;
import lombok.extern.log4j.Log4j2;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 9:27
 * @description 文章dao层的实现类
 */
@Repository
@Log4j2
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

    @Override
    public void updateEssay(EssayBean essay) {
        template.update(essay);
    }

    @Override
    public List<EssayBean> AllEssay() {
        return (List<EssayBean>) template.find("from EssayBean");
    }

    @Override
    public List<EssayBean> searchEssay(String str) {
        return (List<EssayBean>) template.find("from EssayBean where eTitle like ?0 or eContent like  ?1","%"+str+"%","%"+str+"%");
    }

    @Override
    public void deleteEssayById(String eId) {
        EssayBean entity = template.get(EssayBean.class, eId);
        template.delete(entity);
    }
}