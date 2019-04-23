package com.OuSoft.mobileCommerce.service.Clock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Clock.MClockDao;
import com.OuSoft.mobileCommerce.service.Clock.MClcockService;
import com.OuSoft.system.entity.Clock;
import com.OuSoft.utils.DateUtil;

/**
 * 签退签到模块
 * @author pengyueli
 * @date 2018年11月7日
 */
@Service
public class MClockServiceImpl implements MClcockService{

	
	@Autowired
	MClockDao dao;
	
	
	/**
	 * 签到图表列表
	 */
	@Override
	public List<Clock> queryClockService(Clock clock) {
		 List<Clock> clocklist = null;
		if(clock != null){
			clock.setDzuserid(DateUtil.getUserid());
			if(clock.getCltime() != null && !clock.equals("")){
				clocklist = dao.queryClockDao(clock);
			}else{
				clock.setCltime(DateUtil.GetDateR());
				clocklist = dao.queryClockDao(clock);
			}
		}
		// TODO Auto-generated method stub
		return clocklist;
	}

	
	
	
	
}
