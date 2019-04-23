package com.OuSoft.system.service.Clock;

import java.util.List;

import com.OuSoft.system.entity.Clock;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcomment;

public interface ClockService {
	
	//新增签到
	ResponseModel insertClockService(Clock clock);
	
	//查询用户是否签到和签退
	Clock queryClockService(Clock clock);
	
	//签到列表信息查询，个人列表和系统管理员列表信息都可用。筛选条件：个人用户id:id、用户名称:usernmae、开始时间：begtime、结束时间：endtime
	List<Clock> queryListClockService(Clock clock);
	
	//签到列表查询
	List<Clock> queryListTsignService(Clock clock);
	
	//签到详情dz
	List<Clock> queryListDzTsignService(Clock clock);
	
	//评论详情-评论
	List<Tcomment> queryListTcommentService(String itemid);

	//查询所有用户签到信息
	List<Clock> queryAllListService(Clock clock);

	//更新签到
	ResponseModel UpdateClockByidService(Clock clock);
	//删除签到
	ResponseModel deleteClockByidService(String id);
}
