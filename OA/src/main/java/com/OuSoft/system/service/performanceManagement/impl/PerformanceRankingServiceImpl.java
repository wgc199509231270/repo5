package com.OuSoft.system.service.performanceManagement.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.performanceManagement.PerformanceRankingDao;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.parformanceRequest;
import com.OuSoft.system.entity.performanceRank;
import com.OuSoft.system.entity.tdepartType;
import com.OuSoft.system.service.performanceManagement.PerformanceRankingService;
import com.OuSoft.utils.DateUtil;

@Service
public class PerformanceRankingServiceImpl implements PerformanceRankingService{

	@Autowired
	PerformanceRankingDao pfmrDao;

	//业绩排名列表接口
	// 		01	，02	， 03  
	//object: 个人，小组，部门
	//state : 个人，小组，部门，公司
	//type  ： 业绩,效率，工作时长，
	@Override
	public List<performanceRank> queryPfmr(parformanceRequest pfm) {
		Tsuser tuser=DateUtil.GetTsuser();
		pfm.setTcmid(tuser.getUserpid());
		pfm.setUserid(tuser.getId());
		List<performanceRank> list=null;
		if(pfm.getObject().equals("01")){
			if(pfm.getState().equals("01")){
				List<tdepartType> model=pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
				pfm.setDeparepid(model.get(0).getDeparepid());
			}else if(pfm.getState().equals("02")){
				List<tdepartType> model=pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
				pfm.setDeparepid(model.get(0).getDeparepid().substring(0,6));
			}
			//接口调用  直接个人在公司
			 list=pfmrDao.queryPfmr(pfm);
		}else if(pfm.getObject().equals("02")){
			if(pfm.getState().equals("01")){
			pfm.setDeparepid(pfm.getDeparepid().substring(0,6));
			}
			//直接小组在公司
			list=pfmrDao.querygroupList(pfm);
		}else if(pfm.getObject().equals("03")){
			//  querypartList 部门在公司
			list=pfmrDao.querypartList(pfm);
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 业绩点赞详情
	 */
	@Override
	public List<performanceRank> queryDzParformanceRequestService(parformanceRequest pfm) {
		List<performanceRank> list = null;
		if(pfm != null){
			if(pfm.getId() != null && !"".equals(pfm.getId())){
				pfm.setDzuserid(DateUtil.getUserid());
				list = pfmrDao.queryDzParformanceRequestDao(pfm);
			}else{
				System.out.println("业绩id为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}



}
