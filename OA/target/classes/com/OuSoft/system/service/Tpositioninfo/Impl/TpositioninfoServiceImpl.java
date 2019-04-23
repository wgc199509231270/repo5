package com.OuSoft.system.service.Tpositioninfo.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tpositioninfo.TpositioninfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpositioninfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tpositioninfo.TpositioninfoService;
import com.OuSoft.utils.DateUtil;

/**
 * 职位
 * @author pengyueli
 * @date 2018年12月11日
 */
@Service
public class TpositioninfoServiceImpl implements TpositioninfoService{
	
	@Autowired
	TpositioninfoDao dao;

	/**
	 * 查询职位信息
	 */
	@Override
	public List<Tpositioninfo> queryTpositioninfoService() {
		Tsuser tuser=DateUtil.GetTsuser();
		return dao.queryTpositioninfoDao(tuser.getUserpid());
	}

	/**
	 * 新增职位信息
	 */
	@Override
	public ResponseModel insertTpositioninfoService(Tpositioninfo tpositioninfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tpositioninfo) ){
			tpositioninfo.setId(DateUtil.getID()); 
			tpositioninfo.setTpositime(DateUtil.GetDates());
			tpositioninfo.setTpositime(DateUtil.GetTsuser().getUserpid());
			int num = dao.insertTpositioninfoDao(tpositioninfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增一条职位信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增一条职位信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("职位信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除职位信息
	 */
	@Override
	public ResponseModel deleteTpositioninfoService(Tpositioninfo tpositioninfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tpositioninfo) ){
			int num = dao.deleteTpositioninfoDao(tpositioninfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条职位信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条职位信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("职位id为空，删除失败！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除职位信息
	 */
	@Override
	public ResponseModel deleteTuserByIdTpositioninfoService(
			Tpositioninfo tpositioninfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tpositioninfo) ){
			if( tpositioninfo.getUserid() != null && !"".equals(tpositioninfo.getUserid()) && tpositioninfo.getPosiid() != null && !"".equals(tpositioninfo.getPosiid())){
				int num = dao.deleteTuserByIdTpositioninfoDao(tpositioninfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除一条用户职位信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除一条用户职位信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("职位必填参数为空，删除失败！");

			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("职位必填参数为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 新增用户职位信息
	 */
	@Override
	public ResponseModel InsertTuserByIdTpositioninfoService(
			Tpositioninfo tpositioninfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tpositioninfo) ){
			tpositioninfo.setId(DateUtil.getID()); 
			int num = dao.InsertTuserByIdTpositioninfoDao(tpositioninfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增一条用户职位信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增一条用户职位信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("新增用户职位信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 
	 * 查询用户职位信息.
	 * 接收：用户id:userid
	 * 返回 id:职位id, posiname:职位名称，tpositime:时间，userid:用户id,posiid:职位id
	 */
	@Override
	public List<Tpositioninfo> queryTuserByIdTpositioninfoService(
			Tpositioninfo tpositioninfo) {
		List<Tpositioninfo> list = new ArrayList<Tpositioninfo>();
		if(!DateUtil.getObjCheckIsNull(tpositioninfo) ){
			if(tpositioninfo.getUserid() == null || tpositioninfo.getUserid().equals("") ){
				tpositioninfo.setUserid(DateUtil.getUserid());
			}
			list = dao.queryTuserByIdTpositioninfoDao(tpositioninfo);
		}else{
			list = null;
		}
		
		// TODO Auto-generated method stub
		return list;
	}
	
	
	
	
	

}
