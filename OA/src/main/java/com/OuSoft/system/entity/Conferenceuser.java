package com.OuSoft.system.entity;

import java.util.List;
import java.util.Set;

public class Conferenceuser {
    private String id;
    private String conferenceid;//会议id
    private  String userid;//人员id
    private  String signin;//签到时间
    private  String signout;//签退时间
    private String  remark;//备注
    private  String audit;//审核（1.通过 2.未通过 3.未审核）
    private String auditRemark;//审核说明
    private  String auditid;//审核人
    private   String conferenceSummarize;//会议总结
    private String  signinExplain;//签到内容
    private  String signoutExplain;//签退内容

    private String username;//参会人姓名
    private String conferencename;//会议名称
    private  String conferenceType;//会议类型（1.临时会 2.周会 3.月会 4.年会）
    private  String conferenceLevel;//会议级别（1.公司 2.部门 3.小组）
    private  String startTime;//开始时间
    private  String endTime;//结束时间
    private  String sessionState;//会议状态（1.未开始 2.进行中 3.已结束）
    private  String meetingPlace; //会议地点
    private String manage;//管理(01.我管理 02.我参与)
    private Set<String> list;
    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public Set<String> getList() {
        return list;
    }

    public void setList(Set<String> list) {
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSigninExplain() {
        return signinExplain;
    }

    public void setSigninExplain(String signinExplain) {
        this.signinExplain = signinExplain;
    }

    public String getSignoutExplain() {
        return signoutExplain;
    }

    public void setSignoutExplain(String signoutExplain) {
        this.signoutExplain = signoutExplain;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public String getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType;
    }

    public String getConferenceLevel() {
        return conferenceLevel;
    }

    public void setConferenceLevel(String conferenceLevel) {
        this.conferenceLevel = conferenceLevel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getConferenceSummarize() {
        return conferenceSummarize;
    }

    public void setConferenceSummarize(String conferenceSummarize) {
        this.conferenceSummarize = conferenceSummarize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConferenceid() {
        return conferenceid;
    }

    public void setConferenceid(String conferenceid) {
        this.conferenceid = conferenceid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSignin() {
        return signin;
    }

    public void setSignin(String signin) {
        this.signin = signin;
    }

    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid;
    }
}
