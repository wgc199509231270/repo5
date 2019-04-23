package com.OuSoft.system.dao.attendance;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Attendance;
import com.OuSoft.system.entity.AttendanceDesign;


@Mapper
@Component(value="attendance")
public interface AttendanceDao {


	//请假详情
	Attendance queryXQAttendanceDao(Attendance attendance);
	
	//我的请假申请列表，
	List<Attendance> queryWdAttendanceDao(Attendance attendance);
	
	// 请假列表
	List<Attendance> queryDao(Attendance attendance);
	// 根据id查询请假
	List<Attendance> queryAttendanceByIdDao(Attendance attendance);
	//删除一条请假数据
	int deAttendanceDao(Attendance attendance);
	/**
	 * 修改请假数据接收：
	id 请假id 
	timetype 类型
	duration 时长
	 */
	int updateAttendacneDao(Attendance attendance);
	//新增请假数据
	int saveAttendanceDao(Attendance attendance);
	
	//---------------分割线
	
	//查询请假设计表
	List<AttendanceDesign> queryAttendancedesignDao();
	
	//修改请假设计表
	int upAttendancedesignDao(AttendanceDesign attendancedesign);
	
	//删除请假设计表
	int deAttendancedesignDao(AttendanceDesign attendancedesign);
	
	//新增请假设计表
	int saveAttendancedesignDao(AttendanceDesign attendancedesign);
	//查询请假
	List<Attendance> queryUserAttendanceDao(Attendance attendance);
	
	
}
