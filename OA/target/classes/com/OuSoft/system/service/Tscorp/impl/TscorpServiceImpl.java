package com.OuSoft.system.service.Tscorp.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tscorp.TscorpDao;
import com.OuSoft.system.dao.Tscorp.Model.TscorpModel;
import com.OuSoft.system.entity.Tscorp;
import com.OuSoft.system.service.Tscorp.TscorpService;

@Service
public class TscorpServiceImpl implements TscorpService{

	@Autowired
	TscorpDao dao;
	
	// 添加
	@Override
	public boolean InsertTscorp(Tscorp model){
		boolean b = false;
		TscorpModel tsmodel = new TscorpModel();
		tsmodel.setId(model.getEpid());
		List<TscorpModel> list = dao.QueryTscorpList(tsmodel);
		
		if(list!=null&&list.get(0).getId()!=null){
			if(list.size()==1){
				model.setEpid(model.getEpid()+"001");
			}else{
				tsmodel = list.get(list.size()-1);
				long epid = Long.parseLong(tsmodel.getEpid())+1;
				
				model.setEpid(epid+"");
			}
			int i = dao.InsertTscorp(model);
			if(i>0){
				b = true;
			}
		}
		return b;
	}
	
	//根据id删除
	@Override
	public boolean DelTscorp(String id){
		boolean b = false;
		int i = dao.DelTscorp(id);
		if(i>0){
			b = true;
		}
		return b;
	}
	
	// 修改各种参数
	@Override
	public boolean UpdateTscorp(Tscorp model){
		boolean b = false;
		int i = dao.UpdateTscorp(model);
		if(i>0){
			b = true;
		}
		return b;
	}
	
	// 查询列表
	@Override
	public List<TscorpModel> QueryTscorpList(TscorpModel model){
		List<TscorpModel> listmodel = new ArrayList<TscorpModel>();
		listmodel = dao.QueryTscorpList(model);
		return listmodel;
	}
	
}
