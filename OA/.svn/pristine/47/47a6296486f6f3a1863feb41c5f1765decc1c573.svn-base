package com.OuSoft.mobileCommerce.controller.tplan;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.OuSoft.mobileCommerce.controller.Login.MLoginController;
import com.OuSoft.mobileCommerce.entity.RequestEntity;
import com.OuSoft.mobileCommerce.entity.RequestHead;
import com.OuSoft.mobileCommerce.entity.ResponseEntity;
import com.OuSoft.mobileCommerce.entity.ResponseHead;
import com.OuSoft.mobileCommerce.service.tplan.MTplanService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.Plan;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.service.Plan.impl.PlanServiceImpl;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 计划模块
 * @author pengyueli
 * @date 2018年11月1日
 */
@Controller
@RequestMapping(value="/mobile/plan")
public class MTplanController {


	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired 
	BusinessController saveFile;
	
	
	@Autowired
	PlanServiceImpl planService;
	
	@Autowired
	MTplanService mservice;
	
	
	
	
	/**
	 * 新增计划
	 * @author pyl
	 * @date 2018年11月1日
	 */
	@RequestMapping(value="/insetMPlan", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertMPlanController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
		System.out.println("我进来了,心情新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Plan>>() {
		}.getType();
    	RequestEntity<Plan> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	ResponseModel biz = new ResponseModel();
    	//判断是否有值
    	if(data == null || "".equals(data)){
    		responseHead.init();
    		responseHead.setCode(1112);
    		responseHead.setMethod("数据格式错误！");
    	}else{
    		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
    		RequestHead reqeustHead = data.getHead();
    		//用 ResponseModel 接收 
    		ResponseModel responseModel = validationToken.ValidationToken(reqeustHead.getToken());
	    	if(responseModel.getCode().equals("200")){
	    		//接收的参数，
	    		Plan plan = data.getBiz();
	    		if(plan == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			plan.setId(id);
	    			//插入数据,图片
			    	biz = planService.InsertPlan(plan);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增计划数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("mood");//修改成表名如：mood,tplan,tsign,tknowledge.....
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
			    	}else{
			    		responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("插入计划数据失败！");
			    	}
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<ResponseModel> response = new ResponseEntity<ResponseModel>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
		return responseGson;
	}
	

    	/** 
	  	 * 	计划所有人图表列表
		 *  接收pagenum页,pagesize一页的数 begtime开始时间年月日,endtime结束时间年月日 ,plantype:01/02/03:日/周/月
		 *  响应：times年月日，time时分秒，username:姓名，ip，txfilename头像
    	 * @author pyl
    	 * @date 2018年11月8日
    	 */
       @RequestMapping(value="/queryQBTplanList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryQBTplanListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,个人心情列表图表！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Plan>>() {
   		}.getType();
       	RequestEntity<Plan> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Plan> biz = null;
       	//判断是否有值
       	if(data == null || "".equals(data)){
       		responseHead.init();
       		responseHead.setCode(1112);
       		responseHead.setMethod("数据格式错误！");
       	}else{
       		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
       		RequestHead reqeustHead = data.getHead();
       		//用 ResponseModel 接收 
       		ResponseModel responseModel = validationToken.ValidationToken(reqeustHead.getToken());
   	    	if(responseModel.getCode().equals("200")){
   	    		//接收的参数，
   	    		Plan plan = data.getBiz();
   	    		if(plan == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryQBTplanListService(plan);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Plan>> response = new ResponseEntity<List<Plan>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
       
	
       /**
        *  计划个人图表列表  
        *  接收：pagenum页,pagesize一页的数 begtime开始时间年月日,endtime结束时间年月日,plantype:01/02/03:日/周/月
        *  响应：times年月日，time时分秒，username:姓名，ip，txfilename头像
        * @author pyl
        * @date 2018年11月8日
        */
       @RequestMapping(value="/queryGrTplanList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryGrTplanListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,个人心情列表图表！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Plan>>() {
   		}.getType();
       	RequestEntity<Plan> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Plan> biz = null;
       	//判断是否有值
       	if(data == null || "".equals(data)){
       		responseHead.init();
       		responseHead.setCode(1112);
       		responseHead.setMethod("数据格式错误！");
       	}else{
       		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
       		RequestHead reqeustHead = data.getHead();
       		//用 ResponseModel 接收 
       		ResponseModel responseModel = validationToken.ValidationToken(reqeustHead.getToken());
   	    	if(responseModel.getCode().equals("200")){
   	    		//接收的参数，
   	    		Plan plan = data.getBiz();
   	    		if(plan == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryGrTplanListService(plan);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Plan>> response = new ResponseEntity<List<Plan>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
       
       /**
        * 计划点赞详情 
        * 接收项目id  响应 tprausername:点赞人   tprafilename:点赞人头像
        * @author pyl
        * @date 2018年11月8日
        */
       @RequestMapping(value="/queryDzTplanList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryDzTplanListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,计划点赞！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Plan>>() {
   		}.getType();
       	RequestEntity<Plan> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Plan> biz = null;
       	//判断是否有值
       	if(data == null || "".equals(data)){
       		responseHead.init();
       		responseHead.setCode(1112);
       		responseHead.setMethod("数据格式错误！");
       	}else{
       		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
       		RequestHead reqeustHead = data.getHead();
       		//用 ResponseModel 接收 
       		ResponseModel responseModel = validationToken.ValidationToken(reqeustHead.getToken());
   	    	if(responseModel.getCode().equals("200")){
   	    		//接收的参数，
   	    		Plan plan = data.getBiz();
   	    		if(plan == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryDzTplanListService(plan);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Plan>> response = new ResponseEntity<List<Plan>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
	
       /**
        * 计划评论详情
		* 参数，项目itemid   
		* 响应：pusername:评论人姓名 txfilename：评论人头像，husername:回复人姓名，txfilename：姓名头像，hfilename,回复头像
        * @author pyl
        * @date 2018年11月8日
        */
       @RequestMapping(value="/queryPlTplanList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryPlTplanListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,计划评论！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Plan>>() {
   		}.getType();
       	RequestEntity<Plan> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Plan> biz = null;
       	//判断是否有值
       	if(data == null || "".equals(data)){
       		responseHead.init();
       		responseHead.setCode(1112);
       		responseHead.setMethod("数据格式错误！");
       	}else{
       		//判断是否同一个用户，调用方法 ValidationToken() 返回（cood = 200 ）是同一个用户，否则需要从新登录
       		RequestHead reqeustHead = data.getHead();
       		//用 ResponseModel 接收 
       		ResponseModel responseModel = validationToken.ValidationToken(reqeustHead.getToken());
   	    	if(responseModel.getCode().equals("200")){
   	    		//接收的参数，
   	    		Plan plan = data.getBiz();
   	    		if(plan == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryPlTplanListService(plan);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Plan>> response = new ResponseEntity<List<Plan>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
