package com.OuSoft.system.entity;

public class Tmenuinfo {
	
	private String id;
	private String menuname;//菜单名称
	private String menuepid;//菜单关系id
	private String menuurl;//菜单路径
	private String menusort;//菜单排序
	private String menutime;//菜单创建时间
	private String menuinfo;//菜单描述
	private String remark;//备注
	private String menuimage;//图片
	private String menutype;//菜单端
	private String menupid;//顶级公司id
	
	
	
	
	public String getMenuepid() {
		return menuepid;
	}
	public void setMenuepid(String menuepid) {
		this.menuepid = menuepid;
	}
	public String getMenupid() {
		return menupid;
	}
	public void setMenupid(String menupid) {
		this.menupid = menupid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public String getMenusort() {
		return menusort;
	}
	public void setMenusort(String menusort) {
		this.menusort = menusort;
	}
	public String getMenutime() {
		return menutime;
	}
	public void setMenutime(String menutime) {
		this.menutime = menutime;
	}
	public String getMenuinfo() {
		return menuinfo;
	}
	public void setMenuinfo(String menuinfo) {
		this.menuinfo = menuinfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMenuimage() {
		return menuimage;
	}
	public void setMenuimage(String menuimage) {
		this.menuimage = menuimage;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}
	
	
	

}
