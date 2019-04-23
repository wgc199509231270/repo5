package com.OuSoft.system.controller.Remuneration;

import com.OuSoft.system.entity.CompensationRules;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import com.OuSoft.system.service.Remuneration.CompensationRulesService;

import com.OuSoft.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value="/compensationRules")
public class CompensationRulesController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    CompensationRulesService crs;

    /**
     * 查询全部规则
     * @return
     */
    @RequestMapping(value="/queryCrList")
    @ResponseBody
    public List<CompensationRules> QueryCrListController(){

        return crs.QueryCompensationRulesList();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping(value = "deleteIdCr")
    @ResponseBody
    public ResponseModel deleteIdCrController(@Param("id")String id){
        ResponseModel model = crs.deleteIdCr(id);
        return model;
    }

    /*
    *新增规划
     */
    @RequestMapping(value = "insertCr")
    @ResponseBody
    public ResponseModel insertCrController(CompensationRules Cr){

        //id由DateUtil.getID()生成
        Cr.setId(DateUtil.getID());
        Cr.setInputTime(DateUtil.GetDateF());
        ResponseModel model = crs.insertCrDao(Cr);
        return model;
    }

    @RequestMapping(value = "updateCr")
    @ResponseBody
    public ResponseModel updateCrController(CompensationRules Cr){
        ResponseModel model =new ResponseModel();
             model = crs.updateCr(Cr);
        return model;
    }

    @RequestMapping(value = "QueryperformancController")
    @ResponseBody
    public List<Tsuser> QueryperformancController(performance pe){
        System.out.println(pe.getId());
        List<Tsuser> tsusers = crs.QuerycompenService(pe);
        return tsusers;
    }
}
