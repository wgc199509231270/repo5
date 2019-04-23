package com.OuSoft.system.dao.Tsummary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tsummary;

@Mapper
@Component(value="Tsummary")
public interface TsummaryDao {
	
	int saveTsummaryDao(Tsummary tsummary);
	
	int deleteTsummaryDao(String id);
	
	//总结列表
	List<Tsummary> queryListTsummaryDao(Tsummary tsummay);
	
	//总结点赞详情
	List<Tsummary> queryListTsummaryTpraiseDao(Tsummary tsummay);
	
	//总结全部
	List<Tsummary> queryNumListTsummaryDao(Tsummary tsummay);
	
	//总结个人
	List<Tsummary> queryGNumListTsummaryDao(Tsummary tsummay);

	//查询
	List<Tsummary> selectTsummaryDao(Tsummary tsummary);
}
