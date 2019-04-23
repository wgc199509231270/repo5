package com.OuSoft.system.controller.Plan;


import java.util.ArrayList;
import java.util.List;

import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Tjobinfo.TjobinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.service.Plan.IPlanService;

@RequestMapping(value="/tplan")
@Controller
public class PlanController {

//	@Autowired
//	HttpServletRequest request;
	@Autowired
	IPlanService iPlanService;
	@Autowired
	TjobinfoService tjobinfoService;
	
	@RequestMapping(value="/QueryPlanList")
	@ResponseBody
	public List<Plan> QueryPlanList() {;
		List<Plan> list = new ArrayList<Plan>();
		list = iPlanService.QueryPlanList();
		return list;
	}
	@RequestMapping(value="/deleteIdTplan")
	@ResponseBody
	public ResponseModel DelPlan(String id) {
		
//		id = "123";
		
		ResponseModel model = iPlanService.deleteIdTplanService(id);
		return model;
	}

	@RequestMapping(value="/QueryPlanByid")
	@ResponseBody
	public Plan QueryPlanByid(String id) {
		Plan model = iPlanService.QueryPlanByid(id);
		return model;
	}
	//查询计划
	@RequestMapping(value="/QueryPlanListByid")
	@ResponseBody
	public List<Plan> QueryPlanListByid(Plan plan) {
		return iPlanService.QueryPlanListByidService(plan);
	}
	@RequestMapping(value="/UpdatePlanByid")
	@ResponseBody
	public ResponseModel UpdatePlanByid(Plan model) {
		ResponseModel remodel = iPlanService.UpdatePlanByid(model);
		return remodel;
	}

	/**
	 * 新增计划
	 * @author pyl
	 * @date 2018年9月10日
	 */
	@RequestMapping(value="/InsertPlan")
	@ResponseBody
	public ResponseModel InsertPlan(Plan model) {
		System.out.println("新增计划 ： " );
		
		//测试数据
//		model.setPlantext("zheshiyige");
//		model.setPlantype("01");
//		model.setWorkhour(7.5);
//		model.setRemark("beizhu111");
		
		ResponseModel remodel = iPlanService.InsertPlan(model);
		return remodel;
	}
	
	

	/**
	 * 计划列表
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value="/queryListTpraise")
	@ResponseBody
	public List<Plan> queryListTpraiseController(Plan tpraise){
		
//		tpraise.setBegtime("2018/09/10");
//		tpraise.setEndtime("2018/09/19");
//		tpraise.setUsername("wy");
//		tpraise.setLoginname("隆隆");
		
		List<Plan> list = iPlanService.queryListTpraiseService(tpraise);
		return list;
	}
		
	/**
	 * 计划点赞详情
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value="/queryListTpraiseTplan")
	@ResponseBody
	public List<Plan> queryListTpraiseTplanService(Plan tpraise){

//		id = "f9a65c7ba17d4fcba84392b79d89e326";
		
		List<Plan> list = iPlanService.queryListTpraiseTplanService(tpraise);
		return list;
	}
	
	
	/**
	 * 计划列表图数据
	 * @author pyl
	 * @date 2018年10月16日
	 */
	@RequestMapping(value="/queryNumPlan")
	@ResponseBody
	public List<Plan> queryNumListTplanController(Plan p) {
		return iPlanService.queryNumListTplanService(p);
	}


	/**
	 * 查询所有计划
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/QueryAllPlan")
	@ResponseBody
	public List<Plan> QueryAllPlanListByidController(Plan p) {
		return iPlanService.QueryAllPlanListByidService(p);
	}

    /**
     * 查询效率
     * @param p
     * @return
     */
    @RequestMapping(value="/queryRealycient")
    @ResponseBody
    public List<Plan> queryRealycient(Plan p) {
        return iPlanService.queryRealycientService(p);
    }

	/**
	 * 查询进度
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/queryPlanPlan")
	@ResponseBody
	public List<Plan> queryPlanPlan(Plan p) {
		return iPlanService.queryPlanPlanService(p);
	}

	/**
	 * 查询排名
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/queryClockRank")
	@ResponseBody
	public List<Plan> queryClockRank(Plan p) {
		return iPlanService.queryClockRankService(p);
	}

	/**
	 * 查询计划分析列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryAnalysis")
	public List<performanceRank> queryAnalysisList(PlanAnalyze planAnalyze){
		List<performanceRank> list=iPlanService.queryAnalysis(planAnalyze);
		return list;
	}
}
