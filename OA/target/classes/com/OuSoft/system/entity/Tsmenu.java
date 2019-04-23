package com.OuSoft.system.entity;

   /**
    * Tsmenu 实体类
    * 2018-08-23 17:19:44 Lw
    */ 

public class Tsmenu{
	/**
	*用户ID
	*/
	private String	id;
	/**
	*菜单标题
	*/
	private String	title;
	/**
	*菜单路径
	*/
	private String	url;
	/**
	*菜单序号，同级子菜单，从1开始
	*/
	private int	ordernum;
	/**
	*备注信息
	*/
	private String	remark;
	/**
	*上级菜单ID
	*/
	private String	pid;
	/**
	*是否公开：01公开，02不公开
	*/
	private String	whetherpublic;
	/**
	*菜单图标路径
	*/
	private String	image;
	/**
	*菜单打开方式1：当前页面刷新 2：tab页打开 3：弹出窗口
	*/
	private int	actiontype;
	/**
	*菜单类别，1pc,2移动，默认pc
	*/
	private String	menutype;
	//menucode
	private String	menucode;

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url=url;
	}
	public String getUrl(){
		return url;
	}

	public void setOrdernum(int ordernum){
		this.ordernum=ordernum;
	}
	public int getOrdernum(){
		return ordernum;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}

	public void setPid(String pid){
		this.pid=pid;
	}
	public String getPid(){
		return pid;
	}

	public void setWhetherpublic(String whetherpublic){
		this.whetherpublic=whetherpublic;
	}
	public String getWhetherpublic(){
		return whetherpublic;
	}

	public void setImage(String image){
		this.image=image;
	}
	public String getImage(){
		return image;
	}

	public void setActiontype(int actiontype){
		this.actiontype=actiontype;
	}
	public int getActiontype(){
		return actiontype;
	}

	public void setMenutype(String menutype){
		this.menutype=menutype;
	}
	public String getMenutype(){
		return menutype;
	}

	public void setMenucode(String menucode){
		this.menucode=menucode;
	}
	public String getMenucode(){
		return menucode;
	}

}
