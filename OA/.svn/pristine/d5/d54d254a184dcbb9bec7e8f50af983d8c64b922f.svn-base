package com.OuSoft.system.service.attendance.Impl;

import com.OuSoft.system.dao.attendance.AttendanceDao;
import com.OuSoft.system.entity.Attendance;
import com.OuSoft.system.entity.AttendanceDesign;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdepartmentinfo;
import com.OuSoft.system.entity.Tjobinfo;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tdepartmentinfo.TdepartmentinfoService;
import com.OuSoft.system.service.Tjobinfo.TjobinfoService;
import com.OuSoft.system.service.attendance.AttendanceService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceImplService implements AttendanceService{

	@Autowired
	AttendanceDao dao;

	//岗位
	@Autowired
	TjobinfoService tjobinfoService;

	//部门
	@Autowired
	TdepartmentinfoService tdepartmentinfoService;


	//查询所有列表
	@Override
	public List<Attendance> queryService(Attendance attendance) {
		List<Attendance> list = null;
		list = dao.queryDao(attendance);
		return list;
	}


	/**
	 * 删除请假数据
	 * 参数id
	 *
	 */
	@Override
	public ResponseModel deAttendanceService(Attendance attendance) {
		ResponseModel model = new ResponseModel();
		int num;
		if(!DateUtil.getObjCheckIsNull(attendance)){
			if(attendance.getId() != null && !"".equals(attendance.getId())){
				num = dao.deAttendanceDao(attendance);
				if(num > 0){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("删除请假成功！！");
				}else{
					model.setCode("404");
					model.setResult("fali");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("0053");
					model.setMsg("删除请假信息失败！");
				}
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("请假id为空！");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("请假数据为空！");
		}
		// TODO Auto-generated method stub
		return model;
	}


//	/**
//	 * 修改请假数据
//	 * 接收：
//	 * id 请假id
//	 * userid : 请假人id
//	 * statetype : 审批状态 ：01已通过，02未通过、
//	 * timetype 类型 时间类型/01天/02时
//	 * duration 时长,时 天，根据时间类型分辨是天还是时
//	 *
//	 * state 最终审批状态，01已通过，02未通过、03审核中
//	 *
//	 */
//	@Override
//	public ResponseModel updateAttendacneService(Attendance attendance) {
//		ResponseModel model = new ResponseModel();
//		int num;
//		if(attendance != null){
//			if(attendance.getId() != null && !"".equals(attendance.getId()) &&
//					attendance.getUserid() != null && !"".equals(attendance.getUserid()) &&
//					attendance.getTimetype() != null && !"".equals(attendance.getTimetype()) &&
//					attendance.getDuration() != null && !"".equals(attendance.getDuration()) &&
//					attendance.getStatetype() != null && !"".equals(attendance.getStatetype())
//
//			){
//
//				Tsuser tuser = DateUtil.GetTsuser();
//				String timetype = attendance.getTimetype();//时间类型
//				int duration = Integer.valueOf(attendance.getDuration());//时长
//				String qjuserid = attendance.getUserid();//请假人id
////				String userid = DateUtil.getUserid();//当前登录人用户id
//				String userdeparepid = "";//请假人deparepid部门信息
//				String userdeparid = "";//请假人部门id
//				String userdeid = "";//请假人岗位id
//				String piddeparid = "";//公司在部门中的部门id为
//				String epid = "";//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
//				String tjobnum = "";//组长标识,如果= tjobnum03 则是有组长
//				String zjluserid = "";//请假人总经理id
//				String bmjluserid = "";//请假人部门经理id
//				int usertjobnum = 0;//请假人岗位等级01部门经理，02副经理，03组长，04成员
//
//				//查询请假人用户部门
//				Tdepartmentinfo tdepartmentinfos = new Tdepartmentinfo();
//				tdepartmentinfos.setUserid(qjuserid);//请假人id
//				List<Tdepartmentinfo> list = tdepartmentinfoService.queryTuserByIdTdepartmentinfoService(tdepartmentinfos);
//				if(list != null){
//					//获取第一个数据的deparepid截取6位并查询部门id
//					Tdepartmentinfo demodel = list.get(0);
//					userdeparepid = demodel.getDeparepid().substring(0, tuser.getUserpid().length() + 3);//当前用户部门信息
//					System.out.println(" 请假人用户部门信息deparepid信息 : " + userdeparepid);
//					//查询出部门id，因为存在组，所以再通过deparepid查询部门id
//					List<Tdepartmentinfo> lists = null;
//					demodel.setDeparepid(userdeparepid);
//					//通过depaepid查询请假人用户部门id
//					lists = tdepartmentinfoService.queryDeparepidService(demodel);
//					if(lists!=null){
//						//查询出请假人部门id
//						userdeparid = lists.get(0).getId();
//					}else{
//						System.out.println("通过deparepid查询部门id信息为空!");
//					}
//				}else{
//					System.out.println("部门信息为空！");
//				}
//
//				//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
//				epid = tuser.getUserpid()+"001";
//				System.out.println("用户userpid " + epid);
//				//查询部门中（公司）的部门id,通过deparepid
//				List<Tdepartmentinfo> listmodel = null;
//				Tdepartmentinfo listmo = new Tdepartmentinfo();
//				System.out.println("公司在部门中的deparepid 为： " + epid);
//				listmo.setDeparepid(epid);
//				//通过depaepid查询当前用户部门id
//				listmodel = tdepartmentinfoService.queryDeparepidService(listmo);
//				//公司在部门中的部门id为
//				piddeparid = listmodel.get(0).getId();
//				System.out.println("公司在部门中的部门id为： " + piddeparid);
//
//				//公司以下层，岗位 jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
//				//1、查询请假人的岗位等级（），如果是成员04则提交给组长，如果是组长则提交给部门经理，如果是部门经理，则提交给总经理。
//				Tjobinfo tjobinfouserid = new Tjobinfo();
//				tjobinfouserid.setUserid(qjuserid);//传请假人id
//				List<Tjobinfo> usertjoblist = tjobinfoService.queryTuserByIdTjobinfoService(tjobinfouserid);
//				Tjobinfo userjob = usertjoblist.get(0);
//				usertjobnum = Integer.valueOf(userjob.getJobnum());//请假人岗位等级01部门经理，02副经理，03组长，04成员
//				//请假人岗位id
//				userdeid = userjob.getId();
//				System.out.println("用户岗位信息等级信息 ：用户岗位id信息：  " + usertjobnum +"  :  " + userdeid);
//				//请假人部门下岗位的所有等级信息
//				Tjobinfo t = new Tjobinfo();
//				t.setDeparid(userdeparid);
//				List<Tjobinfo> usertjob = tjobinfoService.queryTjobinfoService(t);
//				//1.0循环出这当前用户部门下所有岗位信息，并且提交给组长，如果是组长则提交给经理，如果是经理则提交给总经理。
//				//1.1.如果当前用户是成员则提交给03组长，是组长则提交给02部门经理，是部门经理提交给总经理（已做处理，都是部门以下等级）
//				for(Tjobinfo tjobinfo : usertjob){
//					if(tjobinfo.getJobnum().equals("03")){
//						tjobnum = "tjobnum03";//组长标识
//						break;
//					}
//				}
//
//				//总经理id
//				Tjobinfo tjobsz = new Tjobinfo();
//				Tsuser tsuserz = new Tsuser();
//				Tsuser infoz = null;
//				tjobsz.setDeparid(piddeparid);//公司在部门中的部门deparepid
//				//再通过部门id和等级jobnum 条件: 部门id , jobnum = 02 是总经理岗位，
//				tjobsz.setJobnum("02");//总经理等级
//				List<Tjobinfo> usertjobsz = tjobinfoService.queryTjobinfoService(tjobsz);
//				String jobidz = usertjobsz.get(0).getId();//总经理岗位id
//				//再通过岗位id查询总经理是谁
//				tsuserz.setJobid(jobidz);
//				List<Tsuser> tsusersz = tjobinfoService.queryJobidTuserService(tsuserz);
//				infoz = tsusersz.get(0);//部门经理信息 ,
//				zjluserid = infoz.getId();//总经理id
//				System.out.println("请假人总经理id 为 ：" +  zjluserid);
//
//				//部门经理id
//				Tjobinfo tjobsbm = new Tjobinfo();
//				Tsuser tsuserbm = new Tsuser();
//				Tsuser infobm = null;
//				//查询部门经理是谁，通过岗位id,条件是 等级是  =  01  是部门经理等级
//				tjobsbm.setDeparid(userdeparid);
//				tjobsbm.setJobnum("01");
//				List<Tjobinfo> usertjobsbm = tjobinfoService.queryTjobinfoService(tjobsbm);
//				String jobidbm = usertjobsbm.get(0).getId();//部门经理岗位id
//				//2，再查询部门级经理是谁,信息
//				tsuserbm.setJobid(jobidbm);
//				List<Tsuser> tsusersbm = tjobinfoService.queryJobidTuserService(tsuserbm);
//				infobm = tsusersbm.get(0);//部门经理信息
//				//部门经理id
//				bmjluserid = infobm.getId();
//				System.out.println("请假人部门经理id 为 ：" +  bmjluserid);
//
//				// 先判断组长、部门经理、总经理、那个有值。且是一天的。通过下一级的id是否为空判断。是直接审批过来，还是提上来的。
//				// 如果下一级id为空，则是直接需要审批。直接审批时，如果是1天则直接审批。如果是2-3天则需要提交给总经理。如果是3天以上则是总经理直接审批
//				// 如果下一级id不为空。则是提上来的。判断下一级的审核状态是否为01审批通过。是则可以进行审批，不是01审批通过则不能进行审批.1天则直接审批通过，2-3天则需要部门经理，3天以上需要总经理审批
//				//-----------------------------------------------------------------------------
//				//查询出公司设计请假有几个等级。对应的天数是多少
//				List<AttendanceDesign> attendancedesing = dao.queryAttendancedesignDao();
//				System.out.println("请假设计等级数为： " + attendancedesing.size());
//
//
//				//-----------------------------------------------------------------------------
//				//判断请假人是部门以下还是部门以上
//				if(!userdeparepid.equals(epid)){//不相同是部门以下级别
//					//判断请假人是否有组长职位
//					if(tjobnum.equals("tjobnum03")){//请假人部门下的岗位有组长岗位
//						//部门以下岗位有组长岗位
//						//请假人是成员岗位时请假
//						if( usertjobnum > 3 ){
//							//请假人请假为天数
//							if(timetype.equals("01")){
//								//请假人是成员请假天数为1天，因为有组长，所以组长直接修改状态。
//								if(duration == 1 ){
//									attendance.setState(attendance.getStatetype());//最终审批状态01通过02驳回03审核中
//									//请假人是成员，请假天数是2-3天，权限不够，需要提交给部门经理审批
//								}else if( duration > 1 && duration <= 3 ){
//									//1、请假人请假2-3天，组长权限不够。如果同意请假01，则再提交给部门经理。如果不同意请假则不需要再提交给部门经理
//									//判断部门经理是有值,没有部门经理id则说明组长驳回或则没审批，现在进行的是组长审批
//									if(attendance.getPartuserid() == null){
//										//组长正在审批中。审批状态通过，则提交给部门经理
//										//判断组长是否有值
//										if(attendance.getGroupuserid() == null){
//											System.out.println("组长id为空!");
//										}else{
//											if(attendance.getStatetype().equals("01")){
//												attendance.setGroupstate(attendance.getStatetype());//组长同意
//												attendance.setPartuserid(bmjluserid);//组长同意提交给部门经理
//											}else if(attendance.getStatetype().equals("02")){
//												//组长不同意则直接不同意，不需要提交上一级
//												attendance.setState(attendance.getStatetype());
//											}
//										}
//									}else{//因为请假人是成员，请假是2-3天。部门经理有值则直接审批
//										attendance.setState(attendance.getStatetype());
//									}
//								}else if(duration > 3){// 用户请假条数为3天以上，需要总经理审批
//									//判断总经理是否有值,没有值则是部门经理审批
//									if( attendance.getTotalmanagerid() == null){
//										//判断部门经理是否有值，如果没有值则是组长审批
//										if( attendance.getPartuserid() == null ){
//											//组长审批
//											if(attendance.getGroupuserid() == null  ){
//												System.out.println("组长id为空" + attendance.getGroupuserid());
//											}else{//组长审批状态01通过，02驳回
//												if(attendance.getStatetype().equals("01")){
//													//通过则提交给部门经理
//													attendance.setGroupstate(attendance.getStatetype());
//													attendance.setPartuserid(bmjluserid);//部门经理id
//												}else{
//													attendance.setGroupstate(attendance.getStatetype());
//												}
//											}
//										}else{//部门经理有值则是审批
//											if(attendance.getStatetype().equals("01")){//部门经理审批为01则是通过，则需要总经理审批
//												attendance.setPartstate(attendance.getStatetype());
//												attendance.setTotalmanagerid(zjluserid);//总经理id
//											}else if(attendance.getStatetype().equals("02")){//为02则是驳回，不需要审批
//												attendance.setState(attendance.getStatetype());
//											}
//										}
//
//									}else{//如果总经理有值，则直接审批
//										attendance.setState(attendance.getStatetype());
//									}
//								}
//
//							//请假人请假为小时,则直接审批
//							}else if(timetype.equals("02")) {
//								attendance.setState(attendance.getStatetype());
//							}else{
//								System.out.println("时间类型错误");
//							}
//						}else if(usertjobnum >= 3 || usertjobnum < 1 ){//请假人是组长或则副经理需要部门经理审批
//							//请假人是组长或副经理
//							if(timetype.equals("01")){//请假为天数
//								//请假人是组长或副经理，请假天数为1天，直接修改状态。
//								if(duration == 1 ){
//									attendance.setState(attendance.getStatetype());//最终审批状态01通过02驳回03审核中
//								//请假人是组长或副经理，1天以上，权限不够，需要提交给总经理审批
//								}else if( duration > 1 ){
//									//判断总经理是否审批,空则是没有审批
//									if(attendance.getTotalmanagerid() == null){
//										//部门经理审批
//										if(attendance.getPartuserid() == null){//部门经理为空则是有错
//											System.out.println("部门经理id为空！");
//										}else if(attendance.getPartuserid() != null){
//											//部门经理审批
//											if(attendance.getStatetype().equals("01")){//部门经理01则是通过
//												attendance.setPartstate(attendance.getStatetype());//通过则是提交给总经理审批
//												attendance.setTotalmanagerid(zjluserid);
//											}else if(attendance.getStatetype().equals("02")){//不通过02则是直接审批
//												attendance.setState(attendance.getStatetype());
//											}
//										}
//									}else{
//										//不位空则是总经理直接审批
//										attendance.setState(attendance.getStatetype());
//									}
//								}
//								//请假人请假为小时,则直接审批
//							}else if(timetype.equals("02")) {
//								attendance.setState(attendance.getStatetype());
//							}else{
//								System.out.println("时间类型错误");
//							}
//
//						}else if(usertjobnum == 1){//请假人是部门经理则需要总经理审批
//							attendance.setState(attendance.getStatetype());
//						}
//					}else{//请假人部门下的岗位无组长岗位
//						//1、请假人是部门经理，则直接提交总经理
//						if( usertjobnum == 1 ){//是部门经理请假
//							attendance.setState(attendance.getStatetype());
//						}else if(usertjobnum > 1){//请假人是部门经理以下等级
//							if(attendance.getTimetype().equals("01")){//天和小时
//								//一天是部门经理，一天以上是总经理审批
//								if(duration == 1){//一天
//									attendance.setState(attendance.getStatetype());
//								}else if(duration > 1){//大于一天是总经理审批
//									//判断总经理是否审批,空则没有审批
//									if(attendance.getTotalmanagerid() == null){
//										//判断部门经理是否审批,空则是错误有值则是审批，并提交给总经理
//										if(attendance.getPartuserid() == null){
//											System.out.println("部门经理为空！无组长，部门经理以下等级");
//										}else{
//											if(attendance.getStatetype().equals("01")){
//												attendance.setPartstate(attendance.getStatetype());
//												attendance.setTotalmanagerid(bmjluserid);
//											}else if(attendance.getStatetype().equals("02")){
//												attendance.setState(attendance.getStatetype());
//											}else{
//												System.out.println("请假类型不正确！");
//											}
//										}
//									}else{//总经理id不为空则是审批
//										attendance.setState(attendance.getStatetype());
//									}
//
//								}
//							}else{//则是小时，直接审批
//								attendance.setState(attendance.getStatetype());
//							}
//						}
//					}
//				}else if(userdeparepid.equals(epid)) {//相同时，请假人是部门以上级别
//					//部门以上等级，只要有修改都是直接审批
//					attendance.setState(attendance.getStatetype());
//				}
//
//				//保存数据
//				num = dao.updateAttendacneDao(attendance);
//				if(num > 0){
//					model.setCode("200");
//					model.setResult("success");
//					model.setTime(System.currentTimeMillis()+"");
//					model.setToken("001");
//					model.setMsg("修改请假成功！！");
//				}else{
//					model.setCode("404");
//					model.setResult("fali");
//					model.setTime(System.currentTimeMillis()+"");
//					model.setToken("0053");
//					model.setMsg("修改请假信息失败！");
//				}
//			}else{
//				model.setCode("404");
//				model.setResult("fali");
//				model.setTime(System.currentTimeMillis()+"");
//				model.setToken("0053");
//				model.setMsg("时间类型、时长、请假id为空！");
//			}
//
//		}else{
//			model.setCode("404");
//			model.setResult("fali");
//			model.setTime(System.currentTimeMillis()+"");
//			model.setToken("0053");
//			model.setMsg("请假数据为空，失败！");
//		}
//
//
//		// TODO Auto-generated method stub
//		return model;
//	}

	/**
	 * 修改请假数据
	 * 接收：
	 * id 请假id
	 * userid : 请假人id
	 * statetype : 审批状态 ：01已通过，02未通过、
	 * timetype 类型 时间类型/01天/02时
	 * duration 时长,时 天，根据时间类型分辨是天还是时
	 *
	 * state 最终审批状态，01已通过，02未通过、03审核中
	 *
	 */
	@Override
	public ResponseModel updateAttendacneService(Attendance attendance) {
		ResponseModel model = new ResponseModel();
		int num;
		if(!DateUtil.getObjCheckIsNull(attendance)  ){
			if(attendance.getId() != null && !"".equals(attendance.getId()) &&
					attendance.getUserid() != null && !"".equals(attendance.getUserid()) &&
//					attendance.getTimetype() != null && !"".equals(attendance.getTimetype()) &&
					attendance.getDuration() != null && !"".equals(attendance.getDuration()) &&
					attendance.getStatetype() != null && !"".equals(attendance.getStatetype())

			){

				Tsuser tuser = DateUtil.GetTsuser();
//				String timetype = attendance.getTimetype();//时间类型
				int duration = Integer.valueOf(attendance.getDuration());//时长
				double durations = (double)(duration/8);//将小时转换为天数

//				System.out.println("保留一位小数后为： " + DateUtil.getDoubleFormats(durations));

				System.out.println("请假天数为： " + durations);
				String qjuserid = attendance.getUserid();//请假人id
//				String userid = DateUtil.getUserid();//当前登录人用户id
				String userdeparepid = "";//请假人deparepid部门信息
				String userdeparid = "";//请假人部门id
				String userdeid = "";//请假人岗位id
				String piddeparid = "";//公司在部门中的部门id为
				String epid = "";//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
				String tjobnum = "";//组长标识,如果= tjobnum03 则是有组长
				String zjluserid = "";//请假人总经理id
				String bmjluserid = "";//请假人部门经理id
				int usertjobnum = 0;//请假人岗位等级01部门经理，02副经理，03组长，04成员

				//查询请假人用户部门
				Tdepartmentinfo tdepartmentinfos = new Tdepartmentinfo();
				tdepartmentinfos.setUserid(qjuserid);//请假人id
				List<Tdepartmentinfo> list = tdepartmentinfoService.queryTuserByIdTdepartmentinfoService(tdepartmentinfos);
				if(list != null){
					//获取第一个数据的deparepid截取6位并查询部门id
					Tdepartmentinfo demodel = list.get(0);
					userdeparepid = demodel.getDeparepid().substring(0, tuser.getUserpid().length() + 3);//当前用户部门信息
					System.out.println(" 请假人用户部门信息deparepid信息 : " + userdeparepid);
					//查询出部门id，因为存在组，所以再通过deparepid查询部门id
					List<Tdepartmentinfo> lists = null;
					demodel.setDeparepid(userdeparepid);
					//通过depaepid查询请假人用户部门id
					lists = tdepartmentinfoService.queryDeparepidService(demodel);
					if(lists!=null){
						//查询出请假人部门id
						userdeparid = lists.get(0).getId();
					}else{
						System.out.println("通过deparepid查询部门id信息为空!");
					}
				}else{
					System.out.println("部门信息为空！");
				}

				//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
				epid = tuser.getUserpid()+"001";
				System.out.println("用户userpid " + epid);
				//查询部门中（公司）的部门id,通过deparepid
				List<Tdepartmentinfo> listmodel = null;
				Tdepartmentinfo listmo = new Tdepartmentinfo();
				System.out.println("公司在部门中的deparepid 为： " + epid);
				listmo.setDeparepid(epid);
				//通过depaepid查询当前用户部门id
				listmodel = tdepartmentinfoService.queryDeparepidService(listmo);
				//公司在部门中的部门id为
				piddeparid = listmodel.get(0).getId();
				System.out.println("公司在部门中的部门id为： " + piddeparid);

				//公司以下层，岗位 jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
				//1、查询请假人的岗位等级（），如果是成员04则提交给组长，如果是组长则提交给部门经理，如果是部门经理，则提交给总经理。
				Tjobinfo tjobinfouserid = new Tjobinfo();
				tjobinfouserid.setUserid(qjuserid);//传请假人id
				List<Tjobinfo> usertjoblist = tjobinfoService.queryTuserByIdTjobinfoService(tjobinfouserid);
				Tjobinfo userjob = usertjoblist.get(0);
				usertjobnum = Integer.valueOf(userjob.getJobnum());//请假人岗位等级01部门经理，02副经理，03组长，04成员
				//请假人岗位id
				userdeid = userjob.getId();
				System.out.println("用户岗位信息等级信息 ：用户岗位id信息：  " + usertjobnum +"  :  " + userdeid);
				//请假人部门下岗位的所有等级信息
				Tjobinfo t = new Tjobinfo();
				t.setDeparid(userdeparid);
				List<Tjobinfo> usertjob = tjobinfoService.queryTjobinfoService(t);
				//1.0循环出这当前用户部门下所有岗位信息，并且提交给组长，如果是组长则提交给经理，如果是经理则提交给总经理。
				//1.1.如果当前用户是成员则提交给03组长，是组长则提交给02部门经理，是部门经理提交给总经理（已做处理，都是部门以下等级）
				for(Tjobinfo tjobinfo : usertjob){
					if(tjobinfo.getJobnum().equals("03")){
						tjobnum = "tjobnum03";//组长标识
						break;
					}
				}

				//总经理id
				Tjobinfo tjobsz = new Tjobinfo();
				Tsuser tsuserz = new Tsuser();
				Tsuser infoz = null;
				tjobsz.setDeparid(piddeparid);//公司在部门中的部门deparepid
				//再通过部门id和等级jobnum 条件: 部门id , jobnum = 02 是总经理岗位，
				tjobsz.setJobnum("02");//总经理等级
				List<Tjobinfo> usertjobsz = tjobinfoService.queryTjobinfoService(tjobsz);
				String jobidz = usertjobsz.get(0).getId();//总经理岗位id
				//再通过岗位id查询总经理是谁
				tsuserz.setJobid(jobidz);
				List<Tsuser> tsusersz = tjobinfoService.queryJobidTuserService(tsuserz);
				infoz = tsusersz.get(0);//部门经理信息 ,
				zjluserid = infoz.getId();//总经理id
				System.out.println("请假人总经理id 为 ：" +  zjluserid);

				//部门经理id
				Tjobinfo tjobsbm = new Tjobinfo();
				Tsuser tsuserbm = new Tsuser();
				Tsuser infobm = null;
				//查询部门经理是谁，通过岗位id,条件是 等级是  =  01  是部门经理等级
				tjobsbm.setDeparid(userdeparid);
				tjobsbm.setJobnum("01");
				List<Tjobinfo> usertjobsbm = tjobinfoService.queryTjobinfoService(tjobsbm);
				String jobidbm = usertjobsbm.get(0).getId();//部门经理岗位id
				//2，再查询部门级经理是谁,信息
				tsuserbm.setJobid(jobidbm);
				List<Tsuser> tsusersbm = tjobinfoService.queryJobidTuserService(tsuserbm);
				infobm = tsusersbm.get(0);//部门经理信息
				//部门经理id
				bmjluserid = infobm.getId();
				System.out.println("请假人部门经理id 为 ：" +  bmjluserid);

				// 先判断组长、部门经理、总经理、那个有值。且是一天的。通过下一级的id是否为空判断。是直接审批过来，还是提上来的。
				// 如果下一级id为空，则是直接需要审批。直接审批时，如果是1天则直接审批。如果是2-3天则需要提交给总经理。如果是3天以上则是总经理直接审批
				// 如果下一级id不为空。则是提上来的。判断下一级的审核状态是否为01审批通过。是则可以进行审批，不是01审批通过则不能进行审批.1天则直接审批通过，2-3天则需要部门经理，3天以上需要总经理审批
				//-----------------------------------------------------------------------------
				//查询出公司设计请假有几个等级。对应的天数是多少
				List<AttendanceDesign> desing = dao.queryAttendancedesignDao();
				AttendanceDesign Design1 = desing.get(0);
				int startday1 = Integer.valueOf(Design1.getStartday());
				int endday1 = Integer.valueOf(Design1.getEndday());
				AttendanceDesign Design2 = desing.get(1);
				int startday2 = Integer.valueOf(Design2.getStartday());
				int endday2 = Integer.valueOf(Design2.getEndday());
				AttendanceDesign Design3 = desing.get(2);
				int startday3 = Integer.valueOf(Design3.getStartday());
				int endday3 = Integer.valueOf(Design3.getEndday());
				System.out.println("请假设计等级数为： " + desing.size());
				System.out.println("用户设置的三个等级天数为1：   " + startday1 + "  :   "  +endday1);
				System.out.println("用户设置的三个等级天数为2：   " + startday2 + "  :   "  +endday2);
				System.out.println("用户设置的三个等级天数为3：   " + startday3 + "  :   "  +endday3);
				System.out.println("请假人请假天数为：：   " + durations);
				//-----------------------------------------------------------------------------
				//请假类型改为天数
				System.out.println("天数 ： " + durations);

				//判断请假人是部门以下还是部门以上
				if(!userdeparepid.equals(epid)){//不相同是部门以下级别
					//判断请假人是否有组长职位
					if(tjobnum.equals("tjobnum03")){//请假人部门下的岗位有组长岗位
						//部门以下岗位有组长岗位
						//请假人是成员岗位时请假
						if( usertjobnum > 3 ){
								//请假人是成员请假天数为1天，因为有组长，所以组长直接修改状态。
								if(durations <= endday1 ){//请假天数   和   用户设置天数
									attendance.setState(attendance.getStatetype());//最终审批状态01通过02驳回03审核中
									//请假人是成员，请假天数是2-3天，权限不够，需要提交给部门经理审批
								}else if( durations >= startday2 && durations <= endday2 ){
									//1、请假人请假2-3天，组长权限不够。如果同意请假01，则再提交给部门经理。如果不同意请假则不需要再提交给部门经理
									//判断部门经理是有值,没有部门经理id则说明组长驳回或则没审批，现在进行的是组长审批
									if(attendance.getPartuserid() == null){
										//组长正在审批中。审批状态通过，则提交给部门经理
										//判断组长是否有值
										if(attendance.getGroupuserid() == null){
											System.out.println("组长id为空!");
										}else{
											if(attendance.getStatetype().equals("01")){
												attendance.setGroupstate(attendance.getStatetype());//组长同意
												attendance.setPartuserid(bmjluserid);//组长同意提交给部门经理
												attendance.setNucleususerid(bmjluserid);//当前审批人是谁
											}else if(attendance.getStatetype().equals("02")){
												//组长不同意则直接不同意，不需要提交上一级
												attendance.setState(attendance.getStatetype());
											}
										}
									}else{//因为请假人是成员，请假是2-3天。部门经理有值则直接审批
										attendance.setState(attendance.getStatetype());
									}
								}else if(durations >= startday3 && durations <= endday3){// 用户请假条数为3天以上，需要总经理审批
									//判断总经理是否有值,没有值则是部门经理审批
									if( attendance.getTotalmanagerid() == null||attendance.getTotalmanagerid() ==""){
										//判断部门经理是否有值，如果没有值则是组长审批
										if( attendance.getPartuserid() == null ||attendance.getPartuserid() ==""){
											//组长审批
											if(attendance.getGroupuserid() == null  ||attendance.getGroupuserid() == ""){
												System.out.println("组长id为空" + attendance.getGroupuserid());
											}else{//组长审批状态01通过，02驳回
												if(attendance.getStatetype().equals("01")){
													//通过则提交给部门经理
													attendance.setGroupstate(attendance.getStatetype());
													attendance.setPartuserid(bmjluserid);//部门经理id
													attendance.setNucleususerid(bmjluserid);//当前审批人是谁
												}else{
													attendance.setGroupstate(attendance.getStatetype());
												}
											}
										}else{//部门经理有值则是审批
											if(attendance.getStatetype().equals("01")){//部门经理审批为01则是通过，则需要总经理审批
												attendance.setPartstate(attendance.getStatetype());
												attendance.setTotalmanagerid(zjluserid);//总经理id
												attendance.setNucleususerid(zjluserid);//当前审批人是谁
											}else if(attendance.getStatetype().equals("02")){//为02则是驳回，不需要审批
												attendance.setState(attendance.getStatetype());
											}
										}

									}else{//如果总经理有值，则直接审批
										attendance.setState(attendance.getStatetype());
									}
								}

						}else if(usertjobnum >= 3 || usertjobnum < 1 ){//请假人是组长或则副经理需要部门经理审批
							//请假人是组长或副经理
								//请假人是组长或副经理，请假天数为1天，直接修改状态。
								if(durations <= endday1 ){
									attendance.setState(attendance.getStatetype());//最终审批状态01通过02驳回03审核中
								//请假人是组长或副经理，1天以上，权限不够，需要提交给总经理审批
								}else if( durations >= startday2 && durations <= endday2 ){
									//判断总经理是否审批,空则是没有审批
									if(attendance.getTotalmanagerid() == null){
										//部门经理审批
										if(attendance.getPartuserid() == null){//部门经理为空则是有错
											System.out.println("部门经理id为空！");
										}else if(attendance.getPartuserid() != null){
											//部门经理审批
											if(attendance.getStatetype().equals("01")){//部门经理01则是通过
												attendance.setPartstate(attendance.getStatetype());//通过则是提交给总经理审批
												attendance.setTotalmanagerid(zjluserid);
												attendance.setNucleususerid(zjluserid);
											}else if(attendance.getStatetype().equals("02")){//不通过02则是直接审批
												attendance.setState(attendance.getStatetype());
											}
										}
									}else{
										//不位空则是总经理直接审批
										attendance.setState(attendance.getStatetype());
									}
								}
						}else if(usertjobnum == 1){//请假人是部门经理则需要总经理审批
							attendance.setState(attendance.getStatetype());
						}
					}else{//请假人部门下的岗位无组长岗位
						//1、请假人是部门经理，则直接提交总经理
						if( usertjobnum == 1 ){//是部门经理请假
							attendance.setState(attendance.getStatetype());
						}else if(usertjobnum > 1){//请假人是部门经理以下等级
								//一天是部门经理，一天以上是总经理审批
								if(durations <= endday1){//一天
									attendance.setState(attendance.getStatetype());
								}else if(duration > endday1){//大于一天是总经理审批
									//判断总经理是否审批,空则没有审批
									if(attendance.getTotalmanagerid() == null){
										//判断部门经理是否审批,空则是错误有值则是审批，并提交给总经理
										if(attendance.getPartuserid() == null){
											System.out.println("部门经理为空！无组长，部门经理以下等级");
										}else{
											if(attendance.getStatetype().equals("01")){
												attendance.setPartstate(attendance.getStatetype());
												attendance.setTotalmanagerid(bmjluserid);
												attendance.setNucleususerid(bmjluserid);
											}else if(attendance.getStatetype().equals("02")){
												attendance.setState(attendance.getStatetype());
											}else{
												System.out.println("请假类型不正确！");
											}
										}
									}else{//总经理id不为空则是审批
										attendance.setState(attendance.getStatetype());
									}

								}
						}
					}
				}else if(userdeparepid.equals(epid)) {//相同时，请假人是部门以上级别
					//部门以上等级，只要有修改都是直接审批
					attendance.setState(attendance.getStatetype());
				}

				//保存数据
				num = dao.updateAttendacneDao(attendance);
				if(num > 0){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("修改请假成功！！");
				}else{
					model.setCode("404");
					model.setResult("fali");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("0053");
					model.setMsg("修改请假信息失败！");
				}
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("时间类型、时长、请假id为空！");
			}

		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("请假数据为空，失败！");
		}


		// TODO Auto-generated method stub
		return model;
	}


	/**
	 * 请假数据填写
	 * 必须是整数，小时
	 * 后台获取当前用户上一级领导的id,
	接收： ;userid:提交人id.后台获取
	atype;  //请假类型:01事，02病，03产，04婚，05丧，06年休
	astarttime;//开始时间
	aendtime;//结束时间
	timetype;//时间类型/01天/02时
	duration;///01天/02时，根据时间类型分辨是天还是时
	text;//请假事由
	filetext;//附件说明
	 *
	 */
	@Override
	public ResponseModel saveAttendanceService(Attendance attendance) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(attendance)){
			if(attendance.getTimetype() != null && attendance.getTimetype() != "" && attendance.getDuration() != null && attendance.getDuration() != "" ){
//				int duration = Integer.parseInt(attendance.getDuration());
				//判断请假天数是1-3天，则权限不够，需要部门经理审批
	            //timetype：时间类型/01天/02时
				//duration时||天，根据时间类型分辨是天还是时

				//1查询当前用户的组长、部门经理，总经理。
				//2先查询用户所在部门（因为有的部门没有组，所以查询出部门信息后 ，通过deparepid为6位数等于deparepid相同的
				// 找出部门id）再通过部门id查询出部门下的所有岗位,jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
				//  查询总经理是谁，通过查询部门deparepid等于001001的部门（公司）id，再通过jobnum为01董事长，02总经理，03董经理助理
				//4如果请假一天则直接组长审批，没有组长则是部门经理审批，每个人的请假要提交给自己的上一级

				//1/查询用户部门id, 查询用户的deparpid(部门)，用作比较用户等级是部门下的还是公司下的岗位
				String userdeparid = "";
				String userdeparepid = "";
				Tsuser tuser = DateUtil.GetTsuser();
				//查询用户部门
				List<Tdepartmentinfo> list = tdepartmentinfoService.queryTuserByIdTdepartmentinfoService( new Tdepartmentinfo());
				if(list != null){
					//获取第一个数据的deparepid截取6位并查询部门id
					Tdepartmentinfo demodel = list.get(0);
					userdeparepid = demodel.getDeparepid().substring(0, tuser.getUserpid().length() + 3);//当前用户部门信息
					System.out.println(" 当前用户部门信息deparepid信息 : " + userdeparepid);
					//查询出部门id，因为存在组，所以再通过deparepid查询部门id
					List<Tdepartmentinfo> lists = null;
					demodel.setDeparepid(userdeparepid);
					//通过depaepid查询当前用户部门id
					lists = tdepartmentinfoService.queryDeparepidService(demodel);
					if(lists!=null){
						//查询出用户部门id
						userdeparid = lists.get(0).getId();
					}else{
						System.out.println("通过deparepid查询部门id信息为空!");
					}
				}else{
					System.out.println("部门信息为空！");
				}
				//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
				String epid = tuser.getUserpid()+"001";
				System.out.println("用户userpid " + epid);
				//查询部门中（公司）的部门id,通过deparepid
				List<Tdepartmentinfo> listmodel = null;
				Tdepartmentinfo listmo = new Tdepartmentinfo();
				System.out.println("公司在部门中的deparepid 为： " + epid);
				listmo.setDeparepid(epid);
				//通过depaepid查询当前用户部门id
				listmodel = tdepartmentinfoService.queryDeparepidService(listmo);
				//公司在部门中的部门id为
				String piddeparid = listmodel.get(0).getId();
				System.out.println("公司在部门中的部门id为： " + piddeparid);
				Tjobinfo mejob=new Tjobinfo();
				mejob.setUserid(attendance.getUserid());
				//公司以下层，岗位 jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
				//1、查询用户的岗位等级（），如果是成员04则提交给组长，如果是组长则提交给部门经理，如果是部门经理，则提交给总经理。
				List<Tjobinfo> usertjoblist = tjobinfoService.queryTuserByIdTjobinfoService(mejob);
				Tjobinfo userjob = usertjoblist.get(0);
				int usertjobnum = Integer.valueOf(userjob.getJobnum());//用户岗位等级01部门经理，02副经理，03组长，04成员
				//用户岗位id
				String  userdeid = userjob.getId();
				System.out.println("用户岗位信息等级信息 ：用户岗位id信息：  " + usertjobnum +"  :  " + userdeid);
				//用户部门下岗位的所有等级信息
				Tjobinfo t = new Tjobinfo(); t.setDeparid(userdeparid);
				List<Tjobinfo> usertjob = tjobinfoService.queryTjobinfoService(t);
				//1.0循环出这当前用户部门下所有岗位信息，并且提交给组长，如果是组长则提交给经理，如果是经理则提交给总经理。
				//1.1.如果当前用户是成员则提交给03组长，是组长则提交给02部门经理，是部门经理提交给总经理（已做处理，都是部门以下等级）
				String tjobnum = "";//组长标识
				for(Tjobinfo tjobinfo : usertjob){
					if(tjobinfo.getJobnum().equals("03")){
						tjobnum = "tjobnum03";//组长标识
						break;
					}
				}
				//总经理id
				String zjluserid = "";
				//总经理id
				Tjobinfo tjobsz = new Tjobinfo();
				Tsuser tsuserz = new Tsuser();
				Tsuser infoz = null;
				tjobsz.setDeparid(piddeparid);//公司在部门中的部门deparepid
				//再通过部门id和等级jobnum 条件: 部门id , jobnum = 02 是总经理岗位，
				tjobsz.setJobnum("02");//总经理等级
				List<Tjobinfo> usertjobsz = tjobinfoService.queryTjobinfoService(tjobsz);
				String jobidz = usertjobsz.get(0).getId();//总经理岗位id
				//再通过岗位id查询总经理是谁
				tsuserz.setJobid(jobidz);
				List<Tsuser> tsusersz = tjobinfoService.queryJobidTuserService(tsuserz);
				infoz = tsusersz.get(0);//部门经理信息 ,
				zjluserid = infoz.getId();//总经理id
				System.out.println("总经理id 为 ：" +  zjluserid);

				//部门经理id
				Tjobinfo tjobsbm = new Tjobinfo();
				Tsuser tsuserbm = new Tsuser();
				Tsuser infobm = null;
				//查询部门经理是谁，通过岗位id,条件是 等级是  =  01  是部门经理等级
				tjobsbm.setDeparid(userdeparid);
				tjobsbm.setJobnum("01");
				List<Tjobinfo> usertjobsbm = tjobinfoService.queryTjobinfoService(tjobsbm);
				String jobidbm = usertjobsbm.get(0).getId();//部门经理岗位id
				//2，再查询部门级经理是谁,信息
				tsuserbm.setJobid(jobidbm);
				List<Tsuser> tsusersbm = tjobinfoService.queryJobidTuserService(tsuserbm);
				infobm = tsusersbm.get(0);//部门经理信息
				//部门经理id
				String bmjluserid = infobm.getId();

				//判断请假人是部门以下的还是部门以上的等级
				//不相同则是部门以下等级
				if(!userdeparepid.equals(epid)){

					//判断岗位是否有组长,有组长岗位
						if( tjobnum.equals("tjobnum03")){
							//判断当前用户是什么岗位，04成员，03组长，02副经理，01部门经理
							if(usertjobnum > 3 ){//用户是04成员则提交给组长03
								//查询组长是谁，通过用户岗位（userdeid）id查询,条件，jobnum=03 , jobid = userdeid,用户岗位关联表=岗位id
								//岗位id,等级是03
								//1先查询组长岗位信息
								//用户部门下岗位的所有等级信息
								//通过用户部门id查询组长，部门经理，总经理是谁
								Tjobinfo tjobs = new Tjobinfo();
								Tsuser tsuser = new Tsuser();
								Tsuser info = null;
								tjobs.setDeparid(userdeparid);//用户部门id
								tjobs.setJobnum("03");//组等级
								List<Tjobinfo> usertjobs = tjobinfoService.queryTjobinfoService(tjobs);
								String jobid = usertjobs.get(0).getId();//组长岗位id
								//2，再查询组长是谁,组长信息

								tsuser.setJobid(jobid);
								List<Tsuser> tsusers = tjobinfoService.queryJobidTuserService(tsuser);
								info = tsusers.get(0);//组长信息
								//将组长id存在请假信息中（组长id）
								attendance.setGroupuserid(info.getId());
								attendance.setNucleususerid(info.getId());

							}else if(usertjobnum >= 3 || usertjobnum < 1 ){//如果用户是组长和副经理，则提交给部门经理
								attendance.setGroupuserid(bmjluserid);
								attendance.setNucleususerid(bmjluserid);
							}else if( usertjobnum == 1 ){// 部门经理 则提交给总经理
								//将总经理id放入请假中
								attendance.setGroupuserid(zjluserid);
								attendance.setNucleususerid(zjluserid);
							}

						//无组长岗位
						}else{
							//判断用户是否是部门经理
							if(usertjobnum > 1){//不是部门经理，提交给部门经理
								attendance.setGroupuserid(bmjluserid);
								attendance.setNucleususerid(bmjluserid);

							}else if( usertjobnum == 1){//是部门经理则交给总经理
								attendance.setGroupuserid(zjluserid);
								attendance.setNucleususerid(zjluserid);
							}
						}

				}else{//相同则是部门以上等级，
					//只有总经理以下需要审批请假，总经理及以上不需要申请
					if(usertjobnum < 2){
						attendance.setGroupuserid(zjluserid);
						attendance.setNucleususerid(zjluserid);
					}
				}
			}else{
				System.out.println("时间类型和时长为空  ！  ");
			}

			if(attendance.getGroupuserid() != "" || attendance.getGroupuserid() != null ||
					attendance.getPartuserid() != "" || attendance.getPartuserid() != null ||
							attendance.getTotalmanagerid() != "" || attendance.getTotalmanagerid() != null){
				//添加请假信息
				int dura = Integer.valueOf(attendance.getDuration());//时长
				if(attendance.getTimetype().equals("01")){//01十天，乘以8
					attendance.setDuration(dura*8+"");
				}else if(attendance.getTimetype().equals("02")){
					attendance.setDuration(attendance.getDuration());
				}else{
					System.out.println("时间类型错误！");
				}
				attendance.setCreatetime(DateUtil.GetDates());
				attendance.setState("03");//第一次提交是审核中
				attendance.setUserid(DateUtil.getUserid());//申请人id

				num = dao.saveAttendanceDao(attendance);
			}

			if(num > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("新增请假成功！！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("新增请假信息失败！");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("请假数据为空，新增失败！");
		}
		// TODO Auto-generated method stub
		return model;
	}

//	/**
//	 * 请假数据填写
//	 * 必须是整数，小时
//	 *
//	 */
//	@Override
//	public ResponseModel saveAttendanceService(Attendance attendance) {
//		ResponseModel model = new ResponseModel();
//		int num = 0;
//		if(attendance != null){
//			if(attendance.getTimetype() != null && attendance.getTimetype() != "" && attendance.getDuration() != null && attendance.getDuration() != "" ){
////				int duration = Integer.parseInt(attendance.getDuration());
//				//判断请假天数是1-3天，则权限不够，需要部门经理审批
//	            //timetype：时间类型/01天/02时
//				//duration时||天，根据时间类型分辨是天还是时
//
//				//1查询当前用户的组长、部门经理，总经理。
//				//2先查询用户所在部门（因为有的部门没有组，所以查询出部门信息后 ，通过deparepid为6位数等于deparepid相同的
//				// 找出部门id）再通过部门id查询出部门下的所有岗位,jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
//				//  查询总经理是谁，通过查询部门deparepid等于001001的部门（公司）id，再通过jobnum为01董事长，02总经理，03董经理助理
//				//4如果请假一天则直接组长审批，没有组长则是部门经理审批，每个人的请假要提交给自己的上一级
//
//				//1/查询用户部门id, 查询用户的deparpid(部门)，用作比较用户等级是部门下的还是公司下的岗位
//				String userdeparid = "";
//				String userdeparepid = "";
//				Tsuser tuser = DateUtil.GetTsuser();
//				//查询用户部门
//				List<Tdepartmentinfo> list = tdepartmentinfoService.queryTuserByIdTdepartmentinfoService( new Tdepartmentinfo());
//				if(list != null){
//					//获取第一个数据的deparepid截取6位并查询部门id
//					Tdepartmentinfo demodel = list.get(0);
//					userdeparepid = demodel.getDeparepid().substring(0, tuser.getUserpid().length() + 3);//当前用户部门信息
//					System.out.println(" 当前用户部门信息deparepid信息 : " + userdeparepid);
//					//查询出部门id，因为存在组，所以再通过deparepid查询部门id
//					List<Tdepartmentinfo> lists = null;
//					demodel.setDeparepid(userdeparepid);
//					//通过depaepid查询当前用户部门id
//					lists = tdepartmentinfoService.queryDeparepidService(demodel);
//					if(lists!=null){
//						//查询出用户部门id
//						userdeparid = lists.get(0).getId();
//					}else{
//						System.out.println("通过deparepid查询部门id信息为空!");
//					}
//				}else{
//					System.out.println("部门信息为空！");
//				}
//				//公司：部门中公司的deparepid：先获取用户顶级公司id，后面追加001是顶级公司部门信息。
//				String epid = tuser.getUserpid()+"001";
//				System.out.println("用户userpid " + epid);
//				//查询部门中（公司）的部门id,通过deparepid
//				List<Tdepartmentinfo> listmodel = null;
//				Tdepartmentinfo listmo = new Tdepartmentinfo();
//				System.out.println("公司在部门中的deparepid 为： " + epid);
//				listmo.setDeparepid(epid);
//				//通过depaepid查询当前用户部门id
//				listmodel = tdepartmentinfoService.queryDeparepidService(listmo);
//				//公司在部门中的部门id为
//				String piddeparid = listmodel.get(0).getId();
//				System.out.println("公司在部门中的部门id为： " + piddeparid);
//
//				//公司以下层，岗位 jobnum 为 01部门经理 02部门副经理 03 组长（没有03就是没有组，）04是成员。
//				//1、查询用户的岗位等级（），如果是成员04则提交给组长，如果是组长则提交给部门经理，如果是部门经理，则提交给总经理。
//				List<Tjobinfo> usertjoblist = tjobinfoService.queryTuserByIdTjobinfoService(new Tjobinfo());
//				Tjobinfo userjob = usertjoblist.get(0);
//				int usertjobnum = Integer.valueOf(userjob.getJobnum());//用户岗位等级01部门经理，02副经理，03组长，04成员
//				//用户岗位id
//				String  userdeid = userjob.getId();
//				System.out.println("用户岗位信息等级信息 ：用户岗位id信息：  " + usertjobnum +"  :  " + userdeid);
//				//用户部门下岗位的所有等级信息
//				Tjobinfo t = new Tjobinfo(); t.setDeparid(userdeparid);
//				List<Tjobinfo> usertjob = tjobinfoService.queryTjobinfoService(t);
//				//1.0循环出这当前用户部门下所有岗位信息，并且提交给组长，如果是组长则提交给经理，如果是经理则提交给总经理。
//				//1.1.如果当前用户是成员则提交给03组长，是组长则提交给02部门经理，是部门经理提交给总经理（已做处理，都是部门以下等级）
//				String tjobnum = "";//组长标识
//				for(Tjobinfo tjobinfo : usertjob){
//					if(tjobinfo.getJobnum().equals("03")){
//						tjobnum = "tjobnum03";//组长标识
//						break;
//					}
//				}
//				//总经理id
//				String zjluserid = "";
//				//总经理id
//				Tjobinfo tjobsz = new Tjobinfo();
//				Tsuser tsuserz = new Tsuser();
//				Tsuser infoz = null;
//				tjobsz.setDeparid(piddeparid);//公司在部门中的部门deparepid
//				//再通过部门id和等级jobnum 条件: 部门id , jobnum = 02 是总经理岗位，
//				tjobsz.setJobnum("02");//总经理等级
//				List<Tjobinfo> usertjobsz = tjobinfoService.queryTjobinfoService(tjobsz);
//				String jobidz = usertjobsz.get(0).getId();//总经理岗位id
//				//再通过岗位id查询总经理是谁
//				tsuserz.setJobid(jobidz);
//				List<Tsuser> tsusersz = tjobinfoService.queryJobidTuserService(tsuserz);
//				infoz = tsusersz.get(0);//部门经理信息 ,
//				zjluserid = infoz.getId();//总经理id
//				System.out.println("总经理id 为 ：" +  zjluserid);
//
//				//部门经理id
//				Tjobinfo tjobsbm = new Tjobinfo();
//				Tsuser tsuserbm = new Tsuser();
//				Tsuser infobm = null;
//				//查询部门经理是谁，通过岗位id,条件是 等级是  =  01  是部门经理等级
//				tjobsbm.setDeparid(userdeparid);
//				tjobsbm.setJobnum("01");
//				List<Tjobinfo> usertjobsbm = tjobinfoService.queryTjobinfoService(tjobsbm);
//				String jobidbm = usertjobsbm.get(0).getId();//部门经理岗位id
//				//2，再查询部门级经理是谁,信息
//				tsuserbm.setJobid(jobidbm);
//				List<Tsuser> tsusersbm = tjobinfoService.queryJobidTuserService(tsuserbm);
//				infobm = tsusersbm.get(0);//部门经理信息
//				//部门经理id
//				String bmjluserid = infobm.getId();
//
//				//判断请假人是部门以下的还是部门以上的等级
//				//不相同则是部门以下等级
//				if(!userdeparepid.equals(epid)){
//
//					//判断岗位是否有组长,有组长岗位
//						if( tjobnum.equals("tjobnum03")){
//							//判断当前用户是什么岗位，04成员，03组长，02副经理，01部门经理
//							if(usertjobnum > 3 ){//用户是04成员则提交给组长03
//								//查询组长是谁，通过用户岗位（userdeid）id查询,条件，jobnum=03 , jobid = userdeid,用户岗位关联表=岗位id
//								//岗位id,等级是03
//								//1先查询组长岗位信息
//								//用户部门下岗位的所有等级信息
//								//通过用户部门id查询组长，部门经理，总经理是谁
//								Tjobinfo tjobs = new Tjobinfo();
//								Tsuser tsuser = new Tsuser();
//								Tsuser info = null;
//								tjobs.setDeparid(userdeparid);//用户部门id
//								tjobs.setJobnum("03");//组等级
//								List<Tjobinfo> usertjobs = tjobinfoService.queryTjobinfoService(tjobs);
//								String jobid = usertjobs.get(0).getId();//组长岗位id
//								//2，再查询组长是谁,组长信息
//
//								tsuser.setJobid(jobid);
//								List<Tsuser> tsusers = tjobinfoService.queryJobidTuserService(tsuser);
//								info = tsusers.get(0);//组长信息
//								//将组长id存在请假信息中（组长id）
//								attendance.setGroupuserid(info.getId());
//
//							}else if(usertjobnum >= 3 || usertjobnum < 1 ){//如果用户是组长和副经理，则提交给部门经理
//								attendance.setPartuserid(bmjluserid);
//
//							}else if( usertjobnum == 1 ){// 部门经理 则提交给总经理
//								//将总经理id放入请假中
//								attendance.setTotalmanagerid(zjluserid);
//							}
//
//						//无组长岗位
//						}else{
//							//判断用户是否是部门经理
//							if(usertjobnum > 1){//不是部门经理，提交给部门经理
//								attendance.setTotalmanagerid(bmjluserid);
//
//							}else if( usertjobnum == 1){//是部门经理则交给总经理
//								attendance.setTotalmanagerid(zjluserid);
//							}
//						}
//
//				}else{//相同则是部门以上等级，
//					//只有总经理以下需要审批请假，总经理及以上不需要申请
//					if(usertjobnum < 2){
//						attendance.setTotalmanagerid(zjluserid);
//					}
//				}
//			}else{
//				System.out.println("时间类型和时长为空  ！  ");
//			}
//
//			if(attendance.getGroupuserid() != "" || attendance.getGroupuserid() != null ||
//					attendance.getPartuserid() != "" || attendance.getPartuserid() != null ||
//							attendance.getTotalmanagerid() != "" || attendance.getTotalmanagerid() != null){
//				//添加请假信息
//				attendance.setCreatetime(DateUtil.GetDates());
//				attendance.setState("03");//第一次提交是审核中
//				attendance.setUserid(DateUtil.getUserid());//申请人id
//				attendance.setId(DateUtil.getID());//生成id
//				num = dao.saveAttendanceDao(attendance);
//			}
//
//			if(num > 0){
//				model.setCode("200");
//				model.setResult("success");
//				model.setTime(System.currentTimeMillis()+"");
//				model.setToken("001");
//				model.setMsg("新增请假成功！！");
//			}else{
//				model.setCode("404");
//				model.setResult("fali");
//				model.setTime(System.currentTimeMillis()+"");
//				model.setToken("0053");
//				model.setMsg("新增请假信息失败！");
//			}
//		}else{
//			model.setCode("404");
//			model.setResult("fali");
//			model.setTime(System.currentTimeMillis()+"");
//			model.setToken("0053");
//			model.setMsg("请假数据为空，新增失败！");
//		}
//		// TODO Auto-generated method stub
//		return model;
//	}

	//我的申请列表
	// 选项： 01我的申请，02我的审批
	@Override
	public List<Attendance> queryWdAttendanceService(Attendance attendance) {
		List<Attendance> list = null;
		String userid = DateUtil.getUserid();//当前登录用户id
		if(!DateUtil.getObjCheckIsNull(attendance)){
			if(!attendance.getType().equals("")){

				if(attendance.getType().equals("01")){ //请假管理，选项：我的申请
					attendance.setUserid(userid);
					System.out.println(userid +" :  请假人idid ");
					list = dao.queryWdAttendanceDao(attendance);
				}else if(attendance.getType().equals("02")){ //请假管理，选项：审批
					//查询
					attendance.setGroupuserid(userid);
					attendance.setPartuserid(userid);
					attendance.setTotalmanagerid(userid);
					list = dao.queryWdAttendanceDao(attendance);
				}else{
					System.out.println("请假类型值为空或错误！");
				}
			}else{
				System.out.println("必填type类型为空 ！ ");
			}
		}else{
			System.out.println("请假管理数据为空 ！ ");
		}



		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 根据id查询请假
	 * @param attendance
	 * @return
	 */
	@Override
	public List<Attendance> queryAttendanceByIdService(Attendance attendance) {
		return dao.queryAttendanceByIdDao(attendance);
	}


	/**
	 * 请假详情，接收请假id :id
	 */
	@Override
	public Attendance queryXQAttendanceService(Attendance attendance) {
		Attendance model = new Attendance();
		if(!DateUtil.getObjCheckIsNull(attendance) ){
			if(!attendance.getId().equals("")){
				model = dao.queryXQAttendanceDao(attendance);
			}else{
				System.out.println("请假id为空 ！");
			}

		}else{
			System.out.println("请假数据为空！");
		}

		// TODO Auto-generated method stub
		return model;
	}

	// --------------------------------------------分割线

	/**
	 * 请假设计表，查询
	 */
	@Override
	public List<AttendanceDesign> queryAttendancedesignService() {
		// TODO Auto-generated method stub
		return dao.queryAttendancedesignDao();
	}

	/**
	 * 请假设计表，修改
	 * 等级number不可修改
	 * 修改的参数：startday 开始天数 - endday 结束天数 remark 备注
	 */
	@Override
	public ResponseModel upAttendancedesignService(AttendanceDesign attendancedesign) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(attendancedesign) ){
			if(attendancedesign.getId() != null){
				num = dao.upAttendancedesignDao(attendancedesign);
				if(num > 0){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("修改请假设计成功！！");
				}else{
					model.setCode("404");
					model.setResult("fali");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("0053");
					model.setMsg("修改请假设计失败！");
				}
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("id为空，请从新修改！");
			}

		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("数据为空修改请假设计失败！");
		}
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 请假设计表，删除
	 * id
	 */
	@Override
	public ResponseModel deAttendancedesignService(AttendanceDesign attendancedesign) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(attendancedesign)){
			if(attendancedesign.getId() != null){
				num = dao.deAttendancedesignDao(attendancedesign);
				if(num > 0){
					model.setCode("200");
					model.setResult("success");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("001");
					model.setMsg("删除请假设计成功！！");
				}else{
					model.setCode("404");
					model.setResult("fali");
					model.setTime(System.currentTimeMillis()+"");
					model.setToken("0053");
					model.setMsg("删除请假设计失败！");
				}
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("id为空，请从新修改！");
			}

		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("数据为空删除请假设计失败！");
		}
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 请假设计表，新增
	 * 自给：createtime，pid
	 * 接收：
	 *  number 等级排序 	startday 开始天数 - endday 结束天数  	remark 备注
	 *
	 */
	@Override
	public ResponseModel saveAttendancedesignService(AttendanceDesign attendancedesign) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(attendancedesign) ){
			attendancedesign.setId(DateUtil.getID());
			attendancedesign.setCreatetime(DateUtil.GetDates());
			attendancedesign.setPid(DateUtil.GetTsuser().getUserpid());
			num = dao.saveAttendancedesignDao(attendancedesign);
			if(num > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("新增设计成功！！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("新增请假设计失败！");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("数据为空新增请假设计失败！");
		}
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public List<Attendance> queryUserAttendanceService(Attendance attendance) {
		return dao.queryUserAttendanceDao(attendance);
	}


}
