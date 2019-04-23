package com.OuSoft.system.service.performanceManagement.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.performanceManagement.PerformanceAnalysisDao;
import com.OuSoft.system.dao.performanceManagement.PerformanceRankingDao;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;
import com.OuSoft.system.entity.tdepartType;
import com.OuSoft.system.service.performanceManagement.PerformanceAnalysisService;
import com.OuSoft.utils.DateUtil;

/**
 * 业绩分析和监控接口
 * @author  
 * @date 2018年12月26日
 */
@Service
public class PerformanceAnalysisServiceImpl implements PerformanceAnalysisService{
	@Autowired
	PerformanceAnalysisDao pfmaDao;
	@Autowired
	PerformanceRankingDao pfmrDao;
	@Override
	public List<performanceRank> queryAnalysis(parformanceRequest pfm) {
		Tsuser tuser=DateUtil.GetTsuser();
		pfm.setTcmid(tuser.getUserpid());
		List<performanceRank> list=null;
		if(pfm.getAcrossendlong().equals("01")){
			if(pfm.getObject().equals("01")){
				if(pfm.getState().equals("01")){
					list=pfmaDao.queryAnalysis2(pfm);//（全部）以人分组
					System.out.println(list);
				}else if(pfm.getState().equals("02")){
					list=pfmaDao.queryAnalysis3(pfm);//（全部）以组分组
				}else if(pfm.getState().equals("03")){
					list=pfmaDao.queryAnalysis4(pfm);//（全部）以部门分组
				}
			}else if(pfm.getObject().length()==6){
				if(pfm.getState().equals("01")){
					pfm.setDeparepid(pfm.getObject());
					list=pfmaDao.queryAnalysis5(pfm);//（部门）以人员分组
				}else if(pfm.getState().equals("02")){
					pfm.setDeparepid(pfm.getObject());
					list=pfmaDao.queryAnalysis6(pfm);//（部门）以小组分组
				}else if(pfm.getState().equals("03")){
					list=pfmaDao.queryAnalysis4(pfm);//（全部）以部门分组
				}
			}else if(pfm.getObject().length()==9){
				if(pfm.getState().equals("01")){
					pfm.setDeparepid(pfm.getObject());
					list=pfmaDao.queryAnalysis5(pfm);
				}else if(pfm.getState().equals("02")){
					pfm.setDeparepid(pfm.getObject().substring(0, 2));
					list=pfmaDao.queryAnalysis6(pfm);//(全部)以小组分组
				}else if(pfm.getState().equals("03")){
					pfm.setDeparepid(pfm.getObject().substring(0,5));
					list=pfmaDao.queryAnalysis6(pfm);//(部门)以小组分组
				}
			}else if(pfm.getObject().length()>9){
				if(pfm.getState().equals("01")){
					pfm.setUserid(pfm.getObject());
					list=pfmaDao.queryAnalysis2(pfm);//（全部）以人员分组
				}else if(pfm.getState().equals("02")){
					List<tdepartType> model=pfmrDao.querytdepart(pfm.getObject(),pfm.getTcmid());
					pfm.setDeparepid(model.get(0).getDeparepid());
					list=pfmaDao.queryAnalysis5(pfm);//(小组)以人员分组
				}else if(pfm.getState().equals("03")){
					List<tdepartType> model=pfmrDao.querytdepart(pfm.getObject(),pfm.getTcmid());
					// ！= null 否则报错 ，数组越界,无值可以获取 //////////////
					if(model != null){
						pfm.setDeparepid(model.get(0).getDeparepid().substring(0, 5));
						list=pfmaDao.queryAnalysis5(pfm);//(部门)以人员分组
					}
				}
			}
		}else if(pfm.getAcrossendlong().equals("02")){
			if(pfm.getObject().equals("01")){
				list=pfmaDao.queryAnalysis(pfm);//查询整个公司的纵比统计
			}else if(pfm.getObject().length()==6){
				pfm.setDeparepid(pfm.getObject());
				list=pfmaDao.queryAnalysis(pfm);//查询整个部门的纵比统计
			}else if(pfm.getObject().length()==9){
				pfm.setDeparepid(pfm.getObject());
				list=pfmaDao.queryAnalysis(pfm);//查询整个小组的纵比统计
			}else if(pfm.getObject().length()>9){
				pfm.setUserid(pfm.getObject());
				list=pfmaDao.queryAnalysis(pfm);//查询某个人的纵比统计
			}
			if(pfm.getState().equals("01")){
				for(performanceRank model:list){
					String time=this.getFirstAndLastOfWeek(model.getTime());
					model.setTime(time);
				}
			}else if(!pfm.getState().equals("01")){
				for(performanceRank model:list){
					model.setTime(model.getName());
				}
			}
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	public String getFirstAndLastOfWeek(String dataStr){
		 Calendar cal = Calendar.getInstance();
		 String data1="";
		 String data2="";
	     try {
				cal.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dataStr));
	        int d = 0;
	        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
	            d = -6;
	        } else {
	            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
	        }
	        cal.add(Calendar.DAY_OF_WEEK, d);
	        // 所在周开始日期
	        data1 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
	        cal.add(Calendar.DAY_OF_WEEK, 6);
	        // 所在周结束日期
	        data2 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
	     } catch (ParseException e) {
				// TODO Auto-generated catch block
	    	 e.printStackTrace();
	     }
	        return data1 + "-" + data2;
	}

	/**
	 *  业绩监控：同部门下所有成员的计划业绩，计划用时，
		tcmid:公司id(后台给)
		deparid:部门id(后台给)
		pfmstarttime:计划开始时间(后台给)
		pfmendtime:计划结束时间(后台给)
		接收：state: 01周  02月  03季度  04年 
		返回：
		pfmauditresults   审核业绩
		realitypfm   实际业绩
		realityworkhours  实际时长
		pfmnumber  工作业绩 
		pfmworkhours  工作时长

		
	 */
	@Override
	public List<parformanceRequest> queryMonitorJHTperformanceService(
			parformanceRequest pfm) {
		List<parformanceRequest> list = null;
		Tsuser tuser = DateUtil.GetTsuser();
		//用户id，公司id。返回用户部门id等信息
		List<tdepartType> mode =pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
		if(mode!=null){
			//设置值
			pfm.setTcmid(tuser.getUserpid());
			pfm.setDeparid(mode.get(0).getDeparepid().substring(0,6));
			pfm.setPfmendtime(DateUtil.GetDateR());
			System.out.println("用户查看的信息state: " + pfm.getState());
			if(pfm.getState().equals("01")){//周
				pfm.setPfmstarttime(DateUtil.getCurrentWeekDayStartTime());
				list = pfmaDao.queryMonitorJHTperformanceDao(pfm);
			}else if(pfm.getState().equals("02")){//月
				pfm.setPfmstarttime(DateUtil.getCurrentMonthStartTime());
				list = pfmaDao.queryMonitorJHTperformanceDao(pfm);
			}else if(pfm.getState().equals("03")){//季
				pfm.setPfmstarttime(DateUtil.getCurrentQuarterStartTime());
				list = pfmaDao.queryMonitorJHTperformanceDao(pfm);
			}else if(pfm.getState().equals("04")){//年
				pfm.setPfmstarttime(DateUtil.getCurrentYearStartTime());
				list = pfmaDao.queryMonitorJHTperformanceDao(pfm);
			}else{
				System.out.println("周年月季为空，01...");
			}
		}else{
			list=null;
		}
		
		
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 业绩监控：个人的工作业绩，工作用时，
		userpid:公司id(后台给)
		deparid:部门id(后台给)
		userid:用户id(后台给)
		pfmrealitystarttime:计划开始时间(后台给)
		pfmrealityendtime:计划结束时间(后台给)
		返回：
		pfmauditresults   审核业绩
		realitypfm   实际业绩
		realityworkhours  实际时长
		pfmnumber  工作业绩 
		pfmworkhours  工作时长
		rate：效率
	 */
	@Override
	public List<parformanceRequest> queryMonitorGZTperformanceService(
			parformanceRequest pfm) {
		List<parformanceRequest> list = null;
		Tsuser tuser = DateUtil.GetTsuser();
		//用户id，公司id。返回用户部门id等信息
		List<tdepartType> mode =pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
		if(mode!=null){
			//设置值
			pfm.setTcmid(tuser.getUserpid());
			pfm.setDeparid(mode.get(0).getDeparepid().substring(0,6));
			pfm.setUserid(DateUtil.getUserid());
			pfm.setPfmrealityendtime(DateUtil.GetDateR());
			if(pfm.getState().equals("01")){//周
				pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
				list = pfmaDao.queryMonitorGZTperformanceDao(pfm);
			}else if(pfm.getState().equals("02")){//月
				pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
				list = pfmaDao.queryMonitorGZTperformanceDao(pfm);
			}else if(pfm.getState().equals("03")){//季
				pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
				list = pfmaDao.queryMonitorGZTperformanceDao(pfm);
			}else if(pfm.getState().equals("04")){//年
				pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
				list = pfmaDao.queryMonitorGZTperformanceDao(pfm);
			}else{
				System.out.println("个人周年月季为空，01...");
			}
		}else{
			list=null;
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * /**
	 * 业绩排名，个人在小组，部门，公司的排名。
	 * 后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
		接收:state:01小组，02部门，03公司,grouptime:01周，02月，季03,04年
		返回：num总数，rownum名次
	 */
	@Override
	public List<parformanceRequest> queryMonitorPMTperformanceService(parformanceRequest pfm) {
		 List<parformanceRequest> list =null;
		if(pfm != null){
			Tsuser tuser = DateUtil.GetTsuser();
			//用户id，公司id。返回用户小组id等信息
			List<tdepartType> model =pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
			pfm.setTcmid(tuser.getUserpid());//用户公司id
			pfm.setUserid(tuser.getId());//用户id
			pfm.setPfmrealityendtime(DateUtil.GetDateR());//当前日期年月日
			if(pfm.getState().equals("01")){//小组
				//没有小组的用户没有组数据
				System.out.println( " deparepid长度为： " + model.get(0).getDeparepid().length() );
				if(model.get(0).getDeparepid().length() > 6){
					pfm.setDeparid(model.get(0).getDeparepid().substring(0,9));
					System.out.println("小组：" +model.get(0).getDeparepid().substring(0,9));
				}else{
					//部门信息
					pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
				}
				if(pfm.getGrouptime().equals("01")){//周
					pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("02")){//月
					pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("03")){//季
					pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("04")){//年
					pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else{
					System.out.println("grouptime数据为空！");
					list = null;
				}
			}else if(pfm.getState().equals("02")){//部门
				pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
				System.out.println("部门：" +model.get(0).getDeparepid().substring(0,6));
				if(pfm.getGrouptime().equals("01")){//周
					pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("02")){//月
					pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("03")){//季
					pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("04")){//年
					pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else{
					System.out.println("grouptime数据为空！");
					list = null;
				}
			}else if(pfm.getState().equals("03")){//公司
				//用户没有组则没有组信息
				if(model.get(0).getDeparepid().length() > 6){
					pfm.setDeparid(model.get(0).getDeparepid().substring(0,9));
					System.out.println("公司：" +model.get(0).getDeparepid().substring(0,3));
				}else{
					//部门信息
					pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
				}
				if(pfm.getGrouptime().equals("01")){//周
					pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("02")){//月
					pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("03")){//季
					pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else if(pfm.getGrouptime().equals("04")){//年
					pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
					list = pfmaDao.queryMonitorPMTperformanceDao(pfm);
				}else{
					System.out.println("grouptime数据为空！");
					list = null;
				}
			}else{
				System.out.println("state:数据为空！");
				list = null;
			}
		}else{
			System.out.println("查询个人在小组部门公司数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 个人效率排名
	后台给的参数有：tcmid:公司id,deparid:小组部门公司id,pfmrealitystarttime开始时间，pfmrealityendtime结束时间,userid:用户id
	返回：num总数，rownum名次
	 * @author pyl
	 * @date 2018年12月26日
	 */
	@Override
	public List<parformanceRequest> queryMonitorXLTperformanceService(parformanceRequest pfm) {
		List<parformanceRequest> list = null;
		
		if(pfm != null){
			Tsuser tuser = DateUtil.GetTsuser();
			//用户id，公司id。返回用户小组id等信息
			List<tdepartType> model =pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
			pfm.setTcmid(tuser.getUserpid());//用户公司id
			pfm.setUserid(tuser.getId());//用户id
			pfm.setPfmrealityendtime(DateUtil.GetDateR());//当前日期年月日
			if(model != null){
				if(pfm.getState().equals("01")){//小组
					//用户没有组则没有组信息
					if(model.get(0).getDeparepid().length() > 6){
						pfm.setDeparid(model.get(0).getDeparepid().substring(0,9));
						System.out.println("小组：" +model.get(0).getDeparepid().substring(0,9));
					}else{
						//部门信息
						pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
					}
					if(pfm.getGrouptime().equals("01")){//周
						pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("02")){//月
						pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("03")){//季
						pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("04")){//年
						pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else{
						System.out.println("grouptime数据为空！");
						list = null;
					}
				}else if(pfm.getState().equals("02")){//部门
					pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
					System.out.println("部门：" +model.get(0).getDeparepid().substring(0,6));
					if(pfm.getGrouptime().equals("01")){//周
						pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("02")){//月
						pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("03")){//季
						pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("04")){//年
						pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else{
						System.out.println("grouptime数据为空！");
						list = null;
					}
				}else if(pfm.getState().equals("03")){//公司
					//用户没有组则没有组信息
					if(model.get(0).getDeparepid().length() > 6){
						pfm.setDeparid(model.get(0).getDeparepid().substring(0,9));
						System.out.println("公司：" +model.get(0).getDeparepid().substring(0,3));
					}else{
						//部门信息
						pfm.setDeparid(model.get(0).getDeparepid().substring(0,6));
					}
					if(pfm.getGrouptime().equals("01")){//周
						pfm.setPfmrealitystarttime(DateUtil.getCurrentWeekDayStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("02")){//月
						pfm.setPfmrealitystarttime(DateUtil.getCurrentMonthStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("03")){//季
						pfm.setPfmrealitystarttime(DateUtil.getCurrentQuarterStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else if(pfm.getGrouptime().equals("04")){//年
						pfm.setPfmrealitystarttime(DateUtil.getCurrentYearStartTime());
						list = pfmaDao.queryMonitorXLTperformanceDao(pfm);
					}else{
						System.out.println("grouptime数据为空！");
						list = null;
					}
				}else{
					System.out.println("state:数据为空！");
					list = null;
				}
			}else{
				System.out.println("查询用户部门信息为空！");
			}
		}else{
			System.out.println("数据为空!");
		}
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return list;
	}

	
	
	
	
}
