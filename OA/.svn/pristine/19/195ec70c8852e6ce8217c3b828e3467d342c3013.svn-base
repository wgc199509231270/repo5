package com.OuSoft.system.dao.Achievements;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Achievements;
import com.OuSoft.system.entity.AchievementsRequestParamModel;
import com.OuSoft.system.entity.Mood;

@Mapper
@Component(value="Achievements")
public interface AchievementsDao {
	
	// 添加
	int insertAchievements(Achievements model);
	
	//根据id删除
	int DelAchievements(String id);
	
	// 修改各种参数
	int UpdateAchievements(Achievements model);
	
	// 查询排行榜
	List<AchievementRowNum> QueryAchievementsListRowNum(AchievementsRequestParamModel model);

	// 查询工作完成统计
	List<AchievementSumWorkload> QueryAchievementsListByState(AchievementsRequestParamModel model);
	
	// 普通业绩列表查询 
	List<AchievementsModel> QueryAchievementsList(AchievementsRequestParamModel model);

	//统计业绩审核不通过的数量
	String Countstatenums (String tcmid);
	
}
