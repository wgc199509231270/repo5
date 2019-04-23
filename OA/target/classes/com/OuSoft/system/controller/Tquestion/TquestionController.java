package com.OuSoft.system.controller.Tquestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tquestion;
import com.OuSoft.system.service.Tquestion.TquestionService;

@Controller
@RequestMapping(value="/tquestion")
public class TquestionController {
	
	@Autowired
	TquestionService service;
	/**
	 * 新增问答
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@ResponseBody
	@RequestMapping(value="/saveTquestion")
	public ResponseModel saveTquestionController(Tquestion tquestion){
		ResponseModel model = new ResponseModel();
		
//		tquestion.setQutype("1");
//		tquestion.setQudetail("我爱你我的大地！");
//		tquestion.setQustatus("放空自己！");
//		tquestion.setQutext("放");
//		
		
		model = service.insertTquestionService(tquestion);
		return model;
		
	}
	
	/**
	 * 删除
	 * @author pyl
	 * @date 2018年9月11日
	 */
	@ResponseBody
	@RequestMapping(value="/delteTquestion")
	public ResponseModel deleteTquestionController(String id){
		
//		id = "7a4a7a8348684f91b772aaa574e6503c";
		
		ResponseModel model = new ResponseModel();
		model = service.deleteIdTquestionService(id);
		return model;
		
	}
	/**
	 * 查询
	 */
	@ResponseBody
	@RequestMapping(value="/selectIdTquestion")
	public List<Tquestion> selectIdTquestion(Tquestion tquestion){
		return service.selectIdTquestionService(tquestion);
	}
	
	/**
	 * 问答列表
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@ResponseBody
	@RequestMapping(value="/queryListTquestion")
	public List<Tquestion> queryListTquestionController(Tquestion tquestion){
		
//		tquestion.setBegtime("");
//		tquestion.setEndtime("");
//		tquestion.setUserid("");
//		tquestion.setLoginname("");
		
		List<Tquestion> list = service.queryListTquestionService(tquestion);
		return list;
	}
	
	/**
	 * 问答点赞详情
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@ResponseBody
	@RequestMapping(value="/queryListTquestionTpraise")
	public List<Tquestion> queryListTquestionTpraiseController(Tquestion tquestion){
		
//		id = "0dee97863b3f48fcb03c401f1f8b808d";
		
		List<Tquestion> list = service.queryListTquestionTpraiseService(tquestion);
		
		return list;
	}
	
	/**
	 * 问答点赞评论发布数，起止日期
	 * 参数：起止时间，sqtsgin:(tpranum:点赞、comnum:评论、tsnum:发布数 )
	 * @author pyl
	 * @date 2018年10月17日
	 */
	@ResponseBody
	@RequestMapping(value="/queryDzNumListTquestion")
	public List<Tquestion> queryDzNumListTquestionController(Tquestion tquestion){
	return service.queryDzNumListTquestionService(tquestion);
	}
	
	/**
	 * 问答个人图表
	 * @author pyl
	 * @date 2018年10月25日
	 */
	@ResponseBody
	@RequestMapping(value="/queryGListTquestion")
	public List<Tquestion> queryGListTquestionController(Tquestion tquestion){
	return service.queryGListTquestionService(tquestion);
	}
	
	
}
