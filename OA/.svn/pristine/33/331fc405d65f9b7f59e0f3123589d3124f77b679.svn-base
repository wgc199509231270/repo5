package com.OuSoft.system.service.Conference;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Conferenceonifo;

import java.util.List;

public interface ConferenceService {
    /**
     * 查询会议列表(用户：查个人 管理员：查全部 会议主题模糊 会议时间修改 会议类型  会议级别 )
     * @return
     */
    List<Conferenceonifo> queryConferenceonifolist(Conferenceonifo co);

    /**
     * 新增会议
     * @param co
     * @return
     */
    ResponseModel InsertConference(Conferenceonifo co);

    /**
     * 修改会议（会议状态修改 类型修改）
     * @param co
     * @return
     */
    ResponseModel UpdateConference(Conferenceonifo co);

    /**
     * 修改
     * @return
     */
    ResponseModel DelConference(String id);
}
