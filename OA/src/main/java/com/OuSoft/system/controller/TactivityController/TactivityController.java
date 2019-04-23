package com.OuSoft.system.controller.TactivityController;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tactivity;
import com.OuSoft.system.service.Tactivity.TactivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * mcc
 */
@Controller
@RequestMapping(value="/tactivity")
public class TactivityController {
    @Autowired
    TactivityService tactivityService;

    /**
     * 查询活动
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/queryTactivity")
    @ResponseBody
    public List<Tactivity> queryTactivity(Tactivity tactivity){
        List<Tactivity> list = tactivityService.queryListActivityService(tactivity);
        return list;
    }

    /**
     * 根据id修改活动
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/updateTactivity")
    @ResponseBody
    public ResponseModel updateTactivity(Tactivity tactivity){
        ResponseModel responseModel = tactivityService.updateTactivityService(tactivity);
        return responseModel;
    }

    /**
     * 新增活动
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/insertTactivity")
    @ResponseBody
    public ResponseModel insertTactivity(Tactivity tactivity){
        ResponseModel responseModel = tactivityService.insertTactivityService(tactivity);
        return responseModel;
    }

    /**
     * 删除活动
     * @param id
     * @return
     */
    @RequestMapping(value="/delTactivity")
    @ResponseBody
    public ResponseModel delTactivity(String id){
        ResponseModel responseModel = tactivityService.delTactivityService(id);
        return  responseModel;
    }

    /**
     * 新增报名信息
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/insertTactivityUser")
    @ResponseBody
    public ResponseModel insertTactivityUser(Tactivity tactivity){
        ResponseModel responseModel = tactivityService.insertTactivityUserService(tactivity);
        return responseModel;
    }

    /**
     * 查询报名信息
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/queryListRegActivity")
    @ResponseBody
    public List<Tactivity> queryListRegActivity(Tactivity tactivity){
        List<Tactivity> list = tactivityService.queryListRegActivityService(tactivity);
        return list;
    }

    /**
     * 删除活动人员
     * @param id
     * @return
     */
    @RequestMapping(value="/delUserTactivity")
    @ResponseBody
    public ResponseModel delUserTactivity(String id){
        ResponseModel responseModel = tactivityService.delTactivityUserService(id);
        return  responseModel;
    }

    /**
     * 根据id修改活动人员
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/updateUserTactivity")
    @ResponseBody
    public ResponseModel updateUserTactivity(Tactivity tactivity){
        ResponseModel responseModel = tactivityService.updateTactivityUserService(tactivity);
        return responseModel;
    }

    /**
     * 查询点赞信息
     * @param tactivity
     * @return
     */
    @RequestMapping(value="/queryDzTactivityuserRequest")
    @ResponseBody
    public List<Tactivity> queryDzTactivityuserRequest(Tactivity tactivity){
        List<Tactivity> list = tactivityService.queryDzTactivityuserRequestDao(tactivity);
        return list;
    }
}
