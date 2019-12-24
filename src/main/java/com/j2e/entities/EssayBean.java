package com.j2e.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/24 15:03
 * @description TODO
 */
@Entity
@Table(name = "essay", schema = "myblog", catalog = "")
public class EssayBean {
    private String eId;
    private String eTitle;
    private String eContent;
    private int eLike;
    private int eComment;
    private String userId;
    private int tagId;
    private Timestamp createTime;

    @Id
    @Column(name = "e_id", nullable = false, length = 32)
    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "e_title", nullable = false, length = 255)
    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    @Basic
    @Column(name = "e_content", nullable = false, length = -1)
    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent;
    }

    @Basic
    @Column(name = "e_like", nullable = false)
    public int geteLike() {
        return eLike;
    }

    public void seteLike(int eLike) {
        this.eLike = eLike;
    }

    @Basic
    @Column(name = "e_comment", nullable = false)
    public int geteComment() {
        return eComment;
    }

    public void seteComment(int eComment) {
        this.eComment = eComment;
    }

    @Basic
    @Column(name = "user_id", nullable = false, length = 11)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tag_id", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EssayBean bean = (EssayBean) o;

        if (eLike != bean.eLike) return false;
        if (eComment != bean.eComment) return false;
        if (tagId != bean.tagId) return false;
        if (eId != null ? !eId.equals(bean.eId) : bean.eId != null) return false;
        if (eTitle != null ? !eTitle.equals(bean.eTitle) : bean.eTitle != null) return false;
        if (eContent != null ? !eContent.equals(bean.eContent) : bean.eContent != null) return false;
        if (userId != null ? !userId.equals(bean.userId) : bean.userId != null) return false;
        if (createTime != null ? !createTime.equals(bean.createTime) : bean.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId != null ? eId.hashCode() : 0;
        result = 31 * result + (eTitle != null ? eTitle.hashCode() : 0);
        result = 31 * result + (eContent != null ? eContent.hashCode() : 0);
        result = 31 * result + eLike;
        result = 31 * result + eComment;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + tagId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
