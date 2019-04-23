package com.OuSoft.system.dao.performanceManagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Performanceparm;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import com.OuSoft.system.entity.queryusermodel;

@Mapper
@Component(value = "performance")
public interface PerformanceManageDao {
	
	//业绩管理详情
	List<Performanceparm> queryPfmmListDao(Performanceparm pfm);
	/**
	 * 审核：
	 筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
	返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
	pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	 * @author pyl
	 * @date 2018年12月27日
	 */
	List<performance> querySHTperfromanceDao(performance pfm);
	
	/**
	 * 业绩：
	 * 	筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
		返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
		pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	 * @author pyl
	 * @date 2019年1月7日
	 */
	List<performance> queryYJTperfromanceDao(performance pfm);
	List<performance> queryUserTperfromanceDao(performance pfm);
	int insertpfmm(performance pfm);
	List<Performanceparm> queryPfmmList(Performanceparm pfm);//业绩管理列表
	int updpfmm(performance pfm);
	List<Tdepartmentinfo> queryTsdepart(@Param(value = "state") String state,@Param(value = "id") String id,@Param(value="tcmid") String tcmid);
	List<performance> queryTopAll(@Param(value = "id") String id,@Param(value = "tcmid")String tcmid);
	int deletePerFor(String id);
	List<queryusermodel> queryuserList(@Param(value = "id") String id,@Param(value = "tcmid")String tcmid);
	List<Tsuser> querydepartuser(@Param(value = "id") String id,@Param(value = "tcmid")String tcmid);
	//查询业绩
	List<performance> selectPerformanceListDao(performance pfm);
}
