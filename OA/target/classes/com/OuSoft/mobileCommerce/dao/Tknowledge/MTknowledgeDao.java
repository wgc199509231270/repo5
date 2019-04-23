package com.OuSoft.mobileCommerce.dao.Tknowledge;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tknowledge;

/**
 * 知识
 * @author pengyueli
 * @date 2018年11月13日
 */
@Mapper
@Component(value = "MTknowledge")
public interface MTknowledgeDao {
	
	//所有人列表
	List<Tknowledge> queryQBLBListTknowledgeDao(Tknowledge tknowledge);
	//个人列表
	List<Tknowledge> queryGRLBListTknowledgeDao(Tknowledge tknowledge);
	//所有人图表
	List<Tknowledge> queryQBTBListTknowledgeDao(Tknowledge tknowledge);
	//个人列表
	List<Tknowledge> queryGRTBListTknowledgeDao(Tknowledge tknowledge);
	//点赞详情
	List<Tknowledge> queryDzListTknowledgeDao(Tknowledge tknowledge);
	//评论详情
	List<Tknowledge> queryPlListTknowledgeDao(Tknowledge tknowledge);
	
	
}
