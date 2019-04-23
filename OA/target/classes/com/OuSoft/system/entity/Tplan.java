package com.OuSoft.system.entity;

public class Tplan {
	
	private String id;
	private String userid;
	private String createtime;//创建时间
	private String plantext;//内容
	private String plantype;//计划类型（01:日计划 02：周计划  03：月计划）
	private double workhour;//工作量
	private double workload;//工作量
	private String remark;//备注
	
	
	
	
	public double getWorkload() {
		return workload;
	}
	public void setWorkload(double workload) {
		this.workload = workload;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getPlantext() {
		return plantext;
	}
	public void setPlantext(String plantext) {
		this.plantext = plantext;
	}
	public String getPlantype() {
		return plantype;
	}
	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}
	
	public double getWorkhour() {
		return workhour;
	}
	public void setWorkhour(double workhour) {
		this.workhour = workhour;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	

}
