package com.OuSoft.system.service.Tmenuinfo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tmenuinfo.TmenuinfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tmenuinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tmenuinfo.TmenuinfoService;
import com.OuSoft.utils.DateUtil;

/**
 * 菜单
 * @author pengyueli
 * @date 2018年12月18日
 */
@Service
public class TmenuinfoImplService implements TmenuinfoService{
	
	@Autowired
	TmenuinfoDao dao;
	
	/**
	 * 新增
	 */
	@Override
	public ResponseModel saveTmenuinfoService(Tmenuinfo tmenuinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if( !DateUtil.getObjCheckIsNull(tmenuinfo) ){
			tmenuinfo.setId(DateUtil.getID());
			tmenuinfo.setMenutime(DateUtil.GetDates());
			//如果是主菜单，则设置成1zcd
			if(tmenuinfo.getMenuepid() == null || "".equals(tmenuinfo.getMenuepid()) ){
				tmenuinfo.setMenuepid("1zcd");
			}
			Tsuser tu = DateUtil.GetTsuser();
			//顶级公司id
			tmenuinfo.setMenupid(tu.getUserpid());
			num = dao.saveTmenuinfoDao(tmenuinfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增一条菜单信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增一条菜单信息失败！");
			}
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 查询
	 */
	@Override
	public List<Tmenuinfo> queryTmenuinfoService(Tmenuinfo tmenuinfo) {
		List<Tmenuinfo> list = null;
		Tsuser tsuser = DateUtil.GetTsuser();
		String pid = tsuser.getUserpid();
		if(!DateUtil.getObjCheckIsNull(tmenuinfo)){
			if("000".equals(pid)){
				//000便是平台管理员,查询主菜单
				if(tmenuinfo.getMenuepid() != null && !"".equals(tmenuinfo.getMenuepid())){
					//平台管理员查看子菜单
					list = dao.queryTmenuinfoDao(tmenuinfo);
				}else{
					//平台查看所有主菜单
					list = dao.queryPtTmenuinfoDao();
				}
			}else{
				//查询子菜单数据,
				if(tmenuinfo.getMenuepid() != null && !"".equals(tmenuinfo.getMenuepid()) ){
					tmenuinfo.setMenupid(pid);
					list = dao.queryTmenuinfoDao(tmenuinfo);
				//查询公司主菜单：,menuepid 公司id  , menupid:公司id
				}else{
					tmenuinfo.setMenuepid(pid);
					tmenuinfo.setMenupid(pid);
					list = dao.queryTmenuinfoDao(tmenuinfo);
				}
			}
		}else{
			System.out.println("数据为空！");
		}
		
		
		
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 删除菜单
	 */
	@Override
	public ResponseModel deleteTmenuinfoService(Tmenuinfo tmenuinfo) {
		int num = 0;
		ResponseModel remodel = new ResponseModel();
		if( !DateUtil.getObjCheckIsNull(tmenuinfo)){
			if(tmenuinfo.getId() !=null && !"".equals(tmenuinfo.getId())){
				num = dao.deleteTmenuinfoDao(tmenuinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除一条菜单信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除一条菜单信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("数据为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}
  
	
	
	

}
