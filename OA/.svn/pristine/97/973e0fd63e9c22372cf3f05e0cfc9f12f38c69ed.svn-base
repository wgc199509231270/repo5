package com.OuSoft.mobileCommerce.controller.tsummary;

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
import com.OuSoft.mobileCommerce.service.Tsummary.MTsummaryService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.entity.Tsummary;
import com.OuSoft.system.service.Tsummary.TsummaryService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



/**
 * 总结模块
 * @author pengyueli
 * @date 2018年11月1日
 */
@Controller
@RequestMapping(value="/mobile/tsummary")
public class MTsummary {

	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired 
	BusinessController saveFile;
	
	@Autowired
	TsummaryService tsummaryService;
	
	@Autowired
	MTsummaryService mservice;
	
	
	/**
	 * 新增总结
	 * @author pyl
	 * @date 2018年11月1日
	 */
	@RequestMapping(value="/insettsummary", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertTquestionController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
		System.out.println("我进来了,问答新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tsummary>>() {
		}.getType();
    	RequestEntity<Tsummary> data = requestGson.fromJson(json, type);
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
	    		Tsummary tsummary = data.getBiz();
	    		if(tsummary == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			tsummary.setId(id);
	    			//插入数据,图片
			    	biz = tsummaryService.saveTsummaryService(tsummary);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增总结数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("tsummary");//修改成表名如：tmood,tplan,tsign,tknowledge.....
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
			    	}else{
			    		responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("插入总结数据失败！");
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
   	 * 总结查询所有人列表图表
	 * 接收：pagenum:页pagesize:一页几条数据，（begtime:开始年月日，endtime:结束年月日（默认当天））
 	 * 响应：username:姓名，txfilename：头像,ip:ip，sutext:内容time:年月日 times:时分秒
	 * sucompany：公司 sumanage：管理 suwork：工作 suhygienism：卫生
   	 * @author pyl
   	 * @date 2018年11月09日
   	 */
       @RequestMapping(value="/queryQBTsummaryList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryQBTsummaryListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,总结查询所有人列表图表！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Tsummary>>() {
   		}.getType();
       	RequestEntity<Tsummary> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Tsummary> biz = null;
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
   	    		Tsummary tsummary = data.getBiz();
   	    		if(tsummary == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryQBTsummaryListService(tsummary);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Tsummary>> response = new ResponseEntity<List<Tsummary>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
       
       
	
       /**
        * 总结个人
	    *  接收：pagenum:页pagesize:一页几条数据，begtime:开始年月日，endtime:结束年月日
	    *  响应：username:姓名，txfilename：头像,ip:ip，sutext:内容time:年月日 times:时分秒
		*  sucompany：公司 sumanage：管理 suwork：工作 suhygienism：卫生
        * @author pyl
        * @date 2018年11月9日
        */
       @RequestMapping(value="/queryGrTsummaryList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryGrTsummaryListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,总结个人列表图表！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Tsummary>>() {
   		}.getType();
       	RequestEntity<Tsummary> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Tsummary> biz = null;
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
   	    		Tsummary tsummary = data.getBiz();
   	    		if(tsummary == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryGrTsummaryListService(tsummary);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Tsummary>> response = new ResponseEntity<List<Tsummary>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
	
       /**
        * 总结点赞
        * 接收:id：项目id   响应：tprausername:点赞人，tprafilename:点赞头像， time:年与日 times:时分秒
        * @author pyl
        * @date 2018年11月9日
        */
       @RequestMapping(value="/queryDzTsummaryList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryDzTsummaryListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,总结点赞！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Tsummary>>() {
   		}.getType();
       	RequestEntity<Tsummary> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Tsummary> biz = null;
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
   	    		Tsummary tsummary = data.getBiz();
   	    		if(tsummary == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryDzTsummaryListService(tsummary);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Tsummary>> response = new ResponseEntity<List<Tsummary>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
	
	
	
       /**
        * 总结评论
        * 参数，项目itemid   响应：pusername:评论人姓名，txfilename：姓名头像，hfilename,回复头像 husername:回复人姓名， commenttime:时间
        * @author pyl
        * @date 2018年11月9日
        */
       @RequestMapping(value="/queryPlTsummaryList", produces = "text/plain;charset=utf-8")
       @ResponseBody
       public String queryPlTsummaryListController(@RequestParam("json") String json ,HttpServletRequest request ){
       	System.out.println("我进来了,总结评论！");
       	//接收移动端发送的json并解析数据
       	Gson requestGson = new Gson();
       	Type type = new TypeToken<RequestEntity<Tsummary>>() {
   		}.getType();
       	RequestEntity<Tsummary> data = requestGson.fromJson(json, type);
       	//返回给移动端的消息
       	ResponseHead responseHead = new ResponseHead();
       	//返回给移动端的数据
       	List<Tsummary> biz = null;
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
   	    		Tsummary tsummary = data.getBiz();
   	    		if(tsummary == null){
   	    			responseHead.init();
   	    			responseHead.setCode(1113);
   	    			responseHead.setErr("必填字段为空：username");
   	    		}else{
   			    	biz = mservice.queryPlTsummaryListService(tsummary);
   	    		}
   	    	}else{
   	    		responseHead.init();
   				responseHead.setCode(1113);
   				responseHead.setErr("请重新登录！");
   	    	}
       	}
       	ResponseEntity<List<Tsummary>> response = new ResponseEntity<List<Tsummary>>();
       	response.setBiz(biz);
       	response.setHead(responseHead);
       	String responseGson = new Gson().toJson(response);
       	return responseGson;
       }
	
	

}
