package com.OuSoft.system.controller.Remuneration;

import com.OuSoft.system.entity.CompensationRules;
import com.OuSoft.system.entity.Payrecord;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Remuneration.impl.PayrecordServiceImpl;
import com.OuSoft.system.service.Tsuser.impl.TsuserServiceImpl;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/PayrecordController")
public class PayrecordController {
    @Autowired
    PayrecordServiceImpl psi;
    @Autowired
    TsuserServiceImpl tsi;
    /**
     * 查询全部调薪记录
     * @return
     */
    @RequestMapping(value="/QuerypayrecordList")
    @ResponseBody
    public List<Payrecord> QuerypayrecordList(Payrecord pa){

        return psi.Querypayrecord(pa);
    }

    /*
     *新增调薪记录
     */
    @RequestMapping(value = "/insertpayrecord")
    @ResponseBody
    public ResponseModel InsertpayrecordController(Payrecord pr ){
        //id由DateUtil.getID()生成
        pr.setId(DateUtil.getID());
        Tsuser ts=new Tsuser();
        ts.setUsername (pr.getUsername()) ;
        System.out.println(pr.getUsername());
        List<Tsuser> tsusers = tsi.queryNameTuserService(ts);
        pr.setUserId(tsusers.get(0).getId());
        ResponseModel model = psi.Insertpayrecord(pr);
        return model;
    }

}
