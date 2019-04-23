package com.OuSoft.system.service.Mien.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Mien.MienDao;
import com.OuSoft.system.entity.Mien;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Mien.MienService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

/**
 * 风采业务层
 * @author asus
 *
 */
@Service
public class MienServiceImpl implements MienService{

	@Autowired
	MienDao miendao;

	public ResponseModel insertMienService(Mien mien) {
		ResponseModel model = new ResponseModel();
		System.out.println("打印："+mien);
		int count=0;
		if(!DateUtil.getObjCheckIsNull(mien)) {
			if(mien.getId()==null || mien.equals("")) {
				mien.setId(CommUtil.getID());
			}
			mien.setCreatetime(DateUtil.GetDate());
			mien.setUserid(DateUtil.getUserid());

			count =miendao.insertMienDao(mien);
			if(count > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("发布问答成功！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("发布问答失败！");
			}

		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("问答数据为空！");
		}
		return model;
	}
	
	
	//删除风采
	@Override
	public ResponseModel deleteIdMienService(Mien mien) {
		ResponseModel model = new ResponseModel();
		Mien mie = miendao.detailListMienDao(mien.getId());
		String userid =DateUtil.getUserid();
		if(mie==null) {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("风采数据为空！");
			return model;
		}
		if(!mie.getUserid().equals(userid)) {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("删除失败，数据归属有误！");
			return model;
		}
		Integer val =miendao.deleteIdMienDao(mien.getId());
		if(val ==1) {
			model.setCode("200");
			model.setResult("success");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("001");
			model.setMsg("删除一条风采成功！");
			return model;
		}else {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("删除一条问答失败！");
			return model;
		}
		
	}

	

	@Override
	public List<Mien> queryAllListMienService(Mien mien) {
		return miendao.queryAllListMienDao(mien);
	}

	
	@Override
	public Mien detailListMienDao(Mien mien) {
		
		return miendao.detailListMienDao(mien.getId());
	}


	@Override
	public List<Mien> commentListMienDao(Mien mien) {
		
		return miendao.commentListMienDao(mien.getId());
	}
	
	
	


	@Override
	public ResponseModel updateIdMienService(Mien mien) {
		ResponseModel model =new ResponseModel();
		Mien mie = miendao.detailListMienDao(mien.getId());
		String userid =DateUtil.getUserid();
		if(mie==null) {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("无此条数据，风采数据为空！");
			return model;
		}
		if(!mie.getUserid().equals(userid)) {
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("修改失败，数据归属有误！");
			return model;
		}
			Integer val = miendao.updateIdMienDao(mien);
			if(val ==1) {
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("修改一条风采成功！");
				return model;
			}else {
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("修改一条风采失败，出现未知错误！");
				return model;
			}
		
	}
	
	



}
