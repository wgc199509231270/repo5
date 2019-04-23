package com.OuSoft.mobileCommerce.service.tplan.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Tplan.MTplanDao;
import com.OuSoft.mobileCommerce.service.tplan.MTplanService;
import com.OuSoft.system.entity.Plan;
import com.OuSoft.utils.DateUtil;

@Service
public class MTplanServiceImpl implements MTplanService{
	
	
	@Autowired
	MTplanDao dao;

	
	
	/**
	 * 	计划所有人图表列表
	 *  接收pagenum页,pagesize一页的数 begtime开始时间年月日,endtime结束时间年月日 
	 *  响应：times年月日，time时分秒，username:姓名，ip，txfilename头像
	 */
	@Override
	public List<Plan> queryQBTplanListService(Plan plan) {
		List<Plan> list = null;
		if(plan != null){
			plan.setDzuserid(DateUtil.getUserid());
			if(plan.getBegtime() != null && !"".equals(plan.getBegtime()) && plan.getEndtime() != null && !"".equals(plan.getEndtime())){
				list = dao.queryQBTplanListDao(plan);
			}else{
				plan.setBegtime(DateUtil.GetDateR());
				plan.setEndtime(DateUtil.GetDateR());
				list = dao.queryQBTplanListDao(plan);
			}
			
		}else{
			System.out.println("数据为空!");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 计划个人图表列表
	 * -- 接收：pagenum页,pagesize一页的数 begtime开始时间年月日,endtime结束时间年月日 
	 *  响应：times年月日，time时分秒，username:姓名，ip，txfilename头像
	 */
	@Override
	public List<Plan> queryGrTplanListService(Plan plan) {
		List<Plan> list = null;
		if(plan != null){
			plan.setDzuserid(DateUtil.getUserid());
			plan.setUserid(DateUtil.getUserid());
			list = dao.queryGrTplanListDao(plan);
		}else{
			System.out.println("接收计划个人数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	
	/**
	 * 计划点赞详情
	 * 接收项目id  响应 tprausername:点赞人   tprafilename:点赞人头像
	 */
	@Override
	public List<Plan> queryDzTplanListService(Plan plan) {
		List<Plan> list = null;
		if(plan != null){
			list = dao.queryDzTplanListDao(plan);
		}else{
			System.out.println("计划点赞id为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	
	/**
	 * 计划评论详情
	 *  参数，项目itemid   
	 *  响应：pusername:评论人姓名 txfilename：评论人头像，husername:回复人姓名，txfilename：姓名头像，hfilename,回复头像
	 */
	@Override
	public List<Plan> queryPlTplanListService(Plan plan) {
		List<Plan> list = null;
		if(plan != null){
			list = dao.queryPlTplanListDao(plan);
		}else{
			System.out.println("计划评论详情为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	 
	
	

}
