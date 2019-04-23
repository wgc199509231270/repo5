package com.OuSoft.mobileCommerce.service.Mood;

import java.util.List;

import com.OuSoft.system.entity.Mood;

public interface MTmoodService {

	
	//心情所有图表
	List<Mood> queryQBTmoodListService(Mood mood);
	
	//点赞详情
	List<Mood> queryDzTmoodListService(Mood mood);
	
	//评论详情
	List<Mood> queryPlTmoodService(Mood mood);
	
	//个人列表图表
	List<Mood> queryGrTmoodListService(Mood mood);
	
	
	
}
