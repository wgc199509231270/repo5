package com.OuSoft.system.dao.Tcompany;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tcompany;


@Mapper
@Component(value="tcompany")
public interface TcompanyDao {

	int saveTcompanyDao(Tcompany tcompany);
	
	int deleteTcompanyDao(Tcompany tcompany);
	
	List<Tcompany> queryTcompanyDao(Tcompany tcompany);
	
	
	
}
