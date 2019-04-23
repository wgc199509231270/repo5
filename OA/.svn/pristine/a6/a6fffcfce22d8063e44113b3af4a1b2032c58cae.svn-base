package com.OuSoft.system.dao.Tjobinfo;

import groovy.util.logging.Commons;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.entity.Tsuser;


@Mapper
@Commons(value="tjobinfo")
public interface TjobinfoDao {
	
	
	//通过岗位id查询用户信息等
	List<Tsuser> queryJobidTuserDao(Tsuser tsuser);
	
	//查询岗位信息
	List<Tjobinfo> queryTjobinfoDao(Tjobinfo tjobinfo);
	
	//新增岗位信息 
	int insertTjobinfoDao(Tjobinfo tjobinfo);
	
	//删除岗位信息
	int deleteTjobinfoDao(Tjobinfo tjobinfo);
	
	//删除用户岗位信息
	int deleteTuserByIdTjobinfoDao(Tjobinfo tjobinfo);
	
	//新增用户岗位信息
	int InsertTuserByIdTjobinfoDao(Tjobinfo tjobinfo);
	
	//查询用户岗位信息.接收：用户id:userid.返回 id:岗位id, jobname:岗位名称，jobtime:时间，userid:用户id,jobid:岗位id
	List<Tjobinfo> queryTuserByIdTjobinfoDao(Tjobinfo tjobinfo);
	//修改用户岗位信息
	int updateTuserByIdTjobinfoDao(Tjobinfo tjobinfo);

	//获取上级id
	List<Tjobinfo> queryOldUseridDao(Tjobinfo tjobinfo);

	//获取下级id
	List<Tjobinfo> queryUseridDao(Tjobinfo tjobinfo);

	//获取领导id
	List<Tjobinfo> queryOldDao(Tjobinfo tjobinfo);
}
