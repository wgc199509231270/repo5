package com.OuSoft.intercept.controller.Intercept;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.utils.DateUtil;

/**
 * 拦截器
 * 
 * @author pengyueli
 * @date 2018年10月8日
 */
@Configuration
public class LoginInterceptController implements HandlerInterceptor {

	/**
	 * 除登录注册页面和方法不拦截的都拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("==============  request before  ==============");
		//设置cookie,
//		cookies(response);
		// session
//		session.setMaxInactiveInterval(1000);
//		System.out.println("session Time : " + session.getMaxInactiveInterval());
		// 判断用户ID是否存在，不存在就跳转到登录界面
//		 String paths = request.getContextPath();
//		 System.out.println("path11: " + paths);
		String url = request.getRequestURI();// oa2/
		String [] mobile = url.split("/");
		String mobileurl = mobile[1];
//		System.out.println("url:" + url);
		String id = DateUtil.getUserid();
//		System.out.println("id:" + id);
		//获取cookiename
		String cookiename = queryCookie(request);
//		System.out.println("cookie:"+cookiename);
		//二维码session:rwmtoken使用一次后删除
		if(!"mobile".equals(mobileurl)){
			// 不拦截的页面和方法，登录、注册、退出rul、不拦截
			if (!url.equals("/logins/generationQRCode") && !url.equals("/logins/scanLogin") && !url.equals("/logins/determine") && (!url.equals("/OA2") && !url.equals("/login/QueryUser") && !url.equals("/out/yess")  ) &&
					( null ==id || "".equals(id) && null == cookiename || "".equals(cookiename) )
					) {
				//手机端其他路径判断是否token有值，有则不拦截。if(DateUtil.getToken() == null || "".equals(DateUtil.getToken()) ){    }
					if(   ( null == id || "".equals(id) )  ||  ( null == cookiename || "".equals(cookiename) )  ){
						System.out.println("cookie为空！");
						System.out.println("id: " + id);
						System.out.println("cookiename: "+ cookiename);
						sendRedirect(request, response);
						return false;
					}else{
						return true;
					}
				// 默认三十分钟，1800秒.session过期时到登录页面
			} else if (null == request.getSession(false)) {
				//			System.out.println("session:是否可用!");
				if (true == request.getSession(true).isNew()) {//第一次登录判断session是不是为新创建
					//				System.out.println("session存在可用！");
					return true;
				} else {
					//				System.out.println("session已过期！");
					sendRedirect(request, response);
					return false;
				}
			}else{
				return true;
			}
		//二维码
		}else if(url.equals("/mobile/login/TwoDimensionalCodeLogin") ){
			return true;
		}else{
			//移动端
			String token = DateUtil.getToken();
			System.out.println("token:" + token);
			if(token != null || url.equals("/mobile/login/loginQueryTsuer") ){
				return true;
			}else{
				System.out.println("手机端tokeng为空！");
				ResponseModel remodel = new ResponseModel();
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("从新登录！！");
				return false;
			}
		}
	}

	/**
	 * cookie设置
	 */
	public void cookies(HttpServletResponse response){
		Cookie cookie = new Cookie("cookiename","cookiename");
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}
	/**
	 * 获取cookie
	 * @author pyl
	 * @date 2018年10月9日
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
	/**
	 * 跳转页面
	 * 
	 * @author pyl
	 * @date 2018年10月9日
	 */
	public void sendRedirect(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
//		System.out.println("------:跳转到login页面！");
		String path = request.getContextPath();
		response.sendRedirect(path + "/OA2");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("==============  request  ==============");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("==============  request completion  ==============");

	}

}
