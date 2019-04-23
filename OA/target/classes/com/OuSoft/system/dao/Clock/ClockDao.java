package com.OuSoft.system.dao.Clock;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Clock;
import com.OuSoft.system.entity.Tcomment;

@Mapper
@Component(value="Clock")
public interface ClockDao {
	
	//clock签到表插入
	int InsertClock(Clock clock);
	
	 
	//查询用户是否签到或则签退
	Clock queryClockDao(Clock clock);
	
	//签到列表信息查询，个人列表和系统管理员列表信息都可用。筛选条件：个人用户id:id、用户名称:usernmae、开始时间：begtime、结束时间：endtime
	List<Clock> queryListClockDao(Clock clock);
	
	//查询签到列表和点赞总数,查询用户名，用户头像，签到点赞总数等，筛选条件:用户名、当天的时间年月日、（或用户id，因为筛选条件未定）
	List<Clock> queryListTsignDao(Clock clock);
	
	List<Clock> queryListDzTsignDao(Clock clock);
	//评论详情-评论
	List<Tcomment> queryListTcommentDao(String itemid);

	//查询所有用户签到
	List<Clock> queryAllListDao(Clock clock);

	int UpdateClockByid(Clock clock);

	//删除签到
	int deleteClockByid(String id);
}
