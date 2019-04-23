package com.OuSoft.system.dao.Conference;

import com.OuSoft.system.entity.Conferenceuser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="ConferenceUser")
public interface ConferenceUserDao {
    /**
     * 查询会议列表(用户：查个人 管理员：查全部 会议主题模糊 会议时间修改 会议类型  会议级别 )
     * @return
     */
    List<Conferenceuser> queryConferenceUserlist(Conferenceuser co);

    /**
     * 新增会议
     * @param co
     * @return
     */
    int InsertConferenceUser(Conferenceuser co);

    /**
     * 修改会议（会议状态修改 类型修改）
     * @param co
     * @return
     */
    int UpdateConferenceUser(Conferenceuser co);

    /**
     * 修改
     * @return
     */
    int DelConferenceUser(String id);
}
