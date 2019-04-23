package com.OuSoft.system.entity;

/**
 * 调薪流程
 */
public class Remunerationflow {
    private String id;
    private String userId;//人员id
    private String  departmentId;//部门id
    private String Recommendsalary;//推荐薪资
    private String state;//状态 （1.已通过、2.未通过 3.未审核）
    private String grade;//审批流程（.主管 2.部门经理 3.总经理）
    private String trialuserid;//审批人
    private String trialtext;//审批说明
    private String  inputTime;//添加时间
    private String  approverId;//添加人id
    private String filetext;//附件

    private String groupuserid;//组长id
    private String groupstate;//组长状态
    private String grouptext;//组长审批说明
    private String partuserid;//部门经理
    private String partstate;//部门经状态
    private String parttext;//部门经理审批说明
    private String totalmanagerid;//总经理id
    private String totalmanagertext;//总经理说明
    private String nucleusname;//最终审核人姓名

    private  String username;//姓名
    private  String posiname;//职位
    private  String grzdeparname;//部门
    private  String frontPay;//当前薪资

    public String getFrontPay() {
        return frontPay;
    }

    public void setFrontPay(String frontPay) {
        this.frontPay = frontPay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFiletext() {
        return filetext;
    }

    public void setFiletext(String filetext) {
        this.filetext = filetext;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTrialuserid() {
        return trialuserid;
    }

    public void setTrialuserid(String trialuserid) {
        this.trialuserid = trialuserid;
    }

    public String getTrialtext() {
        return trialtext;
    }

    public void setTrialtext(String trialtext) {
        this.trialtext = trialtext;
    }

    public String getGroupuserid() {
        return groupuserid;
    }

    public void setGroupuserid(String groupuserid) {
        this.groupuserid = groupuserid;
    }

    public String getGroupstate() {
        return groupstate;
    }

    public void setGroupstate(String groupstate) {
        this.groupstate = groupstate;
    }

    public String getGrouptext() {
        return grouptext;
    }

    public void setGrouptext(String grouptext) {
        this.grouptext = grouptext;
    }

    public String getPartuserid() {
        return partuserid;
    }

    public void setPartuserid(String partuserid) {
        this.partuserid = partuserid;
    }

    public String getPartstate() {
        return partstate;
    }

    public void setPartstate(String partstate) {
        this.partstate = partstate;
    }

    public String getParttext() {
        return parttext;
    }

    public void setParttext(String parttext) {
        this.parttext = parttext;
    }

    public String getTotalmanagerid() {
        return totalmanagerid;
    }

    public void setTotalmanagerid(String totalmanagerid) {
        this.totalmanagerid = totalmanagerid;
    }

    public String getTotalmanagertext() {
        return totalmanagertext;
    }

    public void setTotalmanagertext(String totalmanagertext) {
        this.totalmanagertext = totalmanagertext;
    }

    public String getNucleusname() {
        return nucleusname;
    }

    public void setNucleusname(String nucleusname) {
        this.nucleusname = nucleusname;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRecommendsalary() {
        return Recommendsalary;
    }

    public void setRecommendsalary(String recommendsalary) {
        Recommendsalary = recommendsalary;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
