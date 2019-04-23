package com.OuSoft.system.controller.Conference;

import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Conference.ConferenceService;
import com.OuSoft.system.service.Conference.ConferenceUserService;
import com.OuSoft.system.service.Tnews.TnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/ConferenceController")
public class ConferenceController {

    @Autowired
    ConferenceService cfs;

    @Autowired
    ConferenceUserService cus;

    @Autowired
    TnewsService service;

    //列表及筛选
    @ResponseBody
    @RequestMapping(value = "/queryConferenceonifolist")
    public List<Conferenceonifo> queryConferenceonifolist(Conferenceonifo co) {

        List<Conferenceonifo> conferenceonifos = new ArrayList<Conferenceonifo>();
        conferenceonifos = cfs.queryConferenceonifolist(co);
        return conferenceonifos;
    }


    //我参与的会议
    //列表及筛选
    @ResponseBody
    @RequestMapping(value = "/queryConferenceonifouserlist")
    public List<Conferenceuser> queryConferenceonifouserlist(Conferenceuser cs) {

        List<Conferenceuser> conferenceusers = cus.queryConferenceUserlist(cs);

        return conferenceusers;
    }

    //会议发布
    @ResponseBody
    @RequestMapping(value = "/insertConferenceonifo")
    public ResponseModel insertConferenceonifo(Conferenceonifo co){
        ResponseModel Model = cfs.InsertConference(co);
        return Model;
    }

    //会议变更 会议取消
    @ResponseBody
    @RequestMapping(value = "/UpdateConferenceonifo")
    public ResponseModel UpdateConferenceonifo(Conferenceonifo co){
        ResponseModel responseModel = cfs.UpdateConference(co);
        return responseModel;
    }

    //签到 签退 审核
    @ResponseBody
    @RequestMapping(value = "/UpdateConferenceuser")
    public ResponseModel UpdateConferenceuser(Conferenceuser cu){
        ResponseModel Model = cus.UpdateConferenceUser(cu);
        return Model;
    }

    //删除参会人员
    @ResponseBody
    @RequestMapping(value = "/DelConferenceUser")
    public ResponseModel DelConferenceUser(String id){
        ResponseModel responseModel = cus.DelConferenceUser(id);
        return responseModel;
    }

    //删除参会人员
    @ResponseBody
    @RequestMapping(value = "/DelConferenceonifo")
    public ResponseModel DelConferenceonifo(String id){
        ResponseModel responseModel = cfs.DelConference(id);
        return responseModel;
    }

    //会议修改中人员新增
    @ResponseBody
    @RequestMapping(value = "/insertConferenceuser")
    public ResponseModel insertConferenceuser(Conferenceuser cu){
        ResponseModel Model = cus.InsertConferenceUser(cu);
        return Model;
    }
}
