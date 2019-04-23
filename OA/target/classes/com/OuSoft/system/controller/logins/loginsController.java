package com.OuSoft.system.controller.logins;


import java.util.HashMap; 
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.OuSoft.mobileCommerce.service.Login.MLoginService;
import com.OuSoft.system.controller.Login.LoginController;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Login.ILoginService;
import com.OuSoft.system.service.Login.impl.LoginServiceImpl;
import com.OuSoft.utils.StringUtil;

//----------------------- 二维码 -----------------------------

@Controller
@RequestMapping(value = "/logins")
public class loginsController {

	@Autowired 
	LoginController logincontroller;
	
	@Autowired 
	MLoginService mservice;
	
	@Autowired
	LoginServiceImpl service;

	@Autowired
    ILoginService iLoginService;

    //存储二维码维一标识
  	public static Set<String> tokes = new HashSet<String>();
  	//存储toke绑定的用户
  	public static Map<String,String> users = new HashMap<String, String>();
  	
  	public static String codes;
  	
	/**
  	 * 生成二维码维一标识Toke
  	 * @return
  	 */
  	@ResponseBody
  	@RequestMapping("/generationQRCode")
  	public String generationToken(){
  		String uid = UUID.randomUUID().toString();
  		tokes.add(uid);
  		return uid;
  	}
   
  	/**
  	 * app扫码后将token与用户绑定
  	 * @param loginName
  	 * @param token
  	 * @return
  	 */
  	@ResponseBody
  	@RequestMapping("/determine")
  	public String determine(String loginName, String token,HttpServletRequest request ,HttpServletResponse response){
  		ResponseModel model = new ResponseModel();
  		Tsuser tsuser = new Tsuser();
  		tsuser.setLoginname(loginName);
  		for (String t:tokes) {
  			if(t.equals(token)){
  				users.put(token,loginName);
  				model = service.QueryUserService(tsuser, request );
  				
  				if(!model.getCode().equals("200")){
  					return("用户不存在");
  					}
  				return ("正在登录请稍后...");
  			}
  		}
  		return ("请求无效");
  	}
   
  	/**
  	 * Axaj定时请求是否有用户扫描了二维码
  	 * @param token
  	 */
//  	@ResponseBody
//  	@RequestMapping("/scanLogin")
//  	public String scanLogin(String token){
//  		if(StringUtil.isNullOrEmpty(token)) {
//  			
//  				return "token is null";
//  			}
//  		String loginName = users.get(token);
//  		
//  		if(StringUtil.isNullOrEmpty(loginName)){
//  				return "error";
//  			}
//  		users.remove(token);
//  		tokes.remove(token);
//  		return "success";
//  	}
  	
  	/**
  	 * Axaj定时请求是否有用户扫描了二维码
  	 * @param token
  	 */
  	@ResponseBody
  	@RequestMapping("/scanLogin")
  	public String scanLogin(String token, HttpServletRequest request, HttpServletResponse response){
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
  		Tsuser tsu = new Tsuser();
  		//二维码扫描参数
  		String uid = users.get(token);
  		//无值
  		System.out.println("   : " + uid);
  		if(StringUtil.isNullOrEmpty(uid)) {
  			System.out.println("接收参数为空！");
  				return "token is null";
  		}else{
  			String userpass = users.get(uid);
  			tsu.setLoginname(uid);
  			tsu.setUserpass(userpass);
  			System.out.println("--------------- : " + uid + "  ==============  " + userpass);
  			logincontroller.QueryUser( tsu, request, response);
  			System.out.println("允许通过二维码登录");
  			users.remove(token);
  			tokes.remove(token);
  			return "success";
  		}
  	}

	public static Set<String> getTokes() {
		return tokes;
	}

	public static void setTokes(Set<String> tokes) {
		loginsController.tokes = tokes;
	}

	public static Map<String, String> getUsers() {
		return users;
	}

	public static void setUsers(Map<String, String> users) {
		loginsController.users = users;
	}

  	
  	
  	
  	
  	
  	
  	
}
