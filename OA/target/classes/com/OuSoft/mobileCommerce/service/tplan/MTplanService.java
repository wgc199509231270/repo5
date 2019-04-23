package com.OuSoft.mobileCommerce.service.tplan;

import java.util.List;

import com.OuSoft.system.entity.Plan;


public interface MTplanService {
	
	
	//计划所有人图表列表
		List<Plan> queryQBTplanListService(Plan plan);
		
		//计划个人图表列表
		List<Plan> queryGrTplanListService(Plan plan);
		
		//计划点赞
		List<Plan> queryDzTplanListService(Plan plan);
		
		//计划评论
		List<Plan> queryPlTplanListService(Plan plan);
		

}
