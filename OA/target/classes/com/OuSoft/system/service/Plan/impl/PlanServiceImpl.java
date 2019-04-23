package com.OuSoft.system.service.Plan.impl;

import com.OuSoft.system.controller.ClockController.ClockController;
import com.OuSoft.system.controller.Random.RandomController;
import com.OuSoft.system.dao.Clock.ClockDao;
import com.OuSoft.system.dao.Plan.PlansDao;
import com.OuSoft.system.dao.Tdepartmentinfo.TdepartmentinfoDao;
import com.OuSoft.system.dao.Tjobinfo.TjobinfoDao;
import com.OuSoft.system.dao.performanceManagement.PerformanceRankingDao;
import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Plan.IPlanService;

import org.springframework.web.bind.annotation.RequestBody;

import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	PlansDao plan;
	@Autowired
	TdepartmentinfoDao tdepartmentinfoDao;
	@Autowired
	TjobinfoDao tjobinfoDao;
	@Autowired
	PerformanceRankingDao pfmrDao;
	@Autowired
	ClockDao clockDao;


	@Override
	public List<Plan> QueryPlanList() {
		List<Plan> list = new ArrayList<Plan>();
		list = plan.QueryPlanList();
		return list;
	}
	@Override
	public ResponseModel UpdatePlanByid(@RequestBody Plan model) {
		ResponseModel remodel = new ResponseModel();
		int count = 0 ;
		if(!DateUtil.getObjCheckIsNull( model )  ){
			if("0".equals(model.getVerendtime())){
				model.setVerendtime(DateUtil.GetDates());
			}
			count=plan.UpdatePlanByid(model);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("修改计划成功！");
				remodel.setId(model.getId());
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("修改计划失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("计划数据为空！");
		}
		return remodel;
	}
	@Override
	public Plan QueryPlanByid(String id) {
		Plan model = new Plan();
		model = plan.QueryPlanByid(id);
		return model;
	}
	
	
	//新增计划
	@Override
	public ResponseModel InsertPlan(Plan model) {
		ResponseModel remodel = new ResponseModel();
		System.out.println("打印计划：" + model);
		int count = 0;
		if(!DateUtil.getObjCheckIsNull( model )  ){
			if(model.getId() == null || model.equals("")){
				model.setId(CommUtil.getID());//生成id
			}
			model.setCreatetime(DateUtil.GetDates());
			model.setUserid(DateUtil.getUserid());//用户id
			model.setStatus("01");
			Tjobinfo tjobinfo=new Tjobinfo();
			tjobinfo.setUserid(model.getUserid());
			List<Tjobinfo> list=null;
			for(int i=0;i<3;i++){
				tjobinfo.setLimit(i);
				list=tjobinfoDao.queryOldUseridDao(tjobinfo);
				if(list.size()>0){
					model.setVerifierid(list.get(0).getUserid());
					break;
				}
			}
			if(list.size()==0){
				for(int j=0;j<3;j++) {
					tjobinfo.setLimit(j);
					list = tjobinfoDao.queryOldDao(tjobinfo);
					if(list.size()>0) {
						model.setVerifierid(list.get(0).getUserid());
						break;
					}
				}
				if(list.size()==0){
					model.setVerifierid(model.getUserid());
				}
			}
			count = plan.insertTplanDao(model);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("发布计划成功！");
				remodel.setId(model.getId());
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("发布计划失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("计划数据为空！");
		}
		return remodel;
	}

	/**
	 * 删除计划
	 */
	@Override
	public ResponseModel deleteIdTplanService(String id) {
		int count = 0;
		ResponseModel remodel = new ResponseModel();
		if(id != null && id != ""){
			Plan plan1=new Plan();
			plan1.setId(id);
			String clockid=plan.QueryPlanListByidDao(plan1).get(0).getClockid();
			clockDao.deleteClockByid(clockid);
			count = plan.deleteIdTplanDao(id);
			if(count > 0){
				//将计划中的评论、点赞、附件相应删除。
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条计划成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条计划失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("计划ID为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
	 * 计划列表
	 */
	@Override
	public List<Plan> queryListTpraiseService(Plan tpraise) {
		Tsuser tuser=DateUtil.GetTsuser();
		 List<Plan> list = null;
		tpraise.setIdtype("03");
		if(tpraise.getLoginname() != null && !"".equals(tpraise.getLoginname()) ){
			if("01".equals(tpraise.getLoginname())){
				tpraise.setIdtype("01");
			}else{
				Tdepartmentinfo tdepartmentinfo=new Tdepartmentinfo();
				tdepartmentinfo.setId(tpraise.getLoginname());
				List<Tdepartmentinfo> list1=tdepartmentinfoDao.queryIdDao(tdepartmentinfo);
				if(list1.size()>0){
					tpraise.setIdtype("02");
				}
			}
		}
		if(!DateUtil.getObjCheckIsNull( tpraise )  ){
			tpraise.setTcmid(tuser.getUserpid());
			tpraise.setDzuserid(DateUtil.getUserid());
			if(tpraise.getSqtsgin() != null ){
				list = plan.queryListTpraiseDao(tpraise);
			}else{
				if(tpraise.getLoginname() == null || tpraise.getLoginname() == ""){
					tpraise.setUserid(DateUtil.getUserid());
					list = plan.queryListTpraiseDao(tpraise);
				}else{

					list = plan.queryListTpraiseDao(tpraise);
				}
			}
		}else{
			System.out.println("计划数据为空！");
		}

		// TODO Auto-generated method stub
		return list;
	}
		/**
		 * 点赞详情
		 */
		@Override
		public List<Plan> queryListTpraiseTplanService(Plan tpraise) {
			Tsuser tuser=DateUtil.GetTsuser();
			List<Plan> list = null;
			if(!DateUtil.getObjCheckIsNull( tpraise )){
				tpraise.setTcmid(tuser.getUserpid());
				tpraise.setDzuserid(DateUtil.getUserid());
				list = plan.queryListTpraiseTplanDao(tpraise);
			}else{
				System.out.println("id为空，计划！");
			}
			// TODO Auto-generated method stub
			return list;
		}


		/**
		 * 计划列表图数据
		 */
		@Override
		public List<Plan> queryNumListTplanService(Plan p) {
			Tsuser tuser=DateUtil.GetTsuser();
			List<Plan> list = null;
			if(!DateUtil.getObjCheckIsNull( p )){
				//全查
				p.setTcmid(tuser.getUserpid());
				if(p.getSqtsgin() != null ){
					list = plan.queryNumListTplanDao(p);
				}else{
					//个人
					if(p.getLoginname() != null && p.getLoginname() != "" ){
						list = plan.queryGNumListTplanDao(p);
					}else{
						p.setUserid(DateUtil.getUserid());
						System.out.println("userid:" + DateUtil.getUserid());
						list = plan.queryGNumListTplanDao(p);
					}
				}
			}else{
				System.out.println("plan数据为空！");
			}
			// TODO Auto-generated method stub
			return list;
		}

	@Override
	public List<Plan> QueryPlanListByidService(Plan p) {
		return plan.QueryPlanListByidDao(p);
	}

	@Override
	public List<Plan> QueryAllPlanListByidService(Plan p) {
		return plan.QueryAllPlanListByidDao(p);
	}

	/**
	 * 业绩效率 01 周 02 月 03 年
	 * @param p
	 * @return
	 */
	@Override
	public List<Plan> queryRealycientService(Plan p) {
		if(p.getUserid()==null||"".equals(p.getUserid())){
			p.setUserid(DateUtil.getUserid());
		}
		List<Plan> plan1 = new ArrayList<Plan>();
		Plan plan2=new Plan();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		if(p.getPlantype()!=null && p.getPlantype()!=""){
			if("02".equals(p.getPlantype())){
				p.setEndtime(DateUtil.getCurrentWeekDayStartTime());
				try {
					c.setTime(format.parse(p.getEndtime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.DATE, - 7);
				Date d = c.getTime();
				String day = format.format(d);
				System.out.println("过去七天："+day);
				p.setBegtime(day);
				List<Plan> plans = plan.queryRealycientDao(p);
				double number=0;
				String workplan="0";
				for (Plan list0:plans) {
					if("02".equals(list0.getPlantype())){
						workplan=list0.getWorkhour();
					}
					if("01".equals(list0.getPlantype())){
						number+=1;
					}
				}
				double work=Double.parseDouble(workplan);
				if(number==0){
					plan2.setRealycient("0");
				}else{
					plan2.setRealycient(String.valueOf(work/number));
				}
				plan1.add(plan2);
			}else if("03".equals(p.getPlantype())){
				p.setEndtime(DateUtil.getCurrentMonthStartTime());
				try {
					c.setTime(format.parse(p.getEndtime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.MONTH, -1);
				Date m = c.getTime();
				String mon = format.format(m);
				System.out.println("过去一个月："+mon);
				p.setBegtime(mon);
				List<Plan> plans = plan.queryRealycientDao(p);
				double number=0;
				String workplan="0";
				for (Plan list0:plans) {
					if("03".equals(list0.getPlantype())){
						workplan=list0.getWorkhour();
					}
					if("01".equals(list0.getPlantype())){
						number+=1;
					}
				}
				double work=Double.parseDouble(workplan);
				if(number==0){
					plan2.setRealycient("0");
				}else{
					plan2.setRealycient(String.valueOf(work/number));
				}
				plan1.add(plan2);
			}else if("04".equals(p.getPlantype())){
				p.setEndtime(DateUtil.getCurrentYearStartTime());
				try {
					c.setTime(format.parse(p.getEndtime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.YEAR, -1);
				Date y = c.getTime();
				String year = format.format(y);
				System.out.println("过去一年："+year);
				p.setBegtime(year);
				List<Plan> plans = plan.queryRealycientDao(p);
				double number=0;
				String workplan="0";
				for (Plan list0:plans) {
					if("04".equals(list0.getPlantype())){
						workplan=list0.getWorkhour();
					}
					if("01".equals(list0.getPlantype())){
						number+=1;
					}
				}
				double work=Double.parseDouble(workplan);
				if(number==0){
					plan2.setRealycient("0");
				}else{
					plan2.setRealycient(String.valueOf(work/number));
				}
				plan1.add(plan2);
			}
		}
		return plan1;
	}

	@Override
	public List<Plan> queryPlanPlanService(Plan p) {
		if(p.getUserid()==null||"".equals(p.getUserid())){
			p.setUserid(DateUtil.getUserid());
		}
		List<Plan> plan1 = new ArrayList<Plan>();
		Plan plan2=new Plan();
		if("02".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentSundayPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentSundayPeriod().split(",")[1]);
			List<Plan> plans = plan.queryPlanPlanDao(p);
			double work=0;
			double daywork=0;
			for (Plan pla:plans) {
				if("02".equals(pla.getPlantype())){
					work=Double.parseDouble(pla.getWorkhour());
				}
				if("01".equals(pla.getPlantype())){
					daywork+=Double.parseDouble(pla.getWorkhour());
				}
			}
			if(work==0){
				plan2.setSche("0");
				plan2.setWorkhour("0");
			}else{
				plan2.setSche(String.valueOf(daywork));
				plan2.setWorkhour(String.valueOf(work));
			}
			plan1.add(plan2);
		}else if("03".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentMonthPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentMonthPeriod().split(",")[1]);
			List<Plan> plans = plan.queryPlanPlanDao(p);
			double work=0;
			double daywork=0;
			for (Plan pla:plans) {
				if("03".equals(pla.getPlantype())){
					work=Double.parseDouble(pla.getWorkhour());
				}
				if("01".equals(pla.getPlantype())){
					daywork+=Double.parseDouble(pla.getWorkhour());
				}
			}
			if(work==0){
				plan2.setSche("0");
				plan2.setWorkhour("0");
			}else{
				plan2.setSche(String.valueOf(daywork));
				plan2.setWorkhour(String.valueOf(work));
			}
			plan1.add(plan2);
		}else if("04".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentYearPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentYearPeriod().split(",")[1]);
			List<Plan> plans = plan.queryPlanPlanDao(p);
			double work=0;
			double daywork=0;
			for (Plan pla:plans) {
				if("04".equals(pla.getPlantype())){
					work=Double.parseDouble(pla.getWorkhour());
				}
				if("01".equals(pla.getPlantype())){
					daywork+=Double.parseDouble(pla.getWorkhour());
				}
			}
			if(work==0){
				plan2.setSche("0");
				plan2.setWorkhour("0");
			}else{
				plan2.setSche(String.valueOf(daywork));
				plan2.setWorkhour(String.valueOf(work));
			}
			plan1.add(plan2);
		}
		return plan1;
	}

	@Override
	public List<Plan> queryClockRankService(Plan p) {
		DateUtil.getUserid();
		if("01".equals(p.getPlantype())){
			p.setBegtime(DateUtil.GetDateR()+" "+"00:00:00");
			p.setEndtime(DateUtil.GetDateR()+" "+"11:59:59");
		}else if("02".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentSundayPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentSundayPeriod().split(",")[1]);
		}else if("03".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentMonthPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentMonthPeriod().split(",")[1]);
		}else if("04".equals(p.getPlantype())){
			p.setBegtime(DateUtil.getCurrentYearPeriod().split(",")[0]);
			p.setEndtime(DateUtil.getCurrentYearPeriod().split(",")[1]);
		}
		if("01".equals(p.getDepyesno())){
			Tdepartmentinfo tdepartmentinfo=new Tdepartmentinfo();
			tdepartmentinfo.setUserid(DateUtil.getUserid());
			List<Tdepartmentinfo> list=tdepartmentinfoDao.queryTuserByIdTdepartmentinfoDao(tdepartmentinfo);
			if(list.size()>0){
				p.setDeparname(list.get(0).getDeparname());
			}
		}
		return plan.queryClockRankDao(p);
	}

	@Override
	public List<performanceRank> queryAnalysis(PlanAnalyze p) {
		Tsuser tuser=DateUtil.GetTsuser();
		p.setTcmid(tuser.getUserpid());
		List<performanceRank> list=null;
		if(p.getAcrossendlong().equals("01")){
			if(p.getObject().equals("01")){
				if(p.getState().equals("01")){
					list=plan.queryAnalysis2(p);//（全部）以人分组
					System.out.println(list);
				}else if(p.getState().equals("02")){
					list=plan.queryAnalysis3(p);//（全部）以组分组
				}else if(p.getState().equals("03")){
					list=plan.queryAnalysis4(p);//（全部）以部门分组
				}
			}else if(p.getObject().length()==6){
				if(p.getState().equals("01")){
					p.setDeparepid(p.getObject());
					list=plan.queryAnalysis5(p);//（部门）以人员分组
				}else if(p.getState().equals("02")){
					p.setDeparepid(p.getObject());
					list=plan.queryAnalysis6(p);//（部门）以小组分组
				}else if(p.getState().equals("03")){
					list=plan.queryAnalysis4(p);//（全部）以部门分组
				}
			}else if(p.getObject().length()==9){
				if(p.getState().equals("01")){
					p.setDeparepid(p.getObject());
					list=plan.queryAnalysis5(p);
				}else if(p.getState().equals("02")){
					p.setDeparepid(p.getObject().substring(0, 2));
					list=plan.queryAnalysis6(p);//(全部)以小组分组
				}else if(p.getState().equals("03")){
					p.setDeparepid(p.getObject().substring(0,5));
					list=plan.queryAnalysis6(p);//(部门)以小组分组
				}
			}else if(p.getObject().length()>9){
				if(p.getState().equals("01")){
					p.setUserid(p.getObject());
					list=plan.queryAnalysis2(p);//（全部）以人员分组
				}else if(p.getState().equals("02")){
					List<tdepartType> model=pfmrDao.querytdepart(p.getObject(),p.getTcmid());
					p.setDeparepid(model.get(0).getDeparepid());
					list=plan.queryAnalysis5(p);//(小组)以人员分组
				}else if(p.getState().equals("03")){
					List<tdepartType> model=pfmrDao.querytdepart(p.getObject(),p.getTcmid());
					// ！= null 否则报错 ，数组越界,无值可以获取 //////////////
					if(model != null){
						p.setDeparepid(model.get(0).getDeparepid().substring(0, 5));
						list=plan.queryAnalysis5(p);//(部门)以人员分组
					}
				}
			}
		}else if(p.getAcrossendlong().equals("02")){
			if(p.getObject().equals("01")){
				list=plan.queryAnalysis(p);//查询整个公司的纵比统计
			}else if(p.getObject().length()==6){
				p.setDeparepid(p.getObject());
				list=plan.queryAnalysis(p);//查询整个部门的纵比统计
			}else if(p.getObject().length()==9){
				p.setDeparepid(p.getObject());
				list=plan.queryAnalysis(p);//查询整个小组的纵比统计
			}else if(p.getObject().length()>9){
				p.setUserid(p.getObject());
				list=plan.queryAnalysis(p);//查询某个人的纵比统计
			}
			if(p.getState().equals("01")){
				for(performanceRank model:list){
					String time=this.getFirstAndLastOfWeek(model.getTime());
					model.setTime(time);
				}
			}else if(!p.getState().equals("01")){
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

}
