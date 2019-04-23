package com.OuSoft.system.dao.Tsuser;
import com.OuSoft.system.entity.Tsuser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.ResponseModel;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Component(value = "Tsuser")
public interface TsusersDao {

	/*人员管理列表
	接：userpid,后台自己给，获取用户自己的userpid,没有则是全查，pid只有平台管理员才可以设置，其他不能设置
		starttime 开始时间  年/月/日/
		endtime 结束时间  年/月/日/
		zdeparid  小组id 
		bdeparid 部门id  
		id 用户id
		在职状态：01正式、02离岗、03离职，04试岗、04实习、
		返回： 用户基础信息，，，  小组名称grzdeparname  部门名称 grbdeparname  用户状态 dvalue
	 * 
	 */
	List<Tsuser> queryPeopleTuserDao(Tsuser tuser);

	//修改用户个人信息：id：对应的值
	int updateIdTuserInfoDao(Tsuser model);
	
	//修改用户个人密码
	int updateTuserByUserpassDao(Tsuser model);
	
	//用户个人信息
	Tsuser queryIdTuserDao(@Param("id") String id );
	
	//登录验证
	Tsuser QueryTsuserByid(@Param("username") String username ,@Param("password") String password);

	List<Tsuser> QueryTsuserList(Tsuser model );
	
	ResponseModel DelTsuser(@Param("id") String id);
	
	//修改用户个人信息
	ResponseModel UpdateTsuserByid(@RequestBody Tsuser model);

	ResponseModel InsertTsuser(@RequestBody Tsuser model);

	// 查询在职信息，按照工号进行排序
	List<Tsuser> queryTuserDao(Tsuser tsuser);

	int Insertsuser(Tsuser model);
}
