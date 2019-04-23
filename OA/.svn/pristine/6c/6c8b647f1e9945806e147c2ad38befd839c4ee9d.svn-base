package com.OuSoft.system.controller.ClockController;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ch.qos.logback.core.db.dialect.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Clock;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.Plan;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcomment;
import com.OuSoft.system.entity.Tsummary;
import com.OuSoft.system.service.Clock.ClockService;
import com.OuSoft.system.service.Mood.MoodService;
import com.OuSoft.system.service.Plan.IPlanService;
import com.OuSoft.system.service.Tsummary.TsummaryService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@RequestMapping(value="/clock")
@Controller
public class ClockController {

//	  public static  Logger logger = Logger.getLogger(ClockController.class);
	
	@Autowired
	ClockService clockService;
	
	@Autowired
	MoodService moodService;
	
	@Autowired
	IPlanService iPlanService;
	
	@Autowired
	TsummaryService service;
	
	
	
	/**
	 * 查询用户是否签到和签退
	 * @author pyl
	 * @date 2018年10月23日
	 */
	@RequestMapping(value="/queryclock")
	@ResponseBody
	public ResponseModel queryClock(Clock clocks){
		Clock clockmodel = new Clock();
		ResponseModel responseModel = new ResponseModel();
		clockmodel = clockService.queryClockService(clocks);
		if(clockmodel != null){
			responseModel.setCode("404");
			responseModel.setResult("fali");
			responseModel.setTime(System.currentTimeMillis()+"");
			responseModel.setToken("0053");
			responseModel.setMsg("未签！");
		}else{
			responseModel.setCode("200");
			responseModel.setResult("success");
			responseModel.setTime(System.currentTimeMillis()+"");
			responseModel.setToken("001");
			responseModel.setMsg("已签！");
			
		}
		//用户id. cltype签到01 签退02
		return responseModel;
	}
	/**
	 * 签退
	 * @author pyl
	 * @date 2018年10月23日
	 */
	@RequestMapping(value="/UpdateClockByid")
	@ResponseBody
	public ResponseModel UpdateClockByidService(Clock clock,HttpServletRequest request){
		String ip = DateUtil.queryIpAddress(request);
		clock.setClpcipp(ip);//pc，ip地址
		if("02".equals(clock.getClformp())){
			try {
				clock.setClplacep(DateUtil.getAddress(ip));
			} catch (Exception e) {
				clock.setClplacep(ip);
			}
		}else{
			clock.setClplacep(ip);
		}

		return clockService.UpdateClockByidService(clock);
	}
	/**
	 * 签到
	 * @author pyl
	 * @date 2018年9月4日
	 */
	@Transactional
	@RequestMapping(value="/insertClock")
	@ResponseBody
	public ResponseModel insertClock(Clock clock, HttpServletRequest request, Plan tplan, Mood mood, Tsummary tsummary){
//		logger.info("insertClock========");

//		clock.setClplace("0921");
//		clock.setCltype("01");

		ResponseModel clockModel = new ResponseModel();
		ResponseModel tplanModel = null;
		ResponseModel moodModel = null;
		ResponseModel tsummaryModel = null;
		Clock clocks = new Clock();
		if(clock != null &&  !"".equals(clock)){
			clock.setCreatetime(DateUtil.GetDates());
			clock.setUserid(DateUtil.getUserid());//userid:用户id
			System.out.println(DateUtil.getUserid());
			//------------------------签到和签退用到的数据
			//pc的ip
			String ip = DateUtil.queryIpAddress(request);
			System.out.println(ip);
			//clstatus 判断传值01正常，02迟到，03早退  状态 01正常 02未签到 03迟到
			int shi = Integer.parseInt(clock.getCltime().split(" ")[1].split(":")[0]);//时
			int fen = Integer.parseInt(clock.getCltime().split(" ")[1].split(":")[1]);//分
			clock.setClpcip(ip);//pc，ip地址
			if("02".equals(clock.getClform())){
				try {
					clock.setClplace(DateUtil.getAddress(ip));
				} catch (Exception e) {
					clock.setClplace(ip);
				}
			}else{
				clock.setClplace(ip);
			}
			if(clock.getId() == null || clock.equals("")){
				clock.setId(CommUtil.getID());//生成id
			}
			//没有签到和签退记录则可以签到，如果签到了，则不能再签到，如果签退了则不能再签退，如果没有签到是不能签退的。
			//没有查询出当前的签到和签退，则可以签到。但是不能签退
			if(clock.getCltype().equals("01")){
				//判断用户是否签到，是则不能再签到。用户id.当天时间时间,01签到，
				clocks.setUserid(clock.getUserid());
				clocks.setCltype(clock.getCltype());
				if("01".equals(clock.getPlantype())){
					clocks.setCltime(clock.getCltime().replaceAll("-","/").substring(0,10));//日
				}else if("02".equals(clock.getPlantype())){
                    clocks.setCltime(clock.getCltime().replaceAll("-","/").substring(0,10));//周
                    try {
                    	clocks.setFirstday(DateUtil.getFirstAndLastOfWeek(clocks.getCltime()).split(",")[0].replaceAll("-","/")+" "+"00:00:00");
                        clocks.setLastday(DateUtil.getFirstAndLastOfWeek(clocks.getCltime()).split(",")[1].replaceAll("-","/")+" "+"23:59:59");
                    } catch (ParseException e) {
                        clocks.setFirstday("");
                    }
				}else if("03".equals(clock.getPlantype())){
					clocks.setCltime(clock.getCltime().replaceAll("-","/").substring(0,7));//月
				}else if("04".equals(clock.getPlantype())){
					clocks.setCltime(clock.getCltime().replaceAll("-","/").substring(0,4));//年
				}

				clocks.setPlantype(clock.getPlantype());
				//查询用户是否有签到签退记录。
				Clock cl  = clockService.queryClockService(clocks);
				System.out.println("是否可以签到：" + clocks);
				if(cl == null){
					if(shi <= 8 ){
						if(fen < 30){
							clock.setClstatus("01");
						}else{
							clock.setClstatus("02");
						}
					}else{
						clock.setClstatus("02");
					}
					//插入签到信息，可以签到并插入心情、计划、
					try {
						//签到插入
						if(clock != null && !clock.equals("") ){
								clockModel = clockService.insertClockService(clock);
						}else{
							System.out.println("签到数据为空！");
						}
					} catch (Exception e) {
//							throw new RuntimeException();
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					}
				}else{
					clockModel.setCode("404");
					clockModel.setResult("fali");
					clockModel.setTime(System.currentTimeMillis()+"");
					clockModel.setToken("0053");
					clockModel.setMsg("亲，您已签到！");
				}
			}else{
				clockModel.setCode("404");
				clockModel.setResult("fali");
				clockModel.setTime(System.currentTimeMillis()+"");
				clockModel.setToken("0053");
				clockModel.setMsg("传入签到数据错误！");
			}
		}
		return clockModel;
	}
	/**
	 * 签到
	 * @author pyl
	 * @date 2018年9月4日
	 */
	/*@Transactional
	@RequestMapping(value="/insertClock")
	@ResponseBody
	public ResponseModel insertClock(Clock clock, HttpServletRequest request, Plan tplan, Mood mood, Tsummary tsummary){
//		logger.info("insertClock========");
		
//		clock.setClplace("0921");
//		clock.setCltype("01");
		
		ResponseModel clockModel = new ResponseModel();
		ResponseModel tplanModel = null;
		ResponseModel moodModel = null;
		ResponseModel tsummaryModel = null;
		Clock clocks = new Clock();
		if(clock != null &&  !"".equals(clock)){
				clock.setCreatetime(DateUtil.GetDates());
				clock.setUserid(DateUtil.getUserid());//userid:用户id  
				System.out.println(DateUtil.getUserid());
				//------------------------签到和签退用到的数据
				//pc的ip
				String ip = DateUtil.queryIpAddress(request);
				System.out.println(ip);
				//clstatus 判断传值01正常，02迟到，03早退  状态 01正常 02未签到 03迟到
				Calendar now = Calendar.getInstance();
				int shi = now.get(Calendar.HOUR_OF_DAY);//时
				int fen = now.get(Calendar.MINUTE);//分
				clock.setClpcip(ip);//pc，ip地址
			try {
				clock.setClplace(DateUtil.getAddress(ip));
			} catch (Exception e) {
				clock.setClplace(ip);
			}
			if(clock.getId() == null || clock.equals("")){
					clock.setId(CommUtil.getID());//生成id
				}
				//没有签到和签退记录则可以签到，如果签到了，则不能再签到，如果签退了则不能再签退，如果没有签到是不能签退的。
				//没有查询出当前的签到和签退，则可以签到。但是不能签退
				if(clock.getCltype().equals("01")){
					//判断用户是否签到，是则不能再签到。用户id.当天时间时间,01签到，
					clocks.setUserid(clock.getUserid());
					clocks.setCltype(clock.getCltype());
					clocks.setCltime(clock.getCltime().replaceAll("-","/").substring(0,9));//日期
					//查询用户是否有签到签退记录。
					Clock cl  = clockService.queryClockService(clocks);
					System.out.println("是否可以签到：" + clocks);
					if(cl == null){
						if(shi <= 8 ){
							if(fen < 30){
								clock.setClstatus("01");
							}else{
								clock.setClstatus("02");
							}
						}else{
							clock.setClstatus("02");
						}
						//插入签到信息，可以签到并插入心情、计划、
						try {
							//签到插入
							if(clock != null && !clock.equals("") ){
								//判断pc
								if(clock.getTsignid() != null && !"".equals(clock.getTsignid())){
									clock.setId(clock.getTsignid());
									clockModel = clockService.insertClockService(clock);
								}else{
									clockModel = clockService.insertClockService(clock);
								}
							}else{
								System.out.println("签到数据为空！");
							}
							//计划插入
							if( clock.getTplanid() != null && !"".equals(clock.getTplanid() ) ){
							tplan.setId(clock.getTplanid()); 
							tplanModel = iPlanService.InsertPlan(tplan);
							}else{
								System.out.println("计划数据为空！");
							}
							//心情插入
							if( clock.getTmoodid() != null && !"".equals( clock.getTmoodid() )){
							mood.setId(clock.getTmoodid());
							moodModel = moodService.insertMoodService(mood);
							}else{
								System.out.println("心情数据为空！");
							}
							//判断是否插入成功。否则不插入
							if(clockModel.getToken().equals("0053")){
								clockModel.setMsg("签到信息错误！！------------------- ");
								throw new RuntimeException();
							}else if(moodModel != null && !"".equals(moodModel)) {
								if( moodModel.getToken().equals("0053") ){
									clockModel.setMsg("心情信息错误！！--------- ");
									throw new RuntimeException();
								}
							}else if( tplanModel != null && !"".equals(tplanModel)){
								if( tplanModel.getToken().equals("0053") ){
									clockModel.setMsg("心情信息错误！！--- ");
									throw new RuntimeException();
								}
							}
						} catch (Exception e) {
//							throw new RuntimeException();
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  
						}
					}else{
						clockModel.setCode("404");
						clockModel.setResult("fali");
						clockModel.setTime(System.currentTimeMillis()+"");
						clockModel.setToken("0053");
						clockModel.setMsg("亲，您已签到！");
					}
				}else if(clock.getCltype().equals("02")){
					//判断用户是否签到01,签到之后才可签退，
					Clock clockn = new Clock();
					clockn.setUserid(clock.getUserid());
					clockn.setCltype("01");
					clockn.setCltime(clock.getCltime().replaceAll("-","/"));//日期
					//查询用户是否有签到签退记录。
					Clock clo = clockService.queryClockService(clockn);
					System.out.println("是否可以签到：" + clocks);
					//为空则用户没有签到，不能签退
					if(clo == null){
						clockModel.setCode("404");
						clockModel.setResult("fali");
						clockModel.setTime(System.currentTimeMillis()+"");
						clockModel.setToken("0053");
						clockModel.setMsg("亲，没有签到不能签退！");
					}else{
						//用户可签退02
						Clock clockns = new Clock();
						clockns.setUserid(clock.getUserid());
						clockns.setCltype(clock.getCltype());
						clockns.setCltime(clock.getCltime().replaceAll("-","/").substring(0,10));//日期
						//查询用户是否有签到签退记录。
						Clock clos = clockService.queryClockService(clockns);
						System.out.println("是否可以签到：" + clocks);
						//02签退之前查看用户是否已经签退
						if(clos == null){
							if(shi >= 6 ){
								clock.setClstatus("01");
							}else{
								clock.setClstatus("03");
							}
							try {
								//插入签退信息、并插入总结信息
								if(clock != null && !clock.equals("")){
									if(clock.getTsignid() != null && !"".equals(clock.getTsignid())){
										clock.setId(clock.getTsignid());
										clockModel = clockService.insertClockService(clock);
									}else{
										clockModel = clockService.insertClockService(clock);
									}
										
								}else{
									System.out.println("签退数据为空！");
								}
								//总结
								if(tsummary != null && !tsummary.equals("")){
								tsummary.setId(clock.getTsummaryid());
								tsummaryModel = service.saveTsummaryService(tsummary);
								}else{
									System.out.println("总结数据为空！");
								}
								//信息错误则不插入
								if(clockModel.getToken().equals("0053")){
									clockModel.setMsg("签退信息错误！！---------------");
									throw new RuntimeException();
								}else if(tsummaryModel != null && !"".equals(tsummaryModel)){
									if( tsummaryModel.getToken().equals("0053")){
										clockModel.setMsg("总结信息错误！！---------------");
										throw new RuntimeException();
									}
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  
							}
						}else{
							clockModel.setCode("404");
							clockModel.setResult("fali");
							clockModel.setTime(System.currentTimeMillis()+"");
							clockModel.setToken("0053");
							clockModel.setMsg("亲，不能重复签退！");
						}
					}
				}else{
					clockModel.setCode("404");
					clockModel.setResult("fali");
					clockModel.setTime(System.currentTimeMillis()+"");
					clockModel.setToken("0053");
					clockModel.setMsg("传入签到数据错误！");
				}
		} 
		return clockModel;
	}*/
	
	//签到列表信息查询，个人列表和系统管理员列表信息都可用。筛选条件：个人用户id:id、用户名称:usernmae、开始时间：begtime、结束时间：endtime
	@RequestMapping(value="/queryListClock")
	@ResponseBody
	public List<Clock> queryListClockController(Clock clock){
		
		//个人用户
//		clock.setId("123321");
//		clock.setBegtime("2018/09/02");
//		clock.setEndtime("2018/09/04");
//		clock.setCltype("01");
		
		//系统管理员
//		clock.setUsername("王");
//		clock.setBegtime("2018/09/03");
//		clock.setEndtime("2018/09/07");
//		clock.setCltime("02");
		
		List<Clock> clockList = null;
		clockList = clockService.queryListClockService(clock);
		
		return clockList;
	}
	
	/**
	 * 查询签到列表和点赞总数,查询用户名，用户头像，签到点赞总数等，筛选条件:用户名、当天的时间年月日、（或用户id， 
	 * @author pyl
	 * @date 2018年9月17日
	 */
	@RequestMapping(value="/queryListTsig")
	@ResponseBody
	public List<Clock> queryListTsignController(Clock clock){
		List<Clock> model = null;
		
//		clock.setBegtime("2018/09/03");//可为空，或传年月日当天的时间
//		clock.setEndtime("2018/09/03");//可为空，或传年月日当天的时间
//		clock.setLoginname("wy");//可为空，登录名
//		clock.setUserid("");
		
		model = clockService.queryListTsignService(clock);
		
		return model;
	}
	/**
	 * 签到详情，用户头像，点赞头像。签到id必传
	 * @author pyl
	 * @date 2018年9月18日
	 */
	@RequestMapping(value="/queryListDzTsign")
	@ResponseBody
	public List<Clock> queryListDzTsignController(Clock clock){
//		id = "0e457069d31d4e7cbcd52fb99272bb06";
		return clockService.queryListDzTsignService(clock);
	}
	
	/**
	 * 详情-评论
	 * @author pyl
	 * @date 2018年9月18日
	 */
	@RequestMapping(value="/queryListTcomment")
	@ResponseBody
	public List<Tcomment> queryListTcommentController(String itemid){
		
//		itemid = "0e457069d31d4e7cbcd52fb99272bb06";
		
		List<Tcomment> model = null;
		model = clockService.queryListTcommentService(itemid);
		 
		return model;
	}

	@RequestMapping(value="/queryAllList")
	@ResponseBody
	public   List<Clock> queryListTcommentController(Clock clock){
		return clockService.queryAllListService(clock);
	}
	
}
