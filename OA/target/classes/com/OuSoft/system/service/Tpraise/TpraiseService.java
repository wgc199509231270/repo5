package com.OuSoft.system.service.Tpraise;


import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tpraise;


public interface TpraiseService {
	
	ResponseModel saveTpraiseService(Tpraise tpraise);
	
	Tpraise queryTpraise(Tpraise tpraise);
	
	ResponseModel delteIdTrpaiseService(Tpraise tpraise);
	
}
