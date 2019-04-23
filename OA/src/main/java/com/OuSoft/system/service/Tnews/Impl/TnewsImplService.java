package com.OuSoft.system.service.Tnews.Impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tnews.TnewsDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tnews;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tnews.TnewsService;
import com.OuSoft.utils.DateUtil;

@Service
public class TnewsImplService implements TnewsService{

	@Autowired
	TnewsDao dao;
	
	/**
	 * 查消息
	 */
	@Override
	public List<Tnews> queryTnewsService(Tnews tnews) {
		// TODO Auto-generated method stub
		return dao.queryTnewsDao(tnews);
	}

	/**
	 * 新增消息
nitemid:项目id
nuserid：项目用户id
ntext：提醒内容
nitemuserid：操作人id
nitemtype：项目类型，表名
remark：备注
ntype:类型：01通知，02审核，03点赞，04评论
	 */
	@Override
	public ResponseModel saveTnewsService(Tnews tnews) {
		ResponseModel remodel = new ResponseModel();
		Tsuser tu = DateUtil.GetTsuser();
		int num = 0;
		if( !DateUtil.getObjCheckIsNull(tnews ) ){
			try {
				tnews.setId(DateUtil.getID());
				tnews.setNpid(tu.getUserpid());
				tnews.setNtime(DateUtil.GetStringToDate(DateUtil.GetDates()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num = dao.saveTnewsDao(tnews);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增一条信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增一条信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("信息数据为空！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	@Override
	public List<Tnews> queryPlanTnewsService(Tnews tnews) {
		return dao.queryPlanTnewsDao(tnews);
	}

}
