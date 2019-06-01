package com.ctgu.pojo;

import java.util.Date;

public class StockOut {
    private Integer id;

    private String pnum;

    private Integer cid;

    private Integer numberOut;

    private Date createdate;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum == null ? null : pnum.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getNumberOut() {
        return numberOut;
    }

    public void setNumberOut(Integer numberOut) {
        this.numberOut = numberOut;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}