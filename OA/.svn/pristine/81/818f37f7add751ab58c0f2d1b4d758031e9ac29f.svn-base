package com.OuSoft.system.controller.Random;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Random;
import com.OuSoft.utils.CommUtil;

@Controller
@RequestMapping(value="/random")
public class RandomController {
	
	@RequestMapping(value="/randomid")
	@ResponseBody
	public Random randomController(String id ){
		Random ran = new Random();
		ran.setRandomid(CommUtil.getID());
		return ran;
	}

	
	
}
