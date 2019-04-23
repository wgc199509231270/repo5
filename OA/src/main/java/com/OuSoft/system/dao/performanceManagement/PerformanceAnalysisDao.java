package com.OuSoft.system.dao.performanceManagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;

/**
 * 业绩分析和监控接口
 * @author pengyueli
 * @date 2018年12月26日
 */
@Mapper
@Component(value = "tsperformance")
public interface PerformanceAnalysisDao {
	
	/**
	 * 个人效率排名
	后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
	返回：num总数，rownum名次
	 * @author pyl
	 * @date 2018年12月26日
	 */
	List<parformanceRequest> queryMonitorXLTperformanceDao(parformanceRequest pfm);
	
	/**
	 * 业绩排名，个人在小组，部门，公司的排名。
	 * 后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
		接收:state:01小组，02部门，03公司,grouptime:01周，02月，季03,04年
		返回：num总数，rownum名次
	 */
	List<parformanceRequest> queryMonitorPMTperformanceDao(parformanceRequest pfm);
	
	/**
	 * 业绩监控：同部门下所有成员的计划业绩，计划用时，
		tcmid:公司id(后台给)
		deparid:部门id(后台给)
		pfmstarttime:计划开始时间
		pfmendtime:计划结束时间
	 */
	List<parformanceRequest> queryMonitorJHTperformanceDao(parformanceRequest pfm);
	
	/**
	 *  业绩监控：个人的工作业绩，工作用时，
		userpid:公司id(后台给)
		deparid:部门id(后台给)
		userid:用户id(后台给)
		pfmrealitystarttime:计划开始时间
		pfmrealityendtime:计划结束时间
	 */
	List<parformanceRequest> queryMonitorGZTperformanceDao(parformanceRequest pfm);
	
	List<performanceRank> queryAnalysis(parformanceRequest pfr);
	List<performanceRank> queryAnalysis1(parformanceRequest pfr);
	List<performanceRank> queryAnalysis2(parformanceRequest pfr);
	List<performanceRank> queryAnalysis3(parformanceRequest pfr);
	List<performanceRank> queryAnalysis4(parformanceRequest pfr);
	List<performanceRank> queryAnalysis5(parformanceRequest pfr);
	List<performanceRank> queryAnalysis6(parformanceRequest pfr);
	Tdepartmentinfo querygroupid(String id);
}
