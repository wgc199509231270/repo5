package com.OuSoft.system.service.attendance;

import java.util.List;

import com.OuSoft.system.entity.Attendance;
import com.OuSoft.system.entity.AttendanceDesign;
import com.OuSoft.system.entity.ResponseModel;


public interface AttendanceService {
	
	//请假详情
	Attendance queryXQAttendanceService(Attendance attendance);
	
	//我的请假申请列表，
	List<Attendance> queryWdAttendanceService(Attendance attendance);
	//根据id查询请假
	List<Attendance> queryAttendanceByIdService(Attendance attendance);
	// 请假列表
	List<Attendance> queryService(Attendance attendance);
	
	//删除一条请假数据
	ResponseModel deAttendanceService(Attendance attendance);
		//修改请假数据
	ResponseModel updateAttendacneService(Attendance attendance);
		//新增请假数据
	ResponseModel saveAttendanceService(Attendance attendance);
	
	//---------------分割线
	
	//查询请假设计表
	List<AttendanceDesign> queryAttendancedesignService();
	
	//修改请假设计表
	ResponseModel upAttendancedesignService(AttendanceDesign attendancedesign);
	
	//删除请假设计表
	ResponseModel deAttendancedesignService(AttendanceDesign attendancedesign);
	
	//新增请假设计表
	ResponseModel saveAttendancedesignService(AttendanceDesign attendancedesign);

	//查询请假
	List<Attendance> queryUserAttendanceService(Attendance attendance);
	
	
}
