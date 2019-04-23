package com.OuSoft.system.controller.mood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Mood.MoodService;

@RequestMapping(value="/mood")
@Controller
public class MoodController {
	
	@Autowired
	MoodService moodService;
	
	/**
	 * 心情图表
	 * @author pyl
	 * @date 2018年10月16日
	 */
	@RequestMapping(value="/queryNumListMood")
	@ResponseBody
	public List<Mood> queryNumListTmoodController(Mood mood){
		return moodService.queryNumListTmoodService(mood);
	}
	
	
	
	/**
	 * 插入心情
	 * @author pyl
	 * @date 2018年9月5日
	 */
	@RequestMapping(value="/insertMood")
	@ResponseBody
	public ResponseModel insertMood(Mood mood){
		
//		mood.setMotext("我是一个大坏蛋,yiyayiyahei！");
//		mood.setMonumber("");//心情4321
		
		ResponseModel model = moodService.insertMoodService(mood);
		return model;
	}
	
	/**
	 * 根据心情id删除一条数据
	 * @author pyl
	 * @date 2018年9月10日
	 */
	@RequestMapping(value="/deleteidtMood")
	@ResponseBody
	public ResponseModel deleteIdTplanController(String id){
		
//		id = "111";
		
		ResponseModel mood = moodService.deleteIdTplanServcie(id);
		return mood;
	}
	/**
	 * 根据心情id查看一条数据
	 */
	@RequestMapping(value="/selectidtMood")
	@ResponseBody
	public List<Mood> deleteIdTplanController(Mood mood){
		return moodService.selectIdTplanServcie(mood);
	}

	/**
	 * 心情列表
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value="/queryListTmood")
	@ResponseBody
	public List<Mood> queryListTmoodController(Mood mood){
		
		
//		mood.setBegtime("2018/09/05");
//		mood.setEndtime("2018/09/19");
//		mood.setUsername("wy");
//		mood.setLoginname("隆隆");
		
		
		List<Mood> list = moodService.queryListTmoodService(mood);
		return list;
	}
	
	/**
	 * 心情点赞详情
	 * @author pyl
	 * @date 2018年9月20日
	 */
	@RequestMapping(value="/queryListTmoodTpraise")
	@ResponseBody
	public List<Mood> queryListTmoodTpraiseService(Mood mood){
		
//		id = "1ad2fc60c1d44050a0d3f9358f01c4be";
		
		List<Mood> lsit = moodService.queryListTmoodTpraiseService(mood);
		return lsit;
		
	}
	
	
	
	

}
