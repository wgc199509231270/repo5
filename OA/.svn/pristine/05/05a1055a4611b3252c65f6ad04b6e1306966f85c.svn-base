package com.OuSoft.system.service.Tdepartmentinfo.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tdepartmentinfo.TdepartmentinfoDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.TreeTdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tdepartmentinfo.TdepartmentinfoService;
import com.OuSoft.utils.DateUtil;

@Service
public class TdepartmentinfoServiceImpl implements TdepartmentinfoService{

	
	@Autowired
	TdepartmentinfoDao dao;
	

	/**
	 * 树形结构，部门
	 */
	@Override
	public List<TreeTdepartmentinfo> querySXJGTdepartmentinfoService() {
		//获取用户pid,发送参数：pid
		Tsuser tu = DateUtil.GetTsuser();
		Tdepartmentinfo tdepartmentinfo = new Tdepartmentinfo();
		tdepartmentinfo.setDeparpid(tu.getUserpid());
		//查询部门
		List<Tdepartmentinfo> bm = dao.querySXJGBMTdepartmentinfoDao(tdepartmentinfo);
		System.out.println("部门： " + bm.size());
		//查询小组
		List<Tdepartmentinfo> xz = dao.querySXJGXZTdepartmentinfoDao(tdepartmentinfo);
		System.out.println("小组： " + xz.size());
		//封装好业务数据后返回给用户。
		//放入部门数据
		List nodes = new ArrayList<Tdepartmentinfo>();
		//遍历出部门
		for(Tdepartmentinfo modelbm : bm){
			TreeTdepartmentinfo mode = new TreeTdepartmentinfo();
			mode.setNodeid(modelbm.getId());
			mode.setText(modelbm.getDeparname());
			mode.setDeparepid(modelbm.getDeparepid());
			//放入组数据
			List nodess = new ArrayList<Tdepartmentinfo>();
			for(Tdepartmentinfo modelxz : xz){
				//是否是部门下的小组，部门下的epid和小组的epid相等
				if(modelbm.getDeparepid().equals(modelxz.getDeparepid().subSequence(0, 6))){
					//放入组
					Tdepartmentinfo modelx = new Tdepartmentinfo();
					modelx.setNodeid(modelxz.getId());
					modelx.setText(modelxz.getDeparname());
					modelx.setDeparepid(modelxz.getDeparepid());
					
					nodess.add(modelx);
					mode.setNodes(nodess);
				}
			}
			//装
			nodes.add(mode);
		}
//		model.add(nodes);
		// TODO Auto-generated method stub
		return nodes;
	}

	
	/**
	 * 部门信息
	 */
	@Override
	public List<Tdepartmentinfo> queryTdepartmentinfoService() {
		Tsuser tuser=DateUtil.GetTsuser();
		return dao.queryTdepartmentinfoDao(tuser.getUserpid());
	}
	
	
	/**
	 * 新增部门信息
	 * deparname：部门名称
		deparepid：增加部门小组时，根据部门小组deparepid添加 
		参数
		增加部门：deparname 部门名称 remark 备注
		增加组： 组名称，增加在哪个部门下deparepid
		remark：备注
	 * 参数：
 
	 */
	@Override
	public ResponseModel insertTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tdepartmentinfo)){
			tdepartmentinfo.setId(DateUtil.getID()); 
			tdepartmentinfo.setDepartime(DateUtil.GetDates());
			tdepartmentinfo.setDeparpid(DateUtil.GetTsuser().getUserpid());
			
			//1、判断部门deparepid有值则是创建组，无值则创建部门
			Tdepartmentinfo zdminfo = new Tdepartmentinfo();
			zdminfo.setDeparpid(DateUtil.GetTsuser().getUserpid());
			//deparepid有值则是创建组
			if(tdepartmentinfo.getDeparepid() != null){
				//创建组时，查询是否有组存在，没有则是001001001，有值则是查询最大取最大，然后加1再设置回去，
				List<Tdepartmentinfo> zlist = new ArrayList<Tdepartmentinfo>();
				zdminfo.setDeparepid(tdepartmentinfo.getDeparepid());
				zlist = dao.queryDepartmentDao(zdminfo);
				//判断是否为空，如果为空则是xxxxxx001，不为空则是取最大加1然后设置回去
				if(zlist.size() == 0){
					String zepid = tdepartmentinfo.getDeparepid()+"001";
					tdepartmentinfo.setDeparepid(zepid);
				}else{
					int z = Integer.valueOf(zlist.get(0).getDeparepid())+1;
					tdepartmentinfo.setDeparepid("00"+z);
				}
				System.out.println("创建组：  " + tdepartmentinfo.getDeparepid());
			//deparepid无值则是创建部门
			}else{
				//创建部门时，先查询是否有部门存在，没有则是001001，如果有部门存在则是取最大，然后加1再设置回去。
				List<Tdepartmentinfo> zlist = new ArrayList<Tdepartmentinfo>();
				zlist = dao.queryDepartmentDao(zdminfo);
				//判断list是否有值
				if(zlist.size() == 0){//无值，创建部门001001
					tdepartmentinfo.setDeparepid("001001");
				}else{
					int z = Integer.valueOf(zlist.get(0).getDeparepid())+1;
					tdepartmentinfo.setDeparepid("00"+z);
				}
				System.out.println("创建部门：  " + tdepartmentinfo.getDeparepid());
			}
			
			int num = dao.insertTdepartmentinfoDao(tdepartmentinfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("新增一条部门信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("新增一条部门信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("部门信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除部门信息
	 */
	@Override
	public ResponseModel deleteTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		if(tdepartmentinfo != null){
			int num = dao.deleteTdepartmentinfoDao(tdepartmentinfo);
			if(num > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条部门信息成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条部门信息失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("部门id为空，删除失败！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除用户部门信息
	 */
	@Override
	public ResponseModel deleteTuserByIdTdepartmentinfoService( Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		if(tdepartmentinfo != null){
			if( tdepartmentinfo.getUserid() != null && !"".equals(tdepartmentinfo.getUserid()) && tdepartmentinfo.getDeparid() != null && !"".equals(tdepartmentinfo.getDeparid())){
				int num = dao.deleteTuserByIdTdepartmentinfoDao(tdepartmentinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除一条用户部门信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除一条用户部门信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("部门必填参数为空，删除失败！");

			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("部门必填参数为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 新增用户部门信息
	 * userid 用户id
	 * deparid 部门id
	 *  
	 */
	@Override
	public ResponseModel InsertTuserByIdTdepartmentinfoService(
			Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tdepartmentinfo)){
			if( tdepartmentinfo.getUserid() != null && !"".equals(tdepartmentinfo.getUserid()) && tdepartmentinfo.getDeparid() != null && !"".equals(tdepartmentinfo.getDeparid())){
				tdepartmentinfo.setId(DateUtil.getID()); 
				int num = dao.InsertTuserByIdTdepartmentinfoDao(tdepartmentinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增一条用户部门信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("新增一条用户部门信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("部门必填参数为空，删除失败！");
			}
			
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("新增用户部门信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 修改用户部门信息
	 * @param tdepartmentinfo
	 * @return
	 */
	@Override
	public ResponseModel updateTuserByIdTdepartmentinfoService(Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		if(!DateUtil.getObjCheckIsNull(tdepartmentinfo)){
			if( tdepartmentinfo.getUserid() != null && !"".equals(tdepartmentinfo.getUserid()) && tdepartmentinfo.getDeparid() != null && !"".equals(tdepartmentinfo.getDeparid())){
				tdepartmentinfo.setId(DateUtil.getID());
				int num = dao.updateTuserByIdTdepartmentinfoDao(tdepartmentinfo);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("修改一条用户部门信息成功！");
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("修改一条用户部门信息失败！");
				}
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("部门必填参数为空，修改失败！");
			}

		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("修改用户部门信息为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 
	 * 查询用户部门信息.
	 * 接收：用户id:userid
	 * 返回 id:部门id, deparname:部门名称，departime:时间，userid:用户id,deparid:部门id
	 */
	@Override
	public List<Tdepartmentinfo> queryTuserByIdTdepartmentinfoService(
			Tdepartmentinfo tdepartmentinfo) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tdepartmentinfo> list = new ArrayList<Tdepartmentinfo>();
		if(tdepartmentinfo != null){
			if(tdepartmentinfo.getUserid() == null || tdepartmentinfo.getUserid().equals("") ){
				tdepartmentinfo.setUserid(tuser.getId());
			}
			list = dao.queryTuserByIdTdepartmentinfoDao(tdepartmentinfo);
		}else{
			list = null;
		}
		
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 * 小组下的人员，小组id
	 */
	@Override
	public List<Tdepartmentinfo> queryTdepartmentTuserService(Tsuser tsuser) {
		List<Tdepartmentinfo> list = null;
		if( tsuser !=null){
			list = dao.queryTdepartmentTuserDao(tsuser);
		}else{
			System.out.println("小组id为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 部门下的人员 ：deparepid:部门编号
	 * status:01是查询所有人的
	username : 姓名
	usernumber:编号
	 */
	@Override
	public List<Tdepartmentinfo> queryBMTdepartmentTuserService(Tsuser tsuser) {
		List<Tdepartmentinfo> list = null;
		if( tsuser !=null){
			System.out.println(" deparepid: " + tsuser.getDeparepid());
			list = dao.queryBMTdepartmentTuserDao(tsuser);
		}else{
			System.out.println("小部门编号为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


	/**
	 * 修改用户分配的小组信息userid:用户id
	deparid:小组id
	id：修改那条数据的id
	 */
	@Override
	public ResponseModel updateTdeparinfoByIdService(Tdepartmentinfo tdepartmentinfo) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(tdepartmentinfo != null){
			//只可以修改小组
			//获取用户pid,发送参数：pid
			Tsuser tu = DateUtil.GetTsuser();
			Tdepartmentinfo td = new Tdepartmentinfo();
			td.setDeparpid(tu.getUserpid());
			List<Tdepartmentinfo> list = dao.querySXJGXZTdepartmentinfoDao(td);
			//查看是否是小组id，否则不能修改
			for(Tdepartmentinfo info : list){
				if(info.getId().equals(tdepartmentinfo.getDeparid())){
					if( tdepartmentinfo.getId() != null && !"".equals(tdepartmentinfo.getId()) 
							&& tdepartmentinfo.getUserid() != null && !"".equals(tdepartmentinfo.getUserid())
							&& tdepartmentinfo.getDeparid() != null && !"".equals(tdepartmentinfo.getDeparepid()) ){
						num = dao.updateTdeparinfoByIdDao(tdepartmentinfo);
						if(num>0){
							remodel.setCode("200");
							remodel.setResult("success");
							remodel.setTime(System.currentTimeMillis()+"");
							remodel.setToken("001");
							remodel.setMsg("修改用户小组信息成功！");
						}else{
							remodel.setCode("404");
							remodel.setResult("fali");
							remodel.setTime(System.currentTimeMillis()+"");
							remodel.setToken("0053");
							remodel.setMsg("修改用户小组信息失败！");
						}
					}else{
						remodel.setCode("404");
						remodel.setResult("fali");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("0053");
						remodel.setMsg("必填参数为空！");
					}
				}else{
					remodel.setCode("404");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("请填入小组id ！");
				}
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("添加数据为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}


	@Override
	public List<Tdepartmentinfo> queryDeparepidService(
			Tdepartmentinfo tdepartmentinfo) {
		List<Tdepartmentinfo> list = null;
		if(tdepartmentinfo != null){
			list = dao.queryDeparepidDao(tdepartmentinfo);
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Tdepartmentinfo> queryIdService(Tdepartmentinfo tdepartmentinfo) {
		List<Tdepartmentinfo> list = null;
		if(tdepartmentinfo != null){
			list = dao.queryIdDao(tdepartmentinfo);
		}else{
			System.out.println("数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}


}
