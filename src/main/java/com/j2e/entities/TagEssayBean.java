package com.j2e.entities;

import javax.persistence.*;

@Entity
@Table(name = "tag_essay", schema = "myblog", catalog = "")
@IdClass(TagEssayBeanPK.class)
public class TagEssayBean {
    private int tagId;
    private String essayId;

    @Id
    @Column(name = "tag_id", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Id
    @Column(name = "essay_id", nullable = false, length = 32)
    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagEssayBean that = (TagEssayBean) o;

        if (tagId != that.tagId) return false;
        if (essayId != null ? !essayId.equals(that.essayId) : that.essayId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId;
        result = 31 * result + (essayId != null ? essayId.hashCode() : 0);
        return result;
    }
}
