package com.OuSoft.system.entity;

public class Menu {
    private String id;
    private String title;
    private String url;
    private String odernum;
    private String remark;
    private String pid;
    private String whetherpublic;
    private String image;
    private String actiontype;
    private String menutype;
    private String menucode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOdernum() {
        return odernum;
    }

    public void setOdernum(String odernum) {
        this.odernum = odernum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getWhetherpublic() {
        return whetherpublic;
    }

    public void setWhetherpublic(String whetherpublic) {
        this.whetherpublic = whetherpublic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", odernum='" + odernum + '\'' +
                ", remark='" + remark + '\'' +
                ", pid='" + pid + '\'' +
                ", whetherpublic='" + whetherpublic + '\'' +
                ", image='" + image + '\'' +
                ", actiontype='" + actiontype + '\'' +
                ", menutype='" + menutype + '\'' +
                ", menucode='" + menucode + '\'' +
                '}';
    }
}
