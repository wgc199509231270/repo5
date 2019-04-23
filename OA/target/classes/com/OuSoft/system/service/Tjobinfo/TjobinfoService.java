package com.OuSoft.system.service.Tjobinfo;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.entity.Tsuser;

public interface TjobinfoService {
	
	
	//通过岗位id查询用户信息
	List<Tsuser> queryJobidTuserService(Tsuser tsuser);
	
	//查询岗位信息
	List<Tjobinfo> queryTjobinfoService(Tjobinfo tjobinfo);

	//新增岗位信息 
	ResponseModel insertTjobinfoService(Tjobinfo tjobinfo);

	//删除岗位信息
	ResponseModel deleteTjobinfoService(Tjobinfo tjobinfo);
	
	//删除用户岗位信息
	ResponseModel deleteTuserByIdTjobinfoService(Tjobinfo tjobinfo);
	
	//新增用户岗位信息
	ResponseModel InsertTuserByIdTjobinfoService(Tjobinfo tjobinfo);

	//修改用户岗位信息
	ResponseModel updateTuserByIdTjobinfoService(Tjobinfo tjobinfo);

	//查询用户岗位信息.接收：用户id:userid.返回 id:岗位id, jobname:岗位名称，jobtime:时间，userid:用户id,jobid:岗位id
	List<Tjobinfo> queryTuserByIdTjobinfoService(Tjobinfo tjobinfo);

	//获取上级id
	List<Tjobinfo> queryOldUseridService(Tjobinfo tjobinfo);

	//获取下级id
	List<Tjobinfo> queryUseridService(Tjobinfo tjobinfo);
}
