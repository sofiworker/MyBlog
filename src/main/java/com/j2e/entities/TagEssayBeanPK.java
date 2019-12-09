package com.j2e.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TagEssayBeanPK implements Serializable {
    private int tagId;
    private String essayId;

    @Column(name = "tag_id", nullable = false)
    @Id
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Column(name = "essay_id", nullable = false, length = 32)
    @Id
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

        TagEssayBeanPK that = (TagEssayBeanPK) o;

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
