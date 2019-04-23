package com.OuSoft.system.entity;

import java.util.List;

public class Tjobinfo {
	
	private String id;
	private String jobname;
	private String remark;
	private String jobpid;
	private String jobtime;
	private String dkey;
	private String dvalue;
	
	private String deparid;
	private String jobnum;
	
	
	private String userid;
	private String jobid;

	private int limit;

	private List<String> list;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getDeparid() {
		return deparid;
	}
	public void setDeparid(String deparid) {
		this.deparid = deparid;
	}
	public String getJobnum() {
		return jobnum;
	}
	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}
	public String getDkey() {
		return dkey;
	}
	public void setDkey(String dkey) {
		this.dkey = dkey;
	}
	public String getDvalue() {
		return dvalue;
	}
	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
	}
	public String getJobtime() {
		return jobtime;
	}
	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getJobpid() {
		return jobpid;
	}
	public void setJobpid(String jobpid) {
		this.jobpid = jobpid;
	}
	

}
