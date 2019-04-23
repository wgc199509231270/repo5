package com.OuSoft.system.service.Achievements.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Achievements.AchievementRowNum;
import com.OuSoft.system.dao.Achievements.AchievementRowNumModel;
import com.OuSoft.system.dao.Achievements.AchievementSumWorkload;
import com.OuSoft.system.dao.Achievements.AchievementsDao;
import com.OuSoft.system.dao.Achievements.AchievementsModel;
import com.OuSoft.system.entity.Achievements;
import com.OuSoft.system.entity.AchievementsRequestParamModel;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Achievements.AchievementsService;
import com.OuSoft.utils.DateUtil;
import com.OuSoft.utils.StringUtil;

@Service
public class AchievementsImpl implements AchievementsService{

	@Autowired
	AchievementsDao dao;
	
	/**
	 * 排行查询系列
	 */
	@Override
	public AchievementRowNumModel QueryAchievementsListRowNum(AchievementsRequestParamModel model) {
		// TODO 未测试
		AchievementRowNumModel Anmodel = new AchievementRowNumModel();
		List<AchievementRowNum> list = dao.QueryAchievementsListRowNum(model);
		// 名次
		int Firstplace = 1;
		int Lastplace = list.size();
		int Myplace = list.size();
		// 绩效差距
		float FirstGap = 0;
		float LastGap = 0;
		float FrontGap = 0;
		float BehindGap = 0;
		
		//绩效预算
		if(!StringUtil.isNullOrEmpty(model.getUserid())){
			for(int i = 0;i<list.size();i++){
				if(model.getUserid().equals(list.get(i).getUserid())){
					Myplace = list.get(i).getNum();
					
					Float gap = Float.parseFloat(list.get(i).getSum_acs_actual_workload());
					FirstGap = Float.parseFloat(list.get(0).getSum_acs_actual_workload())-gap;
					LastGap = gap-Float.parseFloat(list.get(list.size()-1).getSum_acs_actual_workload());
					
					if(i!=list.size()-1){
						BehindGap = gap - Float.parseFloat(list.get(i+1).getSum_acs_actual_workload());
					}
					if(i!=0){
						FrontGap = Float.parseFloat(list.get(i-1).getSum_acs_actual_workload())-gap;
					}
				}
			}
		}
		
		Anmodel.setList(list);
		Anmodel.setFirstplace(Firstplace);
		Anmodel.setLastplace(Lastplace);
		Anmodel.setMyplace(Myplace);
		Anmodel.setFirstGap(FirstGap);
		Anmodel.setLastGap(LastGap);
		Anmodel.setBehindGap(BehindGap);
		Anmodel.setFrontGap(FrontGap);
		return Anmodel;
	}
	
	/**
	 * 排行查询系列
	 */
	@Override
	public List<AchievementSumWorkload> QueryAchievementsListByState(AchievementsRequestParamModel model) {
		// TODO 未测试
		List<AchievementSumWorkload> list = dao.QueryAchievementsListByState(model);
		return list;
	}
	
	
	/**
	 * 普通列表查询
	 */
	@Override
	public List<AchievementsModel> QueryAchievementsList(AchievementsRequestParamModel model) {
		// TODO 未测试
		Tsuser tuser=DateUtil.GetTsuser();
		model.setTcmid(tuser.getUserpid());
		List<AchievementsModel> list = dao.QueryAchievementsList(model);
		return list;
	}

	/**
	 * 修改参数
	 */
	@Override
	public boolean UpdateAchievements(Achievements model) {
		boolean b = false;
		int i = dao.UpdateAchievements(model);
		if(i>0){
			b = true;
		}
		return b;
	}
	
	/**
	 * 修改参数
	 */
	@Override
	public boolean DelAchievements(String id) {
		boolean b = false;
		int i = dao.DelAchievements(id);
		if(i>0){
			b = true;
		}
		return b;
	}
	
	/**
	 * 添加
	 */
	@Override
	public boolean insertAchievements(Achievements model) {
		boolean b = false;
		int i = dao.insertAchievements(model);
		if(i>0){
			b = true;
		}
		return b;
	}

	@Override
	public String Countstatenums() {
		Tsuser tuser=DateUtil.GetTsuser();
		String num = dao.Countstatenums(tuser.getUserpid());
		return num;
	}
	
}
