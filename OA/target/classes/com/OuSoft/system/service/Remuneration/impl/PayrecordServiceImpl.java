package com.OuSoft.system.service.Remuneration.impl;

import com.OuSoft.system.dao.Remuneration.PayrecordDao;
import com.OuSoft.system.entity.Payrecord;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Remuneration.PayrecordService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrecordServiceImpl implements PayrecordService {

    @Autowired
    PayrecordDao pd;

    @Override
    public List<Payrecord> Querypayrecord(Payrecord pa) {
        List<Payrecord> payrecords = pd.QuerypayrecordDao(pa);
        return payrecords;
    }

    @Override
    public ResponseModel Insertpayrecord(Payrecord pr) {
        ResponseModel remodel = new ResponseModel();
        int num=pd.InsertpayrecordDao(pr);
        if(!DateUtil.getObjCheckIsNull(pr) ){
        if(num > 0){
            remodel.setCode("200");
            remodel.setResult("success");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("001");
            remodel.setMsg("修改个人信息成功！");
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("修改个人信息失败！");
        }
    }else{
        remodel.setCode("404");
        remodel.setResult("fali");
        remodel.setTime(System.currentTimeMillis()+"");
        remodel.setToken("0053");
        remodel.setMsg("个人信息数据为空！");
    }
        return remodel;
    }
}
