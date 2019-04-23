package com.OuSoft.system.dao.Tpraise;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tpraise;


@Mapper
@Component(value="Tparise")
public interface TpariseDao {

	int saveTpariseDao(Tpraise tpraise);
	
	Tpraise queryTpraiseDao(Tpraise tpraise);
	
	//删除点赞
	int delteIdTrpaiseDao(Tpraise tpraise);
	
}
