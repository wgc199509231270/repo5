package com.OuSoft.system.controller.Tsmenu;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsmenu;
import com.OuSoft.system.service.Tsmenu.ITsmenuService;

@Controller
public class TsmenuController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	ITsmenuService iTsmenuService;
	@RequestMapping(value="/QueryTsmenuList")
	@ResponseBody
	public List<Tsmenu> QueryTsmenuList() {;
		List<Tsmenu> list = new ArrayList<Tsmenu>();
		list = iTsmenuService.QueryTsmenuList();
		return list;
	}
	@RequestMapping(value="/DelTsmenu")
	@ResponseBody
	public ResponseModel DelTsmenu(@Param("whetherpublic") String whetherpublic) {
		ResponseModel model = iTsmenuService.DelTsmenu(whetherpublic);
		return model;
	}

	@RequestMapping(value="/QueryTsmenuByid")
	@ResponseBody
	public Tsmenu QueryTsmenuByid(@Param("whetherpublic") String whetherpublic) {
		Tsmenu model = iTsmenuService.QueryTsmenuByid(whetherpublic);
		return model;
	}

	@RequestMapping(value="/UpdateTsmenuByid")
	@ResponseBody
	public ResponseModel UpdateTsmenuByid(@RequestBody Tsmenu model) {
		ResponseModel remodel = iTsmenuService.UpdateTsmenuByid(model);
		return remodel;
	}

	@RequestMapping(value="/InsertTsmenu")
	@ResponseBody
	public ResponseModel InsertTsmenu(@RequestBody Tsmenu model) {
		ResponseModel remodel = iTsmenuService.InsertTsmenu(model);
		return remodel;
	}
}
