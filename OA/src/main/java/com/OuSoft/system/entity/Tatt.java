package com.OuSoft.system.entity;

public class Tatt {
	
	private String id;
	private String itemid;//项目id
	private String itemtype;//标识表名
	private String filename;//图片名称
	private String originalfilename;//服务器上的文件名称
	private String customname;//用户自定义名称
	private String creattime;//上传时间
	private String remark;//备注
	private String attfrom;//附件来源
	private String filetype;//图片类型
	private String itemfrom;//图片类型
	private String msg;
	private String tprafilename;
	private String ip;
	
	
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAttfrom() {
		return attfrom;
	}

	public void setAttfrom(String attfrom) {
		this.attfrom = attfrom;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getTprafilename() {
		return tprafilename;
	}

	public void setTprafilename(String tprafilename) {
		this.tprafilename = tprafilename;
	}

	public Tatt() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getItemfrom() {
		return itemfrom;
	}
	public void setItemfrom(String itemfrom) {
		this.itemfrom = itemfrom;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
