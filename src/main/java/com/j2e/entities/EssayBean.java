package com.j2e.entities;

import javax.persistence.*;

@Entity
@Table(name = "essay", schema = "myblog", catalog = "")
public class EssayBean {
    private String eId;
    private String eTitle;
    private String eContent;
    private int eLike;
    private int eComment;
    private int userId;

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
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EssayBean essayBean = (EssayBean) o;

        if (eLike != essayBean.eLike) return false;
        if (eComment != essayBean.eComment) return false;
        if (userId != essayBean.userId) return false;
        if (eId != null ? !eId.equals(essayBean.eId) : essayBean.eId != null) return false;
        if (eTitle != null ? !eTitle.equals(essayBean.eTitle) : essayBean.eTitle != null) return false;
        if (eContent != null ? !eContent.equals(essayBean.eContent) : essayBean.eContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId != null ? eId.hashCode() : 0;
        result = 31 * result + (eTitle != null ? eTitle.hashCode() : 0);
        result = 31 * result + (eContent != null ? eContent.hashCode() : 0);
        result = 31 * result + eLike;
        result = 31 * result + eComment;
        result = 31 * result + userId;
        return result;
    }
}
