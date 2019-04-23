package com.OuSoft.mobileCommerce.entity;

public class requestMood {
	
	
	private String id;
	private String userid;
	private String motext;//内容
	private String mocreatetime;//创建时间
	private String monumber;//心情指数（大笑4分，微笑3分，委屈2分，难过1分 ）
	
	
	
	
	
	
	
	
	
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
	public String getMotext() {
		return motext;
	}
	public void setMotext(String motext) {
		this.motext = motext;
	}
	public String getMocreatetime() {
		return mocreatetime;
	}
	public void setMocreatetime(String mocreatetime) {
		this.mocreatetime = mocreatetime;
	}
	public String getMonumber() {
		return monumber;
	}
	public void setMonumber(String monumber) {
		this.monumber = monumber;
	}
	
	
	
	

}
