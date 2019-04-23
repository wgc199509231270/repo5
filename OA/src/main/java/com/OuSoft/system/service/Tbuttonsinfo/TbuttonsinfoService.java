package com.OuSoft.system.service.Tbuttonsinfo;

import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tbuttonsinfo;

public interface TbuttonsinfoService {
	
	
	ResponseModel saveTbuttoninfoService(Tbuttonsinfo tbuttoninfos);
	
	List<Tbuttonsinfo> queryTbuttoninfoService(Tbuttonsinfo tbuttoninfos);
	
	ResponseModel deleteTbuttoninfoService(Tbuttonsinfo tbuttoninfos);
	
	ResponseModel updateTbuttoninfoService(Tbuttonsinfo tbuttoninfos);
	
	
	

}
