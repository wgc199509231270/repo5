package com.OuSoft.system.service.Plan;
import com.OuSoft.system.entity.PlanAnalyze;
import com.OuSoft.system.entity.ResponseModel;

import java.util.List;

import com.OuSoft.system.entity.Plan;
import com.OuSoft.system.entity.performanceRank;

public interface IPlanService {

	List<Plan> QueryPlanList();

	//根据id删除一条计划
	ResponseModel deleteIdTplanService(String id);

	Plan QueryPlanByid(String id);

	ResponseModel UpdatePlanByid(Plan model);

	//新增计划
	ResponseModel InsertPlan(Plan model);
	
	
	//计划列表
	List<Plan> queryListTpraiseService(Plan tpraise);
	
	//计划点赞详情
	List<Plan> queryListTpraiseTplanService(Plan tpraise);

	//计划列表图数据
	List<Plan> queryNumListTplanService(Plan plan);

	//查询计划
	List<Plan> QueryPlanListByidService(Plan plan);

	//查询所有计划
	List<Plan> QueryAllPlanListByidService(Plan plan);
	//计划效率
	List<Plan> queryRealycientService(Plan plan);
	//计划进度
	List<Plan> queryPlanPlanService(Plan plan);
	//查询排名
	List<Plan> queryClockRankService(Plan plan);
	//计划分析
	List<performanceRank> queryAnalysis(PlanAnalyze plan);



}
