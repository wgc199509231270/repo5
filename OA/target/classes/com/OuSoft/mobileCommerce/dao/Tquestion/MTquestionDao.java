package com.OuSoft.mobileCommerce.dao.Tquestion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tquestion;


/**
 * 问答
 * @author pengyueli
 * @date 2018年11月13日
 */
@Mapper
@Component(value = "MTquestion")
public interface MTquestionDao {

	List<Tquestion> queryQBLBListTquestionDao(Tquestion tquestion);
	List<Tquestion> queryGRLBListTquestionDao(Tquestion tquestion);
	List<Tquestion> queryQBTBListTquestionDao(Tquestion tquestion);
	List<Tquestion> queryGRTBListTquestionDao(Tquestion tquestion);
	List<Tquestion> queryDzListTquestionDao(Tquestion tquestion);
	List<Tquestion> queryPlListTquestionDao(Tquestion tquestion);
}
