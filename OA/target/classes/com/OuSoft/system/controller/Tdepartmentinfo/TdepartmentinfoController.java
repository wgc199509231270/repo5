package com.OuSoft.system.controller.Tdepartmentinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.TreeTdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tdepartmentinfo.TdepartmentinfoService;



/**
 * 部门
 * @author pengyueli
 * @date 2018年12月11日
 */
@RequestMapping(value="/Tdepartmentinfo")
@Controller
public class TdepartmentinfoController {
	
	@Autowired
	TdepartmentinfoService service; 
	
	
	
	/**
	 * 修改用户分配的小组信息
	 * 	userid:用户id
		deparid:小组id
		id：修改那条数据的id
	 * @author pyl
	 * @date 2019年1月8日
	 */
	@RequestMapping(value="/updateTdeparinfoById")
	@ResponseBody
	public ResponseModel updateTdeparinfoByIdController(Tdepartmentinfo tdepartmentinfo) {
		return service.updateTdeparinfoByIdService(tdepartmentinfo);
	}
	
	
	/**
	 * 部门编号：deparepid
	 * @author pyl
	 * @date 2019年1月2日
	 */
	@RequestMapping(value="/queryBMTdepartmentTuser")
	@ResponseBody
	public List<Tdepartmentinfo> queryBMTdepartmentTuserController(Tsuser tsuser) {
		return service.queryBMTdepartmentTuserService(tsuser);
		
	}
	
	/**
	 * 小组下的人员 ，小组：id
	 *  * status:01是查询所有人的
		username : 姓名
		usernumber:编号
	 * @author pyl
	 * @date 2019年1月2日
	 */
	@RequestMapping(value="/queryTdepartmentTuser")
	@ResponseBody
	public List<Tdepartmentinfo> queryTdepartmentTuserfoController(Tsuser tsuser) {
		return service.queryTdepartmentTuserService(tsuser);
		
	}
	
	/**
	 * 树形结构
	 * @author pyl
	 * @date 2019年1月2日
	 */
	@RequestMapping(value="/querySXJGTdepartmentinfo")
	@ResponseBody
	public List<TreeTdepartmentinfo> querySXJGTdepartmentinfoController() {
		return service.querySXJGTdepartmentinfoService();
		
	}
	
	/**
	 * 查询部门信息
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@RequestMapping(value="/queryTdepartmentinfo")
	@ResponseBody
	public List<Tdepartmentinfo> queryTdepartmentinfoController(){
		return service.queryTdepartmentinfoService();
	}
	
	
	/**
	 * 新增部门信息
	 * 部门数据：
		deparname
		deparepid
		departime
		deparpid
		remark
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/insertTdepartmentinfo")
	@ResponseBody
	public ResponseModel insertTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.insertTdepartmentinfoService(tdepartmentinfo);
	}
	
	/**
	 * 删除部门信息
	 * 接收：id
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTdepartmentinfo")
	@ResponseBody
	public ResponseModel deleteTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.deleteTdepartmentinfoService(tdepartmentinfo);
	}
	
	/**
	 * 查询用户部门信息.
	 * 接收：用户id:userid
	 * 返回 id:部门id, deparname:部门名称，departime:时间，userid:用户id,deparid:部门id
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/queryTuserByIdTdepartmentinfo")
	@ResponseBody
	public List<Tdepartmentinfo> queryTuserByIdTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.queryTuserByIdTdepartmentinfoService(tdepartmentinfo);
	}
	
	
	/**
	 * 新增用户部门信息
	 * 接收
	 * userid
	 * deparid
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/InsertTuserByIdTdepartmentinfo")
	@ResponseBody
	public ResponseModel InsertTuserByIdTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.InsertTuserByIdTdepartmentinfoService(tdepartmentinfo);
	}
	/**
	 * 修改用户部门信息
	 * 接收
	 * userid
	 * deparid
	 */
	@RequestMapping(value="/updateTuserByIdTdepartmentinfo")
	@ResponseBody
	public ResponseModel TuserByIdTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.updateTuserByIdTdepartmentinfoService(tdepartmentinfo);
	}
	/**
	 * 删除用户部门信息
	 * 接收
	 * userid
	 * deparid
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@RequestMapping(value="/deleteTuserByIdTdepartmentinfo")
	@ResponseBody
	public ResponseModel deleteTuserByIdTdepartmentinfoController(Tdepartmentinfo tdepartmentinfo){
		return service.deleteTuserByIdTdepartmentinfoService(tdepartmentinfo);
	}
	
	
	
	
	
	

}
