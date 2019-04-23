package com.OuSoft.system.entity;

public class Tdepartmentinfo {
	
	
	
	private String text;//树形结构使用 -组
	private String epid;//树形结构使用 -组
	private String deparnames;//树形结构使用- 组
	private String nodeids;//树形结构使用-组
	
	private String nodeid;//树形结构使用id-部门
	
	private String id;
	private String createtime;
	private String deparname;//部门名称
	private String deparepid;//部门关系id
	private String departime;//部门创建时间
	private String deparpid;//顶级公司id
	private String remark;//备注
	
	
	private String deparid;
	private String userid;
	private String tcmid;
	
	
	
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEpid() {
		return epid;
	}
	public void setEpid(String epid) {
		this.epid = epid;
	}
	public String getDeparnames() {
		return deparnames;
	}
	public void setDeparnames(String deparnames) {
		this.deparnames = deparnames;
	}
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public String getNodeids() {
		return nodeids;
	}
	public void setNodeids(String nodeids) {
		this.nodeids = nodeids;
	}
	public String getTcmid() {
		return tcmid;
	}
	public void setTcmid(String tcmid) {
		this.tcmid = tcmid;
	}
	public String getDeparid() {
		return deparid;
	}
	public void setDeparid(String deparid) {
		this.deparid = deparid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeparname() {
		return deparname;
	}
	public void setDeparname(String deparname) {
		this.deparname = deparname;
	}
	public String getDeparepid() {
		return deparepid;
	}
	public void setDeparepid(String deparepid) {
		this.deparepid = deparepid;
	}
	public String getDepartime() {
		return departime;
	}
	public void setDepartime(String departime) {
		this.departime = departime;
	}
	public String getDeparpid() {
		return deparpid;
	}
	public void setDeparpid(String deparpid) {
		this.deparpid = deparpid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Tdepartmentinfo [epid=" + epid + ", deparnames=" + deparnames
				+ ", nodeids=" + nodeids + ", nodeid=" + nodeid + ", id=" + id
				+ ", deparname=" + deparname + ", deparepid=" + deparepid
				+ ", departime=" + departime + ", deparpid=" + deparpid
				+ ", remark=" + remark + ", deparid=" + deparid + ", userid="
				+ userid + ", tcmid=" + tcmid + "]";
	}
	
	
	
}
