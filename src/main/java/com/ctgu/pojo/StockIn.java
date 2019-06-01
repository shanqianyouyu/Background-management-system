package com.ctgu.pojo;

import java.util.Date;

public class StockIn {
    private Integer id;

    private Integer numberIn;

    private Date createdate;

    private Integer uid;

    private String pnum;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberIn() {
        return numberIn;
    }

    public void setNumberIn(Integer numberIn) {
        this.numberIn = numberIn;
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

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum == null ? null : pnum.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}