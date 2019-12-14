package com.j2e.entities;

import javax.persistence.*;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/13 22:55
 * @description 文章实体类
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EssayBean essayBean = (EssayBean) o;

        if (eLike != essayBean.eLike) return false;
        if (eComment != essayBean.eComment) return false;
        if (tagId != essayBean.tagId) return false;
        if (eId != null ? !eId.equals(essayBean.eId) : essayBean.eId != null) return false;
        if (eTitle != null ? !eTitle.equals(essayBean.eTitle) : essayBean.eTitle != null) return false;
        if (eContent != null ? !eContent.equals(essayBean.eContent) : essayBean.eContent != null) return false;
        if (userId != null ? !userId.equals(essayBean.userId) : essayBean.userId != null) return false;

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
        return result;
    }
}
