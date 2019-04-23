package com.OuSoft.mobileCommerce.controller.CircleofFriends;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.mobileCommerce.controller.Login.MLoginController;
import com.OuSoft.mobileCommerce.entity.CircleofFriendsModel;
import com.OuSoft.mobileCommerce.entity.RequestEntity;
import com.OuSoft.mobileCommerce.entity.RequestHead;
import com.OuSoft.mobileCommerce.entity.ResponseEntity;
import com.OuSoft.mobileCommerce.entity.ResponseHead;
import com.OuSoft.mobileCommerce.service.CircleofFriends.CircleofFriendsService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value="/mobile/CircleofFriends")
public class CircleofFriendsController {
	//验证
	@Autowired
	MLoginController validationToken;

	@Autowired
	CircleofFriendsService circleofFriendsService;
	/**
	 * 朋友圈列表
	 * @param
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/queryCircleofFriends", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryCircleofFriends(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,心情所有人图表");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Mood>>() {
		}.getType();
    	RequestEntity<Mood> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<CircleofFriendsModel> biz = null;
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
			    	biz = circleofFriendsService.queryCircleofFriends(mood);
			    	//数据插入成功后插入图片
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<CircleofFriendsModel>> response = new ResponseEntity<List<CircleofFriendsModel>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
}
