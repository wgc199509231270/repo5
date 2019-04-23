package com.OuSoft.system.dao.Tscorp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.dao.Tscorp.Model.TscorpModel;
import com.OuSoft.system.entity.TreeModel;
import com.OuSoft.system.entity.Tscorp;

@Mapper
@Component(value="Tscorp")
public interface TscorpDao {
	
	// 添加
	int InsertTscorp(Tscorp model);
	
	//根据id删除
	int DelTscorp(String id);
	
	// 修改各种参数
	int UpdateTscorp(Tscorp model);
	
	// 查询列表
	List<TscorpModel> QueryTscorpList(TscorpModel model);
	
}
