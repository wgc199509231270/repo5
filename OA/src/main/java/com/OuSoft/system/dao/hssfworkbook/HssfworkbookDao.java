package com.OuSoft.system.dao.hssfworkbook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OuSoft.system.entity.Tsuser;


@Mapper
public interface HssfworkbookDao {

	
	List<Tsuser> queryTsuserDao();
	
	
}
