package com.OuSoft.system.entity;

   /**
    * Plan 实体类
    * 2018-08-24 15:22:03 Lw
    */

public class Plan{
	private String txfilename;
	private String tattid;
	private String username;
	private String tpranum;
	private String comnum;
	private String loginname; 
	private String begtime;
	private String endtime;
	private String tprafilename;
	private String tprausername;
	
	private String sqtsgin;
	private String ip;
	private String dz;
	private String numworkhour;
	private String rtime;
	private String mtime;
	private String text;
	private String husername;
	private String hfilename;
	private String pusername;
	private String pagenum;
	private String pagesize;
	private String itemid;
	private String commenttext;
	private String dzuserid;
	private String tcmid;
	private String workload;
	private String status;

	private String planning;//计划帮助
	private String prospectus;//计划说明

	   private String realycient;//效率
	   private String sche;//进度

	   private String cltype;//01签到02签退
	   private String clstatus;// 01正常 02迟到 03早退
	   private String clstatusp;// 01正常 02迟到 03早退
	   private String deparname;//部门
	   private String jobname;//岗位
	   private int limit;//分页
	   private String clocktime;

	   private String clockrank;//签到排名 01：签到时间排名02计划业绩排名03计划用时排名04完成业绩排名05完成用时排名
	   private String depyesno;//是否有部门 01有02无
	   private String type;//01计划02审核
	   private String verifierid;//审核人id
	   private String starttime;//计划开始时间
	   private String comtime;//实际完成时间
	   private String complantime;//计划完成时间
	   private String completetext;//完成说明
	   private String complan;//完成计划量
	   private String vertime;//审核业绩
	   private String verifiertext;//审核说明
	   private String verplan;//审核计划量
       private String deparepid;//部门id
		private String verendtime;//审核时间
	   private String cltime;
	   private String cltimep;
	   private String clform;
	   private String clformp;
	   private String clplace;
	   private String clplacep;

	   private String idtype;//01全部02部门03个人

	   public String getTattid() {
		   return tattid;
	   }

	   public void setTattid(String tattid) {
		   this.tattid = tattid;
	   }

	   public String getIdtype() {
		   return idtype;
	   }

	   public void setIdtype(String idtype) {
		   this.idtype = idtype;
	   }

	   public String getVerendtime() {
		   return verendtime;
	   }

	   public void setVerendtime(String verendtime) {
		   this.verendtime = verendtime;
	   }

	   public String getDeparepid() {
           return deparepid;
       }

       public void setDeparepid(String deparepid) {
           this.deparepid = deparepid;
       }

       public String getCltime() {
		   return cltime;
	   }

	   public void setCltime(String cltime) {
		   this.cltime = cltime;
	   }

	   public String getCltimep() {
		   return cltimep;
	   }

	   public void setCltimep(String cltimep) {
		   this.cltimep = cltimep;
	   }

	   public String getClform() {
		   return clform;
	   }

	   public void setClform(String clform) {
		   this.clform = clform;
	   }

	   public String getClformp() {
		   return clformp;
	   }

	   public void setClformp(String clformp) {
		   this.clformp = clformp;
	   }

	   public String getClplace() {
		   return clplace;
	   }

	   public void setClplace(String clplace) {
		   this.clplace = clplace;
	   }

	   public String getClplacep() {
		   return clplacep;
	   }

	   public void setClplacep(String clplacep) {
		   this.clplacep = clplacep;
	   }

	   public String getComplantime() {
		   return complantime;
	   }

	   public void setComplantime(String complantime) {
		   this.complantime = complantime;
	   }

	   public String getClstatusp() {
		   return clstatusp;
	   }

	   public void setClstatusp(String clstatusp) {
		   this.clstatusp = clstatusp;
	   }

	   public String getVertime() {
		   return vertime;
	   }

	   public void setVertime(String vertime) {
		   this.vertime = vertime;
	   }

	   public String getVerifiertext() {
		   return verifiertext;
	   }

	   public void setVerifiertext(String verifiertext) {
		   this.verifiertext = verifiertext;
	   }

	   public String getVerplan() {
		   return verplan;
	   }

	   public void setVerplan(String verplan) {
		   this.verplan = verplan;
	   }

	   private String clockid;//签到id

	   public String getComplan() {
		   return complan;
	   }

	   public void setComplan(String complan) {
		   this.complan = complan;
	   }

	   public String getComtime() {
		   return comtime;
	   }

	   public void setComtime(String comtime) {
		   this.comtime = comtime;
	   }

	   public String getCompletetext() {
		   return completetext;
	   }

	   public void setCompletetext(String completetext) {
		   this.completetext = completetext;
	   }

	   public String getClockid() {
		   return clockid;
	   }

	   public void setClockid(String clockid) {
		   this.clockid = clockid;
	   }

	   public String getStarttime() {
		   return starttime;
	   }

	   public void setStarttime(String starttime) {
		   this.starttime = starttime;
	   }

	   public String getVerifierid() {
		   return verifierid;
	   }

	   public void setVerifierid(String verifierid) {
		   this.verifierid = verifierid;
	   }

	   public String getType() {
		   return type;
	   }

	   public void setType(String type) {
		   this.type = type;
	   }

	   public String getClocktime() {
		   return clocktime;
	   }

	   public void setClocktime(String clocktime) {
		   this.clocktime = clocktime;
	   }

	   public String getJobname() {
		   return jobname;
	   }

	   public void setJobname(String jobname) {
		   this.jobname = jobname;
	   }

	   public String getDepyesno() {
		   return depyesno;
	   }

	   public void setDepyesno(String depyesno) {
		   this.depyesno = depyesno;
	   }

	   public String getClockrank() {
		   return clockrank;
	   }

	   public void setClockrank(String clockrank) {
		   this.clockrank = clockrank;
	   }

	   public String getStatus() {
		   return status;
	   }

	   public void setStatus(String status) {
		   this.status = status;
	   }

	   public int getLimit() {
		   return limit;
	   }

	   public void setLimit(int limit) {
		   this.limit = limit;
	   }

	   public String getDeparname() {
		   return deparname;
	   }

	   public void setDeparname(String deparname) {
		   this.deparname = deparname;
	   }

	   public String getSche() {
		   return sche;
	   }

	   public void setSche(String sche) {
		   this.sche = sche;
	   }

	   public String getClstatus() {
		   return clstatus;
	   }

	   public void setClstatus(String clstatus) {
		   this.clstatus = clstatus;
	   }

	   public String getRealycient() {
		   return realycient;
	   }

	   public void setRealycient(String realycient) {
		   this.realycient = realycient;
	   }

	   public String getCltype() {
		   return cltype;
	   }

	   public void setCltype(String cltype) {
		   this.cltype = cltype;
	   }

	   public String getPlanning() {
		   return planning;
	   }

	   public void setPlanning(String planning) {
		   this.planning = planning;
	   }

	   public String getProspectus() {
		   return prospectus;
	   }

	   public void setProspectus(String prospectus) {
		   this.prospectus = prospectus;
	   }

	   public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
	}
	public String getTcmid() {
		return tcmid;
	}
	public void setTcmid(String tcmid) {
		this.tcmid = tcmid;
	}
	public String getDzuserid() {
		return dzuserid;
	}
	public void setDzuserid(String dzuserid) {
		this.dzuserid = dzuserid;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getHusername() {
		return husername;
	}
	public void setHusername(String husername) {
		this.husername = husername;
	}
	public String getHfilename() {
		return hfilename;
	}
	public void setHfilename(String hfilename) {
		this.hfilename = hfilename;
	}
	public String getPusername() {
		return pusername;
	}
	public void setPusername(String pusername) {
		this.pusername = pusername;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getNumworkhour() {
		return numworkhour;
	}
	public void setNumworkhour(String numworkhour) {
		this.numworkhour = numworkhour;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getSqtsgin() {
		return sqtsgin;
	}
	public void setSqtsgin(String sqtsgin) {
		this.sqtsgin = sqtsgin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTxfilename() {
		return txfilename;
	}
	public void setTxfilename(String txfilename) {
		this.txfilename = txfilename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTpranum() {
		return tpranum;
	}
	public void setTpranum(String tpranum) {
		this.tpranum = tpranum;
	}
	public String getComnum() {
		return comnum;
	}
	public void setComnum(String comnum) {
		this.comnum = comnum;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
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
	public String getTprafilename() {
		return tprafilename;
	}
	public void setTprafilename(String tprafilename) {
		this.tprafilename = tprafilename;
	}
	public String getTprausername() {
		return tprausername;
	}
	public void setTprausername(String tprausername) {
		this.tprausername = tprausername;
	}
	/**
	*主键
	*/
	private String	id;
	/**
	*用户 外键（关联tsuser表）
	*/
	private String	userid;
	/**
	*创建计划的时间
	*/
	private String	createtime;
	/**
	*计划的内容
	*/
	private String	plantext;
	/**
	*计划类型
	*/
	private String	plantype;
	/**
	*计划工作量
	*/
	private String	workhour;
	/**
	*备注
	*/
	private String	remark;

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}
	public String getUserid(){
		return userid;
	}

	public void setCreatetime(String createtime){
		this.createtime=createtime;
	}
	public String getCreatetime(){
		return createtime;
	}

	public void setPlantext(String plantext){
		this.plantext=plantext;
	}
	public String getPlantext(){
		return plantext;
	}

	public void setPlantype(String plantype){
		this.plantype=plantype;
	}
	public String getPlantype(){
		return plantype;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public String getWorkhour() {
		return workhour;
	}
	public void setWorkhour(String workhour) {
		this.workhour = workhour;
	}
	
}
