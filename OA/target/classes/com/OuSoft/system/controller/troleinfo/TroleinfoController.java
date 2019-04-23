package com.OuSoft.system.controller.troleinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tbuttonsinfo;
import com.OuSoft.system.entity.Tmenuinfo;
import com.OuSoft.system.entity.Tmenurole;
import com.OuSoft.system.entity.Troleinfo;
import com.OuSoft.system.entity.Trolemenubutton;
import com.OuSoft.system.service.Troleinfo.TroleinfoService;


@Controller
@RequestMapping(value="/troleinfo")
public class TroleinfoController {

	
	@Autowired
	TroleinfoService service;
	

	/**
	 * 给角色分配子菜单下的按钮：   roleid  角色id ，menuid	菜单id ，	buttonid	按钮id 
	 * 返回 ：信息 
	 */
	@RequestMapping(value="/insertTrolemenubutton")
	@ResponseBody
	public ResponseModel insertTrolemenubuttonController(Trolemenubutton trolemenubutton){
		return service.insertTrolemenubuttonService(trolemenubutton);
	}
	
	
	/**
		查询角色下的主菜单   roleid 角色id       后台已处理处理条件 menuepid = 1zcd
		返回：menuname 菜单名称 	menuurl  差点地址菜单排序 	menutime 时间 	menuinfo  菜单描述 menuimage  菜单图表 	remark 备注
	 * @author pyl
	 * @date 2019年1月15日
	 */
	@RequestMapping(value="/queryByRoleidTrolemenubutton")
	@ResponseBody
	List<Tmenuinfo> queryByRoleidTrolemenubuttonController(Tmenurole tmenurole){
		return service.queryByRoleidTrolemenubuttonService(tmenurole);
	}

	
	/**
	 * 查询角色下主菜单下的子菜单        roleid	角色id , menuid 主菜单id 
	 * 返回：
	 * menuname	菜单名称 
		menuurl	菜单子菜单路径
		menusort	序号排列
		menutime	创建时间
		menuinfo	按钮描述
		remark	备注信息
		menuimage	图标
		menutype	菜单端
		menupid	顶级公司id
	 * @author pyl
	 * @date 2019年1月15日
	 */
	@RequestMapping(value="/queryByMenuidTmenuinfo")
	@ResponseBody
	List<Tmenuinfo> queryByMenuidTmenuinfoController(Tmenurole tmenurole){
		return service.queryByMenuidTmenuinfoService(tmenurole);
	}
	
	
	/**
	 *  查询角色下子菜单下的按钮：
			 接：
			roleid  角色id
			menuid	菜单id
			返回：
			buttonname	按钮名称
			buttonmark	按钮标识
			buttontime	创建时间
			buttonimage	按钮图标
			buttonsort	按钮排序 
			buttontext	按钮说明 
			buttonpid	顶级公司id
	 * @author pyl
	 * @date 2019年1月15日
	 */
	@RequestMapping(value="/queryByTrolemenuTbutton")
	@ResponseBody
	List<Tbuttonsinfo> queryByTrolemenuTbuttonController(Tmenurole tmenurole){
		return service.queryByTrolemenuTbuttonService(tmenurole);
	}
	
	
	/**
	 * 	删除给角色分配的按钮  
		roleid	角色id 	menuid	菜单id buttonid	按钮id 
		返回：信息  
	 * @author pyl
	 * @date 2019年1月15日
	 */
	@RequestMapping(value="/deleTrolemenubutton")
	@ResponseBody
	ResponseModel deleTrolemenubuttonController(Trolemenubutton trolemenubutton){
		return  service.deleTrolemenubuttonService(trolemenubutton);
	}
	
	
	/**
	 * 	删除给角色分配的主菜单和子菜单 roleid	角色id ,menuid	菜单id 
		返回： 信息 
	 * @author pyl
	 * @date 2019年1月15日
	 */
	@RequestMapping(value="/deleTroleTmenu")
	@ResponseBody
	ResponseModel deleTroleTmenuController(Tmenurole tmenurole){
		return service.deleTroleTmenuService(tmenurole);
	}

	
	/**
	 * 修改角色信息 
	rolename 角色名称
	remark 备注
	id 主键id
	 */
	@RequestMapping(value="/updateByidTroleinfo")
	@ResponseBody
	public ResponseModel updateByidTroleinfoController(Troleinfo troleinfo){
		return service.updateByidTroleinfoService(troleinfo);
	}
	
	
	/**
	 * 给用户分配角色
	 userid用户id
	 roleid角色id
	 */
	@RequestMapping(value="/insertByidTroleinfotuser")
	@ResponseBody
	public ResponseModel insertByidTroleinfotuserController(Troleinfo troleinfo){
		return service.insertByidTroleinfotuserService(troleinfo);
	}
	
	
	/**
	 * 给角色分配主菜单
	roleid 角色id
	menuid 主菜单id
	 */
	@RequestMapping(value="/insertByidTmenuinfoTuser")
	@ResponseBody
	public ResponseModel insertByidTmenuinfoTuserController(Troleinfo troleinfo){
		return service.insertByidTmenuinfoTuserService(troleinfo);
	}
	
	
	/**
	 *  查询
	 *  rolepid,rolename.查询角色列表，条件为顶级公司pid.如果是不传则是平台系统管理员，模糊查询角色名称
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/queryPidTroleinfo")
	@ResponseBody
	public List<Troleinfo> queryPidTroleinfoController(Troleinfo troleinfo){
		return service.queryPidTroleinfoService(troleinfo);
	}
	
	
	/**
	 * 角色新增
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/saveTroleinfo")
	@ResponseBody
	public ResponseModel saveTroleinfoController(Troleinfo troleinfo){
		return service.saveTroleinfoService(troleinfo);
	}
	
	
	/**
	 *   删除一个角色  
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/deleByIdTroleinfo")
	@ResponseBody
	public ResponseModel deleByIdTroleinfoController(Troleinfo troleinfo){
		return service.deleByIdTroleinfoService(troleinfo);
	}
	
	
	
}
