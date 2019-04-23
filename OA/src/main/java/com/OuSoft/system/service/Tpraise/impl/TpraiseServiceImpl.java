package com.OuSoft.system.service.Tpraise.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tpraise.TpariseDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpraise;
import com.OuSoft.system.service.Tpraise.TpraiseService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Service
public class TpraiseServiceImpl implements TpraiseService{

	@Autowired
	TpariseDao dao;

	/**
	 * 新增点赞
	 */
	@Override
	public ResponseModel saveTpraiseService(Tpraise tpraise) {
		ResponseModel remodel = new ResponseModel();
		int count = 0;
		Tpraise t = new Tpraise();
		if(!DateUtil.getObjCheckIsNull(tpraise) ){
			tpraise.setId(CommUtil.getID());
			tpraise.setPraisetime(DateUtil.GetDates());
			tpraise.setUserid(DateUtil.getUserid());//用户id
			if( tpraise.getUserid() != null && tpraise.getUserid() != ""
					&& tpraise.getItemid() != null && tpraise.getItemid() != ""
					&& tpraise.getItemtype() != null && tpraise.getItemtype() != "" ){
				t = dao.queryTpraiseDao(tpraise);
				if(t == null){
					count = dao.saveTpariseDao(tpraise);
					if(count > 0){
						remodel.setCode("200");
						remodel.setResult("success");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("001");
						remodel.setMsg("新增点数数成功！");
					}else{
						remodel.setCode("404");
						remodel.setResult("fali");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("0053");
						remodel.setMsg("新增点赞数失败！");
					}
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("您已点赞，不能重复点赞哦！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("query点赞数据为空为空！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("点赞数据为空为空！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

	@Override
	public Tpraise queryTpraise(Tpraise tpraise) {
		Tpraise t = new Tpraise();
		if(!DateUtil.getObjCheckIsNull(tpraise) ){
			t = dao.queryTpraiseDao(tpraise);
		}else{
			t = null;
		}
		
		// TODO Auto-generated method stub
		return t;
	}

	/**
	 * 用户id、项目id
	 * userid/itemid
	 */
	@Override
	public ResponseModel delteIdTrpaiseService(Tpraise tpraise) {
		int count = 0;
		ResponseModel model = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tpraise) ){
			tpraise.setUserid(DateUtil.getUserid());//用户id
			count = dao.delteIdTrpaiseDao(tpraise);
			if(count > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("取消点赞成功！");
				
			}else {
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("取消点赞失败！");
			}
		}else {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("点赞数据为空，无法删除！");
		}
		return model;
	}

	
	
	
}
