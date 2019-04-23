package com.OuSoft.system.entity;


public class Tcomment {
	
	private String id;
	private String userid;
	private String itemid;//项目id
	private String itemtype;//表名
	private String commentid;//回复评论的id
	private String commenttext;//评论内容
	private String commenttime;//评论时间
	private String remark;//备注
	private String filename;
	private String username;
	private String ip;
	private String hfilename;
	
	
	
	public String getHfilename() {
		return hfilename;
	}
	public void setHfilename(String hfilename) {
		this.hfilename = hfilename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	//关联
	private String txfilename;
	private String pusername;//评论用户名
	private String husername;//回复
	
	
	
	public String getTxfilename() {
		return txfilename;
	}
	public void setTxfilename(String txfilename) {
		this.txfilename = txfilename;
	}
	public String getHusername() {
		return husername;
	}
	public void setHusername(String husername) {
		this.husername = husername;
	}
	public String getPusername() {
		return pusername;
	}
	public void setPusername(String pusername) {
		this.pusername = pusername;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
