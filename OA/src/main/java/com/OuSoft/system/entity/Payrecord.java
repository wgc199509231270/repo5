package com.OuSoft.system.entity;

public class Payrecord {
    private  String id;
    private  String userId;//用户id
    private  String frontPay;//调薪前
    private  String queenPay;//调薪后
    private  String inputTime;//时间
    private  String approverId;//添加人
    private  String describ;//备注

    private  String begtime;//开始时间
    private  String endtime;//结束时间
    private  String username;//姓名
    private  String posiname;//职位
    private  String grzdeparname;//部门

    public String getBegtime() {
        return begtime;
    }

    public void setBegtime(String begtime) {
        this.begtime = begtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getPosiname() {
        return posiname;
    }

    public void setPosiname(String posiname) {
        this.posiname = posiname;
    }

    public String getGrzdeparname() {
        return grzdeparname;
    }

    public void setGrzdeparname(String grzdeparname) {
        this.grzdeparname = grzdeparname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFrontPay() {
        return frontPay;
    }

    public void setFrontPay(String frontPay) {
        this.frontPay = frontPay;
    }

    public String getQueenPay() {
        return queenPay;
    }

    public void setQueenPay(String queenPay) {
        this.queenPay = queenPay;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }
}
