package com.OuSoft.system.service.calendar.impl;

import com.OuSoft.system.dao.Tcalendar.TcalendarDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcalendar;
import com.OuSoft.system.service.calendar.TcalendarService;
import com.OuSoft.utils.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TcalendarServiceImpl implements TcalendarService {

    @Autowired
    TcalendarDao dao;

    /**
     * 查询日历表，接收，starttimne     endtime
     */
	@Override
    public List<Tcalendar> selectTcalendarListService(Tcalendar tcalendar) {
    	Tcalendar ca = new Tcalendar();
    	List<Tcalendar> calendarList = new ArrayList<Tcalendar>();
    	if(!DateUtil.getObjCheckIsNull(tcalendar)){
    		if(tcalendar.getStarttime() != null && tcalendar.getEndtime() != null){
    			calendarList = dao.selectTcalendarListDao(tcalendar);
    		}else{
    			ca.setMsg("必填参数为空");
    			calendarList.add(ca);
    		}
    	}else{
    		ca.setMsg("参数为空");
    		calendarList.add(ca);
    	}
        return calendarList;
    }
	@Override
	public List<Tcalendar> selectAllTcalendarListService(Tcalendar tcalendar) {
		Tcalendar ca = new Tcalendar();
		List<Tcalendar> calendarList = new ArrayList<Tcalendar>();
				calendarList = dao.selectAllTcalendarListDao(tcalendar);
		return calendarList;
	}
    /**
     * 新增日历数据
     */
	@Override
	public ResponseModel saveTcalendarService(Tcalendar tcalendar) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(!DateUtil.getObjCheckIsNull(tcalendar)){
			tcalendar.setId(DateUtil.getID());
			tcalendar.setTcompanypid(DateUtil.GetTsuser().getUserpid());
			tcalendar.setCreatetime(DateUtil.GetDates());
			num = dao.saveTcalendarDao(tcalendar);
			if(num > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("新增一条日历信息成功！！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("新增一条日历信息失败！");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("新增数据为空！！");
		}
		// TODO Auto-generated method stub
		return model;
	}

	/**
     * 根据id删除一条日历
     */
	@Override
	public ResponseModel deTcalendarService(String id) {
		ResponseModel model = new ResponseModel();
		int num = 0;
		if(id != null && id != ""){
			num = dao.deTcalendarDao(id);
			if(num > 0){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("删除一条日历信息成功！！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("删除一条日历信息失败！");
			}
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("删除数据为空！");
		}
		// TODO Auto-generated method stub
		return model;
	}
}
