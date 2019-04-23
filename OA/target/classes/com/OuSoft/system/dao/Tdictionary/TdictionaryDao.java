package com.OuSoft.system.dao.Tdictionary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tdictionary;

@Mapper
@Component(value="Tdictionary")
public interface TdictionaryDao {
	
	
	int saveTdictionaryDao(Tdictionary tdictionary);
	
	List<Tdictionary> queryTdictionaryDao(Tdictionary tdictionary);
	
	int deleteTdictionaryDao(Tdictionary tdictionary);
	
	

}
