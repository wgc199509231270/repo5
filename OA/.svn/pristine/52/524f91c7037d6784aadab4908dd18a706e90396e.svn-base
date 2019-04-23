package com.OuSoft.system.dao.Tdepartmentinfo;

import groovy.util.logging.Commons;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;

/**
 * 部门
 * @author pengyueli
 * @date 2018年12月11日
 */
@Mapper
@Commons(value="Tdepartmentinfo")
public interface TdepartmentinfoDao {
	
	/**
	 * 使用与部门等级编码查询
	 * @author pyl
	 * @date 2019年3月5日
	 */
	List<Tdepartmentinfo> queryDepartmentDao(Tdepartmentinfo tdepartmentinfo);
	
	//通过deparepid查询部门id
	List<Tdepartmentinfo> queryDeparepidDao(Tdepartmentinfo tdepartmentinfo);
	//通过id查询部门
	List<Tdepartmentinfo> queryIdDao(Tdepartmentinfo tdepartmentinfo);
	/**
	 * 修改用户分配的小组信息userid:用户id
	deparid:小组id
	id：修改那条数据的id
	 */
	int updateTdeparinfoByIdDao(Tdepartmentinfo tdepartmentinfo);
	
	//部门下的人员
	List<Tdepartmentinfo> queryBMTdepartmentTuserDao(Tsuser tsuser);
	
	//小组下的人员，id:小组id
	List<Tdepartmentinfo> queryTdepartmentTuserDao(Tsuser tsuser);
	
	//树形结构部门
	List<Tdepartmentinfo> querySXJGBMTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	
	//树形结构小组
	List<Tdepartmentinfo> querySXJGXZTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	
	//查询部门信息
	List<Tdepartmentinfo> queryTdepartmentinfoDao(String tcmid);
	
	//新增部门信息 
	int insertTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	
	//删除部门信息
	int deleteTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	
	//删除用户部门信息
	int deleteTuserByIdTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	
	//新增用户部门信息
	int InsertTuserByIdTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);

	//修改用户部门信息
	int updateTuserByIdTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);

	//查询用户部门信息.接收：用户id:userid.返回 id:部门id, deparname:部门名称，departime:时间，userid:用户id,deparid:部门id 
	List<Tdepartmentinfo> queryTuserByIdTdepartmentinfoDao(Tdepartmentinfo tdepartmentinfo);
	

}
