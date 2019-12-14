package com.j2e.entities;

import javax.persistence.*;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/11 19:41
 * @description 文章标签实体类
 */
@Entity
@Table(name = "tag", schema = "myblog", catalog = "")
public class TagBean {
    private int tagId;
    private String tagName;

    @Id
    @Column(name = "tag_id", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "tag_name", nullable = true, length = 255)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagBean tagBean = (TagBean) o;

        if (tagId != tagBean.tagId) return false;
        if (tagName != null ? !tagName.equals(tagBean.tagName) : tagBean.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }
}
