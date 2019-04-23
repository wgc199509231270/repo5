package com.OuSoft.mobileCommerce.controller.Login;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.mobileCommerce.entity.RequestEntity;
import com.OuSoft.mobileCommerce.entity.RequestHead;
import com.OuSoft.mobileCommerce.entity.RequestTsuser;
import com.OuSoft.mobileCommerce.entity.ResponseEntity;
import com.OuSoft.mobileCommerce.entity.ResponseHead;
import com.OuSoft.mobileCommerce.service.Login.MLoginService;
import com.OuSoft.system.controller.Login.LoginController;
import com.OuSoft.system.controller.logins.loginsController;
import com.OuSoft.system.dao.Login.LoginDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Login.ILoginService;
import com.OuSoft.utils.DateUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@Controller
@RequestMapping(value="/mobile/login")
public class MLoginController {
	
	@Autowired 
	MLoginService service;
	
	@Autowired 
	LoginController logincontroller;
	
	@Autowired 
	loginsController loginscontroller;
	

	@Autowired
    ILoginService iLoginService;
	
	@Autowired
    LoginDao logins;
	
	/**
	 * 修改用户token
	 * @author pyl
	 * @date 2018年10月31日
	 */
	@RequestMapping(value="/upTsuserToken")
	@ResponseBody
	public ResponseModel upTsuserTokenController(Tsuser tsuser){
		return service.upTsuserTokenService(tsuser);
	}

    /**
     * 查询用户tokeng
     * @author pyl
     * @date 2018年10月31日
     */
    @RequestMapping(value="/queryTsuserToken", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String QueryUserTokenService(@RequestParam("json") String json ){
    	System.out.println("我进来了,查询用户信息");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<RequestTsuser>>() {
		}.getType();
    	RequestEntity<RequestTsuser> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	Tsuser biz = new Tsuser();
    	//判断是否有值
    	if(data == null){
    		responseHead.init();
    		responseHead.setCode(1112);
    		responseHead.setMethod("数据格式错误！");
    	}else{
    		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
    		RequestHead reqeustHead = data.getHead();
    		//用 ResponseModel 接收 
    		ResponseModel responseModel = ValidationToken(reqeustHead.getToken());
	    	if(responseModel.getCode().equals("200")){
	    	//参数判断必填参数调用方法 
//    		RequestTsuser entity = data.getBiz();
//    		String idz = entity.getxxx();
//    		String ids = entity.getxxs();
//    		String params = idz + "," + ids;
//    		String param = DateUtil.QueryParamisNullOrEmpty(strparams);
//    		if(DateUtil.isNullOrEmpty(param)){
//    		responseHead.init();
//			responseHead.setCode(1113);
//			responseHead.setErr("必填字段为空：username");
//			}else{
//    			业务处理
//    		}
		    	Tsuser tsu = new Tsuser();
		    	tsu.setId(DateUtil.getUserid());
		    	biz = service.QueryUserTokenService(tsu);
		    	if(biz != null){
		    		responseHead.init();
					responseHead.setCode(1111);
					responseHead.setErr("查询用户信息成功！");
					responseHead.setToken(biz.getToken());
		    	}else{
		    		responseHead.init();
					responseHead.setCode(1113);
					responseHead.setErr("查询用户信息失败！");
		    	}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<Tsuser> response = new ResponseEntity<Tsuser>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
    /**
     * 移动端用户登录
     * @author pyl
     * @date 2018年10月31日
     */
    @ResponseBody
    @RequestMapping(value="/loginQueryTsuer", produces = "text/plain;charset=utf-8")
    public String loginTsuser(@RequestParam("json") String json ,HttpServletRequest request){
    	System.out.println("我进来了！登录");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	//消息
    	ResponseHead responseHead = new ResponseHead();
    	//解析数据并转换
    	Type type = new TypeToken<RequestEntity<RequestTsuser>>() {
		}.getType();
    	RequestEntity<RequestTsuser> data = requestGson.fromJson(json, type);
    	//数据发送对象
    	Tsuser biz = new Tsuser();
    	//判断是否有值
    	if(data == null){
    		responseHead.init();
    		responseHead.setCode(1112);
    		responseHead.setMethod("数据格式错误！");
    	}else{
    		//接收数据
    		RequestTsuser entity = data.getBiz();
    		//接收消息
    		RequestHead requestHead = data.getHead();
    		System.out.println(requestHead.getRequest_time());
//    		System.out.println("当前时间：" + requestHead.getRequest_time());
    		String loginname = entity.getLoginname();
    		String userpass = entity.getUserpass();
    		String param = loginname+","+userpass;
    		String params = DateUtil.QueryParamisNullOrEmpty(param);
    		System.out.println(loginname+userpass+" : loginname:userpass");
    		if(DateUtil.isNullOrEmpty(params)){
	    		if(DateUtil.isNullOrEmpty(loginname)){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else if(DateUtil.isNullOrEmpty(userpass)) {
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：password");
	    		}else{
	    			//判断用户用户名密码是否正确
	    			Tsuser tsu = new Tsuser();
	    			tsu.setLoginname(loginname);
	    			tsu.setUserpass(userpass);
	    			Tsuser tsuser = service.QueryUserTokenService(tsu);
	    			if(tsuser == null || "".equals(tsuser)){
	    				responseHead.init();
	    				responseHead.setCode(1113);
	        			responseHead.setErr("账号密码错误！");
	    			}else{
	    				//获取当前服务器ip
	    				String path = request.getContextPath();
	    		    	String ip = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
//	    				String ip = DateUtil.getServerIp();
	    	        	System.out.println("获取当前服务ip:" + ip);
	    	        	iLoginService.updateTattipIpService(ip);
	    	        	//用户登录成功后修改token
	    	        	service.upTsuserTokenService(tsuser);
	    	        	//将token信息发送给移动端
	    	        	biz = service.QueryUserTokenService(tsuser);
	    	        	String userid = biz.getId();
	    	        	String token = biz.getToken();
	    	        	//存入session
	    	        	DateUtil.setSession(request,userid,token);
	    				responseHead.init();
	    				responseHead.setCode(1111);
	        			responseHead.setErr("登录成功！");
	        			responseHead.setToken(biz.getToken());
	    			}
	    		}
    		}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("数据格式错误！！");
    		}
    	}
    	ResponseEntity<Tsuser> response = new ResponseEntity<Tsuser>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    /**
     * 判断是否是新用户
     * 是新用户返回：404
     * 当前用户返回：200
     * @author pyl
     * @date 2018年10月31日
     */
    public ResponseModel ValidationToken(String token){
    	ResponseModel responseModel = new ResponseModel();
    	Tsuser tsu = new Tsuser();
    	tsu.setId(DateUtil.getUserid());
    	Tsuser tsuser = service.QueryUserTokenService(tsu);
    	if(tsuser.getToken().equals(token)){
    		responseModel.setCode("200");
    		responseModel.setResult("success");
    		responseModel.setTime(System.currentTimeMillis()+"");
    		responseModel.setToken("001");
    		responseModel.setMsg("修改用户token成功！");
    	}else{
    		responseModel.setCode("404");
    		responseModel.setResult("tsuserweikong!");
    		responseModel.setTime(System.currentTimeMillis()+"");
    		responseModel.setToken("0053");
    		responseModel.setMsg("修改用户token失败！");
    	}
    	return responseModel;
    }
    
    /**
     * 用户退出
     * @author pyl
     * @date 2018年11月19日
     */
    @RequestMapping(value="/out/yess", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String outYessTsuser(){
    	System.out.println("我进来了！退出");
    	Tsuser tsuser = new Tsuser();
    	//获取当前id用户
    	tsuser.setId(DateUtil.getUserid());
    	service.upTsuserTokenService(tsuser);
    	ResponseModel biz = new ResponseModel();
    	biz.setCode("200");
    	biz.setResult("success");
    	biz.setTime(System.currentTimeMillis()+"");
    	biz.setToken("001");
    	biz.setMsg("移动端用户退出成功！");
    	ResponseHead responseHead = new ResponseHead();
    	responseHead.init();
		responseHead.setCode(1112);
		responseHead.setMethod("数据格式错误！");
    	ResponseEntity<ResponseModel> response = new ResponseEntity<ResponseModel>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    

 	 /**
    * 二维码登录
    * @author pyl
    * @date 2018年10月31日
    */
   @SuppressWarnings("static-access")
   @ResponseBody
   @RequestMapping(value="/TwoDimensionalCodeLogin", produces = "text/plain;charset=utf-8")
   public void TwoDimensionalCodeLoginController(@RequestParam("json") String json ,HttpServletRequest request, HttpServletResponse response){
   	System.out.println("我进来了！二维码验证");
   	//接收移动端发送的json并解析数据
   	Gson requestGson = new Gson();
   	//消息
   	ResponseHead responseHead = new ResponseHead();
   	//解析数据并转换
   	Type type = new TypeToken<RequestEntity<RequestTsuser>>() {
		}.getType();
   	RequestEntity<RequestTsuser> data = requestGson.fromJson(json, type);
   	//map二维码
   	Map<String,String> users = new HashMap<String, String>();
   	//数据发送对象
   	//判断是否有值
   	if(data == null){
   		responseHead.init();
   		responseHead.setCode(1112);
   		responseHead.setMethod("数据格式错误！");
   	}else{
   		//接收数据
   		RequestTsuser entity = data.getBiz();
   		//接收消息
   		RequestHead requestHead = data.getHead();
   		System.out.println(requestHead.getRequest_time());
//   	System.out.println("当前时间：" + requestHead.getRequest_time());
   		String loginname = entity.getLoginname();
   		String userpass = entity.getUserpass();
   		String uid = entity.getUid();
	    		if(DateUtil.isNullOrEmpty(loginname)){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else if(DateUtil.isNullOrEmpty(userpass)) {
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：password");
	    		}else{
	    			//判断用户用户名密码是否正确
	    			Tsuser tsu = new Tsuser();
	    			tsu.setLoginname(loginname);
	    			tsu.setUserpass(userpass);
	    			Tsuser model = new Tsuser();
    		        model = logins.QueryUser(tsu);
	    			if(model == null || "".equals(model) ){
	    				responseHead.init();
	    				responseHead.setCode(1113);
	        			responseHead.setErr("账号密码错误！");
	    			}else{
	    				//账号密码正确
//	    				users.put(uid, uid);
	    				users.put(loginname, userpass);
	    				users.put(uid, loginname);
	    				loginscontroller.setUsers(users);
	    				responseHead.init();
	    				responseHead.setCode(1111);
	    			}
	    		}
   		}
//   		Tsuser Biz = new Tsuser();
//	   	ResponseEntity<Tsuser> responses = new ResponseEntity<Tsuser>();
////		response.setBiz(biz);
//	   	responses.setHead(responseHead);
//		String responseGson = new Gson().toJson(response);
//		return responseGson;
   }
   
    
	

}
