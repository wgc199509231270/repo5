package com.OuSoft.mobileCommerce.service.Tknowledge.Impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Tknowledge.MTknowledgeDao;
import com.OuSoft.mobileCommerce.service.Tknowledge.MTknowledgeService;
import com.OuSoft.system.entity.Tknowledge;
import com.OuSoft.utils.DateUtil;


/**
 * 知识
 * @author pengyueli
 * @date 2018年11月13日
 */
@Service
public class MTknowledgeServiceImpl implements MTknowledgeService{

	
	@Autowired
	MTknowledgeDao dao;
	
	
	
	
	
	/**
	 * 知识所有人列表
 	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	sqgjz: 模糊查询标题和内容
	 响应：latitle:标题，latype:内容，lacreatetime:时间，time:年月日，times时分秒,
	 username:姓名：txfilename:头像，tpranum点赞数，comnum：评论数，ip:ip
	text:列表内容三十个字后是........
	 */
	@Override
	public List<Tknowledge> queryQBLBListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			tknowledge.setDzuserid(DateUtil.getUserid());
			list = dao.queryQBLBListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 
	 知识个人列表
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	sqgjz: 模糊查询标题和内容
	 响应：latitle:标题，latype:内容，lacreatetime:时间，time:年月日，times时分秒,
	 username:姓名：txfilename:头像，tpranum点赞数，comnum：评论数，ip:ip
	text:列表内容三十个字后是........
	 */
	@Override
	public List<Tknowledge> queryGRLBListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			tknowledge.setDzuserid(DateUtil.getUserid());
			tknowledge.setUserid(DateUtil.getUserid());
			list = dao.queryGRLBListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
			
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 所有人图表
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	响应	tpranum:点赞数，comnum:评论数，tsnum，发布数，username:姓名 ，lacreatetime:时间
	 */
	@Override
	public List<Tknowledge> queryQBTBListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			tknowledge.setDzuserid(DateUtil.getUserid());
			list = dao.queryQBTBListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
			
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 *  个人图表 
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	响应	tpranum:点赞数，comnum:评论数，tsnum，发布数，username:姓名 ，lacreatetime:时间
	 */
	@Override
	public List<Tknowledge> queryGRTBListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			tknowledge.setUserid(DateUtil.getUserid());
			list = dao.queryGRTBListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
			
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 点赞详情 
	接收：pagenum:页。pagesize:一页数 	begtime:开始时间年月日 endtime:结束时间 
	id:项目id
	响应：tprausername:点赞人，tprafilename点赞人头像 ip:ip
	 */
	@Override
	public List<Tknowledge> queryDzListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			tknowledge.setDzuserid(DateUtil.getUserid());
			list = dao.queryDzListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
			
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 评论详情 
	接收：pagenum:页。pagesize:一页数 	begtime:开始时间年月日 endtime:结束时间 
	itemid:项目id
	响应：pusername评论人，txfilename:评论人头像，ip:ip，husername:回复人姓名，hfilename:回复人头像，commenttime:时间
	 */
	@Override
	public List<Tknowledge> queryPlListTknowledgeService(Tknowledge tknowledge) {
		List<Tknowledge> list = null;
		if(tknowledge != null){
			list = dao.queryPlListTknowledgeDao(tknowledge);
			if(list == null){
				System.out.println("数据为空!");
			}
			
		}else{
			System.out.println("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}
	
	
	
	
}
