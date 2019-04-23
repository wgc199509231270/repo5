package com.OuSoft.system.service.Remuneration.impl;

import com.OuSoft.system.dao.Remuneration.RemunerationflowDao;
import com.OuSoft.system.entity.Remunerationflow;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Remuneration.RemunerationflowService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemunerationflowServiceImpl implements RemunerationflowService {

    @Autowired
    RemunerationflowDao rflowd;

    @Override
    public List<Remunerationflow> QueryRemunerationflowService() {
        List<Remunerationflow> remunerationflows = rflowd.QueryRemunerationflowDao();
        return remunerationflows;
    }

    @Override
    public ResponseModel UpdateRemunerationflowService(Remunerationflow model) {

        ResponseModel remodel = new ResponseModel();
        int num=rflowd.UpdateRemunerationflowDao(model);
        if(!DateUtil.getObjCheckIsNull(model) ){
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("修改成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("修改失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("数据为空！");
        }
        return remodel;
    }



    @Override
    public ResponseModel InsertRemunerationflowService(Remunerationflow model) {
        ResponseModel remodel = new ResponseModel();
        int num=rflowd.InsertRemunerationflowDao(model);
        if(!DateUtil.getObjCheckIsNull(model) ){
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("新增成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("新增失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("数据为空！");
        }
        return remodel;
    }

    @Override
    public ResponseModel DelRemunerationflowService(String id) {
        ResponseModel remodel = new ResponseModel();
        if(id!="" & id!=null ){
            int num=rflowd.DelRemunerationflowDao(id);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("修改成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("修改失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("数据为空！");
        }
        return remodel;
    }
}
