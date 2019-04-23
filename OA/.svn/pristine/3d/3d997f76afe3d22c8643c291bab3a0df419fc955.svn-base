package com.OuSoft.mobileCommerce.dao.Tsummary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tsummary;

/**
 * 总结
 * @author pengyueli
 * @date 2018年11月9日
 */
@Mapper
@Component(value = "MTsummarys")
public interface MTsummaryDao {

	//总结所有人
	List<Tsummary> queryQBTsummaryListsDao(Tsummary tsummary);
	
	//总结个人
	List<Tsummary> queryGrTsummaryListsDao(Tsummary tsummary);
	
	//总结点赞
	List<Tsummary> queryDzTsummaryListsDao(Tsummary tsummary);
	
	//总结评论
	List<Tsummary> queryPlTsummaryListsDao(Tsummary tsummary);
	
	
	
	
}
