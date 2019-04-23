package com.OuSoft.mobileCommerce.controller.Tquestion;

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
import com.OuSoft.mobileCommerce.service.Tquestion.MTquestionService;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.entity.Tquestion;
import com.OuSoft.system.service.Tquestion.TquestionService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 问答模块
 * @author pengyueli
 * @date 2018年11月1日
 */
@Controller
@RequestMapping(value="/mobile/tquestion")
public class MTquestionController {

	
	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired 
	BusinessController saveFile;
	
	@Autowired
	TquestionService tquestionService;
	
	@Autowired
	MTquestionService mService;
	
	/**
	 * 新增问答
	 * @author pyl
	 * @date 2018年11月1日
	 */
	@RequestMapping(value="/insetTquestion", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertTquestionController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
		System.out.println("我进来了,问答新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			tquestion.setId(id);
	    			//插入数据,图片
			    	biz = tquestionService.insertTquestionService(tquestion);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增问答数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("tquestion");//修改成表名如：mood,tplan,tsign,tknowledge.....
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
			    	}else{
			    		responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("插入问答数据失败！");
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
	  *  问答所有人列表
	 	接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
		问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
		qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，ip：ip
	  * @author pyl
	  * @date 2018年11月13日
	  */
    @RequestMapping(value="/queryQBLBListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryQBLBListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答总列表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryQBLBListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
     
	
	
	/**
	 * 问答个人列表
	 * 接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
		问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
		qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，ip：ip
	 * 
	 * @author pyl
	 * @date 2018年11月13日
	 */
    @RequestMapping(value="/queryGRLBListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryGRLBListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答个人列表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryGRLBListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
     
	
	/**
	 * 问答所有人图表
		 接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
		问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
		qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
	 * 
	 * @author pyl
	 * @date 2018年11月13日
	 */
    @RequestMapping(value="/queryQBTBListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryQBTBListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答总图表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryQBTBListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
	
    /**
     * 问答个人图表
     * 接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
		问题类型 01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		响应：qucreatetime：时间，qutext：问题内容，qustatus：问题状态（01：解决，02：未解决）
		qudetail：问题描述，qutype：01.产品 02.技术 03.客户 04.组织 05.业务 06.其他
		username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
     * 
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryGRTBListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryGRTBListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答个人图表！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryGRTBListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
	
    /**
     * 问答点赞
     * 接收：pagenum:页。pagesize:一页条数 	begtime:开始时间年月日 endtime:结束时间 
		响应： 
		username:姓名，txfilename:头像，tpranum:点赞数，comnum：评论数，tsnum：发布数 ,ip：ip
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryDzListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryDzListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答点赞！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryDzListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
	
    
    /**
     * 问答详情
     * 参数，项目itemid  
		响应：pusername:评论人姓名，txfilename：姓名头像，hfilename,回复头像,husername:回复人姓名，
     * @author pyl
     * @date 2018年11月13日
     */
    @RequestMapping(value="/queryPlListTquestion", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryPlListTquestionController(@RequestParam("json") String json ,HttpServletRequest request ){
    	System.out.println("我进来了,问答点赞！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tquestion>>() {
		}.getType();
    	RequestEntity<Tquestion> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	List<Tquestion> biz = null;
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
	    		Tquestion tquestion = data.getBiz();
	    		if(tquestion == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	biz = mService.queryPlListTquestionService(tquestion);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<List<Tquestion>> response = new ResponseEntity<List<Tquestion>>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
    }
    
    
    
	
}
