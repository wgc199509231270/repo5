package com.OuSoft.mobileCommerce.dao.Tplan;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Plan;

/**
 * @author pengyueli
 * @date 2018年11月8日
 */
@Mapper
@Component(value = "MTplan")
public interface MTplanDao {
	
	//计划所有人图表列表
	List<Plan> queryQBTplanListDao(Plan plan);
	
	//计划个人图表列表
	List<Plan> queryGrTplanListDao(Plan plan);
	
	//计划点赞
	List<Plan> queryDzTplanListDao(Plan plan);
	
	//计划评论
	List<Plan> queryPlTplanListDao(Plan plan);
	

}
