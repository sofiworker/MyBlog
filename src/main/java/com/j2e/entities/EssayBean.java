package com.j2e.entities;

import javax.persistence.*;

@Entity
@Table(name = "essay", schema = "myblog", catalog = "")
public class EssayBean {
    private String eId;
    private String eTitle;
    private String eContent;
    private Integer eLike;
    private Integer eComment;

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
    @Column(name = "e_content", nullable = true, length = 255)
    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent;
    }

    @Basic
    @Column(name = "e_like", nullable = true)
    public Integer geteLike() {
        return eLike;
    }

    public void seteLike(Integer eLike) {
        this.eLike = eLike;
    }

    @Basic
    @Column(name = "e_comment", nullable = true)
    public Integer geteComment() {
        return eComment;
    }

    public void seteComment(Integer eComment) {
        this.eComment = eComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EssayBean essayBean = (EssayBean) o;

        if (eId != null ? !eId.equals(essayBean.eId) : essayBean.eId != null) return false;
        if (eTitle != null ? !eTitle.equals(essayBean.eTitle) : essayBean.eTitle != null) return false;
        if (eContent != null ? !eContent.equals(essayBean.eContent) : essayBean.eContent != null) return false;
        if (eLike != null ? !eLike.equals(essayBean.eLike) : essayBean.eLike != null) return false;
        if (eComment != null ? !eComment.equals(essayBean.eComment) : essayBean.eComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId != null ? eId.hashCode() : 0;
        result = 31 * result + (eTitle != null ? eTitle.hashCode() : 0);
        result = 31 * result + (eContent != null ? eContent.hashCode() : 0);
        result = 31 * result + (eLike != null ? eLike.hashCode() : 0);
        result = 31 * result + (eComment != null ? eComment.hashCode() : 0);
        return result;
    }
}
