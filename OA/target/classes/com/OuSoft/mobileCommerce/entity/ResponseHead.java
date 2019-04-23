package com.OuSoft.mobileCommerce.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResponseHead {

	private String response_time;//回复时间
	private int code;
	private String err;
	private String method;
	private String token;
	
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getResponse_time() {
		return response_time;
	}


	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getErr() {
		return err;
	}


	public void setErr(String err) {
		this.err = err;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public void init() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temtime = format.format(now);
		this.setResponse_time(temtime);
	}

	
	
	
}
