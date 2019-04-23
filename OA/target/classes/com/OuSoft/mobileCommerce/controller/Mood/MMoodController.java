package com.OuSoft.mobileCommerce.controller.Mood;

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
import com.OuSoft.mobileCommerce.service.Mood.MTmoodService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.service.Mood.MoodService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 心情模块
 * @author pengyueli
 * @date 2018年11月1日
 */
@Controller
@RequestMapping(value="/mobile/mood")
public class MMoodController {

	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired 
	BusinessController saveFile;
	
	//心情
	@Autowired
	MoodService moodService;
	
	@Autowired
	MTmoodService mservice;
	
	/**
	 * 心情插入
	 * @author pyl
	 * @date 2018年11月1日
	 */
    @RequestMapping(value="/insertMood", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertMMoodController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
    	System.out.println("我进来了,心情新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Mood>>() {
		}.getType();
    	RequestEntity<Mood> data = requestGson.fromJson(json, type);
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
	    		Mood mood = data.getBiz();
	    		if(mood == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			mood.setId(id);
	    			//插入数据,图片
			    	biz = moodService.insertMoodService(mood);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增心情数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("mood");//mood
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
			    	}else{
			    		responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("插入心情数据失败！");
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
	 * 心情所有人图表
	 * 接收：选填begtime,endtime:年月日   响应：username用户姓名 tpranum点赞数 time年月日 times时分秒 dz是否点赞 tpranum点赞总数  LIMIT 分页  -->
	 * @author pyl
	 * @date 2018年11月1日
	 */
    @RequestMapping(value="/queryQBTmoodList", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryQBTmoodListController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,心情所有人图表");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Mood>>() {
		}.getType();
    	RequestEntity<Mood> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Mood> biz = null;
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
	    		Mood mood = data.getBiz();
	    		if(mood == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//插入数据,图片
			    	biz = mservice.queryQBTmoodListService(mood);
			    	//数据插入成功后插入图片
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Mood>> response = new ResponseEntity<List<Mood>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
    
    /**
	 * 心情点赞
	 * 接收 项目id  响应：username:姓名 tprausername点赞人 tprafilename点赞头像 
	 * @author pyl
	 * @date 2018年11月1日
	 */
    @RequestMapping(value="/queryDzTmoodList", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryDzTmoodListController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,心情点赞!");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Mood>>() {
		}.getType();
    	RequestEntity<Mood> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Mood> biz = null;
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
	    		Mood mood = data.getBiz();
	    		if(mood == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//插入数据, 
			    	biz = mservice.queryDzTmoodListService(mood);
			    	//数据插入成功后插入图片
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Mood>> response = new ResponseEntity<List<Mood>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    
    
    /**
	 * 心情评论
	 * 参数，项目itemid   响应：username:评论人姓名，husername:回复人姓名，txfilename：姓名头像，hfilename,回复头像
	 * @author pyl
	 * @date 2018年11月1日
	 */
    @RequestMapping(value="/queryPlTmood", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryPlTmoodController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,心情评论!");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Mood>>() {
		}.getType();
    	RequestEntity<Mood> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Mood> biz = null;
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
	    		Mood mood = data.getBiz();
	    		if(mood == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//插入数据, 
			    	biz = mservice.queryPlTmoodService(mood);
			    	//数据插入成功后插入图片
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Mood>> response = new ResponseEntity<List<Mood>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    /**
   	 * 个人心情列表图表
   	 * 接收：pagenum 0  :   pagesize   8
   	 * 响应：username用户姓名 tpranum点赞数 time年月日 times时分秒 dz是否点赞 tpranum点赞总数  LIMIT 分页
   	 * @author pyl
   	 * @date 2018年11月1日
   	 */
       @RequestMapping(value="/queryGrTmoodList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryGrTmoodListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,个人心情列表图表！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Mood>>() {
   		}.getType();
       	RequestEntity<Mood> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Mood> biz = null;
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
   	    		Mood mood = data.getBiz();
   	    		if(mood == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryGrTmoodListService(mood);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Mood>> response = new ResponseEntity<List<Mood>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
       
       
       
       
       
       
       
       
       
       
}
