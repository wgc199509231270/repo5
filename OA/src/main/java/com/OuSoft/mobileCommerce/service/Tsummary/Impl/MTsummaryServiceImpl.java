package com.OuSoft.mobileCommerce.service.Tsummary.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.Tsummary.MTsummaryDao;
import com.OuSoft.mobileCommerce.service.Tsummary.MTsummaryService;
import com.OuSoft.system.entity.Tsummary;
import com.OuSoft.utils.DateUtil;

/**
 * 总结
 * @author pengyueli
 * @date 2018年11月9日
 */
@Service
public class MTsummaryServiceImpl implements MTsummaryService{
	
	@Autowired
	MTsummaryDao dao;

	/**
	 * 总结全查
	 * 接收：pagenum:页pagesize:一页几条数据，（begtime:开始年月日，endtime:结束年月日（默认当天））
 	 * 响应：username:姓名，txfilename：头像,ip:ip，sutext:内容time:年月日 times:时分秒
	 * sucompany：公司 sumanage：管理 suwork：工作 suhygienism：卫生
	 */
	@Override
	public List<Tsummary> queryQBTsummaryListService(Tsummary tsummary) {
		List<Tsummary> list = null;
		if(tsummary != null){
			tsummary.setDzuserid(DateUtil.getUserid());
			if(tsummary.getBegtime() != null && !"".equals(tsummary.getBegtime()) && tsummary.getEndtime() != null && !"".equals(tsummary.getEndtime())){
				list = dao.queryQBTsummaryListsDao(tsummary);
			}else{
				tsummary.setBegtime(DateUtil.GetDateR());
				tsummary.setEndtime(DateUtil.GetDateR());
				list = dao.queryQBTsummaryListsDao(tsummary);
			}
		}else{
			System.out.println("总结数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 总结个人
	 *  接收：pagenum:页pagesize:一页几条数据，begtime:开始年月日，endtime:结束年月日
	 *  响应：username:姓名，txfilename：头像,ip:ip，sutext:内容time:年月日 times:时分秒
	 *  sucompany：公司 sumanage：管理 suwork：工作 suhygienism：卫生
	 */
	@Override
	public List<Tsummary> queryGrTsummaryListService(Tsummary tsummary) {
		List<Tsummary> list = null;
		if(tsummary != null){
			tsummary.setDzuserid(DateUtil.getUserid());
			tsummary.setUserid(DateUtil.getUserid());
			System.out.println("總結個人userid：" +DateUtil.getUserid() );
			list = dao.queryGrTsummaryListsDao(tsummary);
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 总结点赞
	 * 接收:id：项目id   响应：tprausername:点赞人，tprafilename:点赞头像， time:年与日 times:时分秒
	 */
	@Override
	public List<Tsummary> queryDzTsummaryListService(Tsummary tsummary) {
		List<Tsummary> list = null;
		tsummary.setDzuserid(DateUtil.getUserid());
		if(tsummary != null){
				list = dao.queryDzTsummaryListsDao(tsummary);
		} 
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 总结评论
	 * 参数，项目itemid   响应：pusername:评论人姓名，txfilename：姓名头像，hfilename,回复头像 husername:回复人姓名， commenttime:时间
	 */
	@Override
	public List<Tsummary> queryPlTsummaryListService(Tsummary tsummary) {
		List<Tsummary> list = null;
		if(tsummary != null){
				list = dao.queryPlTsummaryListsDao(tsummary);
		} 
		// TODO Auto-generated method stub
		return list;
	}
	
	
	
	
	

}
