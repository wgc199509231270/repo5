package com.OuSoft.system.controller.performanceManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;
import com.OuSoft.system.service.performanceManagement.PerformanceAnalysisService;

@Controller
@RequestMapping(value="/performance/analysis")
public class PerformanceAnalysisController {
	@Autowired
	PerformanceAnalysisService pfmAService;
	
	
	/**
	 * 个人效率排名
	后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
	返回：num总数，rownum名次
	 * @author pyl
	 * @date 2018年12月26日
	 */
	@ResponseBody
	@RequestMapping(value="/queryMonitorXLTperformance")
	public List<parformanceRequest> queryMonitorXLTperformanceController(parformanceRequest pfm) {
		return pfmAService.queryMonitorXLTperformanceService(pfm);
	}
	
	
	/**
	 * /**
	 * 业绩排名，个人在小组，部门，公司的排名。
	 * 后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
		接收:state:01小组，02部门，03公司,grouptime:01周，02月，季03,04年
		返回：num总数，rownum名次
	 */
	@ResponseBody
	@RequestMapping(value="/queryMonitorPMTperformance")
	public List<parformanceRequest> queryMonitorPMTperformanceController(parformanceRequest pfm) {
		return pfmAService.queryMonitorPMTperformanceService(pfm);
	}
	
	
	/**
	 * 业绩监控：同部门下所有成员的计划业绩，计划用时，
		tcmid:公司id(后台给)
		deparid:部门id(后台给)
		pfmstarttime:计划开始时间
		pfmendtime:计划结束时间
	 */
	@ResponseBody
	@RequestMapping(value="/queryMonitorJHTperformance")
	public List<parformanceRequest> queryMonitorJHTperformanceController(parformanceRequest pfm){
		return pfmAService.queryMonitorJHTperformanceService(pfm);
	}
	
	/**
	 *  业绩监控：个人的工作业绩，工作用时，
		userpid:公司id(后台给)
		deparid:部门id(后台给)
		userid:用户id(后台给)
		pfmrealitystarttime:计划开始时间
		pfmrealityendtime:计划结束时间
		返回：
		pfmauditresults   审核业绩
		realitypfm   实际业绩
		realityworkhours  实际时长
		pfmnumber  工作业绩 
		pfmworkhours  工作时长
		rate：效率
	 */
	@ResponseBody
	@RequestMapping(value="/queryMonitorGZTperformance")
	public List<parformanceRequest> queryMonitorGZTperformanceController(parformanceRequest pfm){
		return pfmAService.queryMonitorGZTperformanceService(pfm);
	}
	
	/**
	 * 查询业绩分析列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryAnalysis")
	public List<performanceRank> queryAnalysisList(parformanceRequest pfmr){
		List<performanceRank> list=pfmAService.queryAnalysis(pfmr);
		return list;
	}

}
