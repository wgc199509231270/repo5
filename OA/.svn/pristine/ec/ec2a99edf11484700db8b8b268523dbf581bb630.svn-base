package com.OuSoft.system.controller.Tsuser;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.service.Tdepartmentinfo.TdepartmentinfoService;
import com.OuSoft.system.service.Tjobinfo.TjobinfoService;
import com.OuSoft.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tsuser.ITsuserService;

@RequestMapping(value="/tuser")
@Controller
public class TsuserController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	ITsuserService iTsuserService;

	@Autowired
	TjobinfoService service;

	@Autowired
	TdepartmentinfoService tdservice;

	@RequestMapping(value="/queryPeopleTuser")
	@ResponseBody
	public List<Tsuser> queryPeopleTuserController(Tsuser tuser){
		return iTsuserService.queryPeopleTuserService(tuser);
	}
	

	/**
	 * 修改用户个人信息
		tpositioninfoid;//职位id
		tdepartmentinfoid;//部门id：
		tjobinfoid;//岗位id
		troleinfoid;//角色id
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@RequestMapping(value="/updateIdTuserInfo")
	@ResponseBody
	public ResponseModel updateIdTuserInfoController(Tsuser tsuser){
		ResponseModel model =  iTsuserService.updateIdTuserInfoService(tsuser);
		return model;
	}
	
	/**
	 * 查询用户个人信息
	 * @author pyl
	 * @date 2018年9月25日
	 */
	@RequestMapping(value="/queryIdTuser")
	@ResponseBody
	public Tsuser queryIdTuserController(Tsuser ts){
		System.out.println("id"+ts.getId());
		Tsuser tsuser =  iTsuserService.queryIdTuserService(ts);
		return tsuser;
	}
	
	/**
	 * 系统登录验证
	 * @author pyl
	 * @date 2018年8月31日
	 */
	@RequestMapping(value="/QueryTsuserByUsernamePassword")
	@ResponseBody
	public Tsuser QueryTsuserByid(@Param("username") String username ,@Param("password") String password) {
		Tsuser model = iTsuserService.QueryTsuserByid(username, password);
		return model;
	}

	/**
	 * 查询用户所有在职01人员
	 * 默认为在职，
	 * 接收：
	 * status：在职状态：01正式、02离岗、03离职，04试岗、04实习
	 * username：用户姓名，模糊查询
	 * usernumber:用户编号
	 * @author pyl
	 * @date 2018年12月13日
	 */
	@RequestMapping(value="/QueryTsuserList")
	@ResponseBody
	public List<Tsuser> QueryTsuserList(Tsuser tu) {;
		List<Tsuser> list = new ArrayList<Tsuser>();
		list = iTsuserService.QueryTsuserList(tu);
		return list;
	}
	@RequestMapping(value="/DelTsuser")
	@ResponseBody
	public ResponseModel DelTsuser(@Param("id") String id) {
		ResponseModel model = iTsuserService.DelTsuser(id);
		return model;
	}

	@RequestMapping(value="/UpdateTsuserByid")
	@ResponseBody
	public ResponseModel UpdateTsuserByid(@RequestBody Tsuser model) {
		ResponseModel remodel = iTsuserService.UpdateTsuserByid(model);
		return remodel;
	}

	@RequestMapping(value="/insertTsuser")
	@ResponseBody
	public ResponseModel InsertTsuser(@RequestBody Tsuser model) {
		ResponseModel remodel = iTsuserService.InsertTsuser(model);
		return remodel;
	}
	
	/**
	 * 修改用户个人密码
	 * 参数：
	 * usedpass:原始密码
	 * userpass:新密码
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@RequestMapping(value="/updatetuserbyuserpass")
	@ResponseBody
	public ResponseModel updateTuserByUserpassController(Tsuser model){
		return iTsuserService.updateTuserByUserpassService(model);
	}
	


	@RequestMapping(value = "queryTuser")
	@ResponseBody
	public List<Tsuser> queryTuserDao(Tsuser tu){
			if(tu.getStatus() ==  "" || tu.getStatus() == null){
				tu.setStatus("01");
			}
		return iTsuserService.queryTuserDao(tu);
	}

	@RequestMapping(value = "Insertsuser")
	@ResponseBody
	public ResponseModel Insertsuser(Tsuser model){
		String id = DateUtil.getID();
		model.setId(id);
		String id1 = DateUtil.getID();
		System.out.println(id1);
		Tjobinfo tjobinf = null;
		tjobinf.setId(id1);
		tjobinf.setUserid(id);
		tjobinf.setJobid(model.getTpositioninfoid());
		service.InsertTuserByIdTjobinfoService(tjobinf);
		Tdepartmentinfo tdepartmentinfo = null;
		tdepartmentinfo.setId(id1);
		tdepartmentinfo.setUserid(id);
		tdepartmentinfo.setDeparid(model.getTdepartmentinfoid());
		tdservice.InsertTuserByIdTdepartmentinfoService(tdepartmentinfo);
		model.setInductiontime(DateUtil.GetDateR());
		ResponseModel remodel = iTsuserService.Insertsuser(model);
		return remodel;
	}
}
