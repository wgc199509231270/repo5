package com.OuSoft.mobileCommerce.dao.Mood;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Mood;

/**
 * @author pengyueli
 * @date 2018年11月8日
 */
@Mapper
@Component(value = "MTmood")
public interface MTmoodDao {

	//心情图表所有人图表
	List<Mood> queryQBTmoodListDao(Mood mood);
	
	//点赞详情
	List<Mood> queryDzTmoodListsDao(Mood mood);
	
	//评论详情
	List<Mood> queryPlTmoodDao(Mood mood);
	
	//个人列表图表
	List<Mood> queryGrTmoodListDao(Mood mood);
	
	
	
}
