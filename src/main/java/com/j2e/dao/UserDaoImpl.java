package com.j2e.dao;

import com.j2e.entities.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
    public UserBean validatePassword(UserBean userBean) {
        boolean isExist = findUserById(userBean.getUid());
        if (isExist) {
            UserBean user = mTemplate.get(UserBean.class, userBean.getUid());
            if (userBean.getPassword().equals(user.getPassword())) {
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean saveUser(UserBean user) {
        return mTemplate.save(user) != null;
    }
}
