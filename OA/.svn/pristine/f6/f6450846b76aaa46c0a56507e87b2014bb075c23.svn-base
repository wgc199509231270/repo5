package com.OuSoft.system.service.Tsummary.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tsummary.TsummaryDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsummary;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tsummary.TsummaryService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

/**
 * 总结
 * @author pengyueli
 * @date 2018年9月25日
 */
@Service
public class TsummaryServiceImpl implements TsummaryService{

	@Autowired
	TsummaryDao dao;
	
	/**
	 * 新增总结 
	 */
	@Override
	public ResponseModel saveTsummaryService(Tsummary tsummay) {
		ResponseModel remodel = new ResponseModel();
		System.out.println("打印总结：" + tsummay);
		int count = 0;
		if(!DateUtil.getObjCheckIsNull(tsummay) ){
			if(tsummay.getId() == null || tsummay.equals("")){
				tsummay.setId(CommUtil.getID());//生成id
			}
			tsummay.setSucreatetime(DateUtil.GetDates());
			tsummay.setUserid(DateUtil.getUserid());//用户id
			count = dao.saveTsummaryDao(tsummay);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("发布总结成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("发布总结失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("总结数据为空！");
		}
		return remodel;
	}

	@Override
	public ResponseModel deleteTsummaryService(String id) {
		int count = 0;
		ResponseModel remodel = new ResponseModel();
		if(id != null && id != ""){
			count = dao.deleteTsummaryDao(id);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条总结成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条总结失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("总结ID为空！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 总结列表
	 */
	@Override
	public List<Tsummary> queryListTsummaryService(Tsummary tsummay) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tsummary> list = null;
		if(!DateUtil.getObjCheckIsNull(tsummay) ){
			tsummay.setTcmid(tuser.getUserpid());
			tsummay.setDzuserid(DateUtil.getUserid());
			if( "sq".equals(tsummay.getSqtsgin())){
				list = dao.queryListTsummaryDao(tsummay);
			}else{
				if(tsummay.getLoginname() == null || tsummay.getLoginname() == ""){
					tsummay.setUserid(DateUtil.getUserid());
					list = dao.queryListTsummaryDao(tsummay);
				}else{
					list = dao.queryListTsummaryDao(tsummay);
				}
			}
		}else{
			System.out.println("总结数据为空");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 总结点赞详情
	 */
	@Override
	public List<Tsummary> queryListTsummaryTpraiseService(Tsummary tsummay) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tsummary> list = null;
		if(!DateUtil.getObjCheckIsNull(tsummay) ){
			tsummay.setTcmid(tuser.getUserpid());
			tsummay.setDzuserid(DateUtil.getUserid());
			list = dao.queryListTsummaryTpraiseDao(tsummay);
		}else{
			System.out.println("总结数据为空点赞");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 总结图表
	 */
	@Override
	public List<Tsummary> queryNumListTsummaryDao(Tsummary tsummay) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tsummary> list = null;
		if(!DateUtil.getObjCheckIsNull(tsummay) ){
			tsummay.setTcmid(tuser.getUserpid());
			if( tsummay.getSqtsgin() != null && tsummay.getSqtsgin() != ""){
				list = dao.queryNumListTsummaryDao(tsummay);
			}else{
				//其他
				if(tsummay.getLoginname() != null && tsummay.getLoginname() != ""){
					list = dao.queryGNumListTsummaryDao(tsummay);
				}else{
					//个人
					tsummay.setUserid(DateUtil.getUserid());
					list = dao.queryGNumListTsummaryDao(tsummay);
				}
			}
			
		}else{
			System.out.println("心情数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Tsummary> selectTsummaryService(Tsummary tsummary) {
		return dao.selectTsummaryDao(tsummary);
	}


}
