package com.OuSoft.system.service.Conference.impl;

import com.OuSoft.system.dao.Conference.ConferenceDao;
import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Conference.ConferenceService;
import com.OuSoft.system.service.Conference.ConferenceUserService;
import com.OuSoft.system.service.Tjobinfo.Impl.TjobinfoServiceImpl;
import com.OuSoft.system.service.Tnews.TnewsService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    ConferenceDao cd;

    @Autowired
    ConferenceUserService cus;

    @Autowired
    TnewsService service;

    @Autowired
    TjobinfoServiceImpl tfs;


    @Override
    public List<Conferenceonifo> queryConferenceonifolist(Conferenceonifo co) {
        String userid=DateUtil.getUserid();
        if("01".equals(co.getManage())){
            co.setUserid(userid);
        }else if("02".equals(co.getManage())){
            Conferenceuser conferenceuser=new Conferenceuser();
            conferenceuser.setUserid(userid);
            List<Conferenceuser> entityLists = cus.queryConferenceUserlist(conferenceuser);
            List<String> list=new ArrayList<String>();
            for(int i=0;i<entityLists.size();i++){
                list.add(entityLists.get(i).getConferenceid());
            }
            co.setList(list);
        }else if("03".equals(co.getManage())){
            Tjobinfo tj=new Tjobinfo();
            tj.setUserid(userid);
            List<Tjobinfo> tjobinfos = tfs.queryUseridService(tj);
            Set<String> list=new HashSet<String>();
            for(int i=0;i<tjobinfos.size();i++){
                list.add(tjobinfos.get(i).getUserid());
            }
            Conferenceuser conferenceuser=new Conferenceuser();
            conferenceuser.setManage(co.getManage());
            conferenceuser.setList(list);
            List<Conferenceuser> entityLists = cus.queryConferenceUserlist(conferenceuser);
            List<String> list1=new ArrayList<String>();
            for(int i=0;i<entityLists.size();i++){
                list1.add(entityLists.get(i).getConferenceid());
            }
            co.setList(list1);
        }
        return cd.queryConferenceonifolist(co);
    }

    @Override
    public ResponseModel InsertConference(Conferenceonifo co) {
        ResponseModel remodel = new ResponseModel();
        //id由DateUtil.getID()生成
        String duid = DateUtil.getID();
        co.setId(duid);
        co.setReleaseTime(DateUtil.GetDateF());
        String issuer = co.getIssuer();
        co.setId(duid);
        int num= cd.InsertConference(co);

        ArrayList<Conferenceuser> cu = co.getCu();

        for(int i=0; i < cu.size();i++){
            Conferenceuser cs=new Conferenceuser();
            cs.setUserid(cu.get(i).getUserid());
            cs.setConferenceid(duid);
            cus.InsertConferenceUser(cs);
            Tnews tnews=new Tnews();
            tnews.setNtype("01");//类型
            tnews.setNitemid(duid);//项目id
            tnews.setNuserid(cu.get(i).getUserid());//提醒用户id
            tnews.setNitemuserid(issuer);//发布人
            tnews.setNitemtype("工作圈");//项目类型
            tnews.setNtext("会议主题："+ co.getConferencename() +  "会议时间：" +co.getConferenceDate()+"会议地点：" + co.getMeetingPlace());
            service.saveTnewsService(tnews);
        }


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
    public ResponseModel UpdateConference(Conferenceonifo co) {
        ResponseModel remodel = new ResponseModel();
        int num = cd.UpdateConference(co);
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
    public ResponseModel DelConference(String id) {
        ResponseModel remodel = new ResponseModel();
        if(id!="" & id!=null ){
            int num = cd.DelConference(id);
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
