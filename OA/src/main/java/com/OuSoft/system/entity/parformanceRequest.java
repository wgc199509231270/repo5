package com.OuSoft.system.entity;

public class parformanceRequest {
	
	
	private String bdeparid;//部门id
	private String zdeparid;//小组id
	
	
	private String pfmauditresults;//审核业绩
	private String realitypfm;//实际业绩
	private String realityworkhours;//实际时长
	private String pfmnumber;//工作业绩 
	private String pfmworkhours;//

	
	
	public String getBdeparid() {
		return bdeparid;
	}
	public void setBdeparid(String bdeparid) {
		this.bdeparid = bdeparid;
	}
	public String getZdeparid() {
		return zdeparid;
	}
	public void setZdeparid(String zdeparid) {
		this.zdeparid = zdeparid;
	}
	public String getRealitypfm() {
		return realitypfm;
	}
	public void setRealitypfm(String realitypfm) {
		this.realitypfm = realitypfm;
	}
	public String getRealityworkhours() {
		return realityworkhours;
	}
	public void setRealityworkhours(String realityworkhours) {
		this.realityworkhours = realityworkhours;
	}
	public String getPfmnumber() {
		return pfmnumber;
	}
	public void setPfmnumber(String pfmnumber) {
		this.pfmnumber = pfmnumber;
	}
	public String getPfmworkhours() {
		return pfmworkhours;
	}
	public void setPfmworkhours(String pfmworkhours) {
		this.pfmworkhours = pfmworkhours;
	}
	private String rate;//效率
	private String num;//实际结束时间
	private String rownum;//实际结束时间
	private String pfmrealityendtime;//实际结束时间
	private String pfmrealitystarttime;//实际开始时间
	private String pfmendtime;//计划结束时间
	private String pfmstarttime;//计划开始时间
	private String deparid;//点赞用户id
	private String dzuserid;//点赞用户id
	private String tpraid;//
	private String username;//
	private String tprausername;//
	private String tparuserid;//
	private String txfulename;//
	private String ip;//
	private String dz;//
	
	
	
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getPfmrealityendtime() {
		return pfmrealityendtime;
	}
	public void setPfmrealityendtime(String pfmrealityendtime) {
		this.pfmrealityendtime = pfmrealityendtime;
	}
	public String getPfmrealitystarttime() {
		return pfmrealitystarttime;
	}
	public void setPfmrealitystarttime(String pfmrealitystarttime) {
		this.pfmrealitystarttime = pfmrealitystarttime;
	}
	public String getPfmendtime() {
		return pfmendtime;
	}
	public void setPfmendtime(String pfmendtime) {
		this.pfmendtime = pfmendtime;
	}
	public String getPfmstarttime() {
		return pfmstarttime;
	}
	public void setPfmstarttime(String pfmstarttime) {
		this.pfmstarttime = pfmstarttime;
	}
	
	private String id;//排名参数   01，02，03
	private String type;//排名参数   01，02，03
	private String state;//范围参数01，02，03
	private String grouptime;//范围参数01，02，03
	private String deparepid;//部门编号
	private String starttime;//开始时间
	private String endtime;//结束时间
	private String tcmid;//顶级公司id
	private int pagenum;
	private int pagesize;
	private String userid;
	private String acrossendlong;//横纵 01，02
	private String object;//对象参数01，02，03	


	private String timetype;

	public String getTimetype() {
		return timetype;
	}

	public void setTimetype(String timetype) {
		this.timetype = timetype;
	}

	public String getGrouptime() {
		return grouptime;
	}
	public void setGrouptime(String grouptime) {
		this.grouptime = grouptime;
	}
	public String getDeparid() {
		return deparid;
	}
	public void setDeparid(String deparid) {
		this.deparid = deparid;
	}
	public String getPfmauditresults() {
		return pfmauditresults;
	}
	public void setPfmauditresults(String pfmauditresults) {
		this.pfmauditresults = pfmauditresults;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDzuserid() {
		return dzuserid;
	}
	public void setDzuserid(String dzuserid) {
		this.dzuserid = dzuserid;
	}
	public String getTpraid() {
		return tpraid;
	}
	public void setTpraid(String tpraid) {
		this.tpraid = tpraid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTprausername() {
		return tprausername;
	}
	public void setTprausername(String tprausername) {
		this.tprausername = tprausername;
	}
	public String getTparuserid() {
		return tparuserid;
	}
	public void setTparuserid(String tparuserid) {
		this.tparuserid = tparuserid;
	}
	public String getTxfulename() {
		return txfulename;
	}
	public void setTxfulename(String txfulename) {
		this.txfulename = txfulename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getObject() {
		return object;
	}
	public String getAcrossendlong() {
		return acrossendlong;
	}
	public void setAcrossendlong(String acrossendlong) {
		this.acrossendlong = acrossendlong;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDeparepid() {
		return deparepid;
	}
	public void setDeparepid(String deparepid) {
		this.deparepid = deparepid;
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
	public String getTcmid() {
		return tcmid;
	}
	public void setTcmid(String tcmid) {
		this.tcmid = tcmid;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
}
