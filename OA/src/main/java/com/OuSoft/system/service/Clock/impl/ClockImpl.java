package com.OuSoft.system.service.Clock.impl;

import java.util.*;

import com.OuSoft.system.dao.Tdepartmentinfo.TdepartmentinfoDao;
import com.OuSoft.system.dao.Tjobinfo.TjobinfoDao;
import com.OuSoft.system.dao.Tsuser.TsusersDao;
import com.OuSoft.system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Clock.ClockDao;
import com.OuSoft.system.service.Clock.ClockService;
import com.OuSoft.utils.DateUtil;

@Service
public class ClockImpl implements ClockService{

	@Autowired
	ClockDao dao;
	@Autowired
	TjobinfoDao tjobinfoDao;
	@Autowired
	TdepartmentinfoDao tdepartmentinfoDao;
	@Autowired
	TsusersDao tsusersDao;

	/** 
	 * 签到
	 * @author pyl
	 * @date 2018年9月3日
	 */
	@Override
	public ResponseModel insertClockService(Clock clock) {
		ResponseModel model = new ResponseModel();
		int count = 0;
		//插入的数据
		if(!DateUtil.getObjCheckIsNull(clock) ){
				count = dao.InsertClock(clock);
				System.out.println(count);
				if(count > 0 ){
					if(clock.getCltype().equals("01")){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("签到成功！");
					model.setId(clock.getId());
					}else{
						model.setCode("200");
						model.setResult("success");
						model.setTime(System.currentTimeMillis()+"");
						model.setToken("001");
						model.setMsg("签退成功！");
						model.setId(clock.getId());
					}
		            // TODO 将登录信息放入session中
				}else{
					model.setCode("404");
					model.setResult("fali");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("0053");
				} 
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("签到退信息失败！");
		}
		return model;
	}

	 

	/**
	 * 查询用户是否签到和签退
	 */
	@Override
	public Clock queryClockService(Clock clock) {
		Clock clockModel = new Clock();
		if(!DateUtil.getObjCheckIsNull(clock) ){
			if(clock.getUserid() != null && clock.getUserid().equals("") ){
				clockModel = dao.queryClockDao(clock);
			}else{
				clock.setUserid(DateUtil.getUserid());
				clockModel = dao.queryClockDao(clock);
			}
		}else{
			System.out.println("签到数据为空!");
		}
		return clockModel;
	}


	/**
	 * 签到列表信息查询，个人列表和系统管理员列表信息都可用。筛选条件：个人用户id:id、用户名称:usernmae、开始时间：begtime、结束时间：endtime
	 */
	@Override
	public List<Clock> queryListClockService(Clock clock) {
		List<Clock> clockList = null;
		if(!DateUtil.getObjCheckIsNull(clock) ){
			if(clock.getLoginname() == null || clock.getLoginname() == ""){
				//用户查询条件，用户名为空则是查询当前登录人。有值。则是查询其他用户的信息
				clock.setId(DateUtil.getUserid());
				clockList = dao.queryListClockDao(clock);
			}else{
				clockList = dao.queryListClockDao(clock);
			}
		}
		return clockList;
	}



	/**
	 * 签到列表
	 */
	@Override
	public List<Clock> queryListTsignService(Clock clock) {
		List<Clock> model = null;
		if(!DateUtil.getObjCheckIsNull(clock) ){
			if(clock.getSqtsgin() !=null && clock.getSqtsgin() != ""){
				clock.setDzuserid(DateUtil.getUserid());
				model = dao.queryListTsignDao(clock);
			}else{
				if(clock.getLoginname() != null && clock.getLoginname() != ""){
					clock.setDzuserid(DateUtil.getUserid());
					model = dao.queryListTsignDao(clock);
				}else{
					clock.setUserid(DateUtil.getUserid());
					clock.setDzuserid(DateUtil.getUserid());
					model = dao.queryListTsignDao(clock);
				}
			}
			
		}else{
			System.out.println("签到查询数据为空！");
		}
		// TODO Auto-generated method stub
		return model;
	}


	/**
	 * 签到详情点赞
	 */
	@Override
	public List<Clock> queryListDzTsignService(Clock clock) {
		List<Clock> model = null;
		if(!DateUtil.getObjCheckIsNull(clock) ){
			clock.setDzuserid(DateUtil.getUserid());
			model = dao.queryListDzTsignDao(clock);
			
		}else{
			System.out.println("签到id为空！");
		}
		
		// TODO Auto-generated method stub
		return model;
	}



	/**
	 * 评论详情-评论
	 */
	@Override
	public List<Tcomment> queryListTcommentService(String itemid) {
		List<Tcomment> model = null;
		if(itemid != null){
			model = dao.queryListTcommentDao(itemid);
		}else{
			System.out.println("itemid为空");
		}
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 查询所有用户签到
	 * @param clock
	 * @return
	 */
	@Override
	public   List<Clock> queryAllListService(Clock clock) {
		List li=new ArrayList();
		Map map=new HashMap();
        List<Clock> list=dao.queryAllListDao(clock);
		int number=0;
		int late=0;
		int early=0;
		int absenteeism=0;
		int lack=0;
		List list2=new ArrayList();
		String time="";
		for (Clock list1:list) {
			if("01".equals(list1.getClstatus())){
				number+=1;
			}else if("02".equals(list1.getClstatus())){
				late+=1;
			}else if("03".equals(list1.getClstatus())){
				early+=1;
			}else{

			}
		}
		for(int i=0;i<list.size();i++){
			time=list.get(i).getCltime().split(" ")[0];
			for(int j=1+i;j<list.size();j++){
				if(list.get(j).getCltime().split(" ")[0].equals(time)){
					list2.add(time);
				}else{
					lack+=1;
					for(Object list3:list2){
						if(time.equals(list3)){
							lack-=1;
							break;
						}
					}
				}
			}

		}

		try {
			map.put("username",list.get(0).getUsername());
		}catch (IndexOutOfBoundsException e){
			Tsuser tsuser=tsusersDao.queryIdTuserDao(clock.getUserid());
			map.put("username",tsuser.getUsername());
		}
		try {
			map.put("deparname",list.get(0).getDeparname());
		}catch (IndexOutOfBoundsException e){
			Tdepartmentinfo tdepartmentinfo=new Tdepartmentinfo();
			tdepartmentinfo.setUserid(clock.getUserid());
			List<Tdepartmentinfo> tdepartmentinfoList=tdepartmentinfoDao.queryTuserByIdTdepartmentinfoDao(tdepartmentinfo);
			map.put("deparname",tdepartmentinfoList.get(0).getDeparname());
		}
        map.put("number",number);
        map.put("late",late);
        map.put("early",early);
        map.put("absenteeism",absenteeism);
        map.put("lack",lack);
        map.put("userid",clock.getUserid());
        li.add(map);
        return li;
	}

	@Override
	public ResponseModel UpdateClockByidService(Clock clock) {
		ResponseModel model = new ResponseModel();
		int count = 0;
		if(!DateUtil.getObjCheckIsNull(clock) ){
			if("".equals(clock.getCltime())||clock.getCltime()==null){
				clock.setCltimep(DateUtil.GetDates());
			}
		int shi = Integer.parseInt(clock.getCltimep().split(" ")[1].split(":")[0]);//时
		if(shi >= 18 ){
			clock.setClstatusp("01");
		}else{
			clock.setClstatusp("03");
		}
			count = dao.UpdateClockByid(clock);
			System.out.println(count);
			if(count > 0 ){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("签退成功！");
					model.setId(clock.getId());
				// TODO 将登录信息放入session中
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("签到退信息失败！");
		}
		return model;
	}

	@Override
	public ResponseModel deleteClockByidService(String id) {
		int count = 0;
		ResponseModel remodel = new ResponseModel();
		if(id != null && id != ""){
					count = dao.deleteClockByid(id);
			if(count > 0){
				//将计划中的评论、点赞、附件相应删除。
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条签到成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条签到失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("签到ID为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}


}
