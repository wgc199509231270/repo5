package com.OuSoft.system.controller.Login;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Login.ILoginService;

@RequestMapping(value="/login")
@Controller
public class LoginController {

    // 登录方法集合


	@Autowired
    HttpServletRequest request;

    // 传递实体类
    @Autowired
    ILoginService iLoginService;

    // 登录页面
    @RequestMapping(value="/QueryUser")
    @ResponseBody
    public ResponseModel QueryUser(Tsuser tsuser, HttpServletRequest request, HttpServletResponse response) {
    	String path = request.getContextPath();
    	String ip = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
//    	String ip =  DateUtil.getServerIp();
    	System.out.println("pc获取当前服务ip: " + ip);
    	iLoginService.updateTattipIpService(ip);
    	ResponseModel model = new ResponseModel();
    	Cookie cookie = new Cookie("cookiename","cookiename");
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
        model = iLoginService.QueryUserService(tsuser,request );
        return model;
    }

    /**
     * 用户注册
     */
    @RequestMapping(value="/inserTsuser")
    @ResponseBody
    public ResponseModel InsertUser(Tsuser tsuser){
    	ResponseModel model = new ResponseModel();
    	model = iLoginService.insertUserService(tsuser);
    	return model;
    }
    
    /**
     * 用户查询
     * 参数：username，选填。（like）
     * @author pyl
     * @date 2018年10月24日
     */
    @RequestMapping(value="/queryUsername")
    @ResponseBody
    public List<Tsuser> queryNameTuserController(Tsuser tsu){
    	return iLoginService.queryNameTuserService(tsu);
    }
    
   
} 
    
