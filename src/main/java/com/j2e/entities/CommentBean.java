package com.j2e.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:44
 * @description TODO
 */
@Entity
@Table(name = "comment", schema = "myblog", catalog = "")
public class CommentBean {
    private int cId;
    private int cLevel;
    private String cContent;
    private String cuid;
    private String ceid;
    private String replayId;
    private Timestamp createTime;

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

    @Basic
    @Column(name = "cuid", nullable = false, length = 11)
    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    @Basic
    @Column(name = "ceid", nullable = false, length = 32)
    public String getCeid() {
        return ceid;
    }

    public void setCeid(String ceid) {
        this.ceid = ceid;
    }

    @Basic
    @Column(name = "replay_id", nullable = false, length = 11)
    public String getReplayId() {
        return replayId;
    }

    public void setReplayId(String replayId) {
        this.replayId = replayId;
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

        CommentBean bean = (CommentBean) o;

        if (cId != bean.cId) return false;
        if (cLevel != bean.cLevel) return false;
        if (cContent != null ? !cContent.equals(bean.cContent) : bean.cContent != null) return false;
        if (cuid != null ? !cuid.equals(bean.cuid) : bean.cuid != null) return false;
        if (ceid != null ? !ceid.equals(bean.ceid) : bean.ceid != null) return false;
        if (replayId != null ? !replayId.equals(bean.replayId) : bean.replayId != null) return false;
        if (createTime != null ? !createTime.equals(bean.createTime) : bean.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + cLevel;
        result = 31 * result + (cContent != null ? cContent.hashCode() : 0);
        result = 31 * result + (cuid != null ? cuid.hashCode() : 0);
        result = 31 * result + (ceid != null ? ceid.hashCode() : 0);
        result = 31 * result + (replayId != null ? replayId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
