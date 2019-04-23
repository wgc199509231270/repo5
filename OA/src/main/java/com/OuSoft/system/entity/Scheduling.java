package com.OuSoft.system.entity;

public class Scheduling {

	private String id;//主键id                
	private String shiftworkid;//排班班次id
	private String teamsid;//班次对应班组id
	private String userid;//客服人员ID，创建时自动加上班组里的所有人
	private String sccreatetime;//创建时间
	private String sccreateman;//创建人
	private String scbegintime;//开始时间
	private String scendtime;//结束时间
	private int sctype;//排班类型
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShiftworkid() {
		return shiftworkid;
	}
	public void setShiftworkid(String shiftworkid) {
		this.shiftworkid = shiftworkid;
	}
	public String getTeamsid() {
		return teamsid;
	}
	public void setTeamsid(String teamsid) {
		this.teamsid = teamsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSccreatetime() {
		return sccreatetime;
	}
	public void setSccreatetime(String sccreatetime) {
		this.sccreatetime = sccreatetime;
	}
	public String getSccreateman() {
		return sccreateman;
	}
	public void setSccreateman(String sccreateman) {
		this.sccreateman = sccreateman;
	}
	public String getScbegintime() {
		return scbegintime;
	}
	public void setScbegintime(String scbegintime) {
		this.scbegintime = scbegintime;
	}
	public String getScendtime() {
		return scendtime;
	}
	public void setScendtime(String scendtime) {
		this.scendtime = scendtime;
	}
	public int getSctype() {
		return sctype;
	}
	public void setSctype(int sctype) {
		this.sctype = sctype;
	}

	
	
	
}
