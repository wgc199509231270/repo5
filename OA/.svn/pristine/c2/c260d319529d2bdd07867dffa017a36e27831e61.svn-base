package com.OuSoft.system.controller.Tcomment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcomment;
import com.OuSoft.system.service.Tcomment.TcommentService;

/**
 * 评论
 * @author pengyueli
 * @date 2018年9月14日
 */
@RequestMapping(value="/tcomment")
@Controller
public class TcommentController {
	
	private static Logger log = Logger.getLogger(TcommentController.class);

	@Autowired
	TcommentService service;
	
	/**
	 * 评论新增
	 * @author pyl
	 * @date 2018年9月14日
	 */
	@RequestMapping(value="/savetcomment")
	@ResponseBody
	public ResponseModel saveTcomment(Tcomment tcomment){
		log.info("评论新增：" + tcomment.getItemid());
		return service.saveTcommentService(tcomment);
	}
	
	/**
	 * 评论回复详情
	 * @author pyl
	 * @date 2018年9月25日
	 */
	@RequestMapping(value="/queryListTcomment")
	@ResponseBody
	public List<Tcomment> queryListTcommentController(Tcomment tcomment){
		return service.queryListTcommentService(tcomment);
	}
	
	/**
	 * 删除当前用户的评论
	 * 评论id
	 * @author pyl
	 * @date 2018年10月11日
	 */
	@RequestMapping(value="/deleIdTcomment")
	@ResponseBody
	public ResponseModel deleTcommentController(Tcomment tcomment){
		return service.deleTcommentService(tcomment);
	}
	
	
	
	
	
	
	
}
