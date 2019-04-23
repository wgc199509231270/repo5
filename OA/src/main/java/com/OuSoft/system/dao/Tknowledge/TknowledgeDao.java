package com.OuSoft.system.dao.Tknowledge;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tknowledge;

@Mapper
@Component(value = "Tknowledge")
public interface TknowledgeDao {
	//插入
	int insertTknowledgeDao(Tknowledge tknowledge);
	//删除
	int deleteIdTknowledgeDao(String id);
	//查询
	List<Tknowledge> selectIdTknowledgeDao(Tknowledge tknowledge);
	//知识列表
	List<Tknowledge> queryListTknowledgeDao(Tknowledge tknowledge);
	//知识列表最新
	List<Tknowledge> queryZxListTknowledgeDao(Tknowledge tknowledge);
	//知识列表最热
	List<Tknowledge> queryListZrTknowledgeDao(Tknowledge tknowledge);
	//知识列表最火
	List<Tknowledge> queryListZhTknowledgeDao(Tknowledge tknowledge);
//	//个人知识列表最新
//	List<Tknowledge> queryGZxListTknowledgeDao(Tknowledge tknowledge);
//	//个人知识列表最热
//	List<Tknowledge> queryListGZrTknowledgeDao(Tknowledge tknowledge);
//	//个人知识列表最火
//	List<Tknowledge> queryListGZhTknowledgeDao(Tknowledge tknowledge);
	//知识点赞详情
	List<Tknowledge> queryListTknowledgeTpraiseDao(Tknowledge tknowledge);
	//知识图表点赞
	List<Tknowledge> queryDzNumListTknowledgeDao(Tknowledge tknowledge);
	//知识图表评论
	List<Tknowledge> queryPlNumListTknowledgeDao(Tknowledge tknowledge);
	//知识图表条数
	List<Tknowledge> queryFbNumListTknowledgeDao(Tknowledge tknowledge);
	//个人知识图表统计
	List<Tknowledge> queryGListTknowledgeDao(Tknowledge tknowledge);
}
