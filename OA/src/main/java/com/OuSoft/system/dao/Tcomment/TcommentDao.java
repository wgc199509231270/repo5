package com.OuSoft.system.dao.Tcomment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tcomment;

@Mapper
@Component(value="Tcomment")
public interface TcommentDao {
	
	//评论新增
	int saveTcommentDao(Tcomment tcomment);
	
	//评论回复详情
	List<Tcomment> queryListTcommentDao(Tcomment tcomment);

	//删除当前用户的评论
	int deleTcommentDao(Tcomment tcomment);
	
}
