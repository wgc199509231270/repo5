package com.OuSoft.system.service.Tnews;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tnews;

public interface TnewsService {
	
	
	List<Tnews> queryTnewsService(Tnews tnews);
	
	ResponseModel saveTnewsService(Tnews tnews);
	
	List<Tnews> queryPlanTnewsService(Tnews tnews);
}
