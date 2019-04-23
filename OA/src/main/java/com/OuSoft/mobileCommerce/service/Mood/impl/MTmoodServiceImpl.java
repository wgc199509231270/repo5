package com.OuSoft.mobileCommerce.service.Mood.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Mood.MTmoodDao;
import com.OuSoft.mobileCommerce.service.Mood.MTmoodService;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.utils.DateUtil;

/**
 * 心情模块
 * @author pengyueli
 * @date 2018年11月7日
 */
@Service
public class MTmoodServiceImpl implements MTmoodService{

	
	@Autowired
	MTmoodDao dao;
	
	
	/**
	 * 心情所有人图表
	 */
	@Override
	public List<Mood> queryQBTmoodListService(Mood mood) {
		List<Mood> list = null;
		if(mood != null){
			mood.setDzuserid(DateUtil.getUserid());
			if(mood.getBegtime() != null && !"".equals(mood.getBegtime()) && mood.getEndtime() != null && !"".equals(mood.getEndtime())){
				list = dao.queryQBTmoodListDao(mood);
			}else{
				mood.setBegtime(DateUtil.GetDateR());
				mood.setEndtime(DateUtil.GetDateR());
				list = dao.queryQBTmoodListDao(mood);
			}
			
		}else{
			System.out.println("心情数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 * 点赞详情
	 * 接收 项目id  响应：username:姓名 tprausername点赞人 tprafilename点赞头像 
	 */
	@Override
	public List<Mood> queryDzTmoodListService(Mood mood) {
		List<Mood> list = null;
		if(mood != null){
				list = dao.queryDzTmoodListsDao(mood);
		} 
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 评论详情
	 * 参数，项目itemid   响应：username:评论人姓名，husername:回复人姓名，txfilename：姓名头像，hfilename,回复头像
	 */
	@Override
	public List<Mood> queryPlTmoodService(Mood mood) {
		List<Mood> list = null;
		if(mood != null){
				list = dao.queryPlTmoodDao(mood);
		} 
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 * 个人图表列表
	 * 接收：pagenum:pagesize   响应：username用户姓名 tpranum点赞数 time年月日 times时分秒 dz是否点赞 tpranum点赞总数  LIMIT 分页
	 */
	@Override
	public List<Mood> queryGrTmoodListService(Mood mood) {
		List<Mood> list = null;
		if(mood != null){
			mood.setDzuserid(DateUtil.getUserid());
			mood.setUserid(DateUtil.getUserid());
			list = dao.queryGrTmoodListDao(mood);
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	
	
	
	
	
	
	
	
	
}
