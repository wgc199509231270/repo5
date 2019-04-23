package com.OuSoft.system.controller.Tnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tnews;
import com.OuSoft.system.service.Tnews.TnewsService;

@RequestMapping(value="/tnews")
@Controller
public class TnewsController {
	
	@Autowired
	TnewsService service;
	
	/**
	 * 新增
		nitemid:项目id
		nuserid：项目用户id
		ntext：提醒内容
		nitemuserid：操作人id
		nitemtype：项目类型，表名
		remark：备注
		ntype:类型：01通知，02审核，03点赞，04评论
	 * 
	 * @author pyl
	 * @date 2018年12月27日
	 */
	@RequestMapping(value="/saveTnews")
	@ResponseBody
	public ResponseModel saveTnewsController(Tnews tnews){
		return service.saveTnewsService(tnews);
	}
	
	/**
	 * 查询消息
	 * 接收：
	 *  nstarttime：开始时间
		nendtime：结束时间
		ntype：类型：01通知，02审核，03点赞，04评论
		nitemtype：表名对应的是哪个模块(模块名称)
	 * 返回：
	 * nuserid：项目用户id
		ntext：提醒内容
		nitemuserid：操作人id
		nitemtype：项目类型，表名
		times:时间
		remark：备注
		username:用户名称
		txfilename:操作人头像
		ntype:类型：01通知，02审核，03点赞，04评论
	 * @author pyl
	 * @date 2018年12月27日
	 */
	@RequestMapping(value="/queryTnews")
	@ResponseBody
	public List<Tnews> queryTnewsService(Tnews tnews){
		return service.queryTnewsService(tnews);
	}

	/**
	 * 查询计划消息
	 * @param tnews
	 * @return
	 */
	@RequestMapping(value="/queryPlanTnews")
	@ResponseBody
	public List<Tnews> queryPlanTnewsService(Tnews tnews){
		return service.queryPlanTnewsService(tnews);
	}

}
