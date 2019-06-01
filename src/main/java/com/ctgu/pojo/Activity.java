package com.ctgu.pojo;

import java.util.Date;

public class Activity {
    private Integer id;

    private String aitem;

    private String adetail;

    private Date createdate;

    private Integer uid;

    private String cus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAitem() {
        return aitem;
    }

    public void setAitem(String aitem) {
        this.aitem = aitem == null ? null : aitem.trim();
    }

    public String getAdetail() {
        return adetail;
    }

    public void setAdetail(String adetail) {
        this.adetail = adetail == null ? null : adetail.trim();
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

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus == null ? null : cus.trim();
    }
}