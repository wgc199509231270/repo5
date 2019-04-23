package com.OuSoft.system.service.performanceManagement.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.performanceManagement.PerformanceManageDao;
import com.OuSoft.system.dao.performanceManagement.PerformanceRankingDao;
import com.OuSoft.system.entity.Performanceparm;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import com.OuSoft.system.entity.queryusermodel;
import com.OuSoft.system.entity.tdepartType;
import com.OuSoft.system.service.performanceManagement.PerformanceManageService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Service
public class PerformanceManageServiceImpl implements PerformanceManageService{
	
	@Autowired
	PerformanceManageDao pfmmDao;
	
	@Autowired
	PerformanceRankingDao pfmrDao;
	
	
	//发布业绩
	@Override
	public ResponseModel insertPfmm(performance pfm){
//		Tsuser tuser=DateUtil.GetTsuser();
		ResponseModel responModel=new ResponseModel();
		if(pfm!=null){
			pfm.setId(CommUtil.getID());
			pfm.setUserid(DateUtil.getUserid());
			pfm.setCreatetime(DateUtil.GetDates());
			pfm.setPfmstate("01");
			//如果是发起人，所属父id不可以为空，设置成userid
			if(pfm.getPfmpid() == null || "".equals(pfm.getPfmpid())){
				pfm.setPfmpid(pfm.getId());
			}
			int i=pfmmDao.insertpfmm(pfm);
			if(i!=0){
				responModel.setCode("200");
				responModel.setResult("success");
				responModel.setTime(System.currentTimeMillis()+"");
				responModel.setToken("001");
				responModel.setMsg("发布业绩成功！");
			}else{
				responModel.setCode("404");
				responModel.setResult("fali");
				responModel.setTime(System.currentTimeMillis()+"");
				responModel.setToken("0053");
				responModel.setMsg("发布业绩失败！");
			}
		}else{
			responModel.setCode("404");
			responModel.setResult("tsuserweikong!");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("0053");
			responModel.setMsg("未传值！");
		}
		// TODO Auto-generated method stub
		return responModel;
	}

	//查询列表
	@Override
	public List<Performanceparm> queryPfmmList(Performanceparm pfm) {
		Tsuser tuser=DateUtil.GetTsuser();
		pfm.setTcmid(tuser.getUserpid());
		pfm.setDzuserid(tuser.getId());
		List<Performanceparm> list=pfmmDao.queryPfmmList(pfm);
		return list;
	}


	/**
	 * 确认业绩
	 */
	@Override
	public ResponseModel updpfmm(performance pfm){
		Tsuser tuser=DateUtil.GetTsuser();
		pfm.setTcmid(tuser.getUserpid());
		ResponseModel responModel=new ResponseModel();
		if(pfm.getPfmachieveplan() == null){
			pfm.setPfmachieveplan("0%");
		}
			if(pfm.getPfmachieveplan().equals("100%")){
				pfm.setPfmstate("04");
			}
		if(pfm.getRealitypfm()!=null){
			DecimalFormat df=new DecimalFormat("0.00");
			int i=Integer.parseInt(pfm.getRealitypfm().trim());
			int j=Integer.parseInt(pfm.getRealityworkhours().trim());
				String b=df.format((float)i/j);
				pfm.setRealityefficient(b);
		}
		if(pfm.getPfmstate().equals("02")){
			pfm.setPfmaffirmtime(DateUtil.GetDates());
		}else if(pfm.getPfmstate().equals("03")){
			pfm.setPfmaffirmtime(DateUtil.GetDates());
		}else if(pfm.getPfmstate().equals("05")){
			pfm.setPfmaudittime(DateUtil.GetDates());
			//审核人id
			pfm.setPfmauditid(DateUtil.getUserid());
		}
		int i=pfmmDao.updpfmm(pfm);
		if(i!=0){
			responModel.setCode("200");
			responModel.setResult("success");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("001");
			responModel.setMsg("修改成功！");
		}else{
			responModel.setCode("404");
			responModel.setResult("fali");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("0053");
			responModel.setMsg("修改失败！");
		}
		return responModel;
	}

	@Override
	public List<Tdepartmentinfo> queryTsdepart(String state,String id) {
		Tsuser tuser=DateUtil.GetTsuser();
		
		List<Tdepartmentinfo> list=pfmmDao.queryTsdepart(state,id,tuser.getUserpid());
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<performance> queryTopAll(String id) {
		Tsuser tuser=DateUtil.GetTsuser();
		
		// TODO Auto-generated method stub
		return pfmmDao.queryTopAll(id,tuser.getUserpid());
	}

	@Override
	public ResponseModel deletePerFor(String id) {
		ResponseModel responModel=new ResponseModel();
		int i=pfmmDao.deletePerFor(id);
		if(i!=0){
			responModel.setCode("200");
			responModel.setResult("success");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("001");
			responModel.setMsg("删除成功！");
		}else{
			responModel.setCode("404");
			responModel.setResult("fali");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("0053");
			responModel.setMsg("删除失败！");
		}
		// TODO Auto-generated method stub
		return responModel;
	}

	@Override
	public List<performance> selectPerformanceListService(performance pfm) {
		return pfmmDao.selectPerformanceListDao(pfm);
	}

	@Override
	public List<queryusermodel> queryuserList(String id) {
		Tsuser tuser=DateUtil.GetTsuser();
		
		// TODO Auto-generated method stub
		return pfmmDao.queryuserList(id,tuser.getUserpid());
	}

	@Override
	public List<Tsuser> querydepartuser(String id) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tsuser> list=new ArrayList<Tsuser>();
		if(id != "" && id !=null){
			//用户id，公司id
			List<tdepartType> model=pfmrDao.querytdepart(id,tuser.getUserpid());
			//截取部门id，公司id，查询当前用户的epid
			if(model != null){
				list=pfmmDao.querydepartuser(model.get(0).getDeparepid().substring(0, 6),tuser.getUserpid());
			}else{
				list = null;
			}
		}else {
			//用户id，公司id ,查询当前用户的epid 
			List<tdepartType> model1=pfmrDao.querytdepart(DateUtil.getUserid(),tuser.getUserpid());
			//截取部门id，公司id
			if(model1 != null){
				list=pfmmDao.querydepartuser(model1.get(0).getDeparepid().substring(0, 6),tuser.getUserpid());
			}else{
				list = null;
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 *
	 *state
	审核：
	筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
	返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
	pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	业绩
	筛选条件：id:用户id人员，pfmstate:状态，deparid:部门，日期，开始时间：pfmstarttime,结束时间pfmendtime
	返回:tpranum:点赞数，comnum评论数，dz自己是否点赞，deparname:部门名称，username：此数据姓名
	pfmstate：状态，开始时间：pfmstarttime,结束时间pfmendtime，内容：pfmtext,pfmnumber:工作业绩 ,pfmworkhours:工作时长
	 */
	@Override
	public List<performance> querySHTperfromanceService(performance pfm) {
		List<performance> list = null;
		if(pfm != null){
			if("01".equals(pfm.getState())){
				//业绩01
				pfm.setUserid(DateUtil.getUserid());
				//用户deparepid
				Tsuser tuser = DateUtil.GetTsuser();
				//用户id，公司id。返回用户小组id等信息 
				List<tdepartType> model =pfmrDao.querytdepart(tuser.getId(),tuser.getUserpid());
				// 业绩管理：只能看到同部门下的人员。？？？？？？后期根据职位可以查看所有人员的.
				//如：根据角色或则职位来去掉这个条件pfm.setDeparepid(model.getDeparepid().substring(0,6));
				pfm.setDeparepid(model.get(0).getDeparepid().substring(0,6));
				System.out.println("截取后的epid为：  " + model.get(0).getDeparepid().substring(0,6));
				list = pfmmDao.queryYJTperfromanceDao(pfm);
			}else if("02".equals(pfm.getState())){
				//审核02
				pfm.setUserid(DateUtil.getUserid());
				list = pfmmDao.querySHTperfromanceDao(pfm);
			}else{
				System.out.println("状态不正确，值为： " + pfm.getState() );
			}
		}else{
			System.out.println("业绩审核下拉数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<performance> queryUserTperfromanceService(performance pfm) {
		return pfmmDao.queryUserTperfromanceDao(pfm);
	}

	//业绩管理详情
	@Override
	public List<Performanceparm> queryPfmmListService(Performanceparm pfm) {
		Tsuser tuser=DateUtil.GetTsuser();
		pfm.setTcmid(tuser.getUserpid());
		pfm.setDzuserid(tuser.getId());
		List<Performanceparm> list=pfmmDao.queryPfmmListDao(pfm);
		// TODO Auto-generated method stub
		return list;
	}
}
