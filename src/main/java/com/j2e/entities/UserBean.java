package com.j2e.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "myblog", catalog = "")
public class UserBean {
    private String uid;
    private String username;
    private String password;
    private String photo;
    private String gender;
    private String sign;
    private int type;
    private Timestamp createtime;

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
    @Column(name = "photo", nullable = false, length = 255)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = " sign", nullable = false, length = 255)
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "createtime", nullable = false)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (type != userBean.type) return false;
        if (uid != null ? !uid.equals(userBean.uid) : userBean.uid != null) return false;
        if (username != null ? !username.equals(userBean.username) : userBean.username != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;
        if (photo != null ? !photo.equals(userBean.photo) : userBean.photo != null) return false;
        if (gender != null ? !gender.equals(userBean.gender) : userBean.gender != null) return false;
        if (sign != null ? !sign.equals(userBean.sign) : userBean.sign != null) return false;
        if (createtime != null ? !createtime.equals(userBean.createtime) : userBean.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
