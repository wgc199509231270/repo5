package com.OuSoft.system.service.Tsuser;
import com.OuSoft.system.entity.ResponseModel;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.OuSoft.system.entity.Tsuser;

import org.springframework.web.bind.annotation.RequestBody;

public interface ITsuserService {

	List<Tsuser> queryPeopleTuserService(Tsuser tuser);
	
	//修改用户个人信息：id：对应的值
	ResponseModel updateIdTuserInfoService(Tsuser model);
	
	List<Tsuser> QueryTsuserList(Tsuser tu);

	ResponseModel DelTsuser(@Param("id") String id);

	/**
	 * 用户个人信息
	 * @author pyl
	 * @date 2018年9月25日
	 */
	Tsuser queryIdTuserService(Tsuser ts);

	/**
	 * 用户个人信息（name）
	 * @return
	 */
	List<Tsuser> queryNameTuserService(Tsuser ts);
	/**
	 * 系统登录验证
	 * @author pyl
	 * @date 2018年8月31日
	 */
	Tsuser QueryTsuserByid(@Param("username") String username ,@Param("password") String password);

	ResponseModel UpdateTsuserByid(@RequestBody Tsuser model);

	ResponseModel InsertTsuser(@RequestBody Tsuser model);
	
	//修改用户个人密码
	ResponseModel updateTuserByUserpassService(Tsuser model);

	// 查询在职信息，按照工号进行排序
	List<Tsuser> queryTuserDao(Tsuser tsus);

	ResponseModel Insertsuser(Tsuser model);
}
