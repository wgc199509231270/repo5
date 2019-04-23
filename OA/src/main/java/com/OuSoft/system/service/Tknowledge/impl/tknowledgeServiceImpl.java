package com.OuSoft.system.service.Tknowledge.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tknowledge.TknowledgeDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tknowledge;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tknowledge.tknowledgeService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Service
public class tknowledgeServiceImpl implements tknowledgeService{

	@Autowired
	TknowledgeDao dao;
	
	@Override
	public ResponseModel deleteIdTknowledgeService(String id) {
		int count = 0;
		ResponseModel remodel = new ResponseModel();
		if(id != null && id != ""){
			count = dao.deleteIdTknowledgeDao(id);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条知识成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条知识失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("知识ID为空！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	@Override
	public List<Tknowledge> selectIdTknowledgeService(Tknowledge tknowledge) {
		return dao.selectIdTknowledgeDao(tknowledge);
	}

	//插入知识
	@Override
	public ResponseModel insertTknowledgeServcie(Tknowledge tknowledge) {
		ResponseModel remodel = new ResponseModel();
		System.out.println("打印知识：" + tknowledge);
		int count = 0;
		if(!DateUtil.getObjCheckIsNull( tknowledge ) ){
			if(tknowledge.getId() == null || tknowledge.equals("")){
				tknowledge.setId(CommUtil.getID());//生成id
			}
			tknowledge.setLacreatetime(DateUtil.GetDates());
			tknowledge.setUserid(DateUtil.getUserid());//用户id
			count = dao.insertTknowledgeDao(tknowledge);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("发布知识成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("发布知识失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("知识数据为空！");
		}
		return remodel;
	}

	/**
	 * 知识列表
	 */
	@Override
	public List<Tknowledge> queryListTknowledgeService(Tknowledge tknowledge) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tknowledge> tkn = null;
		if(!DateUtil.getObjCheckIsNull( tknowledge ) ){
			//全查
			tknowledge.setTcmid(tuser.getUserpid());
			tknowledge.setDzuserid(DateUtil.getUserid());
			if(tknowledge.getSqtsgin() != null ){
				if(tknowledge.getSqtsgins() != null){
					//最新，时间
					if(tknowledge.getSqtsgins().equals("zx") ){
						tkn = dao.queryZxListTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zr")) {
					//最热，点赞
						tkn = dao.queryListZrTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zh")){
						//最热，点火
						tkn = dao.queryListZhTknowledgeDao(tknowledge);
					}else {
						tkn = dao.queryListTknowledgeDao(tknowledge);
					}
				}else{
					System.out.println("知识全查数据信息错误");
				}
			}else{
				//个人
				if(tknowledge.getLoginname() == null || tknowledge.getLoginname() == ""){
					tknowledge.setUserid(DateUtil.getUserid());
					//最新，时间
					if(tknowledge.getSqtsgins().equals("zx") ){
						tkn = dao.queryZxListTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zr")) {
					//最热，点赞
						tkn = dao.queryListZrTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zh")){
						//最热，点火
						tkn = dao.queryListZhTknowledgeDao(tknowledge);
					}else {
						tkn = dao.queryListTknowledgeDao(tknowledge);
					}
				}else{
						//最新，时间
					if(tknowledge.getSqtsgins().equals("zx") ){
						tkn = dao.queryZxListTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zr")) {
						//最热，点赞
						tkn = dao.queryListZrTknowledgeDao(tknowledge);
					}else if(tknowledge.getSqtsgins().equals("zh")){
						//最热，最火
						tkn = dao.queryListZhTknowledgeDao(tknowledge);
					}else {
						tkn = dao.queryListTknowledgeDao(tknowledge);
					}
				}
			}
		}else {
			System.out.println("知识数据为空！");
		}
		// TODO Auto-generated method stub
		return tkn;
	}

	@Override
	public List<Tknowledge> queryListTknowledgeTpraiseService(Tknowledge tknowledge) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tknowledge> tkn = null;
		if(!DateUtil.getObjCheckIsNull( tknowledge ) ){
			tknowledge.setTcmid(tuser.getUserpid());
			tknowledge.setDzuserid(DateUtil.getUserid());
			tkn = dao.queryListTknowledgeTpraiseDao(tknowledge);
		}else{
			System.out.println("数据知识为空！");
		}
		// TODO Auto-generated method stub
		return tkn;
	}

	/**
	 * 知识图表-点赞评论条数
	 * 起止日期，
	 * 参数：起止时间，sqtsgin:(tpranum:点赞、comnum:评论、tsnum:发布数 )
	 */
	@Override
	public List<Tknowledge> queryFbNumListTknowledgeService(Tknowledge tknowledge) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tknowledge> list = new ArrayList<Tknowledge>();
		if(!DateUtil.getObjCheckIsNull( tknowledge ) ){
			tknowledge.setTcmid(tuser.getUserpid());
			if(tknowledge.getSqtsgin() != null){
				if( tknowledge.getSqtsgin().equals("tpranum") ) {
					list = dao.queryDzNumListTknowledgeDao(tknowledge);
				}else if( tknowledge.getSqtsgin().equals("comnum") ) { 
					list = dao.queryPlNumListTknowledgeDao(tknowledge);
				}else if( tknowledge.getSqtsgin().equals("tsnum") ) {
					list = dao.queryFbNumListTknowledgeDao(tknowledge);
				}else{
					System.out.println("知识参数不正确！");
					tknowledge.setSqtsgin("知识参数不正确！");
					list.add(tknowledge);
				}
			}
		}else{
			System.out.println("知识参数不正确！");
			tknowledge.setSqtsgin("知识参数不正确！");
			list.add(tknowledge);
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 个人知识图表统计
	 */
	@Override
	public List<Tknowledge> queryGListTknowledgeService(Tknowledge tknowledge) {
		Tsuser tuser=DateUtil.GetTsuser();
		tknowledge.setTcmid(tuser.getUserpid());
		 List<Tknowledge> tknowledgeList = null;
		 if(!DateUtil.getObjCheckIsNull( tknowledge ) ){//条件
			 if( tknowledge.getLoginname() != null && tknowledge.getLoginname() != null ){
				 tknowledgeList = dao.queryGListTknowledgeDao(tknowledge);
			 }else{//个人
				 tknowledge.setUserid(DateUtil.getUserid());
				 tknowledgeList = dao.queryGListTknowledgeDao(tknowledge);
			 }
		 }
		
		
		// TODO Auto-generated method stub
		return tknowledgeList;
	}
	
	

}
