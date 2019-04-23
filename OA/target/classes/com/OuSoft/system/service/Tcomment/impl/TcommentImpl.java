package com.OuSoft.system.service.Tcomment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tcomment.TcommentDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcomment;
import com.OuSoft.system.service.Tcomment.TcommentService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

/**
 * 评论
 * @author pengyueli
 * @date 2018年10月12日
 */
@Service
public class TcommentImpl implements TcommentService{

	@Autowired
	TcommentDao dao;
	
	/**
	 * 评论新增
	 */
	@Override
	public ResponseModel saveTcommentService(Tcomment tcomment) {
		ResponseModel remodel = new ResponseModel();
		int count = 0;
		if(tcomment != null){
			if(tcomment.getId() == null || tcomment.equals("")){
				tcomment.setId(CommUtil.getID());//生成id
			}
			tcomment.setCommenttime(DateUtil.GetDates());
			tcomment.setUserid(DateUtil.getUserid());//用户id
			count = dao.saveTcommentDao(tcomment);
			if(count > 0 ){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("发布评论成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("发布评论失败！");
				
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 评论回复详情
	 */
	@Override
	public List<Tcomment> queryListTcommentService(Tcomment tcomment) {
		List<Tcomment> listTcomment = null;
		if(tcomment != null){
			listTcomment = dao.queryListTcommentDao(tcomment);
		}else{
			System.out.println("评论回复详情为空！");
		}
		// TODO Auto-generated method stub
		return listTcomment;
	}

	/**
	 * 删除当前用户的评论
	 */
	@Override
	public ResponseModel deleTcommentService(Tcomment tcomment) {
		ResponseModel remodel = new ResponseModel();
		tcomment.setUserid(DateUtil.getUserid());
		int num = dao.deleTcommentDao(tcomment);
		if(num > 0){
			remodel.setCode("200");
			remodel.setResult("success");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("001");
			remodel.setMsg("删除评论成功！");
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("删除评论失败！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

}
