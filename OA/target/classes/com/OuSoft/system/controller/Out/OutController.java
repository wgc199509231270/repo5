package com.OuSoft.system.controller.Out;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.utils.DateUtil;


/**
 * 退出
 * @author pengyueli
 * @date 2018年10月10日
 */
@RequestMapping(value="/out")
@Controller
public class OutController {

	@RequestMapping(value="/yess")
	@ResponseBody
	public ResponseModel outController(HttpServletRequest request, HttpServletResponse response){
		
		ResponseModel model = new ResponseModel();
		//用户退出清空session和cookie
		sestroyCookies(response);
		String sess = destroySessions(request);
		System.out.println("sess:"+sess);
		System.out.println("userid:" + DateUtil.getUserid());
		String cookiename = queryCookie(request);
		System.out.println("cookienameoutcontroller:"+cookiename);
		System.out.println("退出成功！");
		model.setCode("200");
		model.setResult("success");
		model.setTime(System.currentTimeMillis()+"");
		model.setToken("001");
		model.setMsg("退出成功！!");
		return model;
	}
	/**
	 * 清空session
	 * @author pyl
	 * @date 2018年10月10日
	 */
	public String destroySessions(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		System.out.println("1：" + DateUtil.getUserid());
		session.setAttribute("userid",null);
		System.out.println("2：" + DateUtil.getUserid());
		return "a:";
	}
	
	/**
	 * 清空浏览器的cookie
	 * @author pyl
	 * @date 2018年10月10日
	 */
	public void sestroyCookies(HttpServletResponse response){
		Cookie cookie = new Cookie("cookiename",null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		System.out.println("清空cookie！");
	}
	
	/**
	 * 获取cookie,判断cookie是否成功
	 * @author pyl
	 * @date 2018年10月10日
	 */

	public String queryCookie(HttpServletRequest request){
		String cookiename = "";
		Cookie[] coo = request.getCookies();
		if(coo != null){
			for (Cookie cookie : coo) {
				if(cookie.getName().equals("cookiename")){
					cookiename = cookie.getValue();
				}
			}
		}else{
			cookiename = null;
		}
		return cookiename;
	}
	
	
	
}
