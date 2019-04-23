package com.OuSoft.mobileCommerce.service.Tquestion.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Tquestion.MTquestionDao;
import com.OuSoft.mobileCommerce.service.Tquestion.MTquestionService;
import com.OuSoft.system.entity.Tquestion;
import com.OuSoft.utils.DateUtil;

/**
 * 问答
 * @author pengyueli
 * @date 2018年11月13日
 */
@Service
public class MTquestionServiceImpl implements MTquestionService{

	@Autowired
	MTquestionDao dao;
	
	/**
	 * 问答所有人列表
 	接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
	问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
	qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，ip：ip  
	 */
	@Override
	public List<Tquestion> queryQBLBListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			tquestion.setDzuserid(DateUtil.getUserid());
			list = dao.queryQBLBListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 问答个人列表
			接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
			问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
			qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，ip：ip
	 */
	@Override
	public List<Tquestion> queryGRLBListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			tquestion.setDzuserid(DateUtil.getUserid());
			if(tquestion.getUserid() == null || "".equals(tquestion.getUserid())){
				tquestion.setUserid(DateUtil.getUserid());
			}
			list = dao.queryGRLBListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 *  问答所有人图表
			 接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
			问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
			qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
	 */
	@Override
	public List<Tquestion> queryQBTBListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			list = dao.queryQBTBListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 问答个人图表
			接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
			问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
			qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
			username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
	 */
	@Override
	public List<Tquestion> queryGRTBListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			if(tquestion.getUserid() == null || "".equals(tquestion.getUserid())){
				tquestion.setUserid(DateUtil.getUserid());
			}
			list = dao.queryGRTBListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 *  问答点赞详情
			接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
			响应： 
			username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
	 */
	@Override
	public List<Tquestion> queryDzListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			tquestion.setDzuserid(DateUtil.getUserid());
			tquestion.setUserid(DateUtil.getUserid());
			list = dao.queryDzListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 问答评论详情
			参数，项目itemid  
			响应：pusername:评论人姓名，txfilename：姓名头像，hfilename,回复头像,husername:回复人姓名，
	 */
	@Override
	public List<Tquestion> queryPlListTquestionService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(tquestion != null){
			tquestion.setUserid(DateUtil.getUserid());
			list = dao.queryPlListTquestionDao(tquestion);
			if(list == null){
				System.out.println("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	
	 
	
	
	

}
