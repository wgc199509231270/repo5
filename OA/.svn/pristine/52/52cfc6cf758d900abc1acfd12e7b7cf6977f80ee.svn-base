package com.OuSoft.mobileCommerce.controller.Tpraise;

import java.lang.reflect.Type;

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
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.ResponseEntity;
import com.OuSoft.system.entity.ResponseHead;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.entity.Tpraise;
import com.OuSoft.system.service.Tpraise.TpraiseService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 点赞模块
 * @author pengyueli
 * @date 2018年11月7日
 */
@Controller
@RequestMapping(value="/mobile/tpraise")
public class MTpraiseController {
	
		//验证
		@Autowired
		MLoginController validationToken;
		
		//图片
		@Autowired 
		BusinessController saveFile;
		

		@Autowired 
		TpraiseService cservice;
		
		/**
		 * 点赞插入
		 * @author pyl
		 * @date 2018年11月7日
		 */
	    @RequestMapping(value="/inserttpraise", produces = "text/plain;charset=utf-8")
	    @ResponseBody
	    public String insertTpraiseController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
	    	System.out.println("我进来了,心情新增");
	    	//接收移动端发送的json并解析数据
	    	Gson requestGson = new Gson();
	    	Type type = new TypeToken<RequestEntity<Tpraise>>() {
			}.getType();
	    	RequestEntity<Tpraise> data = requestGson.fromJson(json, type);
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
		    		Tpraise tpraise = data.getBiz();
		    		if(tpraise == null){
		    			responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("必填字段为空：username");
		    		}else{
				    	biz = cservice.saveTpraiseService(tpraise);
				    	//数据插入成功后插入图片
				    	if(biz.getCode().equals("200")){
				    		responseHead.init();
			    			responseHead.setCode(1113);
			    			responseHead.setErr("插入点赞数据成功！！");
				    	}else{
				    		responseHead.init();
			    			responseHead.setCode(1113);
			    			responseHead.setErr("插入点赞数据失败！");
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
		 * 删除点赞
		 * @author pyl
		 * @date 2018年11月7日
		 */
	    @RequestMapping(value="/delteIdTrpaise", produces = "text/plain;charset=utf-8")
	    @ResponseBody
	    public String deleIdTcommentController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
	    	System.out.println("我进来了,心情新增");
	    	//接收移动端发送的json并解析数据
	    	Gson requestGson = new Gson();
	    	Type type = new TypeToken<RequestEntity<Tpraise>>() {
			}.getType();
	    	RequestEntity<Tpraise> data = requestGson.fromJson(json, type);
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
		    		Tpraise tpraise = data.getBiz();
		    		if(tpraise == null){
		    			responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("必填字段为空：username");
		    		}else{
		    			//生成id
		    			String id = CommUtil.getID();
		    			tpraise.setId(id);
		    			//插入数据,图片
				    	biz = cservice.delteIdTrpaiseService(tpraise);
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
		
		
		

	
	
}
