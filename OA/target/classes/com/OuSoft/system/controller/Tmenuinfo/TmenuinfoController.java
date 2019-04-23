package com.OuSoft.system.controller.Tmenuinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tmenuinfo;
import com.OuSoft.system.service.Tmenuinfo.TmenuinfoService;



/**
 * 菜单
 * @author pengyueli
 * @date 2018年12月18日
 */
@RequestMapping(value="/tmenuinfo")
@Controller
public class TmenuinfoController {
	
	
	@Autowired
	TmenuinfoService service;
	
	
	
	
	
	
	
	/**
	 * 删除一个菜单
	 * 接收：id:菜单id
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/deleteTmenuinfo")
	@ResponseBody
	public ResponseModel deleteTmenuinfoController(Tmenuinfo tmenuinfo){
		return service.deleteTmenuinfoService(tmenuinfo);
	}
	
	/**
	 * 查询主菜单，无参
	 * 查询子菜单：menuepid:主菜单id
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/queryTmenuinfo")
	@ResponseBody
	public List<Tmenuinfo> queryTmenuinfoService(Tmenuinfo tmenuinfo){
		return service.queryTmenuinfoService(tmenuinfo);
	}
	
	/**
	 * 新增菜单信息
	 * menuepid:新增主菜单填写顶级公司id,新增子菜单填写主菜单id
	 * menupid:顶级公司id 必传
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/saveTmenuinfo")
	@ResponseBody
	public ResponseModel saveTmenuinfoService(Tmenuinfo tmenuinfo){
		return service.saveTmenuinfoService(tmenuinfo);
	}
	
	

}
