package com.j2e.entities;

import javax.persistence.*;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/6 20:14
 * @description 用户实体类
 */
@Entity
@Table(name = "user", schema = "myblog", catalog = "")
public class UserBean {
    private int uid;
    private String username;
    private String password;

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (uid != userBean.uid) return false;
        if (username != null ? !username.equals(userBean.username) : userBean.username != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
