package com.OuSoft.system.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuewei on 2018/7/19.
 */
public class ResponseModel {
    private String code;
    private String result;
    private String time;
    private String token;
    private String msg;
    private String id;
    
    public void init() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temtime = format.format(now);
		this.setTime(temtime);
	}
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
