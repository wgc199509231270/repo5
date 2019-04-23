package com.OuSoft.system.service.Tcompany;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcompany;

/**
 * 公司
 * @author pengyueli
 * @date 2018年12月18日
 */
public interface TcompanyService {
	
	
	ResponseModel saveTcompanyService(Tcompany tcompany);
	
	ResponseModel deleteTcompanyService(Tcompany tcompany);
	
	List<Tcompany> queryTcompanyService(Tcompany tcompany);

}
