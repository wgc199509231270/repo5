package com.OuSoft.system.service.Tsmenu.impl;

import com.OuSoft.system.dao.Tsmenu.TsmenusDao;
import com.OuSoft.system.entity.Tsmenu;
import com.OuSoft.system.service.Tsmenu.ITsmenuService;
import org.springframework.web.bind.annotation.RequestBody;
import com.OuSoft.system.entity.ResponseModel;
import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TsmenuServiceImpl implements ITsmenuService {

	@Autowired
	TsmenusDao tsmenu;
	
	@Override
	public List<Tsmenu> QueryTsmenuList() {
		List<Tsmenu> list = new ArrayList<Tsmenu>();
		list = tsmenu.QueryTsmenuList();
		return list;
	}
	@Override
	public ResponseModel DelTsmenu(@Param("whetherpublic") String whetherpublic) {
		ResponseModel model = new ResponseModel();
		model = tsmenu.DelTsmenu(whetherpublic);
		return model;
	}
	@Override
	public ResponseModel UpdateTsmenuByid(@RequestBody Tsmenu model) {
		ResponseModel remodel = new ResponseModel();
		tsmenu.UpdateTsmenuByid(model);
		return remodel;
	}
	@Override
	public Tsmenu QueryTsmenuByid(@Param("whetherpublic") String whetherpublic) {
		Tsmenu model = new Tsmenu();
		model = tsmenu.QueryTsmenuByid(whetherpublic);
		return model;
	}
	@Override
	public ResponseModel InsertTsmenu(@RequestBody Tsmenu model) {
		ResponseModel remodel = new ResponseModel();
		 tsmenu.InsertTsmenu(model);
		return remodel;
	}
}
