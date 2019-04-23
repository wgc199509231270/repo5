package com.OuSoft.system.service.Mood.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Mood.MoodDao;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Mood.MoodService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Service
public class MoodServiceImpl implements MoodService{

	@Autowired
	MoodDao moodDao;
	/**
	 * 插入心情
	 */
	@Override
	public ResponseModel insertMoodService(Mood mood) {
		int count = 0;
		ResponseModel responModel = new ResponseModel();
		//插入心情
		if(mood.getId() == null || mood.equals("")){
			mood.setId(CommUtil.getID());//生成id
		}
		mood.setMocreatetime(DateUtil.GetDates());
		mood.setUserid(DateUtil.getUserid());//获取当前用户id
		count = moodDao.InsertMoodDao(mood);
		if(count != 0 ){
			responModel.setCode("200");
			responModel.setResult("success");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("001");
			responModel.setMsg("插入心情成功！");
		}else{
			responModel.setCode("404");
			responModel.setResult("fali");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("0053");
			responModel.setMsg("插入心情失败！");
		}
		
		return responModel;
	}
	
	/**
	 * 根据id删除一条心情记录
	 */
	@Override
	public ResponseModel deleteIdTplanServcie(String id) {
		ResponseModel model = new ResponseModel();
		int count = 0;
		System.out.println("id========: " + id);
		if(id != null && id != ""){
			count = moodDao.deleteIdTplanDao(id);
			System.out.println("count==========: " + count);
			if(count > 0 ){
				model.setCode("200");
				model.setResult("success");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("001");
				model.setMsg("删除一条心情记录成功！");
			}else{
				model.setCode("404");
				model.setResult("fali");
				model.setTime(System.currentTimeMillis()+"");
				model.setToken("0053");
				model.setMsg("删除一条心情记录失败！");
			}
			
		}else{
			model.setCode("404");
			model.setResult("fali");
			model.setTime(System.currentTimeMillis()+"");
			model.setToken("0053");
			model.setMsg("id为空，不能删除！");
		}
		
		
		
		return model;
	}

	@Override
	public List<Mood> selectIdTplanServcie(Mood mood) {
		return moodDao.selectIdTplanDao(mood);
	}

	//心情列表
	@SuppressWarnings("unused")
	@Override
	public List<Mood> queryListTmoodService(Mood mood) {
		Tsuser tuser=DateUtil.GetTsuser();
		mood.setTcmid(tuser.getUserpid());
		List<Mood> list = null;
		
		if(!DateUtil.getObjCheckIsNull( mood )  ){
			mood.setDzuserid(DateUtil.getUserid());
			if("sq".equals(mood.getSqtsgin())){
				list = moodDao.queryListTmoodDao(mood);
			}else{
				if(mood.getLoginname() == null || mood.getLoginname() == ""){
					//用户查询条件，用户名为空则是查询当前登录人。有值。则是查询其他用户的信息
					mood.setUserid(DateUtil.getUserid());
					list = moodDao.queryListTmoodDao(mood);
				}else{
					list = moodDao.queryListTmoodDao(mood);
				}
			}
			
		}else{
			System.out.println("心情数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 详情
	 */
	@Override
	public List<Mood> queryListTmoodTpraiseService(Mood mood) {
		List<Mood> list = null;
		if(!DateUtil.getObjCheckIsNull( mood )  ){
			mood.setDzuserid(DateUtil.getUserid());
			list = moodDao.queryListTmoodTpraiseDao(mood);
		}else{
			System.out.println("心情数据为空！点赞详情");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 心情图表
	 */
	@Override
	public List<Mood> queryNumListTmoodService(Mood mood) {
		List<Mood> list = null;
		if(!DateUtil.getObjCheckIsNull( mood )){
			if( mood.getSqtsgin() != null ){
				list = moodDao.queryNumListTmoodDao(mood);
			}else{
				//其他
				if(mood.getLoginname() != null && mood.getLoginname() != ""){
					list = moodDao.queryGNumListTmoodDao(mood);
				}else{
					//个人
					mood.setUserid(DateUtil.getUserid());
					list = moodDao.queryGNumListTmoodDao(mood);
				}
			}
			
		}else{
			System.out.println("心情数据为空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

}
