package com.OuSoft.system.controller.Tpraise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpraise;
import com.OuSoft.system.service.Tpraise.TpraiseService;

@Controller
@RequestMapping(value="/tpraise")
public class TpraiseController {

	@Autowired
	TpraiseService service;
	/**
	 * 点赞
	 * @author pyl
	 * @date 2018年9月14日
	 */
	@RequestMapping(value="/savetpraise")
	@ResponseBody
	public ResponseModel saveTpraiseController(Tpraise t){
		ResponseModel model = new ResponseModel();
		
//		t.setItemid("4444444");
//		t.setItemtype("tknowledge444");
//		t.setRemark("0914测试！");

		model = service.saveTpraiseService(t);
		return model;
	}
	
	/**
	 * 查询
	 * @author pyl
	 * @date 2018年9月14日
	 */
	@RequestMapping(value="/querytpraise")
	@ResponseBody
	public Tpraise queryTpraise(Tpraise tpraise){
		Tpraise t = new Tpraise();
		
//		tpraise.setUserid("456654");
//		tpraise.setItemid("333333");
//		tpraise.setItemtype("tknowledge");
		t = service.queryTpraise(tpraise);
		return t;
	}
	
	/**
	 * 取消点赞
	 * @author pyl
	 * @date 2018年9月25日
	 */
	@RequestMapping(value="/deleteIdTpraise")
	@ResponseBody
	public ResponseModel delteIdTrpaiseController(Tpraise tpraise){
		ResponseModel res = new ResponseModel();
//		tpraise.setUserid("234432");
//		tpraise.setItemid("f9a65c7ba17d4fcba84392b79d89e326");
		res = service.delteIdTrpaiseService(tpraise);
		return res;
	}
	
	
	
}
