package com.OuSoft.system.service.Login.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.OuSoft.system.dao.Login.LoginDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Login.ILoginService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    LoginDao logins;

    @Override
    public ResponseModel QueryUserService(Tsuser tsuser, HttpServletRequest request ) {
        Tsuser model = new Tsuser();
        //userid存入session中
        ResponseModel returnmodel = new ResponseModel();
        model = logins.QueryUser(tsuser);
        if(model != null){
        	//保存用户id 
        	request.getSession().setAttribute("userid", model.getId());
        	request.getSession().setAttribute("tsuser", model);
        	//用户登录后将id存入session中
            returnmodel.setCode("200");
            returnmodel.setResult("success");
            returnmodel.setTime(System.currentTimeMillis()+"");
            returnmodel.setToken("001");
            returnmodel.setMsg("登录成功!");
            // TODO 将登录信息放入session中
        }else{
            returnmodel.setCode("404");
            returnmodel.setResult("fali");
            returnmodel.setTime(System.currentTimeMillis()+"");
            returnmodel.setToken("0053");
            returnmodel.setMsg("登录失败!");
        }
        return returnmodel;
    }

    //用户注册:平台管理员必传userpid, 公司管理员不需要传
	@Override
	public ResponseModel insertUserService(Tsuser tsuser) {
		 int count = 0;
	        ResponseModel returnmodel = new ResponseModel();
	        if(!DateUtil.getObjCheckIsNull(tsuser ) ){
	        	List<Tsuser> list = logins.queryLoginname(tsuser.getLoginname());
	        	if(list.isEmpty()){
	        		returnmodel.setCode("404");
        			returnmodel.setResult("fali");
        			returnmodel.setTime(System.currentTimeMillis()+"");
        			returnmodel.setToken("0053");
        			returnmodel.setMsg("亲，用户名已存在，请从新输入用户名！");
	        	}else{
	        		tsuser.setId(CommUtil.getID());//生成id
	        		//将用户密码加密后存入，存入日期
	        		tsuser.setInductiontime(DateUtil.GetDates());//入职时间
	        		tsuser.setUserpass(DateUtil.GetMD5(tsuser.getUserpass()));
	        		tsuser.setInductiontime(DateUtil.GetDates());
	        		//情况：1、公司自己管理员添加员工，userpid则为空
	        		//情况：2、平台管理员添加管理员，userpid必须有值。
	        		if(tsuser.getUserpid() == null && tsuser.getUserpid() == ""){
	        			tsuser.setUserpid(DateUtil.GetTsuser().getUserpid());
	        		}
	        		count = logins.insertUserDao(tsuser);
	        		if(count > 0){
	        			returnmodel.setCode("200");
	        			returnmodel.setResult("success");
	        			returnmodel.setTime(System.currentTimeMillis()+"");
	        			returnmodel.setToken("001");
	        			returnmodel.setMsg("用户信息新增成功！");
	        			// TODO 将登录信息放入session中
	        		}else{
	        			returnmodel.setCode("404");
	        			returnmodel.setResult("fali");
	        			returnmodel.setTime(System.currentTimeMillis()+"");
	        			returnmodel.setToken("0053");
	        			returnmodel.setMsg("用户信息新增失败！");
	        		}
	        	}
	        }else{
	            returnmodel.setCode("404");
	            returnmodel.setResult("tsuserweikong!");
	            returnmodel.setTime(System.currentTimeMillis()+"");
	            returnmodel.setToken("0053");
	        }
		
		return returnmodel;
	}

	@Override
	/**
	 * 查询用户名quabu
	 */
	public List<Tsuser> queryNameTuserService(Tsuser tsu) {
		Tsuser tsuser = DateUtil.GetTsuser();
		List<Tsuser> personList =null;
		if(!DateUtil.getObjCheckIsNull( tsu ) ){
			tsu.setUserpid(tsuser.getUserpid());
    		personList = logins.queryNameTuserDao(tsu);
		}else{
			System.out.println("全部用户信息为空！");
		}
		// TODO Auto-generated method stub
		return personList;
	}

	/**
	 * 修改tattip中的ip
	 */
	@Override
	public ResponseModel updateTattipIpService(String ip) {
		ResponseModel returnmodel = new ResponseModel();
		int numm = 0;
		if(ip != null && !"".equals(ip)){
			String tattip = ip+"/static/fileupload/";
			numm = logins.updateTattipIpDao(tattip);
			if(numm > 0){
				 returnmodel.setCode("200");
	            returnmodel.setResult("success");
	            returnmodel.setTime(System.currentTimeMillis()+"");
	            returnmodel.setToken("001");
	            returnmodel.setMsg("修改ip成功！！");
			}else{
				returnmodel.setCode("404");
	            returnmodel.setResult("tsuserweikong!");
	            returnmodel.setTime(System.currentTimeMillis()+"");
	            returnmodel.setToken("0053");
	            returnmodel.setMsg("修改ip！");
			}
		}else{
			returnmodel.setCode("404");
            returnmodel.setResult("tsuserweikong!");
            returnmodel.setTime(System.currentTimeMillis()+"");
            returnmodel.setToken("0053");
            returnmodel.setMsg("ip为空！");
		}
		
		// TODO Auto-generated method stub
		return returnmodel;
	}

}
