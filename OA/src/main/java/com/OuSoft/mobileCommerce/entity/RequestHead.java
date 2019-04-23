package com.OuSoft.mobileCommerce.entity;

public class RequestHead {

	
	private String app_code;
	private int app_version;	//系统版本id，int类型单调递增
	private String request_time;//yyyy-MM-dd HH:mm:ss
	private String app_sign;	//签名
	private String method;		//留着不用
	private String token;
	
	public String getApp_code() {
		return app_code;
	}
	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}
	public int getApp_version() {
		return app_version;
	}
	public void setApp_version(int app_version) {
		this.app_version = app_version;
	}
	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}
	public String getApp_sign() {
		return app_sign;
	}
	public void setApp_sign(String app_sign) {
		this.app_sign = app_sign;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
