package com.OuSoft.system.entity;


public class Attendance {
	
	private String id;
	private String userid;//提交人id
	private String atype;//请假类型:01事，02病，03产，04婚，05丧，06年休
	private String astarttime;//开始时间
	private String aendtime;//结束时间
	private String timetype;//时间类型/01天/02时
	private String duration;//时，天，根据时间类型分辨是天还是时
	private String text;//请假事由
	private String state;//审批状态，01通过，02未通过，03审核中
	private String trialuserid;//审批人
	private String trialtext;//审批说明
	private String filetext;//附件说明
	private String createtime;//创建时间
	private String nucleususerid;//创建时间

	private String groupuserid;//组长id
	private String groupstate;//组长状态
	private String grouptext;//组长审批说明
	private String partuserid;//部门经理
	private String partstate;//部门经状态
	private String parttext;//部门经理审批说明
	private String totalmanagerid;//总经理id
	private String totalmanagertext;//总经理说明
	private String nucleusname;//最终审核人姓名

	
	
	public String getNucleusname() {
		return nucleusname;
	}
	public void setNucleusname(String nucleusname) {
		this.nucleusname = nucleusname;
	}
	public String getNucleususerid() {
		return nucleususerid;
	}
	public void setNucleususerid(String nucleususerid) {
		this.nucleususerid = nucleususerid;
	}
	private String username;
	private String txfilename;
	private String ip;
	
	private String zusername;//组姓名
	private String busername;//部门经理名称
	private String zjlusername;//总经理名称
	
	
	private String type;//状态
	private String statetype;//请假休息请假状态
	
	
	
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getStatetype() {
		return statetype;
	}
	public void setStatetype(String statetype) {
		this.statetype = statetype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZusername() {
		return zusername;
	}
	public void setZusername(String zusername) {
		this.zusername = zusername;
	}
	public String getBusername() {
		return busername;
	}
	public void setBusername(String busername) {
		this.busername = busername;
	}
	public String getZjlusername() {
		return zjlusername;
	}
	public void setZjlusername(String zjlusername) {
		this.zjlusername = zjlusername;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTxfilename() {
		return txfilename;
	}
	public void setTxfilename(String txfilename) {
		this.txfilename = txfilename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
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
	public String getTimetype() {
		return timetype;
	}
	public void setTimetype(String timetype) {
		this.timetype = timetype;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public String getFiletext() {
		return filetext;
	}
	public void setFiletext(String filetext) {
		this.filetext = filetext;
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
	
	
	

}
