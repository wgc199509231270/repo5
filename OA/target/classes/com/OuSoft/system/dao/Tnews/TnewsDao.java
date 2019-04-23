package com.OuSoft.system.dao.Tnews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tnews;


@Mapper
@Component(value="Tnews")
public interface TnewsDao {
	
	
	List<Tnews> queryTnewsDao(Tnews tnews);
	
	
	int saveTnewsDao(Tnews tnews);



	List<Tnews> queryPlanTnewsDao(Tnews tnews);

}
