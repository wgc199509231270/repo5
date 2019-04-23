package com.OuSoft.system.service.Conference;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Conferenceuser;
import com.OuSoft.system.entity.entityList;

import java.util.List;

public interface ConferenceUserService {
    /**
     * 查询会议列表(用户：查个人 管理员：查全部 会议主题模糊 会议时间修改 会议类型  会议级别 )
     * @return
     */
    List<Conferenceuser> queryConferenceUserlist(Conferenceuser co);

    /**
     * 新增会议
     * @param cs
     * @return
     */
    ResponseModel InsertConferenceUser(Conferenceuser cs);

    /**
     * 修改会议（会议状态修改 类型修改）
     * @param cs
     * @return
     */
    ResponseModel UpdateConferenceUser(Conferenceuser cs);

    /**
     * 修改
     * @return
     */
    ResponseModel DelConferenceUser(String id);
}
