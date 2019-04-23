package com.OuSoft.system.dao.Plan;
import com.OuSoft.system.entity.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "Tplan")
public interface PlansDao {

	List<Plan> QueryPlanList();

	//根据id删除一条计划
	int deleteIdTplanDao(String id);

	Plan QueryPlanByid(String id);
	//更新计划
	int UpdatePlanByid(Plan model);

	//新增计划
	int insertTplanDao(Plan model);
	

	//计划列表
	List<Plan> queryListTpraiseDao(Plan plan);
	
	//计划点赞详情
	List<Plan> queryListTpraiseTplanDao(Plan plan);
	
	//计划列表图数据，全查
	List<Plan> queryNumListTplanDao(Plan plan);
	
	//计划列表图数据，个人
	List<Plan> queryGNumListTplanDao(Plan plan);
	

	//查询计划
	List<Plan> QueryPlanListByidDao(Plan plan);
	//计划提醒
	List<Plan> queryPlanListNewDao(Plan plan);
    //查询所有计划
	List<Plan> QueryAllPlanListByidDao(Plan plan);
	//查询效率
	List<Plan> queryRealycientDao(Plan plan);
    //查询进度
    List<Plan> queryPlanPlanDao(Plan plan);
    //查询排名
	List<Plan> queryClockRankDao(Plan plan);
	//计划分析
	List<performanceRank> queryAnalysis(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis1(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis2(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis3(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis4(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis5(PlanAnalyze planAnalyze);
	List<performanceRank> queryAnalysis6(PlanAnalyze planAnalyze);
}
