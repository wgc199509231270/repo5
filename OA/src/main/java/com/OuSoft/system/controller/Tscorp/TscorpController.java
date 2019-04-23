package com.OuSoft.system.controller.Tscorp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.dao.Tscorp.Model.TscorpModel;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tquestion;
import com.OuSoft.system.entity.Tscorp;
import com.OuSoft.system.service.Tscorp.TscorpService;

@Controller
@RequestMapping(value="/tscorp")
public class TscorpController {
	
	@Autowired
	TscorpService service;
	
	
	@ResponseBody
	@RequestMapping(value="/InsertTscorp")
	public ResponseModel InsertTscorp(Tscorp tsmodel){
		ResponseModel model = new ResponseModel();
		boolean b  = service.InsertTscorp(tsmodel);
		if(b){
			model.setCode("1");
		}else{
			model.setCode("50002");
		}
		return model;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/DelTscorp")
	public ResponseModel deleteTquestionController(String id){
		ResponseModel model = new ResponseModel();
		boolean b = service.DelTscorp(id);
		if(b){
			model.setCode("1");
		}else{
			model.setCode("50002");
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/UpdateTscorp")
	public ResponseModel UpdateTscorp(Tscorp tsmodel){
		ResponseModel model = new ResponseModel();
		boolean b = service.UpdateTscorp(tsmodel);
		if(b){
			model.setCode("1");
		}else{
			model.setCode("50002");
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/QueryTscorpList")
	public List<TscorpModel> QueryTscorpList(TscorpModel model){
		List<TscorpModel> list = service.QueryTscorpList(model);
		return list;
	}
	

}
