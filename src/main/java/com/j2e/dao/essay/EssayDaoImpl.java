package com.j2e.dao.essay;

import com.j2e.dto.EssayDto;
import com.j2e.entities.EssayBean;
import com.j2e.entities.TagBean;
import com.j2e.entities.UserBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<EssayDto> AllEssay() {
        List<EssayDto> re=new ArrayList<>();
        List<EssayBean> list=(List<EssayBean>) template.find("from EssayBean order by createTime desc");
        for(EssayBean essay :list){
            UserBean user=template.get(UserBean.class,essay.getUserId());
            System.out.println(user.getUsername());
            TagBean tag=template.get(TagBean.class,essay.getTagId());
            EssayDto ans=new EssayDto();
            ans.setEComment(essay.geteComment());
            ans.setEContent(essay.geteContent());
            ans.setEId(essay.geteId());
            ans.setELike(essay.geteLike());
            ans.setETitle(essay.geteTitle());
            ans.setUserName(user.getUsername());
            ans.setTagName(tag.getTagName());
            ans.setCreateTime(essay.getCreateTime());
            re.add(ans);
        }
        return re;
    }

    @Override
    public List<EssayDto> searchEssay(String str) {
        List<EssayDto> re=new ArrayList<>();
        List<EssayBean> list=(List<EssayBean>) template.find("from EssayBean where eTitle like ?0 or eContent like  ?1 order by createTime desc","%"+str+"%","%"+str+"%");
        for(EssayBean essay :list){
            UserBean user=template.get(UserBean.class,essay.getUserId());
            System.out.println(user.getUsername());
            TagBean tag=template.get(TagBean.class,essay.getTagId());
            EssayDto ans=new EssayDto();
            ans.setEComment(essay.geteComment());
            ans.setEContent(essay.geteContent());
            ans.setEId(essay.geteId());
            ans.setELike(essay.geteLike());
            ans.setETitle(essay.geteTitle());
            ans.setUserName(user.getUsername());
            ans.setTagName(tag.getTagName());
            ans.setCreateTime(essay.getCreateTime());
            re.add(ans);
        }
        return re;
    }

    @Override
    public void deleteEssayById(String eId) {
        EssayBean entity = template.get(EssayBean.class, eId);
        template.delete(entity);
    }

    @Override
    public EssayDto getEssay(String str) {
        List<EssayBean> list=(List<EssayBean>)template.find("from EssayBean where eId=?0",str);
        EssayBean  essay=list.get(0);
        List<UserBean> list1=(List<UserBean>) template.find("from UserBean where uid=?0",essay.getUserId());
        UserBean user=list1.get(0);
        System.out.println(user.getUsername());
        List<TagBean> list2=(List<TagBean>) template.find("from TagBean where tagId=?0",essay.getTagId());
        TagBean tag=list2.get(0);
        EssayDto ans=new EssayDto();
        ans.setEComment(essay.geteComment());
        ans.setEContent(essay.geteContent());
        ans.setEId(essay.geteId());
        ans.setELike(essay.geteLike());
        ans.setETitle(essay.geteTitle());
        ans.setUserName(user.getUsername());
        ans.setTagName(tag.getTagName());
        ans.setCreateTime(essay.getCreateTime());
        return ans;
    }

    @Override
    public EssayBean getBean(String id) {
        return template.get(EssayBean.class, id);
    }


}