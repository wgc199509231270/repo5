package com.OuSoft.system.service.Tdepartmentinfo;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.TreeTdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;


/**
 * 部门
 * @author pengyueli
 * @date 2018年12月11日
 */
public interface TdepartmentinfoService {
	
	
	//通过deparepid查询部门id
	List<Tdepartmentinfo> queryDeparepidService(Tdepartmentinfo tdepartmentinfo);

	//通过deparepid查询部门id
	List<Tdepartmentinfo> queryIdService(Tdepartmentinfo tdepartmentinfo);
	/**
	 * 修改用户分配的小组信息userid:用户id
	deparid:小组id
	id：修改那条数据的id
	 * @author pyl
	 * @date 2019年1月8日
	 */
	ResponseModel updateTdeparinfoByIdService(Tdepartmentinfo tdepartmentinfo);
	
	//部门下的人员 ：deparepid:部门编号
	List<Tdepartmentinfo> queryBMTdepartmentTuserService(Tsuser tsuser);
	
	//小组下的人员，id:小组id
	List<Tdepartmentinfo> queryTdepartmentTuserService(Tsuser tsuser);
	
	//树形结构
	List<TreeTdepartmentinfo> querySXJGTdepartmentinfoService();
	
	//查询部门信息
	List<Tdepartmentinfo> queryTdepartmentinfoService();
	
	//新增部门信息 
	ResponseModel insertTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);
	
	//删除部门信息
	ResponseModel deleteTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);
	
	//删除用户部门信息
	ResponseModel deleteTuserByIdTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);
	
	//新增用户部门信息
	ResponseModel InsertTuserByIdTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);

	//修改用户部门信息
	ResponseModel updateTuserByIdTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);
	
	//查询用户部门信息.接收：用户id:userid.返回 id:部门id, deparname:部门名称，departime:时间，userid:用户id,deparid:部门id 
	List<Tdepartmentinfo> queryTuserByIdTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo);

}
