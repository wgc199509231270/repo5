package com.OuSoft.system.service.Tknowledge;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tknowledge;


public interface tknowledgeService {
	
	ResponseModel insertTknowledgeServcie(Tknowledge tknowledge);
	
	ResponseModel deleteIdTknowledgeService(String id);
	//查询
	List<Tknowledge> selectIdTknowledgeService(Tknowledge tknowledge);
	//知识列表
	List<Tknowledge> queryListTknowledgeService(Tknowledge tknowledge);
	
	//个人知识图表
	List<Tknowledge> queryGListTknowledgeService(Tknowledge tknowledge);
	
	//知识点赞详情
	List<Tknowledge> queryListTknowledgeTpraiseService(Tknowledge tknowledge);
	
	//知识点赞、评论、条数
	List<Tknowledge> queryFbNumListTknowledgeService(Tknowledge tknowledge);

}
