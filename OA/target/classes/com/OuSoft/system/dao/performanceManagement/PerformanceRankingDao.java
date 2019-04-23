package com.OuSoft.system.dao.performanceManagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;
import com.OuSoft.system.entity.tdepartType;

@Mapper
@Component(value="tperformance")
public interface PerformanceRankingDao {

	/**
	 * 业绩点赞详情
	 * @author pyl
	 * @date 2018年12月24日
	 */
	List<performanceRank> queryDzParformanceRequestDao(parformanceRequest pfm);
	
	
	List<performanceRank> queryPfmr(parformanceRequest pfm);
	List<tdepartType> querytdepart(@Param(value = "userid") String userid,@Param(value = "tcmid")String tcmid);
	List<performanceRank> querygroupList(parformanceRequest pfm);
	List<performanceRank> querypartList(parformanceRequest pfm);


	
}
