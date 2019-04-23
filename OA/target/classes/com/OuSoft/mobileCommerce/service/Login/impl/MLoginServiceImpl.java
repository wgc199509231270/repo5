package com.OuSoft.mobileCommerce.service.Login.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.mobileCommerce.dao.login.MLoginDao;
import com.OuSoft.mobileCommerce.service.Login.MLoginService;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;


/**
 * 用户信息
 * @author pengyueli
 * @date 2018年10月31日
 */
@Service
public class MLoginServiceImpl implements MLoginService{

	@Autowired
	MLoginDao dao;
	
	
	//登录使用修改用户token
	@Override
	public ResponseModel upTsuserTokenService(Tsuser tsu) {
		ResponseModel returnmodel = new ResponseModel();
		tsu.setToken(CommUtil.getID());
		int num = dao.upTsuserTokenDao(tsu); 
		if(num > 0){
			 returnmodel.setCode("200");
	         returnmodel.setResult("success");
	         returnmodel.setTime(System.currentTimeMillis()+"");
	         returnmodel.setToken("001");
	         returnmodel.setMsg("修改用户token成功！");
		}else{
			returnmodel.setCode("404");
	        returnmodel.setResult("tsuserweikong!");
	        returnmodel.setTime(System.currentTimeMillis()+"");
	        returnmodel.setToken("0053");
	        returnmodel.setMsg("修改用户token失败！");
		}
		// TODO Auto-generated method stub
		return returnmodel;
		}


	/**
	 * 查询用户token
	 */
	@Override
	public Tsuser QueryUserTokenService(Tsuser tsu) {
		Tsuser tu = new Tsuser();
		if(tsu != null){
			if(tsu.getId() != null && !"".equals(tsu.getId() )){
				tu = dao.QueryUserTokenDao(tsu);
			}else{
				tu.setId(DateUtil.getUserid());
				tu = dao.QueryUserTokenDao(tsu);
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return tu;
	}

}
