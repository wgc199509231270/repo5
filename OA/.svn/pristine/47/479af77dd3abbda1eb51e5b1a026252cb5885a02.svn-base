package com.OuSoft.system.service.Tpositioninfo;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpositioninfo;


/**
 * 职位
 * @author pengyueli
 * @date 2018年12月11日
 */
public interface TpositioninfoService {
	
	//查询职位信息
	List<Tpositioninfo> queryTpositioninfoService();
	
	//新增职位信息 
	ResponseModel insertTpositioninfoService(Tpositioninfo tpositioninfo);
	
	//删除职位信息
	ResponseModel deleteTpositioninfoService(Tpositioninfo tpositioninfo);
	
	//删除用户职位信息
	ResponseModel deleteTuserByIdTpositioninfoService(Tpositioninfo tpositioninfo);
	
	//新增用户职位信息
	ResponseModel InsertTuserByIdTpositioninfoService(Tpositioninfo tpositioninfo);
	
	//查询用户职位信息.接收：用户id:userid.返回 id:职位id, posiname:职位名称，tpositime:时间，userid:用户id,posiid:职位id
	List<Tpositioninfo> queryTuserByIdTpositioninfoService(Tpositioninfo tpositioninfo);

}
