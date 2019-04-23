package com.OuSoft.mobileCommerce.controller.Clock;

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
import com.OuSoft.mobileCommerce.entity.ResponseClockModel;
import com.OuSoft.mobileCommerce.entity.ResponseEntity;
import com.OuSoft.mobileCommerce.entity.ResponseHead;
import com.OuSoft.mobileCommerce.entity.ResponseTcommentModel;
import com.OuSoft.mobileCommerce.service.Clock.MClcockService;
import com.OuSoft.system.controller.ClockController.ClockController;
import com.OuSoft.system.controller.FileUpload.BusinessController;
import com.OuSoft.system.entity.Clock;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.entity.Tcomment;
import com.OuSoft.system.service.Clock.ClockService;
import com.OuSoft.utils.CommUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 签到模块
 * @author pengyueli
 * @date 2018年11月2日
 */
@Controller
@RequestMapping(value="/mobile/clock")
public class MClockController {

	//验证
	@Autowired
	MLoginController validationToken;
	
	//图片
	@Autowired 
	BusinessController saveFile;
	
	@Autowired
	ClockController clockscon;
	
	@Autowired
	MClcockService mservice;
	
	@Autowired
	ClockService cservice;
	
	/**
	 * 签到，签退
	 * @author pyl
	 * @date 2018年11月2日
	 */
	@RequestMapping(value="/saveclock", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String saveClockController(@RequestParam("json") String json ,HttpServletRequest request, MultipartFile[] files){
		System.out.println("我进来了,签到新增");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Clock>>() {
		}.getType();
    	RequestEntity<Clock> data = requestGson.fromJson(json, type);
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
	    		Clock clock = data.getBiz();
	    		if(clock == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
	    			//生成id
	    			String id = CommUtil.getID();
	    			clock.setId(id);
	    			//插入数据,图片
			    	biz = clockscon.insertClock(clock, request, null, null, null);
			    	responseHead.init();
	    			responseHead.setCode(1111);
	    			responseHead.setErr("新增签到数据成功！");
			    	//数据插入成功后插入图片
			    	if(biz.getCode().equals("200")){
			    		if(files != null && files.length > 0){
			    			Tatt tatt = new Tatt();
			    			tatt.setItemid(id);//项目id
			    			tatt.setItemtype("tsign");//mood
			    			tatt.setAttfrom("02");//来源
			    			tatt.setFiletype("01");//类型01
			    			saveFile.filesUpload(files, tatt, request);
			    		}
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
	 *  签到/签退的排名和列表 : 接收参数 id 判断当前用户 cltype 01 签到 02签退。 通过dz判断用户是否点赞过 cltime : 年月日
	 *  响应：time：时分秒，timss：年月日 username：姓名 tpranum点赞数   
	 * @author pyl
	 * @date 2018年11月7日
	 */
	@RequestMapping(value="/queryclock", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String queryController(@RequestParam("json") String json ,HttpServletRequest request){
		System.out.println("我进来了,签到图表列表查询");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Clock>>() {
		}.getType();
    	RequestEntity<Clock> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	ResponseClockModel biz = new ResponseClockModel();
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
	    		Clock clock = data.getBiz();
	    		if(clock == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	//查询数据
	    			System.out.println("cltype:"+clock.getCltype()  );
	    			biz.setList(mservice.queryClockService(clock));
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<ResponseClockModel> response = new ResponseEntity<ResponseClockModel>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
		
	}
	
	/**
	 * 详情 queryListDzTsignService
	 * 必传：签到id:
	 * 返回：
	 * @author pyl
	 * @date 2018年11月7日
	 */
	@RequestMapping(value="/queryListDzTsign", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String queryListDzTsignController(@RequestParam("json") String json ,HttpServletRequest request){
		System.out.println("我进来了,签到图表列表查询");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Clock>>() {
		}.getType();
    	RequestEntity<Clock> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	ResponseClockModel biz = new ResponseClockModel();
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
	    		Clock clock = data.getBiz();
	    		if(clock == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	//查询数据
	    			String id = clock.getId();
	    			System.out.println("签到cltype:"+ id);
	    			List<Clock> clocklist = cservice.queryListDzTsignService(clock);
	    			biz.setList(clocklist);
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<ResponseClockModel> response = new ResponseEntity<ResponseClockModel>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
		
	}
	
	/**
	 * queryListClockTcomment
	 * 签到评论，iteimid
	 */
	@RequestMapping(value="/queryListClockTcomment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String queryListClockTcommentController(@RequestParam("json") String json ,HttpServletRequest request){
		System.out.println("我进来了,签到图表列表查询");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Tcomment>>() {
		}.getType();
    	RequestEntity<Tcomment> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	ResponseTcommentModel biz = new ResponseTcommentModel();
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
	    		Tcomment clock = data.getBiz();
	    		if(clock == null){
	    			responseHead.init();
	    			responseHead.setCode(1113);
	    			responseHead.setErr("必填字段为空：username");
	    		}else{
			    	//查询数据
	    			String itemid = clock.getItemid();
	    			System.out.println("cltype:"+ itemid);
	    			biz.setList(cservice.queryListTcommentService(itemid));
	    		}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<ResponseTcommentModel> response = new ResponseEntity<ResponseTcommentModel>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
    	return responseGson;
		
	}
	 
    
    /**
     * 查询用户是否签到
     * @author pyl
     * @date 2018年10月31日
     */
    @RequestMapping(value="/quetuserryclock", produces = "text/plain;charset=utf-8")
    @ResponseBody
	public String queryclockController(@RequestParam("json") String json ,HttpServletRequest request ){
		System.out.println("我进来了,用户是否签到！");
    	//接收移动端发送的json并解析数据
    	Gson requestGson = new Gson();
    	Type type = new TypeToken<RequestEntity<Clock>>() {
		}.getType();
    	RequestEntity<Clock> data = requestGson.fromJson(json, type);
    	//返回给移动端的消息
    	ResponseHead responseHead = new ResponseHead();
    	//返回给移动端的数据
    	Clock biz = new Clock();
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
	    		Clock clo =  data.getBiz();
	    		if(clo != null){
	    			biz = cservice.queryClockService(clo);
	    			if(clo.getCltype().equals("01")){
	    				if(biz != null && !"".equals(biz)){
		    				responseHead.init();
			    			responseHead.setCode(1111);
			    			responseHead.setErr("用户已签到！");
		    			}else{
		    				responseHead.init();
			    			responseHead.setCode(1113);
			    			responseHead.setErr("用户未签到！");
		    			}
	    			}else if(clo.getCltype().equals("02")){
	    				if(biz != null && !"".equals(biz)){
		    				responseHead.init();
			    			responseHead.setCode(1111);
			    			responseHead.setErr("用户已签退！");
		    			}else{
		    				responseHead.init();
			    			responseHead.setCode(1113);
			    			responseHead.setErr("用户未签退！");
		    			}
	    			}else{
	    				responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("数据为空！");
	    			}
	    		}else{
	    			//单独查询用户是否签到
		    		Clock clock =new Clock();
		    		clock.setCltype("01");
		    		biz = cservice.queryClockService(clock);
		    		if(biz != null && !"".equals(biz)){
	    				responseHead.init();
		    			responseHead.setCode(1111);
		    			responseHead.setErr("用户已经签到签退！");
	    			}else{
	    				responseHead.init();
		    			responseHead.setCode(1113);
		    			responseHead.setErr("用户未签到签退！");
	    			}
	    		}
//		    	if(biz != null && !biz.equals("")){
//		    		responseHead.init();
//					responseHead.setCode(1111);
//					responseHead.setErr("用户已签到！");
//		    	}else{
//		    		responseHead.init();
//					responseHead.setCode(1113);
//					responseHead.setErr("用户未签到！");
//		    	}
	    	}else{
	    		responseHead.init();
				responseHead.setCode(1113);
				responseHead.setErr("请重新登录！");
	    	}
    	}
    	ResponseEntity<Clock> response = new ResponseEntity<Clock>();
    	response.setBiz(biz);
    	response.setHead(responseHead);
    	String responseGson = new Gson().toJson(response);
		return responseGson;
	}
	
	
    
    
    
	
	
}
