package com.OuSoft.system.controller.Achievements;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.dao.Achievements.AchievementRowNumModel;
import com.OuSoft.system.dao.Achievements.AchievementSumWorkload;
import com.OuSoft.system.dao.Achievements.AchievementsModel;
import com.OuSoft.system.entity.Achievements;
import com.OuSoft.system.entity.AchievementsRequestParamModel;
import com.OuSoft.system.entity.PageModel;
import com.OuSoft.system.entity.ResponseEntity;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Achievements.AchievementsService;
import com.OuSoft.utils.StringUtil;

@RequestMapping(value="/achievements")
@Controller
public class AchievementsController {

    // 登录方法集合

    @Autowired
    HttpServletRequest request;

    // 传递实体类
    @Autowired
    AchievementsService achievementsService;

    /**
     * 查询个人业绩列表
     * @param userid
     * @return
     */
	@RequestMapping(value="/QueryAchievementsListRowNum")
	@ResponseBody
	public ResponseEntity<AchievementRowNumModel> queryAchievementsByUserId(AchievementsRequestParamModel achievements){
		ResponseEntity<AchievementRowNumModel> model = new ResponseEntity<AchievementRowNumModel>();
		AchievementRowNumModel listmolde = new AchievementRowNumModel();
		// TODO 业绩查询ById model.setBiz(pm);
		listmolde = achievementsService.QueryAchievementsListRowNum(achievements);
		model.setBiz(listmolde);
//		model.getHead().setCode(2663);
//		model.getHead().setErr("");
//		model.getHead().setMethod("queryAchievementsByUserId");
		return model;
	}
	
	// 工作完成/未完成量统计
	@RequestMapping(value="/QueryAchievementsListByState")
	@ResponseBody
	public ResponseEntity<List<AchievementSumWorkload>> QueryAchievementsListByState(AchievementsRequestParamModel achievements){
		ResponseEntity<List<AchievementSumWorkload>> model = new ResponseEntity<List<AchievementSumWorkload>>();
		List<AchievementSumWorkload> listmolde = new ArrayList<AchievementSumWorkload>();
		// TODO 业绩查询ById model.setBiz(pm);
		listmolde = achievementsService.QueryAchievementsListByState(achievements);
		model.setBiz(listmolde);
//		model.getHead().setCode(2663);
//		model.getHead().setErr("");
//		model.getHead().setMethod("queryAchievementsByUserId");
		return model;
	}
	
	// 普通列表查询
	@RequestMapping(value="/QueryAchievementsList")
	@ResponseBody
	public ResponseEntity<List<AchievementsModel>> QueryAchievementsList(AchievementsRequestParamModel achievements){
		ResponseEntity<List<AchievementsModel>> model = new ResponseEntity<List<AchievementsModel>>();
		List<AchievementsModel> listmolde = new ArrayList<AchievementsModel>();
		listmolde = achievementsService.QueryAchievementsList(achievements);
		model.setBiz(listmolde);
//		model.getHead().setCode(2663);
//		model.getHead().setErr("");
//		model.getHead().setMethod("queryAchievementsByUserId");
		return model;
	}
	
	/**
     * 查询单个业绩   因为查询结果相似所以不写这个了
     * @param userid
     * @return
     */
	@RequestMapping(value="/queryAchievementsById")
	@ResponseBody
	public ResponseEntity<Achievements> queryAchievementsById(String id){
		return null;
	}
	
	/**
     * 单独修改一项业绩项
     * 也可以修改单一项内容
     * @param UpdateAchievementsById
     * @return
     */
	@RequestMapping(value="/UpdateAchievementsById")
	@ResponseBody
	public ResponseModel UpdateAchievementsById(Achievements achievements){
		boolean b = false;
		
    	ResponseModel model = new ResponseModel();
		
    	if(!StringUtil.isNullOrEmpty(achievements.getAcs_id())){
    		// TODO 修改业绩项
    		b = achievementsService.UpdateAchievements(achievements);
        	if(b){
        		model.setCode("2663");
        		model.setMsg("正常");
        		model.setResult("正常");
        	}else{
        		model.setCode("4160");
        		model.setMsg("异常");
        		model.setResult("异常");
        	}
    	}else{
    		model.setCode("4160");
    		model.setMsg("必传字段为空");
    		model.setResult("异常");
    	}
    	return model;
	}
	
    /**
     * 根据实体类添加
     * @param AchievementsModel
     * @return
     */
    @RequestMapping(value="/inserAchievements")
    @ResponseBody
    public ResponseModel InsertAchievements(Achievements achievements){
    	boolean b = false;
    	
    	ResponseModel model = new ResponseModel();
    	// TODO 业绩添加
    	b = achievementsService.insertAchievements(achievements);
    	if(b){
    		model.setCode("2663");
    		model.setMsg("正常");
    		model.setResult("正常");
    	}else{
    		model.setCode("2663");
    		model.setMsg("异常");
    		model.setResult("异常");
    	}
    	
    	return model;
    }

    /**
     * 删除
     * @param AchievementsModel
     * @return
     */
    @RequestMapping(value="/DelAchievements")
    @ResponseBody
    public ResponseModel DelAchievements(String id){
    	boolean b = false;
    	
    	ResponseModel model = new ResponseModel();
    	// TODO 业绩添加
    	b = achievementsService.DelAchievements(id);
    	if(b){
    		model.setCode("2663");
    		model.setMsg("正常");
    		model.setResult("正常");
    	}else{
    		model.setCode("4525");
    		model.setMsg("异常");
    		model.setResult("异常");
    	}
    	
    	return model;
    }
    
    /**
     * 统计业绩审核不通过的数量
     * @param AchievementsModel
     * @return
     */
    @RequestMapping(value="/Countstatenums")
    @ResponseBody
    public String Countstatenums() {
    	System.out.println("start_________");
		String num  = achievementsService.Countstatenums();
		System.out.println("start_________num");
		System.out.println("----------num:"+ num);
		return num;
	}
    
    @RequestMapping(value="/countnum")
    public String fileUpload() {
        return "msg";
    }
    
}
