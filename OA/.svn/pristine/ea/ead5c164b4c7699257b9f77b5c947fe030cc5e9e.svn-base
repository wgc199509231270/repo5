package com.OuSoft.system.controller.performanceManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Performanceparm;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import com.OuSoft.system.entity.queryusermodel;
import com.OuSoft.system.service.performanceManagement.PerformanceManageService;


/**
 * 业绩管理
 * @author wangyuxin
 *
 */
@Controller
@RequestMapping(value="/performance/manage")
public class PerformanceManageController {
	
	@Autowired
	PerformanceManageService pfmmService;
	
	/**
	参数，筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
	返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
	pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	 * @author pyl
	 * @date 2018年12月27日
	 */
	@ResponseBody
	@RequestMapping(value="/querySHTperfromance")
	public List<performance> querySHTperfromanceController(performance pfm){
		return pfmmService.querySHTperfromanceService(pfm);
	}
	@ResponseBody
	@RequestMapping(value="/queryUserTperfromance")
	public List<performance> queryUserTperfromanceController(performance pfm){
		return pfmmService.queryUserTperfromanceService(pfm);
	}
	/**
	 * 发布业绩
	 * @param pfm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertPfmm")
	public ResponseModel insertPerformancemanage(performance pfm){
		ResponseModel model=pfmmService.insertPfmm(pfm);
		return model;
	}

	/**
	 * 查询业绩
	 * @param pfm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectPerformanceList")
	public List<performance> selectPerformanceList(performance pfm){
		return pfmmService.selectPerformanceListService(pfm);
	}
	/**
	 * 查询业绩列表
	 * @param pfm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryPfmmlist")
	public List<Performanceparm> queryPerformancemanageList(Performanceparm pfm){
		List<Performanceparm> list=pfmmService.queryPfmmList(pfm);
		return list;
	}
	
	/**
	 * 查询业绩详情
	 * @param pfm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryJGLXQPfmmList")
	public List<Performanceparm> queryPfmmListController(Performanceparm pfm){
		List<Performanceparm> list=pfmmService.queryPfmmListService(pfm);
		return list;
	}
	
	/**
	 * 修改业绩状态
	 * @param pfm
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/updPfmm")
	public ResponseModel updPerformancemanage(performance pfm){
		ResponseModel model=pfmmService.updpfmm(pfm);
		return model;
	}
	
	/**
	 * 查询所有部门
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryTsdepart")
	public List<Tdepartmentinfo> queryTsdepart(String state,String id){
		List<Tdepartmentinfo> list=pfmmService.queryTsdepart(state,id);
		return list;
	}
	
	/**
	 * 查询组下的用户
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryuserList")
	public List<queryusermodel> queryuserList(String id){
		List<queryusermodel> list=pfmmService.queryuserList(id);
		return list;
	}
	/**
	 * 查询部门下的用户
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/querydepartuser")
	public List<Tsuser> querydepartuser(String id){
		List<Tsuser> list=pfmmService.querydepartuser(id); 
		return list;
	}
	
	/**
	 * 查询单个业绩信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryTopAll")
	public List<performance> queryTopAll(String id){
		List<performance> list=pfmmService.queryTopAll(id);
		return list;
	}
	
	/**
	 * 删除业绩
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deletePerFor")
	public ResponseModel DeletePerfor(String id){
		ResponseModel model=pfmmService.deletePerFor(id);
		return model;
	}
}
