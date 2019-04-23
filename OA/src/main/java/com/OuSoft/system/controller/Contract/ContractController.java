package com.OuSoft.system.controller.Contract;

import com.OuSoft.system.entity.CompensationRules;
import com.OuSoft.system.entity.Contract;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Contract.ContractService;
import com.OuSoft.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/ContractController")
public class ContractController {
    @Autowired
    ContractService cs;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value="/queryCrList")
    @ResponseBody
    public List<Contract> QueryContractController(Contract contract){
        List<Contract> contracts = cs.queryContract(contract);
        return contracts;
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping(value = "deleteIdCr")
    @ResponseBody
    public ResponseModel deleteIdCrController(@Param("id")String id){
        ResponseModel responseModel = cs.DelContract(id);
        return responseModel;
    }

    /*
     *新增
     */
    @RequestMapping(value = "insertCr")
    @ResponseBody
    public ResponseModel insertCrController(Contract co){

        //id由DateUtil.getID()生成
        co.setCreatetime(DateUtil.GetDateF());

        ResponseModel model = cs.InsertContract(co);
        return model;
    }

    @RequestMapping(value = "updateCr")
    @ResponseBody
    public ResponseModel updateCrController(Contract co){
        ResponseModel model =new ResponseModel();
        model = cs.UpdateContract(co);
        return model;
    }


}
