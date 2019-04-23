package com.OuSoft.system.controller.Attendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Attendance;
import com.OuSoft.system.entity.AttendanceDesign;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.attendance.AttendanceService;


@Controller
@RequestMapping(value="/attendance")
public class AttendanceController {

	@Autowired AttendanceService service;
	
	
	//请假详情，接收id : id
	@RequestMapping(value="/queryXQAttendance")
	@ResponseBody
	public Attendance queryXQAttendanceController(Attendance attendance) {
		return service.queryXQAttendanceService(attendance);
	}
	//id查询请假详情，接收id : id
	@RequestMapping(value="/queryAttendanceById")
	@ResponseBody
	public List<Attendance> queryAttendanceByIdController(Attendance attendance) {
		return service.queryAttendanceByIdService(attendance);
	}
	//查询请假
	@RequestMapping(value="/queryUserAttendance")
	@ResponseBody
	public List<Attendance> queryUserAttendanceController(Attendance attendance) {
		return service.queryUserAttendanceService(attendance);
	}
	//查询我的审批列表勤
	@RequestMapping(value="/queryWdAttendance")
	@ResponseBody
	public List<Attendance> queryWdAttendanceController(Attendance attendance) {
		return service.queryWdAttendanceService(attendance);
	}
	
	
	//查询请假所有考勤
	@RequestMapping(value="/query")
	@ResponseBody
	public List<Attendance> queryController(Attendance attendance) {
		return service.queryService(attendance);
	}
	
	
	//删除一条请假数据
	@RequestMapping(value="/deAttendance")
	@ResponseBody
	public ResponseModel deAttendanceController(Attendance attendance){
		return service.deAttendanceService(attendance);
	}
	
	
	//修改请假数据
	@RequestMapping(value="/updateAttendacne")
	@ResponseBody
	public ResponseModel updateAttendacneController(Attendance attendance){
		return service.updateAttendacneService(attendance);
	}


	//新增请假数据
	@RequestMapping(value="/saveAttendance")
	@ResponseBody
	public ResponseModel saveAttendanceController(Attendance attendance){
		System.out.println(attendance.getId());
		return service.saveAttendanceService(attendance);
	}
	
	//-----------------------分割线
	
	/**
	 * 查询请假设计表
	 * @author pyl
	 * @date 2019年2月26日
	 */
	@RequestMapping(value="/queryAttendancedesign")
	@ResponseBody
	List<AttendanceDesign> queryAttendancedesignController(){
		return service.queryAttendancedesignService();
	}
	
	/**
	 * 修改请假设计表
	 * @author pyl
	 * @date 2019年2月26日
	 */
	@RequestMapping(value="/upAttendancedesign")
	@ResponseBody
	public ResponseModel upAttendancedesignController(AttendanceDesign attendancedesign){
		return service.upAttendancedesignService(attendancedesign);
	}
	
	/**
	 * 删除请假设计表
	 * @author pyl
	 * @date 2019年2月26日
	 */
	@RequestMapping(value="/deAttendancedesign")
	@ResponseBody
	public ResponseModel deAttendancedesignController(AttendanceDesign attendancedesign){
		return service.deAttendancedesignService(attendancedesign);
		
	}
	
	/**
	 * 新增请假设计表
	 * @author pyl
	 * @date 2019年2月26日
	 */
	@RequestMapping(value="/saveAttendancedesign")
	@ResponseBody
	public ResponseModel saveAttendancedesignController(AttendanceDesign attendancedesign){
		return service.saveAttendancedesignService(attendancedesign);
	}
	
	
	
}
