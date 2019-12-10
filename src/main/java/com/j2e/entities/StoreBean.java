package com.j2e.entities;

import javax.persistence.*;

@Entity
@Table(name = "store", schema = "myblog", catalog = "")
public class StoreBean {
    private int sId;
    private String sUid;
    private String sEid;

    @Id
    @Column(name = "s_id", nullable = false)
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_uid", nullable = false, length = 11)
    public String getsUid() {
        return sUid;
    }

    public void setsUid(String sUid) {
        this.sUid = sUid;
    }

    @Basic
    @Column(name = "s_eid", nullable = false, length = 32)
    public String getsEid() {
        return sEid;
    }

    public void setsEid(String sEid) {
        this.sEid = sEid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreBean storeBean = (StoreBean) o;

        if (sId != storeBean.sId) return false;
        if (sUid != null ? !sUid.equals(storeBean.sUid) : storeBean.sUid != null) return false;
        if (sEid != null ? !sEid.equals(storeBean.sEid) : storeBean.sEid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId;
        result = 31 * result + (sUid != null ? sUid.hashCode() : 0);
        result = 31 * result + (sEid != null ? sEid.hashCode() : 0);
        return result;
    }
}
