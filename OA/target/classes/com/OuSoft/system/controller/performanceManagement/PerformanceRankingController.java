package com.OuSoft.system.controller.performanceManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;
import com.OuSoft.system.service.performanceManagement.PerformanceRankingService;

@Controller
@RequestMapping(value="/performance/rank")
public class PerformanceRankingController {
	
	@Autowired
	PerformanceRankingService pfmrService;
	
	/**
	 * 业绩点赞详情
	 * @author pyl
	 * @date 2018年12月24日
	 */
	@RequestMapping(value="/queryDzParformanceRequest")
	@ResponseBody
	public List<performanceRank> queryDzParformanceRequestController(parformanceRequest pfm){
		return pfmrService.queryDzParformanceRequestService(pfm);
	}
	
	
	
	/**
	 * 业绩排名列表
	 * @param pfm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryPerformanceRank")
	public List<performanceRank> queryPerformanceRank(parformanceRequest pfm){
		return pfmrService.queryPfmr(pfm);
	}

}
