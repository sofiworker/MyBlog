package com.j2e.entities;

import javax.persistence.*;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/11 19:41
 * @description 评论实体类
 */
@Entity
@Table(name = "comment", schema = "myblog", catalog = "")
public class CommentBean {
    private int cId;
    private int cLevel;
    private String cContent;

    @Id
    @Column(name = "c_id", nullable = false)
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "c_level", nullable = false)
    public int getcLevel() {
        return cLevel;
    }

    public void setcLevel(int cLevel) {
        this.cLevel = cLevel;
    }

    @Basic
    @Column(name = "c_content", nullable = false, length = 255)
    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentBean that = (CommentBean) o;

        if (cId != that.cId) return false;
        if (cLevel != that.cLevel) return false;
        if (cContent != null ? !cContent.equals(that.cContent) : that.cContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + cLevel;
        result = 31 * result + (cContent != null ? cContent.hashCode() : 0);
        return result;
    }
}
