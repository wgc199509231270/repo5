package com.OuSoft.system.service.Conference.impl;

import com.OuSoft.system.dao.Conference.ConferenceUserDao;
import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Conference.ConferenceUserService;
import com.OuSoft.system.service.Tjobinfo.Impl.TjobinfoServiceImpl;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConferenceUserServiceImpl implements ConferenceUserService {

    @Autowired
    ConferenceUserDao cud;

    @Autowired
    TjobinfoServiceImpl tfs;


    @Override
    public List<Conferenceuser> queryConferenceUserlist(Conferenceuser co) {

        return cud.queryConferenceUserlist(co);
    }

    @Override
    public ResponseModel InsertConferenceUser(Conferenceuser co) {
        //id由DateUtil.getID()生成
        co.setId(DateUtil.getID());
        ResponseModel remodel = new ResponseModel();
        int num= cud.InsertConferenceUser(co);
        if(!DateUtil.getObjCheckIsNull(co) ){
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
            remodel.setMsg("新增数据为空！");
        }
        return remodel;
    }

    @Override
    public ResponseModel UpdateConferenceUser(Conferenceuser co) {
        ResponseModel remodel = new ResponseModel();
        int num = cud.UpdateConferenceUser(co);
        if(!DateUtil.getObjCheckIsNull(co) ){
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
            remodel.setMsg("修改数据为空！");
        }
        return remodel;
    }

    @Override
    public ResponseModel DelConferenceUser(String id) {
        ResponseModel remodel = new ResponseModel();
        if(id!="" & id!=null ){
            int num = cud.DelConferenceUser(id);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("删除成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("删除失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("删除为空！");
        }
        return remodel;

    }
}
