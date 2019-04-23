package com.OuSoft.system.service.Tbuttonsinfo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tbuttonsinfo.TbuttonsinfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tbuttonsinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tbuttonsinfo.TbuttonsinfoService;
import com.OuSoft.utils.DateUtil;


/**
 * 按钮
 * @author pengyueli
 * @date 2018年12月20日
 */
@Service
public class TbuttonsinfoImplService implements TbuttonsinfoService{
	
	@Autowired
	TbuttonsinfoDao dao;

	/**
	 * 新增按钮
		buttonname按钮名称
		buttonmark按钮标识
		buttonimage图表
		buttonsort排序
		buttontext描述
		buttonpid顶级公司id
		buttonitemid按钮对应菜单id：必填
	 */
	@Override
	public ResponseModel saveTbuttoninfoService(Tbuttonsinfo tbuttoninfos) {
		ResponseModel remodel= new ResponseModel();
		int num = 0;
		if(tbuttoninfos != null){
			Tsuser tu = DateUtil.GetTsuser();
			tbuttoninfos.setButtonpid(tu.getUserpid());
			tbuttoninfos.setId(DateUtil.getID());
			tbuttoninfos.setButtontime(DateUtil.GetDates());
			num = dao.saveTbuttoninfoDao(tbuttoninfos);
			if(num>0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增按钮成功！");
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增按钮失败！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("按钮数据为空！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 查询按钮
	 * buttonitemid:按钮对应菜单id
	 */
	@Override
	public List<Tbuttonsinfo> queryTbuttoninfoService(Tbuttonsinfo tbuttoninfos) {
		List<Tbuttonsinfo> list = null;
		if(tbuttoninfos != null){
			if(tbuttoninfos.getButtonitemid() != null && !"".equals(tbuttoninfos.getButtonitemid())){
				Tsuser tsuser = DateUtil.GetTsuser();
				tbuttoninfos.setButtonpid(tsuser.getUserpid());
				list = dao.queryTbuttoninfoDao(tbuttoninfos);
			}else{
				System.out.println("对应菜单id为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 删除按钮
	 * id
	 */
	@Override
	public ResponseModel deleteTbuttoninfoService(Tbuttonsinfo tbuttoninfos) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(tbuttoninfos != null){
			if(tbuttoninfos.getId() != null && !"".equals(tbuttoninfos.getId())){
				num = dao.deleteTbuttoninfoDao(tbuttoninfos);
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除按钮成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除按钮失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除按钮id为空！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("删除按钮数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 修改按钮
	 * id:必传
	 * 其他修改数据：
	 * buttonname按钮名称
		buttonmark按钮标识
		buttonimage图表
		buttonsort排序
		buttontext描述
		buttonpid顶级公司id
		buttonitemid按钮对应菜单id
	 * 
	 */
	@Override
	public ResponseModel updateTbuttoninfoService(Tbuttonsinfo tbuttoninfos) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(tbuttoninfos != null){
			if(tbuttoninfos.getId() != null && !"".equals(tbuttoninfos.getId())){
				num = dao.updateTbuttoninfoDao(tbuttoninfos);
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("修改按钮成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("修改按钮失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("修改按钮id数据为空！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}
	
	
	
	
	
	
	

}
