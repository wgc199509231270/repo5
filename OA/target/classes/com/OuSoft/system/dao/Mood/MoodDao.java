package com.OuSoft.system.dao.Mood;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Mood;

@Mapper
@Component(value="Tmood")
public interface MoodDao {
	
	//插入心情
	int InsertMoodDao(Mood mood);
	
	//根据id删除一条心情记录
	int deleteIdTplanDao(String id);

	//根据id查询一条心情记录
	List<Mood> selectIdTplanDao(Mood mood);

	//心情列表
	List<Mood> queryListTmoodDao(Mood mood);
	
	//点赞详情
	List<Mood> queryListTmoodTpraiseDao(Mood mood);

	//心情图表ge
	List<Mood> queryGNumListTmoodDao (Mood mood);
	
	//心情图表quancha
	List<Mood> queryNumListTmoodDao (Mood mood);
}
