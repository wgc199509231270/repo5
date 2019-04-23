package com.OuSoft.system.entity;

import java.security.PrivateKey;

/**
 * 合同
 */
public class Contract {
    private  String id;
    private  String contractId;//档案编号
    private  String userId;//用户id
    private  String astarttime;//开始时间
    private String aendtime;//结束时间
    private String accessory; //附件
    private String filetext;//附件说明
    private String createtime;//创建时间
    private  String nucleususerid;//创建人

    private  String username;//姓名
    private  String posiname;//职位
    private  String grzdeparname;//部门

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAstarttime() {
        return astarttime;
    }

    public void setAstarttime(String astarttime) {
        this.astarttime = astarttime;
    }

    public String getAendtime() {
        return aendtime;
    }

    public void setAendtime(String aendtime) {
        this.aendtime = aendtime;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getFiletext() {
        return filetext;
    }

    public void setFiletext(String filetext) {
        this.filetext = filetext;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNucleususerid() {
        return nucleususerid;
    }

    public void setNucleususerid(String nucleususerid) {
        this.nucleususerid = nucleususerid;
    }
}
