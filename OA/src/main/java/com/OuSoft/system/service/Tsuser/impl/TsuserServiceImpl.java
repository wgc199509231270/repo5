package com.OuSoft.system.service.Tsuser.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.OuSoft.system.dao.Tsuser.TsusersDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tsuser.ITsuserService;
import com.OuSoft.utils.DateUtil;

@Service
public class TsuserServiceImpl implements ITsuserService {

	@Autowired
	TsusersDao tsuser;
	
	/**
	 * 查询所有用户，
	 * status：在职状态：01正式、02离岗、03离职，04试岗、04实习
	 * username：用户姓名，模糊查询
	 * usernumber:用户编号
	 */
	@Override
	public List<Tsuser> QueryTsuserList(Tsuser tu) {
		List<Tsuser> list = new ArrayList<Tsuser>();
		Tsuser tuser=DateUtil.GetTsuser();
		if(!DateUtil.getObjCheckIsNull(tu) ){
			if(tu.getStatus() == null || "".equals(tu.getStatus())){
				tu.setStatus("01");
			} 
			tu.setUserpid(tuser.getUserpid());
			list = tsuser.QueryTsuserList(tu);
		}else{
			tu.setUserpid(tuser.getUserpid());
			tu.setStatus("01");
			list = tsuser.QueryTsuserList(tu);
		}
		return list;
	}
	@Override
	public ResponseModel DelTsuser(@Param("id") String id) {
		ResponseModel model = new ResponseModel();
		model = tsuser.DelTsuser(id);
		return model;
	}
	@Override
	public ResponseModel UpdateTsuserByid(@RequestBody Tsuser model) {
		ResponseModel remodel = new ResponseModel();
		tsuser.UpdateTsuserByid(model);
		return remodel;
	}
	
	/**
	 * 登录验证
	 */
	@Override
	public Tsuser QueryTsuserByid(@Param("username") String username ,@Param("password") String password) {
		Tsuser model = new Tsuser();
		model = tsuser.QueryTsuserByid(username, password);
		
		
		
		return model;
	}
	@Override
	public ResponseModel InsertTsuser(Tsuser model) {
		ResponseModel remodel = new ResponseModel();
		 tsuser.InsertTsuser(model);
		return remodel;
	}
	/**
	 * 个人信息
	 */
	@Override
	public Tsuser queryIdTuserService(Tsuser ts) {
		Tsuser t = new Tsuser();
		if(ts.getId() != "" && ts.getId() != null){

			t = tsuser.queryIdTuserDao(ts.getId());
		}else{

			t = tsuser.queryIdTuserDao(DateUtil.getUserid());
		}
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute("tsuser", t);
		return t;
	}

	@Override
	public List<Tsuser> queryNameTuserService(Tsuser ts) {
		System.out.println(ts.getUsername());
		List<Tsuser> tsusers = tsuser.queryPeopleTuserDao(ts);
		return tsusers;
	}


	/**
	 * 修改用户个人密码
	 */
	@Override
	public ResponseModel updateTuserByUserpassService(Tsuser model) {
		ResponseModel remodel = new ResponseModel();
		//判断是否为空
		if(!DateUtil.getObjCheckIsNull(model) ){
			if(model.getUsedpass() != null && !"".equals(model.getUsedpass())){
				//查询用户原始密码
				Tsuser tuser = tsuser.queryIdTuserDao(DateUtil.getUserid());
				//查询是否有此用户
				if(tuser != null){
					//判断是否和原始密码相同
					if(model.getUsedpass().equals(tuser.getUserpass())){
						//原始密码正确后允许修改密码
						model.setId(DateUtil.getUserid());
						int num = tsuser.updateTuserByUserpassDao(model);
						if(num > 0){
							remodel.setCode("200");
							remodel.setResult("success");
							remodel.setTime(System.currentTimeMillis()+"");
							remodel.setToken("001");
							remodel.setMsg("修改密码成功！");
						}else{
							remodel.setCode("404");
							remodel.setResult("fali");
							remodel.setTime(System.currentTimeMillis()+"");
							remodel.setToken("0053");
							remodel.setMsg("修改密码错误！");
						}
					}else{
						remodel.setCode("404");
						remodel.setResult("fali");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("0053");
						remodel.setMsg("请输入正确的原始密码！");
					}
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("无此用户！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("请输入原始密码！");
				
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("修改密码数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	@Override
	public List<Tsuser> queryTuserDao(Tsuser tsus) {
		List<Tsuser> tsusers = tsuser.queryTuserDao(tsus);
		return tsusers;
	}

	@Override
	public ResponseModel Insertsuser(Tsuser model) {
		ResponseModel remodel = new ResponseModel();
		tsuser.Insertsuser(model);
		return remodel;
	}


	/**
	 * 修改用户个人信息
	 */
	@Override
	public ResponseModel updateIdTuserInfoService(Tsuser model) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(model) ){
			int num = tsuser.updateIdTuserInfoDao(model);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("修改个人信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("修改个人信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("个人信息数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}
	
	/**
	 * 人力管理
	 * 可以设置状态为start == 01 则查询出除离职外的所有用户
	 */
	@Override
	public List<Tsuser> queryPeopleTuserService(Tsuser tuser) {
		List<Tsuser> list = new ArrayList<Tsuser>();
		Tsuser tu = DateUtil.GetTsuser();
		tuser.setUserpid(tu.getUserpid());
		//不传参为全查，，可以默认为查询在职的
		list = tsuser.queryPeopleTuserDao(tuser);
		// TODO Auto-generated method stub
		return list;
	}

}
