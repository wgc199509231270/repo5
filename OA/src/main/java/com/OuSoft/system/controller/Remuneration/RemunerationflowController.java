package com.OuSoft.system.controller.Remuneration;

import com.OuSoft.system.entity.Remunerationflow;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Remuneration.RemunerationflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/remunerationflow")
public class RemunerationflowController {

    @Autowired
    RemunerationflowService rfs;
    /**
     * 查询调薪申请
     * @return
     */
    @RequestMapping(value="/QueryRemunerationflow")
    @ResponseBody
    public List<Remunerationflow> QueryRemunerationflowController(){

        List<Remunerationflow> remunerationflows = new ArrayList<Remunerationflow>();
        remunerationflows  = rfs.QueryRemunerationflowService();

        return remunerationflows;
    }

    /**
     * 根据id 修改流程审核
     * @param mode
     * @return
     */
    @RequestMapping(value="/UpdateRemunerationflowController")
    @ResponseBody
    public ResponseModel UpdateRemunerationflowController(Remunerationflow mode){


        ResponseModel responseModel = rfs.UpdateRemunerationflowService(mode);
        return responseModel;
    }

    /**
     * 新增审批流程
     * @param mode
     * @return
     */
    @RequestMapping(value="/InsertRemunerationflowService")
    @ResponseBody
    public ResponseModel InsertRemunerationflowService(Remunerationflow mode){
        ResponseModel responseModel = rfs.InsertRemunerationflowService(mode);
        return responseModel;
    }

    /**
     * 删除审批流程
     * @param id
     * @return
     */
    @RequestMapping(value="/DelRemunerationflowService")
    @ResponseBody
    public ResponseModel DelRemunerationflowService(String id){
        ResponseModel responseModel = rfs.DelRemunerationflowService(id);

        return  responseModel;
    }

    
}
