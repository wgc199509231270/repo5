package com.OuSoft.system.service.performanceManagement;

import java.util.List;

import com.OuSoft.system.entity.Performanceparm;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import com.OuSoft.system.entity.queryusermodel;

public interface PerformanceManageService {
	
	
	List<Performanceparm> queryPfmmListService(Performanceparm pfm);//业绩管理详情
	/**
	 * 
	 筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
	返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
	pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	 * @author pyl
	 * @date 2018年12月27日
	 */
	List<performance> querySHTperfromanceService(performance pfm);
	List<performance> queryUserTperfromanceService(performance pfm);
	ResponseModel insertPfmm(performance pfm);
	List<queryusermodel> queryuserList(String id);
	List<Tsuser> querydepartuser(String id);
	List<Performanceparm> queryPfmmList(Performanceparm pfm);//业绩管理列表
	
	ResponseModel updpfmm(performance pfm);
	List<Tdepartmentinfo> queryTsdepart(String state,String id);
	List<performance> queryTopAll(String id);
	ResponseModel deletePerFor(String id);

	//查询业绩
	List<performance> selectPerformanceListService(performance pfm);
}
