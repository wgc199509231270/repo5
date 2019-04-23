package com.OuSoft.system.entity;

import com.google.common.base.Objects;


public class Tcalendar {

	
	private String msg;
	
    private String id;
    private String type;//类型：01:休息日正常上班，02,上班时休息
    private String createtime;//这条记录的生成日期
    private String time;//类型日期
    private String mark;//备忘录
    private String tcompanypid;//顶级公司，对应哪个公司
    private String starttime;//开始时间
    private String endtime;//结束时间

    
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Tcalendar() {
    }

    public Tcalendar(String id, String type, String createtime, String time, String mark, String tcompanypid) {
        this.id = id;
        this.type = type;
        this.createtime = createtime;
        this.time = time;
        this.mark = mark;
        this.tcompanypid = tcompanypid;
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

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getTcompanypid() {
        return tcompanypid;
    }

    public void setTcompanypid(String tcompanypid) {
        this.tcompanypid = tcompanypid;
    }

    @Override
    public String toString() {
        return "Tcalendar{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", createtime=" + createtime +
                ", time=" + time +
                ", mark='" + mark + '\'' +
                ", tcompanypid='" + tcompanypid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tcalendar)) return false;
        Tcalendar tcalendar = (Tcalendar) o;
        return Objects.equal(getId(), tcalendar.getId()) &&
                Objects.equal(getType(), tcalendar.getType()) &&
                Objects.equal(getCreatetime(), tcalendar.getCreatetime()) &&
                Objects.equal(getTime(), tcalendar.getTime()) &&
                Objects.equal(getMark(), tcalendar.getMark()) &&
                Objects.equal(getTcompanypid(), tcalendar.getTcompanypid());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getType(), getCreatetime(), getTime(), getMark(), getTcompanypid());
    }
}
