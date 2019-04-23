package com.OuSoft.system.dao.Tpositioninfo;

import groovy.util.logging.Commons;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OuSoft.system.entity.Tpositioninfo;


@Mapper
@Commons(value="Tpositioninfo")
public interface TpositioninfoDao {

	//查询职位信息
	List<Tpositioninfo> queryTpositioninfoDao(String tcmid);
	
	//新增职位信息 
	int insertTpositioninfoDao(Tpositioninfo tpositioninfo);
	
	//删除职位信息
	int deleteTpositioninfoDao(Tpositioninfo tpositioninfo);
	
	//删除用户职位信息
	int deleteTuserByIdTpositioninfoDao(Tpositioninfo tpositioninfo);
	
	//新增用户职位信息
	int InsertTuserByIdTpositioninfoDao(Tpositioninfo tpositioninfo);
	
	//查询用户职位信息.接收：用户id:userid.返回 id:职位id, posiname:职位名称，tpositime:时间，userid:用户id,posiid:职位id
	List<Tpositioninfo> queryTuserByIdTpositioninfoDao(Tpositioninfo tpositioninfo);
	
	
}
