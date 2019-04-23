package com.OuSoft.mobileCommerce.controller.Tknowledge;

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
import com.OuSoft.mobileCommerce.service.Tknowledge.MTknowledgeService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.entity.Tknowledge;
import com.OuSoft.system.service.Tknowledge.tknowledgeService;
import com.OuSoft.system.service.fileUpload.attFileUploadService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 知识模块
 * @author pengyueli
 * @date 2018年11月1日
 */
@Controller
@RequestMapping(value="/mobile/mtknowledge")
public class MTknowledgeController {

	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired
	attFileUploadService attFileUploadService; 
	
	//图片
	@Autowired 
	BusinessController saveFile;

	@Autowired
	tknowledgeService tknowledgeService;
	
	@Autowired
	MTknowledgeService mservice;
	
	
	/**
	 * 图片查询，接收itemid
	 * @author pyl
	 * @date 2018年11月1日
	 */
	@RequestMapping(value="/queryTatt", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String queryTattController(@RequestParam("json") String json){
		System.out.println("我进来了,知识新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tatt>>() {
		}.getType();
    	RequestEntity<Tatt> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tatt> biz = null;
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
	    		Tatt tatt = data.getBiz();
	    		if(tatt == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//接收itemid
	    			String itemid = tatt.getItemid();
			    	biz = attFileUploadService.queryFileUploadService(itemid);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tatt>> response = new ResponseEntity<List<Tatt>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
		return responseGson;
	}
	
	
	
	
	/**
	 * 新增zhishi 
	 * @author pyl
	 * @date 2018年11月1日
	 */
	@RequestMapping(value="/insetmtknowledge", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertMTknowledge(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
		System.out.println("我进来了,知识新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			tknowledge.setId(id);
	    			//插入数据,图片
			    	biz = tknowledgeService.insertTknowledgeServcie(tknowledge);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增知识数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("tknowledge");//修改成表名如：mood,tplan,tsign,tknowledge.....
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
			    	}else{
			    		responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("插入知识数据失败！");
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
	 *知识所有人列表
 	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	sqgjz: 模糊查询标题和内容
	 响应：latitle:标题，latype:内容，lacreatetime:时间，time:年月日，times时分秒,
	username:姓名：txfilename:头像，tpranum点赞数，comnum：评论数，ip:ip
	text:列表内容三十个字后是........
	 * @author pyl
	 * @date 2018年11月13日
	 */
    @RequestMapping(value="/queryQBLBListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryQBLBListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,知识总列表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryQBLBListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
	/**
	 * 知识个人列表
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	sqgjz: 模糊查询标题和内容
	 响应：latitle:标题，latype:内容，lacreatetime:时间，time:年月日，times时分秒,
	username:姓名：txfilename:头像，tpranum点赞数，comnum：评论数，ip:ip
	text:列表内容三十个字后是........
	 * @author pyl
	 * @date 2018年11月13日
	 */
    @RequestMapping(value="/queryGRLBListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryGRLBListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,个人列表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryGRLBListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    /**
     * 所有人图表
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	响应	tpranum:点赞数，comnum:评论数，tsnum，发布数，username:姓名 ，lacreatetime:时间
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryQBTBListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryQBTBListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,总图表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryQBTBListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    
    /**
     *  个人图表 
	接受，选填 latype：知识类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
	pagenum:页。pagesize:一页数
	begtime:开始时间年月日
	endtime:结束时间
	响应	tpranum:点赞数，comnum:评论数，tsnum，发布数，username:姓名 ，lacreatetime:时间
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryGRTBListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryGRTBListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,个人图表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryGRTBListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    /**
     * 点赞详情 
	接收：pagenum:页。pagesize:一页数 	begtime:开始时间年月日 endtime:结束时间 
	id:项目id
	响应：tprausername:点赞人，tprafilename点赞人头像 ip:ip
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryDzListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryDzListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,知识点赞详情！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryDzListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    /**
     *  评论详情 
	接收：pagenum:页。pagesize:一页数 	begtime:开始时间年月日 endtime:结束时间 
	itemid:项目id
	响应：pusername评论人，txfilename:评论人头像，ip:ip，husername:回复人姓名，hfilename:回复人头像，commenttime:时间
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryPlListTknowledge", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryPlListTknowledgeController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,知识评论详情！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tknowledge>>() {
		}.getType();
    	RequestEntity<Tknowledge> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tknowledge> biz = null;
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
	    		Tknowledge tknowledge = data.getBiz();
	    		if(tknowledge == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mservice.queryPlListTknowledgeService(tknowledge);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tknowledge>> response = new ResponseEntity<List<Tknowledge>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
     
	
	
	
	
	
}
