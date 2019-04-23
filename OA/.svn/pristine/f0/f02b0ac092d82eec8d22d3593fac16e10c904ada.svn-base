package com.OuSoft.system.dao.Tcalendar;

import com.OuSoft.system.entity.Tcalendar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component()
public interface TcalendarDao {

	
	/**
	 * 新增日历
	 * 新增日历表中的数据  
     * tcompanypid  pid 
     * createtime   创建时间
     * 接收：
     * 开始日期  starttime   年/月/日
     * 结束日期 endtime     年/月/日      
     * 类型： type  01 休息日加班      02  上班日休息 
     * mark   备注
	 * @author pyl
	 * @date 2019年2月28日
	 */
	int saveTcalendarDao(Tcalendar tcalendar);
	
	/**
	 * 删除日历表中的数据
	 * @author pyl
	 * @date 2019年2月28日
	 */
	int deTcalendarDao(String id);
	
    /**
     * 跟据时间范围展示考勤日历的方法
     * @param start 从哪天开始
     * @param end 到哪天结束
     * @return 返回日历类的全部数据
     */
    List<Tcalendar> selectTcalendarListDao(Tcalendar tcalendar);

	/**
	 * 查询所有考勤日历
	 * @param tcalendar
	 * @return
	 */
	List<Tcalendar> selectAllTcalendarListDao(Tcalendar tcalendar);

}

