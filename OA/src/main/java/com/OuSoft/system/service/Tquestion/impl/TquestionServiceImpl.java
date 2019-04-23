package com.OuSoft.system.service.Tquestion.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tquestion.TquestionDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tquestion;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tquestion.TquestionService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Service
public class TquestionServiceImpl implements TquestionService{

	@Autowired
	TquestionDao dao;
	
	/**
	 * 新增问答
	 */
	@Override
	public ResponseModel insertTquestionService(Tquestion tquestion) {
		ResponseModel remodel = new ResponseModel();
		System.out.println("打印知识：" + tquestion);
		int count = 0;
		if(!DateUtil.getObjCheckIsNull(tquestion) ){
			if(tquestion.getId() == null || tquestion.equals("")){
				tquestion.setId(CommUtil.getID());//生成id
			}
			tquestion.setQucreatetime(DateUtil.GetDates());
			tquestion.setUserid(DateUtil.getUserid());//用户id
			//未解决
			tquestion.setQustatus("01");
			count = dao.insertTquestionDao(tquestion);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("发布问答成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("发布问答失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("问答数据为空！");
		}
		return remodel;
	}

	/**
	 * 删除问答
	 */
	@Override
	public ResponseModel deleteIdTquestionService(String id) {
		int count = 0;
		ResponseModel remodel = new ResponseModel();
		if(id != null && id != ""){
			count = dao.deleteIdTquestionDao(id);
			if(count > 0){
				remodel.setCode("200");
				remodel.setResult("success");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("001");
				remodel.setMsg("删除一条问答成功！");
			}else{
				remodel.setCode("404");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("删除一条问答失败！");
			}
		}else{
			remodel.setCode("404");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("问答ID为空！");
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	//问答列表
	@Override
	public List<Tquestion> queryListTquestionService(Tquestion tquestion) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tquestion> list = null;
		if(!DateUtil.getObjCheckIsNull(tquestion)){
			tquestion.setTcmid(tuser.getUserpid());
			tquestion.setDzuserid(DateUtil.getUserid());
				if(tquestion.getSqtsgin() !=null ){
					if(tquestion.getSqtsgins() != null){
						if(tquestion.getSqtsgins().equals(("zx"))){//最新
							list = dao.queryListZxTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zr")) {//最热
							list = dao.queryListZrTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zh")) {//最火
							list = dao.queryListZhTquestionDao(tquestion);
						}else{
							list = dao.queryListTquestionDao(tquestion);
						}
					}else {
						System.out.println("问答数据错误！");
					}
				}else{
					if(tquestion.getLoginname() == null || tquestion.getLoginname() == ""){
						tquestion.setUserid(DateUtil.getUserid());
						if(tquestion.getSqtsgins().equals(("zx"))){//最新
							list = dao.queryListZxTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zr")) {//最热
							list = dao.queryListZrTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zh")) {//最火
							list = dao.queryListZhTquestionDao(tquestion);
						}else{
							list = dao.queryListTquestionDao(tquestion);
						}
					}else{
						if(tquestion.getSqtsgins().equals(("zx"))){//最新
							list = dao.queryListZxTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zr")) {//最热
							list = dao.queryListZrTquestionDao(tquestion);
						}else if(tquestion.getSqtsgins().equals("zh")) {//最火
							list = dao.queryListZhTquestionDao(tquestion);
						}else{
							list = dao.queryListTquestionDao(tquestion);
						}
					}
				}
			
		}else{
			System.out.println("问答数据空！");
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	//问答点赞详情
	@Override
	public List<Tquestion> queryListTquestionTpraiseService(Tquestion tquestion) {
		List<Tquestion> list = null;
		if(!DateUtil.getObjCheckIsNull(tquestion)){
			Tsuser tuser=DateUtil.GetTsuser();
			tquestion.setTcmid(tuser.getUserpid());
			tquestion.setDzuserid(DateUtil.getUserid());
			list = dao.queryListTquestionTpraiseDao(tquestion);
		}else{
			System.out.println("问答数据空！");
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 问答点赞、评论、发布数
	 */
	@Override
	public List<Tquestion> queryDzNumListTquestionService(Tquestion tquestion) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tquestion> list = new ArrayList<Tquestion>();
		if(!DateUtil.getObjCheckIsNull(tquestion)){
			tquestion.setTcmid(tuser.getUserpid());
			if(tquestion.getSqtsgin() != null){
				if( tquestion.getSqtsgin().equals("tpranum") ) {
					list = dao.queryDzNumListTquestionDao(tquestion);
				}else if( tquestion.getSqtsgin().equals("comnum") ) { 
					list = dao.queryPlNumListTquestionDao(tquestion);
				}else if( tquestion.getSqtsgin().equals("tsnum") ) {
					list = dao.queryFbNumListTquestionDao(tquestion);
				}else{
					System.out.println("知识参数不正确！");
					tquestion.setSqtsgin("知识参数不正确！");
					list.add(tquestion);
				}
			}
		}else{
			System.out.println("知识参数不正确！");
			tquestion.setSqtsgin("知识参数不正确！");
			list.add(tquestion);
		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 问答个人图表
	 */
	@Override
	public List<Tquestion> queryGListTquestionService(Tquestion tquestion) {
		Tsuser tuser=DateUtil.GetTsuser();
		List<Tquestion> tquestionList = null;
		if(!DateUtil.getObjCheckIsNull(tquestion) ){
			tquestion.setTcmid(tuser.getUserpid());
			if(tquestion.getLoginname() != null && tquestion.getLoginname() != ""  ){
				tquestionList = dao.queryGListTquestionDao(tquestion);
			}else{
				tquestion.setUserid(DateUtil.getUserid());
				tquestionList = dao.queryGListTquestionDao(tquestion);
			}
			
		}else{
			System.out.println("问答个人图表数据为空");
		}
		// TODO Auto-generated method stub
		return tquestionList;
	}

	@Override
	public List<Tquestion> selectIdTquestionService(Tquestion tquestion) {
		return dao.selectIdTquestionDao(tquestion);
	}

}
