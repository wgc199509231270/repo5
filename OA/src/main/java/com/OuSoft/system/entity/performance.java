package com.OuSoft.system.entity;

/**
 * 业绩表
 * @author wangyuxin
 *
 */
public class performance {
	
	
	private String type;// 01 个人，02小组，03部门
	private String grzdeparid;// 组id
	private String grzdeparname;// 部门id
	
	private String grbdeparid;  //： 部门id
	private String grbdeparname;// :部门名称
	
	
	//审核人id
	private String pfmauditid;
	
	private String deparepid;//deparepid
	private String pername;//部门
	private String deparid;//部门id
	private String tpranum;//点赞
	private String comnum;//评论
	private String dz;//当前用户是否点赞
	private String deparname;//点赞姓名
	private String username;//姓名
	private String commentnum;//评论数
	private String praisenum;//点赞数
	private String grzdeparnames;//职位
	private String GetDateGY3;
	private String currentMonthStartTime;

	public String getGetDateGY3() {
		return GetDateGY3;
	}

	public void setGetDateGY3(String getDateGY3) {
		GetDateGY3 = getDateGY3;
	}

	public String getCurrentMonthStartTime() {
		return currentMonthStartTime;
	}

	public void setCurrentMonthStartTime(String currentMonthStartTime) {
		this.currentMonthStartTime = currentMonthStartTime;
	}

	private  String posiname;
		private  String remuneration;

	public String getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(String remuneration) {
		this.remuneration = remuneration;
	}

	public String getGrzdeparnames() {
		return grzdeparnames;
	}

	public void setGrzdeparnames(String grzdeparnames) {
		this.grzdeparnames = grzdeparnames;
	}

	public String getPosiname() {
		return posiname;
	}

	public void setPosiname(String posiname) {
		this.posiname = posiname;
	}

	private String state;//01 是 业绩，02 是审核
	private String id;
	private String userid;//发布人id
	private String pfmnumber;//业绩量
	private String pfmworkhours;//工作时长
	private String pfmtext;//业绩内容
	private String pfmtype;//业绩类型：需求、设计、开发
	private String pfmdepartmentid;//所属部门：关联部门表：产品、技术、项目
	private String pfmstarttime;//业绩开始时间
	private String pfmendtime;//业绩结束时间
	private String pfmissuersuccess;//发布人完成说明
	private String pfmdowntext;//所属业绩：
	private String pfmpid;//所属业绩父id
	private String pfmstate;//业绩状态：未确认01,未通过03,已通过04,已完成,已审核
	private String pfmaffirmtime;//已确认时间
	private String pfmaudittime;//已审核时间
	private String pfmissuerpublish;//发布人发布说明
	private String pfmauditoraffirm;//审核人确认说明
	private String pfmauditoraudit;//审核人审核说明
	private String pfmachieveplan;//完成进度，100%后审核人可点击审核
	private String pfmrealitystarttime;//审核后：开始时间(实际开始时间)
	private String pfmrealityendtime;//审核后：结束时间(实际结束时间)
	private String realitypfm;//实际业绩
	private String realityworkhours;//实际时长
	private String realityefficient;//实际效率
	private String createtime;//创建时间
	private String remark;//创建时间
	private String tcmid;//顶级公司id
	
	
	
	
	
	
	
	public String getGrbdeparid() {
		return grbdeparid;
	}
	public void setGrbdeparid(String grbdeparid) {
		this.grbdeparid = grbdeparid;
	}
	public String getGrbdeparname() {
		return grbdeparname;
	}
	public void setGrbdeparname(String grbdeparname) {
		this.grbdeparname = grbdeparname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrzdeparid() {
		return grzdeparid;
	}
	public void setGrzdeparid(String grzdeparid) {
		this.grzdeparid = grzdeparid;
	}
	public String getGrzdeparname() {
		return grzdeparname;
	}
	public void setGrzdeparname(String grzdeparname) {
		this.grzdeparname = grzdeparname;
	}
	public String getDeparepid() {
		return deparepid;
	}
	public void setDeparepid(String deparepid) {
		this.deparepid = deparepid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPername() {
		return pername;
	}
	public void setPername(String pername) {
		this.pername = pername;
	}
	public String getPfmauditid() {
		return pfmauditid;
	}
	public void setPfmauditid(String pfmauditid) {
		this.pfmauditid = pfmauditid;
	}
	public String getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(String commentnum) {
		this.commentnum = commentnum;
	}
	public String getPraisenum() {
		return praisenum;
	}
	public void setPraisenum(String praisenum) {
		this.praisenum = praisenum;
	}
	public String getDeparid() {
		return deparid;
	}
	public void setDeparid(String deparid) {
		this.deparid = deparid;
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
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getDeparname() {
		return deparname;
	}
	public void setDeparname(String deparname) {
		this.deparname = deparname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTcmid() {
		return tcmid;
	}
	public void setTcmid(String tcmid) {
		this.tcmid = tcmid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	public String getPfmtext() {
		return pfmtext;
	}
	public void setPfmtext(String pfmtext) {
		this.pfmtext = pfmtext;
	}
	public String getPfmtype() {
		return pfmtype;
	}
	public void setPfmtype(String pfmtype) {
		this.pfmtype = pfmtype;
	}
	public String getPfmdepartmentid() {
		return pfmdepartmentid;
	}
	public void setPfmdepartmentid(String pfmdepartmentid) {
		this.pfmdepartmentid = pfmdepartmentid;
	}
	public String getPfmstarttime() {
		return pfmstarttime;
	}
	public void setPfmstarttime(String pfmstarttime) {
		this.pfmstarttime = pfmstarttime;
	}
	public String getPfmendtime() {
		return pfmendtime;
	}
	public void setPfmendtime(String pfmendtime) {
		this.pfmendtime = pfmendtime;
	}
	public String getPfmissuersuccess() {
		return pfmissuersuccess;
	}
	public void setPfmissuersuccess(String pfmissuersuccess) {
		this.pfmissuersuccess = pfmissuersuccess;
	}
	public String getPfmdowntext() {
		return pfmdowntext;
	}
	public void setPfmdowntext(String pfmdowntext) {
		this.pfmdowntext = pfmdowntext;
	}
	public String getPfmpid() {
		return pfmpid;
	}
	public void setPfmpid(String pfmpid) {
		this.pfmpid = pfmpid;
	}
	public String getPfmstate() {
		return pfmstate;
	}
	public void setPfmstate(String pfmstate) {
		this.pfmstate = pfmstate;
	}
	public String getPfmaffirmtime() {
		return pfmaffirmtime;
	}
	public void setPfmaffirmtime(String pfmaffirmtime) {
		this.pfmaffirmtime = pfmaffirmtime;
	}
	public String getPfmaudittime() {
		return pfmaudittime;
	}
	public void setPfmaudittime(String pfmaudittime) {
		this.pfmaudittime = pfmaudittime;
	}
	public String getPfmissuerpublish() {
		return pfmissuerpublish;
	}
	public void setPfmissuerpublish(String pfmissuerpublish) {
		this.pfmissuerpublish = pfmissuerpublish;
	}
	public String getPfmauditoraffirm() {
		return pfmauditoraffirm;
	}
	public void setPfmauditoraffirm(String pfmauditoraffirm) {
		this.pfmauditoraffirm = pfmauditoraffirm;
	}
	public String getPfmauditoraudit() {
		return pfmauditoraudit;
	}
	public void setPfmauditoraudit(String pfmauditoraudit) {
		this.pfmauditoraudit = pfmauditoraudit;
	}
	public String getPfmachieveplan() {
		return pfmachieveplan;
	}
	public void setPfmachieveplan(String pfmachieveplan) {
		this.pfmachieveplan = pfmachieveplan;
	}
	public String getPfmrealitystarttime() {
		return pfmrealitystarttime;
	}
	public void setPfmrealitystarttime(String pfmrealitystarttime) {
		this.pfmrealitystarttime = pfmrealitystarttime;
	}
	public String getPfmrealityendtime() {
		return pfmrealityendtime;
	}
	public void setPfmrealityendtime(String pfmrealityendtime) {
		this.pfmrealityendtime = pfmrealityendtime;
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
	public String getRealityefficient() {
		return realityefficient;
	}
	public void setRealityefficient(String realityefficient) {
		this.realityefficient = realityefficient;
	}
	
}
