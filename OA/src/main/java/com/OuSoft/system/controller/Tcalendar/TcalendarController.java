package com.OuSoft.system.controller.Tcalendar;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcalendar;
import com.OuSoft.system.service.calendar.TcalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tcalendar")
@RestController
public class TcalendarController {

    @Autowired
    TcalendarService service;

    /**
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
    @RequestMapping("/saveTcalendar")
    @ResponseBody
    public ResponseModel saveTcalendarController(Tcalendar tcalendar){
    	return service.saveTcalendarService(tcalendar);
    }
    
    
    /**
     * 根据id删除一条日历信息
     * 接收id id
     * @author pyl
     * @date 2019年2月28日
     */
    @RequestMapping("/deTcalendar")
    @ResponseBody
    public ResponseModel deTcalendarController(String id ){
    	return service.deTcalendarService(id);
    }
    
    
    /**
     * 查询日历表中的数据
     * 接收：
     * 开始日期  starttime   年/月/日
     * 结束日期 endtime     年/月/日      
     * @author pyl
     * @date 2019年2月28日
     */
    @RequestMapping("/querycalendar")
    @ResponseBody
    public List<Tcalendar> selectTcalendarListController(Tcalendar tcalendar) {
    	return service.selectTcalendarListService(tcalendar);
    }

    /**
     * 查询所有日历
     * @param tcalendar
     * @return
     */
    @RequestMapping("/queryallcalendar")
    @ResponseBody
    public List<Tcalendar> selectAllTcalendarListController(Tcalendar tcalendar) {
        return service.selectAllTcalendarListService(tcalendar);
    }




}
