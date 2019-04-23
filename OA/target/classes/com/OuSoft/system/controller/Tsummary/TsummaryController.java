package com.OuSoft.system.controller.Tsummary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsummary;
import com.OuSoft.system.service.Tsummary.TsummaryService;

/**
 * 总结
 * @author pengyueli
 * @date 2018年9月14日
 */
@Controller
@RequestMapping(value="/tsummary")
public class TsummaryController {
	
	@Autowired
	TsummaryService service;
	
	/**
	 * 新增总结
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@ResponseBody
	@RequestMapping(value="/saveTsummary")
	public ResponseModel svaeTsummaryController(Tsummary tsummary){
		
//		tsummary.setSucompany("今天很冷，心中确暖！");
//		tsummary.setSutext("走在心中有正义的大道上");
//		tsummary.setSuhygienism("4");
		
		
		ResponseModel model = new ResponseModel();
		model = service.saveTsummaryService(tsummary);
		return model;
		
	}
	
	
	/**
	 * 删除
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@ResponseBody
	@RequestMapping(value="/delteTsummary")
	public ResponseModel deleteTquestionController(String id){
		
		ResponseModel model = new ResponseModel();
		model = service.deleteTsummaryService(id);
		return model;
		
	}
	
	/**
	 * 总结列表
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@ResponseBody
	@RequestMapping(value="/queryListTsummary")
	public List<Tsummary> queryListTsummaryController(Tsummary tsummay){
		
//		tsummay.setBegtime("2018/09/05");
//		tsummay.setEndtime("2018/09/19");
//		tsummay.setUsername("wy");
//		tsummay.setLoginname("隆隆");
		
		List<Tsummary> list = service.queryListTsummaryService(tsummay);
			return list;
	}
	
	/**
	 * 总结点赞详情
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@ResponseBody
	@RequestMapping(value="/queryListTsummaryTpraise")
	public List<Tsummary> queryListTsummaryTpraiseController(Tsummary tsummay){
		
//		id = "b78a6c300b1e442faa217f27a9375007";
		
		List<Tsummary> list = service.queryListTsummaryTpraiseService(tsummay);
				return list;
	}
	
	/**
	 * 总结图表
	 * @author pyl
	 * @date 2018年10月16日
	 */
	@ResponseBody
	@RequestMapping(value="/queryNumListTsummary")
	public List<Tsummary> queryNumListTsummaryDao(Tsummary tsummay){
		return service.queryNumListTsummaryDao(tsummay);
	}
	/**
	 * 查询
	 */
	@ResponseBody
	@RequestMapping(value="/selectTsummary")
	public List<Tsummary> selectTsummaryService(Tsummary tsummay){
		return service.selectTsummaryService(tsummay);
	}
}
