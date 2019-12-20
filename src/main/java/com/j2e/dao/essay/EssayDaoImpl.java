package com.j2e.dao.essay;

import com.j2e.entities.EssayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public void updateEssay(EssayBean essay) {
        template.update(essay);
    }

    @Override
    public List<EssayBean> AllEssay() {
        return (List<EssayBean>) template.find("from EssayBean ");
    }

    @Override
    public List<EssayBean> searchEssay(String str) {
        System.out.println(str);
        return (List<EssayBean>) template.find("from EssayBean where eTitle like ?0 or eContent like  ?1","%"+str+"%","%"+str+"%");
    }
}