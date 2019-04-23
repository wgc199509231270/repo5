package com.OuSoft.system.service.Tdictionary;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdictionary;

public interface TdictionaryService {
	
	
	ResponseModel saveTdictionaryService(Tdictionary tdictionary);
	
	List<Tdictionary> queryTdictionaryService(Tdictionary tdictionary);
	
	ResponseModel deleteTdictionaryService(Tdictionary tdictionary);
	

}
