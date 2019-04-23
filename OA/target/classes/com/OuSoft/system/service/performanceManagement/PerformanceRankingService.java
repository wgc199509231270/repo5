package com.OuSoft.system.service.performanceManagement;

import java.util.List;

import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;

public interface PerformanceRankingService {

	
	/**
	 * 业绩点赞详情
	 * @author pyl
	 * @date 2018年12月24日
	 */
	List<performanceRank> queryDzParformanceRequestService(parformanceRequest pfm);
	
	
	List<performanceRank> queryPfmr(parformanceRequest pfm);

}
