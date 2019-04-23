package com.OuSoft.system.entity;

public class AchievementsRequestParamModel {
	private String acs_id; //主键id
	private String acs_title;	//业绩标题
	private String acs_workload;	//分配工作量
	private String acs_actual_workload;	//实际工作量
	private String acs_content;	//业绩内容
	private String acs_type;	//业绩分类
	private String acs_starttime;	//业绩开始时间
	private String acs_endtime;	//业绩结束时间
	private String acs_pid;	//业绩父级id
	private String acs_code;	//业绩编码
	private String acs_state;	//业绩状态
	private String acs_statetime;	//业绩审核批复时间
	private String acs_state_comment;	//业绩审核批复内容
	private String acs_corp;	//所属部门
	private String acs_tab;	//业绩标签
	private String acs_receiver;	//业绩完成人
	private String acs_done;	// 工作完成状态
	
	private String username;	// 业绩人名称
	private String assessor;	// 审核人名称
	private String corpname;	//	部门名称
	private String corpid; // 部门id 对部门进行group by 部门业绩完成工作量统计需要用
	
	private String liketype; // 点赞的分类
	private String likecorp; // 点赞的部门
	private String commenttype; // 同上
	private String commentcorp; // 同上
	
	// 如果不录入排名方式 默认用 用户姓名排名
	private String Topofworkload; //根据工作量做排序排名
	private String Topoflike; //根据点赞数量做排序排名
	private String Topofcomment; //根据评论数量做排序排名
	
	// 如果需要分页必须加入 page 和 pageSize
	private String page;
	private String pageSize;
	
	// 对比其他的需要userid
	private String userid;
	
	private String tcmid;//顶级公司id

	public String getTcmid() {
		return tcmid;
	}

	public void setTcmid(String tcmid) {
		this.tcmid = tcmid;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getAcs_id() {
		return acs_id;
	}

	public void setAcs_id(String acs_id) {
		this.acs_id = acs_id;
	}

	public String getAcs_title() {
		return acs_title;
	}

	public void setAcs_title(String acs_title) {
		this.acs_title = acs_title;
	}

	public String getAcs_workload() {
		return acs_workload;
	}

	public void setAcs_workload(String acs_workload) {
		this.acs_workload = acs_workload;
	}

	public String getAcs_actual_workload() {
		return acs_actual_workload;
	}

	public void setAcs_actual_workload(String acs_actual_workload) {
		this.acs_actual_workload = acs_actual_workload;
	}

	public String getAcs_content() {
		return acs_content;
	}

	public void setAcs_content(String acs_content) {
		this.acs_content = acs_content;
	}

	public String getAcs_type() {
		return acs_type;
	}

	public void setAcs_type(String acs_type) {
		this.acs_type = acs_type;
	}

	public String getAcs_starttime() {
		return acs_starttime;
	}

	public void setAcs_starttime(String acs_starttime) {
		this.acs_starttime = acs_starttime;
	}

	public String getAcs_endtime() {
		return acs_endtime;
	}

	public void setAcs_endtime(String acs_endtime) {
		this.acs_endtime = acs_endtime;
	}

	public String getAcs_pid() {
		return acs_pid;
	}

	public void setAcs_pid(String acs_pid) {
		this.acs_pid = acs_pid;
	}

	public String getAcs_code() {
		return acs_code;
	}

	public void setAcs_code(String acs_code) {
		this.acs_code = acs_code;
	}

	public String getAcs_state() {
		return acs_state;
	}

	public void setAcs_state(String acs_state) {
		this.acs_state = acs_state;
	}

	public String getAcs_statetime() {
		return acs_statetime;
	}

	public void setAcs_statetime(String acs_statetime) {
		this.acs_statetime = acs_statetime;
	}

	public String getAcs_state_comment() {
		return acs_state_comment;
	}

	public void setAcs_state_comment(String acs_state_comment) {
		this.acs_state_comment = acs_state_comment;
	}

	public String getAcs_corp() {
		return acs_corp;
	}

	public void setAcs_corp(String acs_corp) {
		this.acs_corp = acs_corp;
	}

	public String getAcs_tab() {
		return acs_tab;
	}

	public void setAcs_tab(String acs_tab) {
		this.acs_tab = acs_tab;
	}

	public String getAcs_receiver() {
		return acs_receiver;
	}

	public void setAcs_receiver(String acs_receiver) {
		this.acs_receiver = acs_receiver;
	}

	public String getLiketype() {
		return liketype;
	}

	public void setLiketype(String liketype) {
		this.liketype = liketype;
	}

	public String getLikecorp() {
		return likecorp;
	}

	public void setLikecorp(String likecorp) {
		this.likecorp = likecorp;
	}

	public String getCommenttype() {
		return commenttype;
	}

	public void setCommenttype(String commenttype) {
		this.commenttype = commenttype;
	}

	public String getCommentcorp() {
		return commentcorp;
	}

	public void setCommentcorp(String commentcorp) {
		this.commentcorp = commentcorp;
	}

	public String getTopofworkload() {
		return Topofworkload;
	}

	public void setTopofworkload(String topofworkload) {
		Topofworkload = topofworkload;
	}

	public String getTopoflike() {
		return Topoflike;
	}

	public void setTopoflike(String topoflike) {
		Topoflike = topoflike;
	}

	public String getTopofcomment() {
		return Topofcomment;
	}

	public void setTopofcomment(String topofcomment) {
		Topofcomment = topofcomment;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAcs_done() {
		return acs_done;
	}

	public void setAcs_done(String acs_done) {
		this.acs_done = acs_done;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAssessor() {
		return assessor;
	}

	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	
}
