package com.OuSoft.system.service.Tscorp;

import java.util.List;

import com.OuSoft.system.dao.Tscorp.Model.TscorpModel;
import com.OuSoft.system.entity.Tscorp;


public interface TscorpService {

	// 添加
	boolean InsertTscorp(Tscorp model);
	
	//根据id删除
	boolean DelTscorp(String id);
	
	// 修改各种参数
	boolean UpdateTscorp(Tscorp model);
	
	// 查询列表
	List<TscorpModel> QueryTscorpList(TscorpModel model);

	
}
