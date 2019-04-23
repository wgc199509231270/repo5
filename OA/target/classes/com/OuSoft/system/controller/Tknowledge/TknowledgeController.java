package com.OuSoft.system.controller.Tknowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tknowledge;
import com.OuSoft.system.service.Tknowledge.tknowledgeService;


@RequestMapping(value="/tknowledge")
@Controller
public class TknowledgeController {
	
	@Autowired
	tknowledgeService service;
	
	/**
	 * 知识点赞、评论、条数
	 * 参数：起止时间，sqtsgin:(tpranum:点赞、comnum:评论、tsnum:发布数 )
	 * @author pyl
	 * @date 2018年10月17日
	 */
	@RequestMapping(value = "/queryFbNumListTknowledge")
	@ResponseBody
	public List<Tknowledge> queryFbNumListTknowledgeController(Tknowledge tknowledge){
		return service.queryFbNumListTknowledgeService(tknowledge);
	}
	
	
	/**
	 * 知识新增
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@RequestMapping(value = "/savetknowledge")
	@ResponseBody
	public ResponseModel insertTknowledgeController(Tknowledge tknowledge){
		
//		tknowledge.setLatitle("开心");
//		tknowledge.setLatext("有一个快了，，，，");
//		tknowledge.setLatype("01");
		
		 ResponseModel model = service.insertTknowledgeServcie(tknowledge);
		return model;
	}
	
	/**
	 * 知识删除一条
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@RequestMapping(value = "/deletetknowledge")
	@ResponseBody
	public ResponseModel deleteTknowledgeController(String id){

		//		id = "e4088f9b0d3e43368ece5ec200dae703";
		
		ResponseModel model = service.deleteIdTknowledgeService(id);
		return model;
	}

	/**
	 * 知识查询一条
	 */
	@RequestMapping(value = "/selecttknowledge")
	@ResponseBody
	public List<Tknowledge> deleteTknowledgeController(Tknowledge tknowledge){
		return service.selectIdTknowledgeService(tknowledge);
	}
	
	/**
	 * 知识列表
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value = "/queryListTknowledge")
	@ResponseBody
	public List<Tknowledge> queryListTknowledgeController(Tknowledge tknowledge){
		
//		tknowledge.setUserid();		
//		tknowledge.setBegtime("");
//		tknowledge.setEndtime("");
//		tknowledge.setUserid("");
//		tknowledge.setLoginname("");
		
		List<Tknowledge> list = service.queryListTknowledgeService(tknowledge);
		return list;
	}
		
	/**
	 * 知识点赞详情
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value = "/queryListTknowledgeTpraise")
	@ResponseBody
	public List<Tknowledge> queryListTknowledgeTpraiseService(Tknowledge tknowledge){
		
//		id = "9f3f6d54f39e44ef8146034e2c00811a";
		
		List<Tknowledge> list = service.queryListTknowledgeTpraiseService(tknowledge);
		return list;
	}
	
	/**
	 * 个人图表知识
	 * @author pyl
	 * @date 2018年10月25日
	 */
	@RequestMapping(value = "/queryGListTknowledgeTpraise")
	@ResponseBody
	public List<Tknowledge> queryGListTknowledgeController(Tknowledge tknowledge){
		return service.queryGListTknowledgeService(tknowledge);
	}

}
