package com.OuSoft.system.service.Troleinfo.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Troleinfo.TroleinfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tbuttonsinfo;
import com.OuSoft.system.entity.Tmenuinfo;
import com.OuSoft.system.entity.Tmenurole;
import com.OuSoft.system.entity.Troleinfo;
import com.OuSoft.system.entity.Trolemenubutton;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Troleinfo.TroleinfoService;
import com.OuSoft.utils.DateUtil;

@Service
public class TroleinfoImplService implements TroleinfoService{
	
	
	
	@Autowired
	TroleinfoDao dao;

	/**
	 * 查询列表角色
	 */
	@Override
	public List<Troleinfo> queryPidTroleinfoService(Troleinfo troleinfo) {
		List<Troleinfo> list = null;
		Tsuser tsuser = DateUtil.GetTsuser();
		String pid = tsuser.getUserpid();
		//平台管理员是pid:000.可以全查
		if( "000".equals(pid)){
			troleinfo.setRolepid(null);
			list = dao.queryPidTroleinfoDao(troleinfo);
		}else{
			//公司则查询本公司的角色信息
			troleinfo.setRolepid(pid);
			list = dao.queryPidTroleinfoDao(troleinfo);
		}
		// TODO Auto-generated method stub
		return list;
	}

	
	/**
	 * 新增角色
	 */
	@Override
	public ResponseModel saveTroleinfoService(Troleinfo troleinfo) {
		ResponseModel remodel = new ResponseModel();
		int num =0;
		if(!DateUtil.getObjCheckIsNull(troleinfo)){
			if( troleinfo.getRolename() != null && !"".equals(troleinfo.getRolename())){
				Tsuser tu = DateUtil.GetTsuser();
				//如果是平台管理员pid:000，则需要输入pid：必填,如果是公司人员则不需要输入公司pid
				if(tu.getUserpid().equals("000")){
					if(troleinfo.getRolepid() != null && !"".equals(troleinfo.getRolepid())){
						troleinfo.setRolepid(tu.getUserpid());
						troleinfo.setId(DateUtil.getID());
						troleinfo.setRoletime(DateUtil.GetDates());
						num = dao.saveTroleinfoDao(troleinfo);
					}else{
						remodel.setCode("400");
						remodel.setResult("fali");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("0053");
						remodel.setMsg("平台管理员请输入为那个公司添加角色。！");
					}
				}else{
					// 如果是公司人员则不需要输入公司pid,自动获取人员公司pid
					troleinfo.setRolepid(tu.getUserpid());
					troleinfo.setId(DateUtil.getID());
					troleinfo.setRoletime(DateUtil.GetDates());
					num = dao.saveTroleinfoDao(troleinfo);
				}
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增角色成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("新增角色失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("角色名称参数不正确！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("新增角色数据为空！！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
	 * 删除一个角色
	 */
	@Override
	public ResponseModel deleByIdTroleinfoService(Troleinfo troleinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(troleinfo)){
			if(troleinfo.getId() != null && !"".equals(troleinfo.getId())){
				dao.deleByIdTroleinfoDao(troleinfo);
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除角色成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除角色失败！！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("角色数据为空！！");
			}
			
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("删除角色数据为空！！");
		}
		
		return null;
	}

	
	/**
	 修改角色信息 
	rolename 角色名称
	remark 备注
	
	 */
	@Override
	public ResponseModel updateByidTroleinfoService(Troleinfo troleinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(troleinfo)){
			if( troleinfo.getRolename() != null && !"".equals(troleinfo.getRolename()) && 
					troleinfo.getId() != null && !"".equals(troleinfo.getId())){
				num = dao.updateByidTroleinfoDao(troleinfo);
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("修改角色成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("修改角色失败！");
				}
				
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("角色名称、主键为空！！");
			}
			
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
	 给用户分配角色
	 userid用户id
	 roleid角色id
	
	 */
	@Override
	public ResponseModel insertByidTroleinfotuserService(Troleinfo troleinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(troleinfo)){
			if(troleinfo.getUserid() != null && !"".equals(troleinfo.getUserid())
					&& troleinfo.getRoleid() != null && !"".equals(troleinfo.getRoleid())){
				troleinfo.setId(DateUtil.getID());
				num = dao.insertByidTroleinfotuserDao(troleinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("给用户分配角色成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("给用户分配角色失败！");
				}
				
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("用户和角色id为空！！");
			}
			
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
	给角色分配主菜单
	roleid 角色id
	menuid 主菜单id
	id 主键id
	 */
	@Override
	public ResponseModel insertByidTmenuinfoTuserService(Troleinfo troleinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(troleinfo)){
			if(troleinfo.getRoleid() != null && !"".equals(troleinfo.getRoleid())
					&& troleinfo.getMenuid() != null && !"".equals(troleinfo.getMenuid())){
				troleinfo.setId(DateUtil.getID());
				troleinfo.setId(DateUtil.getID());
				num = dao.insertByidTmenuinfoTuserDao(troleinfo);
				if(num>0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("给角色分配主菜单成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("给角色分配主菜单失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("角色，主菜单id为空！！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
	 * 给角色分配子菜单下的按钮：   roleid  角色id ，menuid	菜单id ，	buttonid	按钮id 
	 * 返回 ：信息 
	 */
	@Override
	public ResponseModel insertTrolemenubuttonService(Trolemenubutton trolemenubutton) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(trolemenubutton)){
			if(trolemenubutton.getRoleid() != null && !"".equals(trolemenubutton.getRoleid())
					&& trolemenubutton.getMenuid() != null && !"".equals(trolemenubutton.getMenuid())
						&& trolemenubutton.getButtonid() != null && !"".equals(trolemenubutton.getButtonid()) ){
				num = dao.insertTrolemenubuttonDao(trolemenubutton);
				if(num >0 ){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("给角色分配子菜单下的按钮成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg(" 给角色分配子菜单下的按钮失败!");
				}
				
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("必填为空！！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		
		
		
		// TODO Auto-generated method stub
		return remodel;
	}


	/**
		查询角色下的主菜单   roleid 角色id   后台已处理处理条件 menuepid = 1zcd
		返回：menuname 菜单名称 	menuurl  差点地址菜单排序 	menutime 时间 	menuinfo  菜单描述 menuimage  菜单图表 	remark 备注
	 */
	@Override
	public List<Tmenuinfo> queryByRoleidTrolemenubuttonService(Tmenurole tmenurole) {
		List<Tmenuinfo> list = new ArrayList<Tmenuinfo>();
		if(!DateUtil.getObjCheckIsNull(tmenurole) ){
			if(tmenurole.getRoleid() != null && !"".equals(tmenurole.getRoleid()) ){
				list = dao.queryByRoleidTrolemenubuttonDao(tmenurole);
			}else{
				System.out.println("必填参数为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 * 查询角色下主菜单下的子菜单        roleid	角色id , menuid 主菜单id 
	 * 返回：
	 * menuname	菜单名称 
		menuurl	菜单子菜单路径
		menusort	序号排列
		menutime	创建时间
		menuinfo	按钮描述
		remark	备注信息
		menuimage	图标
		menutype	菜单端
		menupid	顶级公司id
	 */
	@Override
	public List<Tmenuinfo> queryByMenuidTmenuinfoService(Tmenurole tmenurole) {
		List<Tmenuinfo> list = new ArrayList<Tmenuinfo>();
		if(!DateUtil.getObjCheckIsNull(tmenurole) ){
			if(tmenurole.getRoleid() != null && !"".equals(tmenurole.getRoleid()) 
					&& tmenurole.getMenuepid() != null && !"".equals(tmenurole.getMenuepid()) ){
				list = dao.queryByMenuidTmenuinfoDao(tmenurole);
			}else{
				System.out.println("必填参数为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 *
	 *		查询角色下子菜单下的按钮：
			 接：
			roleid  角色id
			menuid	菜单id
			返回：
			buttonname	按钮名称
			buttonmark	按钮标识
			buttontime	创建时间
			buttonimage	按钮图标
			buttonsort	按钮排序 
			buttontext	按钮说明 
			buttonpid	顶级公司id
	 */
	@Override
	public List<Tbuttonsinfo> queryByTrolemenuTbuttonService(Tmenurole tmenurole) {
		List<Tbuttonsinfo> list = new ArrayList<Tbuttonsinfo>();
		if(!DateUtil.getObjCheckIsNull(tmenurole)  ){
			if(tmenurole.getRoleid() != null && !"".equals(tmenurole.getRoleid()) 
					&& tmenurole.getMenuid() != null && !"".equals(tmenurole.getMenuid()) ){
				list = dao.queryByTrolemenuTbuttonDao(tmenurole);
			}else{
				System.out.println("必填参数为空！");
			}
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 *
	 *	删除给角色分配的按钮  
		roleid	角色id 	menuid	菜单id buttonid	按钮id 
		返回：信息  
	 */
	@Override
	public ResponseModel deleTrolemenubuttonService(Trolemenubutton trolemenubutton) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(trolemenubutton != null){
			if(trolemenubutton.getRoleid() != null && !"".equals(trolemenubutton.getRoleid()) 
					&& trolemenubutton.getMenuid() != null && !"".equals(trolemenubutton.getMenuid()) 
					&& trolemenubutton.getButtonid() != null && !"".equals(trolemenubutton.getButtonid()) ){
				num = dao.deleTrolemenubuttonDao(trolemenubutton);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除给角色分配的按钮  成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除给角色分配的按钮 失败 ！！");
				}
				
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("必填为空！！");
			}
			
			
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 	删除给角色分配的主菜单和子菜单 roleid	角色id ,menuid	菜单id 
		返回： 信息 
	 */
	@Override
	public ResponseModel deleTroleTmenuService(Tmenurole tmenurole) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(tmenurole) ){
			if(tmenurole.getRoleid() != null && !"".equals(tmenurole.getRoleid()) 
					&& tmenurole.getMenuid() != null && !"".equals(tmenurole.getMenuid()) ){
				num = dao.deleTroleTmenuDao(tmenurole);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除给角色分配的按钮  成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除给角色分配的按钮 失败 ！！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("必填为空！！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据为空！！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

}
