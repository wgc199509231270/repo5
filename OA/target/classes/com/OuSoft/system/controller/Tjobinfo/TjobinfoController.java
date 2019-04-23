package com.OuSoft.system.controller.Tjobinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.service.Tjobinfo.TjobinfoService;


@RequestMapping(value="/Tjobinfo")
@Controller
public class TjobinfoController {
	
	@Autowired
	TjobinfoService service;
	
	
	/**
	 * 查询岗位信息
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@RequestMapping(value="/queryTjobinfo")
	@ResponseBody
	public List<Tjobinfo> queryTjobinfoController(Tjobinfo tjobinfo){
		return service.queryTjobinfoService(tjobinfo);
	}
	
	
	
	/**
	 * 新增岗位信息
	 * 岗位数据：jobname ，jobpid，remark，jobtime
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/insertTjobinfo")
	@ResponseBody
	public ResponseModel insertTjobinfoController(Tjobinfo tjobinfo){
		return service.insertTjobinfoService(tjobinfo);
	}
	
	/**
	 * 删除岗位信息
	 * 接收：id
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTjobinfo")
	@ResponseBody
	public ResponseModel deleteTjobinfoController(Tjobinfo tjobinfo){
		return service.deleteTjobinfoService(tjobinfo);
	}
	
	/**
	 * 查询用户岗位信息.
	 * 接收：用户id:userid
	 * 返回 id:岗位id, deparname:岗位名称，departime:时间，userid:用户id,deparid:岗位id
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/queryTuserByIdTjobinfo")
	@ResponseBody
	public List<Tjobinfo> queryTuserByIdTjobinfoController(Tjobinfo tjobinfo){
		return service.queryTuserByIdTjobinfoService(tjobinfo);
	}

	/**
	 * 修改用户岗位信息.
	 * 接收：id userid jobid
	 */
	@RequestMapping(value="/updateTuserByIdTjobinfo")
	@ResponseBody
	public ResponseModel updateTuserByIdTjobinfo(Tjobinfo tjobinfo){
		return service.updateTuserByIdTjobinfoService(tjobinfo);
	}
	/**
	 * 新增用户岗位信息
	 * 接收
	 * userid
	 * jobid
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/InsertTuserByIdTjobinfo")
	@ResponseBody
	public ResponseModel InsertTuserByIdTjobinfoController(Tjobinfo tjobinfo){
		return service.InsertTuserByIdTjobinfoService(tjobinfo);
	}
	
	/**
	 * 删除用户岗位信息
	 * 接收
	 * userid
	 * jobid	
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTuserByIdTjobinfo")
	@ResponseBody
	public ResponseModel deleteTuserByIdTjobinfoController(Tjobinfo tjobinfo){
		return service.deleteTuserByIdTjobinfoService(tjobinfo);
	}

	/**
	 * 查询岗上级id
	 */
	@RequestMapping(value="/queryOldUserid")
	@ResponseBody
	public List<Tjobinfo> queryOldUserid(Tjobinfo tjobinfo){
		return service.queryOldUseridService(tjobinfo);
	}
}
