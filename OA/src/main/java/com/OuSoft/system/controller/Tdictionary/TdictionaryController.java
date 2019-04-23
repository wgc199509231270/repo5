package com.OuSoft.system.controller.Tdictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdictionary;
import com.OuSoft.system.service.Tdictionary.TdictionaryService;

/**
 * 数据字典
 * @author pengyueli
 * @date 2018年12月20日
 */
@Controller
@RequestMapping(value="/tdictionary")
public class TdictionaryController {
	
	@Autowired
	TdictionaryService service;
	
	/**
	 * 新增
	 * dpid:必传，顶级公司id
	 * @author pyl
	 * @date 2018年12月20日
	 */
	@RequestMapping(value="/saveTdictionary")
	@ResponseBody
	ResponseModel saveTdictionaryController(Tdictionary tdictionary){
		return service.saveTdictionaryService(tdictionary);
	}
	
	/**
	 * 查询
	 * @author pyl
	 * @date 2018年12月20日
	 */
	@RequestMapping(value="/queryTdictionary")
	@ResponseBody
	List<Tdictionary> queryTdictionaryController(Tdictionary tdictionary){
		return service.queryTdictionaryService(tdictionary);
	}
	
	
	/**
	 * 删除
	 * id:id
	 * @author pyl
	 * @date 2018年12月20日
	 */
	@RequestMapping(value="/deleteTdictionary")
	@ResponseBody
	ResponseModel deleteTdictionaryController(Tdictionary tdictionary){
		return service.deleteTdictionaryService(tdictionary);
	}
	
	
	
	
	

}
