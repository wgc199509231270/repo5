package com.OuSoft.system.dao.Tbuttonsinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tbuttonsinfo;

@Mapper
@Component(value="Tbuttonsinfo")
public interface TbuttonsinfoDao {
	
	
	int saveTbuttoninfoDao(Tbuttonsinfo tbuttoninfos);
	
	List<Tbuttonsinfo> queryTbuttoninfoDao(Tbuttonsinfo tbuttoninfos);
	
	int deleteTbuttoninfoDao(Tbuttonsinfo tbuttoninfos);
	
	int updateTbuttoninfoDao(Tbuttonsinfo tbuttoninfos);
	
	
	
	
	

}
