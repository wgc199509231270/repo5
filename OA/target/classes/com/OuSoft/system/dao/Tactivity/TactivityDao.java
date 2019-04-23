package com.OuSoft.system.dao.Tactivity;

import com.OuSoft.system.entity.Tactivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "Tactivity")
public interface TactivityDao {
    //新增活动
    int insertTactivityDao(Tactivity tactivity);
    //查询活动
    List<Tactivity> queryListActivityDao(Tactivity tactivity);
    //删除活动
    int delTactivityDao(String id);
    //修改活动
    int updateTactivityDao(Tactivity tactivity);
    //查询报名列表
    List<Tactivity> queryListRegActivityDao(Tactivity tactivity);
    //新增报名列表
    int insertTactivityUserDao(Tactivity tactivity);
    //删除活动人员
    int delTactivityUserDao(String id);
    //修改活动人员
    int updateTactivityUserDao(Tactivity tactivity);
    //查询点赞
    List<Tactivity> queryDzTactivityuserRequestDao(Tactivity tactivity);
}
