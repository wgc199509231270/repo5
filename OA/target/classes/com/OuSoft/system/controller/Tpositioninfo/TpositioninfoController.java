package com.OuSoft.system.controller.Tpositioninfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpositioninfo;
import com.OuSoft.system.service.Tpositioninfo.TpositioninfoService;


/**
 * 职位
 * @author pengyueli
 * @date 2018年12月11日
 */
@RequestMapping(value="/Tpositioninfo")
@Controller
public class TpositioninfoController {
	
	@Autowired
	TpositioninfoService service;
	
	/**
	 * 查询职位信息
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@RequestMapping(value="/queryTpositioninfo")
	@ResponseBody
	public List<Tpositioninfo> queryTpositioninfoController(){
		return service.queryTpositioninfoService();
	}
	
	/**
	 * 新增职位信息
	 * 职位数据：id
		posiname
		posiepid
		posipid
		remark
		tpositime

	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/insertTpositioninfo")
	@ResponseBody
	public ResponseModel insertTpositioninfoController(Tpositioninfo tpositioninfo){
		return service.insertTpositioninfoService(tpositioninfo);
	}
	
	/**
	 * 删除职位信息
	 * 
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTpositioninfo")
	@ResponseBody
	public ResponseModel deleteTpositioninfoController(Tpositioninfo tpositioninfo){
		return service.deleteTpositioninfoService(tpositioninfo);
	}
	
	/**
	 * 查询用户职位信息.
	 * 接收：用户id:userid
	 * 返回 id:职位id, posiname:职位名称，tpositime:时间，userid:用户id,posiid:职位id
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/queryTuserByIdTpositioninfo")
	@ResponseBody
	public List<Tpositioninfo> queryTuserByIdTpositioninfoController(Tpositioninfo tpositioninfo){
		return service.queryTuserByIdTpositioninfoService(tpositioninfo);
	}
	
	
	/**
	 * 新增用户职位信息
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/InsertTuserByIdTpositioninfo")
	@ResponseBody
	public ResponseModel InsertTuserByIdTpositioninfoController(Tpositioninfo tpositioninfo){
		return service.InsertTuserByIdTpositioninfoService(tpositioninfo);
	}
	
	/**
	 * 删除用户职位信息
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTuserByIdTpositioninfo")
	@ResponseBody
	public ResponseModel deleteTuserByIdTpositioninfoController(Tpositioninfo tpositioninfo){
		return service.deleteTuserByIdTpositioninfoService(tpositioninfo);
	}
	
	
	
	
	
	
	
	
	

}
