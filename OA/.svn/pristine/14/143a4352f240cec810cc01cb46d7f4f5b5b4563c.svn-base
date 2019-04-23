package com.OuSoft.system.service.Tjobinfo.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tjobinfo.TjobinfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tjobinfo.TjobinfoService;
import com.OuSoft.utils.DateUtil;


@Service
public class TjobinfoServiceImpl implements TjobinfoService{


	@Autowired
	TjobinfoDao dao;

	/**
	 * 查询岗位信息
	 */
	@Override
	public List<Tjobinfo> queryTjobinfoService(Tjobinfo tjobinfo) {
		// TODO Auto-generated method stub
		return dao.queryTjobinfoDao(tjobinfo);
	}

	/**
	 * 新增岗位信息：jobname 岗位名称 ，remark，备注 jobnum 等及01部门经理，02副经理，03组长，04成员
	 * @author pyl
	 * @date 2018年12月12日
	 */
	@Override
	public ResponseModel insertTjobinfoService(Tjobinfo tjobinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tjobinfo)){
			if(tjobinfo.getDeparid() != null && tjobinfo.getDeparid() != "" && tjobinfo.getJobnum() != null && tjobinfo.getJobnum() != ""){
				tjobinfo.setId(DateUtil.getID());
				tjobinfo.setJobtime(DateUtil.GetDates());
				tjobinfo.setJobpid(DateUtil.GetTsuser().getUserpid());
				int num = dao.insertTjobinfoDao(tjobinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增一条岗位信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("新增一条岗位信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("部门id为空空空！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("岗位信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除岗位信息
	 * 接收：id
	 *
	 */
	@Override
	public ResponseModel deleteTjobinfoService(Tjobinfo tjobinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(  tjobinfo ) ){
			int num = dao.deleteTjobinfoDao(tjobinfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条岗位信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条岗位信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("岗位id为空，删除失败！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除用户岗位信息
	 * 接收：userid,jobid
	 */
	@Override
	public ResponseModel deleteTuserByIdTjobinfoService( Tjobinfo tjobinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(  tjobinfo ) ){
			if( tjobinfo.getUserid() != null && !"".equals(tjobinfo.getUserid()) && tjobinfo.getJobid() != null && !"".equals(tjobinfo.getJobid())){
				int num = dao.deleteTuserByIdTjobinfoDao(tjobinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除一条用户岗位信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除一条用户岗位信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("岗位必填参数为空，删除失败！");

			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("岗位必填参数为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 新增用户岗位信息
	 */
	@Override
	public ResponseModel InsertTuserByIdTjobinfoService(
			Tjobinfo tjobinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(  tjobinfo ) ){
			if( tjobinfo.getUserid() != null && !"".equals(tjobinfo.getUserid()) && tjobinfo.getJobid() != null && !"".equals(tjobinfo.getJobid())){
				tjobinfo.setId(DateUtil.getID());
				int num = dao.InsertTuserByIdTjobinfoDao(tjobinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增一条用户岗位信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("新增一条用户岗位信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("岗位必填参数为空，删除失败！");
			}

		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("新增用户岗位信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 修改用户岗位信息
	 * @param tjobinfo
	 * @return
	 */
	@Override
	public ResponseModel updateTuserByIdTjobinfoService(Tjobinfo tjobinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(  tjobinfo ) ){
			if( tjobinfo.getUserid() != null && !"".equals(tjobinfo.getUserid()) && tjobinfo.getJobid() != null && !"".equals(tjobinfo.getJobid())){
				tjobinfo.setId(DateUtil.getID());
				int num = dao.updateTuserByIdTjobinfoDao(tjobinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("修改一条用户岗位信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("修改一条用户岗位信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("岗位必填参数为空，修改失败！");
			}

		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("用户岗位信息为空！");
		}
		return remodel;
	}

	/**
	 *
	 * 查询用户岗位信息.
	 * 接收：用户id:userid
	 * 返回 id:岗位id, jobname:岗位名称，jobtime:时间，userid:用户id,jobid:岗位id
	 */
	@Override
	public List<Tjobinfo> queryTuserByIdTjobinfoService(
			Tjobinfo tjobinfo) {
		List<Tjobinfo> list = new ArrayList<Tjobinfo>();
		if(!DateUtil.getObjCheckIsNull(  tjobinfo ) ){
			if(tjobinfo.getUserid() == null || tjobinfo.getUserid().equals("") ){
				tjobinfo.setUserid(DateUtil.getUserid());
			}
			list = dao.queryTuserByIdTjobinfoDao(tjobinfo);
		}else{
			list = null;
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 获取上级id
	 * userid
	 * @param tjobinfo
	 * @return
	 */
	@Override
	public List<Tjobinfo> queryOldUseridService(Tjobinfo tjobinfo) {
		if(tjobinfo.getUserid().isEmpty()){
			tjobinfo.setUserid(DateUtil.getUserid());
		}
		List<Tjobinfo> list=dao.queryOldUseridDao(tjobinfo);
		if(list.size()==0){
			list.add(new Tjobinfo());
			list.get(0).setUserid(tjobinfo.getUserid());
		}
		return list;
	}

	@Override
	public List<Tjobinfo> queryUseridService(Tjobinfo tjobinfo) {
		List<Tjobinfo> tjobinfos = dao.queryUseridDao(tjobinfo);
		return tjobinfos;
	}

	/**
	 * 通过岗位id查询用户信息
	 */
	@Override
	public List<Tsuser> queryJobidTuserService(Tsuser tsuser) {
		 List<Tsuser> list = null;
		if(!DateUtil.getObjCheckIsNull(  tsuser ) ){
			list = dao.queryJobidTuserDao(tsuser);
		}else{
			System.out.println("岗位id为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


}
