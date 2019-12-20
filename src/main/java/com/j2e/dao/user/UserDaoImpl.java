package com.j2e.dao.user;

import com.j2e.Constants;
import com.j2e.dto.MyEassyItemDto;
import com.j2e.dto.StoreDto;
import com.j2e.dto.UserDto;
import com.j2e.entities.EssayBean;
import com.j2e.entities.StoreBean;
import com.j2e.entities.TagBean;
import com.j2e.entities.UserBean;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 15:26
 * @description 用户持久层
 */
@Repository
public class UserDaoImpl implements UserDao {

    private HibernateTemplate mTemplate;

    @Autowired
    public UserDaoImpl(HibernateTemplate template){
        this.mTemplate = template;
    }

    @Override
    public boolean findUserById(String uid){
        UserBean userBean = mTemplate.get(UserBean.class, uid);
        return userBean != null;
    }
    @Override
    public UserBean findUser(String uid){
        return mTemplate.get(UserBean.class, uid);
    }

    @Override
    public UserBean validatePassword(String uid, String password) {
        UserBean user = mTemplate.get(UserBean.class, uid);
        if (password.equals(user.getPassword())) {
            return user;
        }else {
            return null;
        }
    }

    @Override
    public boolean saveUser(UserBean user) {
        if (user.getCreatetime() == null) {
            user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        }
        return mTemplate.save(user) != null;
    }

    @Override
    public boolean savechange(UserBean user){
        mTemplate.update(user);
        return true;
    }

    @Override
    public List<MyEassyItemDto> findEassy(){
        return getEssay();
    }

    private List<MyEassyItemDto> getEssay(){
        UserDto user=(UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        List<EssayBean> eassylist= (List<EssayBean>) mTemplate.find("from EssayBean where userId="+user.getUid());
        List<MyEassyItemDto> myessay =new ArrayList<>();
        for (EssayBean essaybean : eassylist){
            TagBean tagbean = mTemplate.get(TagBean.class,essaybean.getTagId());
            MyEassyItemDto item=new MyEassyItemDto();
            item.setEid(essaybean.geteId());
            item.setEtitle(essaybean.geteTitle());
            item.setEcontent(essaybean.geteContent());
            item.setEcomment(essaybean.geteComment());
            item.setElike(essaybean.geteLike());
            item.setTagid(essaybean.getTagId());
            item.setTagname(tagbean.getTagName());
            item.setUid(essaybean.getUserId());
            item.setUname(user.getUsername());
            myessay.add(item);
        }
        return myessay;
    }

    @Override
    public List<StoreDto> findStore(){
        return getStore();
    }
    public List<StoreDto> getStore(){
        UserDto user=(UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        List<StoreBean> storelist= (List<StoreBean>) mTemplate.find("from StoreBean where sUid=" + user.getUid());
        List<StoreDto> store=new ArrayList<>();
        for (StoreBean storebean : storelist){
            StoreDto item=new StoreDto();
            EssayBean essay=mTemplate.get(EssayBean.class,storebean.getsEid());
            UserBean userbean=mTemplate.get(UserBean.class,essay.getUserId());
            item.setUid(userbean.getUid());
            item.setUserName(userbean.getUsername());
            item.setEid(essay.geteId());
            item.setEtitle(essay.geteTitle());
            item.setEcontent(essay.geteContent());
            store.add(item);
        }
        return store;
    }
}
