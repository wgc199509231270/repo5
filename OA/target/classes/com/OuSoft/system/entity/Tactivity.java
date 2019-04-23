package com.OuSoft.system.entity;

/**
 * mcc
 */
public class Tactivity {
    private String id;
    private String promulgatorid;//活动发布人id
    private String activname;//活动名称
    private String theme;//活动主题
    private String starttime;//活动开始时间
    private String endtime;//活动结束时间
    private String regstarttime;//报名开始时间
    private String regendtime;//报名结束时间
    private String address;//活动地址
    private String content;//活动内容
    private String requires;//活动要求
    private String remark;//备注
    private String status;//活动状态
    private String creattime;//活动创建时间

    private String userid;//报名活动的用户id
    private String activityid;//活动id
    private String regstatus;//报名状态
    private String managerid;//活动管理员
    private String alluser;//01全部活动 02我的活动

    private String text;//模糊查询字段
    private String filename;//图片名
    private String ip;//图片ip
    private String username;//名字

    private String cron;//定时时间

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPromulgatorid() {
        return promulgatorid;
    }

    public void setPromulgatorid(String promulgatorid) {
        this.promulgatorid = promulgatorid;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getActivname() {
        return activname;
    }

    public void setActivname(String activname) {
        this.activname = activname;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getRegstarttime() {
        return regstarttime;
    }

    public void setRegstarttime(String regstarttime) {
        this.regstarttime = regstarttime;
    }

    public String getRegendtime() {
        return regendtime;
    }

    public void setRegendtime(String regendtime) {
        this.regendtime = regendtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getAlluser() {
        return alluser;
    }

    public void setAlluser(String alluser) {
        this.alluser = alluser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
