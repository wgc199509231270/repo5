package com.OuSoft.system.controller.Tbuttonsinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tbuttonsinfo;
import com.OuSoft.system.service.Tbuttonsinfo.TbuttonsinfoService;




/**
 * 按钮
 * @author pengyueli
 * @date 2018年12月24日
 */
@RequestMapping(value="/tbuttoninfo")
@Controller
public class TbuttonsinfoController {
	
	@Autowired
	TbuttonsinfoService service;
	
	/**
	 *  新增
	 *  buttonname按钮名称
		buttonmark按钮标识
		buttonimage图表
		buttontext描述
		buttonpid顶级公司id
		buttonitemid按钮对应菜单id
	 * @author pyl
	 * @date 2018年12月24日
	 */
	@RequestMapping(value="/saveTbuttoninfo")
	@ResponseBody
	public ResponseModel saveTbuttoninfoController(Tbuttonsinfo tbuttoninfos){
		return service.saveTbuttoninfoService(tbuttoninfos);
	}
	
	/**
	 * 查询菜单下的按钮
	 * 对应菜单id
	 * @author pyl
	 * @date 2018年12月24日
	 */
	@RequestMapping(value="/queryTbuttoninfo")
	@ResponseBody
	List<Tbuttonsinfo> queryTbuttoninfoController(Tbuttonsinfo tbuttoninfos){
		return service.queryTbuttoninfoService(tbuttoninfos);
	}
	
	/**
	 * 删除一个按钮
	 * id:按钮id
	 * @author pyl
	 * @date 2018年12月24日
	 */
	@RequestMapping(value="/deleteTbuttoninfo")
	@ResponseBody
	ResponseModel deleteTbuttoninfoController(Tbuttonsinfo tbuttoninfos){
		return service.deleteTbuttoninfoService(tbuttoninfos);
	}
	
	/**
	 * 修改按钮信息
	 * id:必传按钮id
	 * buttonname按钮名称
		buttonmark按钮标识
		buttonimage图表
		buttontext描述
		buttonpid顶级公司id
		buttonitemid按钮对应菜单id
	 * @author pyl
	 * @date 2018年12月24日
	 */
	@RequestMapping(value="/updateTbuttoninfo")
	@ResponseBody
	ResponseModel updateTbuttoninfoController(Tbuttonsinfo tbuttoninfos){
		return service.updateTbuttoninfoService(tbuttoninfos);
	}
	
	

}
