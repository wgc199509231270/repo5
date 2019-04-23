package com.OuSoft.system.dao.Tmenuinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tmenuinfo;

 /**
  * 菜单
  * @author pengyueli
  * @date 2018年12月18日
  */
@Mapper
@Component(value="Tmenuinfo")
public interface TmenuinfoDao {

	int saveTmenuinfoDao(Tmenuinfo tmenuinfo);
	
	List<Tmenuinfo> queryTmenuinfoDao(Tmenuinfo tmenuinfo);
	
	int deleteTmenuinfoDao(Tmenuinfo tmenuinfo);
	
	//平台管理员查看所有主菜单列表
	List<Tmenuinfo> queryPtTmenuinfoDao();
	
	
}
