package com.OuSoft.system.service.Tquestion;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tquestion;


public interface TquestionService {

	ResponseModel insertTquestionService(Tquestion tquestion);
	
	ResponseModel deleteIdTquestionService(String id);
	
	//问答列表
	List<Tquestion> queryListTquestionService(Tquestion tquestion);
	
	//问答点赞详情
	List<Tquestion> queryListTquestionTpraiseService(Tquestion tquestion);
	
	//问答点赞、评论、发布数
	List<Tquestion> queryDzNumListTquestionService(Tquestion tquestion);
	
	//问答个人图表
	List<Tquestion> queryGListTquestionService(Tquestion tquestion);

	//查询问答
	List<Tquestion> selectIdTquestionService(Tquestion tquestion);
}
