package com.OuSoft.mobileCommerce.service.Tquestion;

import java.util.List;

import com.OuSoft.system.entity.Tquestion;

/**
 * 问答
 * @author pengyueli
 * @date 2018年11月13日
 */
public interface MTquestionService {
	
	List<Tquestion> queryQBLBListTquestionService(Tquestion tquestion);
	List<Tquestion> queryGRLBListTquestionService(Tquestion tquestion);
	List<Tquestion> queryQBTBListTquestionService(Tquestion tquestion);
	List<Tquestion> queryGRTBListTquestionService(Tquestion tquestion);
	List<Tquestion> queryDzListTquestionService(Tquestion tquestion);
	List<Tquestion> queryPlListTquestionService(Tquestion tquestion);
}
