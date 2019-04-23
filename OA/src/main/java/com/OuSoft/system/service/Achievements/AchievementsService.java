package com.OuSoft.system.service.Achievements;

import java.util.List;

import com.OuSoft.system.dao.Achievements.AchievementRowNumModel;
import com.OuSoft.system.dao.Achievements.AchievementSumWorkload;
import com.OuSoft.system.dao.Achievements.AchievementsModel;
import com.OuSoft.system.entity.Achievements;
import com.OuSoft.system.entity.AchievementsRequestParamModel;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;


public interface AchievementsService {
	
	AchievementRowNumModel QueryAchievementsListRowNum(AchievementsRequestParamModel model);
	
	List<AchievementSumWorkload> QueryAchievementsListByState(AchievementsRequestParamModel model);
	
	List<AchievementsModel> QueryAchievementsList(AchievementsRequestParamModel model);

	boolean UpdateAchievements(Achievements achievements);

	boolean DelAchievements(String id);

	boolean insertAchievements(Achievements model);
	
	//统计业绩审核不通过的数量
		String Countstatenums ();
	
}
