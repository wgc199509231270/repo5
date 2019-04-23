package com.OuSoft.system.controller.Tcompany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcompany;
import com.OuSoft.system.service.Tcompany.TcompanyService;

/**
 * 公司
 * @author pengyueli
 * @date 2018年12月18日
 */
@RequestMapping(value="/tcompany")
@Controller
public class TcompanyController {
	
	@Autowired
	TcompanyService service;
	
	/**
	 * 
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/saveTcompany")
	@ResponseBody
	public ResponseModel saveTcompanyController(Tcompany tcompany){
		return service.saveTcompanyService(tcompany);
	}
	
	/**
	 * 
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/deleteTcompany")
	@ResponseBody
	public ResponseModel deleteTcompanyController(Tcompany tcompany){
		return service.deleteTcompanyService(tcompany);
	}
	
	/**
	 * 
	 * @author pyl
	 * @date 2018年12月18日
	 */
	@RequestMapping(value="/queryTcompany")
	@ResponseBody
	public List<Tcompany> queryTcompanyController(Tcompany tcompany){
		return service.queryTcompanyService(tcompany);
	}
	
	
	

}
