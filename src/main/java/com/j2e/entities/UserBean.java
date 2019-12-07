package com.j2e.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 22:16
 * @description 用户实体
 */
@Entity
@Table(name = "user", schema = "myblog", catalog = "")
public class UserBean implements Serializable {
    private static final long serialVersionUID = -8712420936914444270L;
    private String uid;
    private String username;
    private String password;
    private int type;

    @Id
    @Column(name = "uid", nullable = false, length = 11)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 15)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserBean userBean = (UserBean) o;

        if (type != userBean.type) {
            return false;
        }
        if (uid != null ? !uid.equals(userBean.uid) : userBean.uid != null) {
            return false;
        }
        if (username != null ? !username.equals(userBean.username) : userBean.username != null) {
            return false;
        }
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }
}
