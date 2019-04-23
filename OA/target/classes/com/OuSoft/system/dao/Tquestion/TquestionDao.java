package com.OuSoft.system.dao.Tquestion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tquestion;

@Mapper
@Component(value="Tquestion")
public interface TquestionDao {
	
	//新增问答
	int insertTquestionDao(Tquestion tquestion);
	//删除问答
	int deleteIdTquestionDao(String id);
	//查询问答
	List<Tquestion> selectIdTquestionDao(Tquestion tquestion);
	//问答列表
	List<Tquestion> queryListTquestionDao(Tquestion tquestion);
	//问答列表最新
	List<Tquestion> queryListZxTquestionDao(Tquestion tquestion);
	//问答列表最热
	List<Tquestion> queryListZrTquestionDao(Tquestion tquestion);
	//问答列表最火
	List<Tquestion> queryListZhTquestionDao(Tquestion tquestion);
	//问答点赞详情
	List<Tquestion> queryListTquestionTpraiseDao(Tquestion tquestion);
	//问答点赞图表
	List<Tquestion> queryDzNumListTquestionDao(Tquestion tquestion);
	//问答评论图表
	List<Tquestion> queryPlNumListTquestionDao(Tquestion tquestion);
	//问答发布条数图表
	List<Tquestion> queryFbNumListTquestionDao(Tquestion tquestion);
	//问答个人图表
	List<Tquestion> queryGListTquestionDao(Tquestion tquestion);
	
	
	
}
