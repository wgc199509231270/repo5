package com.OuSoft.mobileCommerce.service.CircleofFriends.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.CircleofFriends.CircleofFriendsDao;
import com.OuSoft.mobileCommerce.entity.CircleofFriendsModel;
import com.OuSoft.mobileCommerce.service.CircleofFriends.CircleofFriendsService;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.Tatt;

/**
 * 朋友圈模块
 * @author wangyuxin
 *
 */
@Service
public class CircleofFriendsServiceImpl implements CircleofFriendsService {
	
	@Autowired
	private CircleofFriendsDao circleofFriendsDao;
	
	public List<CircleofFriendsModel> queryCircleofFriends(Mood mood){
		List<CircleofFriendsModel> list=null;
		List<Tatt> listt=null;
		list=circleofFriendsDao.queryCircleofFriends(mood);
		for(CircleofFriendsModel model:list){
			listt=circleofFriendsDao.querytattAll(model);	
			model.setTattlist(listt);
		}
		return list;
	}

}
