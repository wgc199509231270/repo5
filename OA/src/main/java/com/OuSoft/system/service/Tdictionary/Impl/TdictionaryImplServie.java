package com.OuSoft.system.service.Tdictionary.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tdictionary.TdictionaryDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tdictionary;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tdictionary.TdictionaryService;
import com.OuSoft.utils.DateUtil;

/**
 * 数据字典表
 * @author pengyueli
 * @date 2018年12月20日
 */
@Service
public class TdictionaryImplServie implements TdictionaryService {

	@Autowired
	TdictionaryDao dao;
	
	/**
	 * 新增
	 */
	@Override
	public ResponseModel saveTdictionaryService(Tdictionary tdictionary) {
		ResponseModel remodel = new ResponseModel();
		Tsuser tu = DateUtil.GetTsuser();
		int num = 0;
		if(tdictionary != null){
				tdictionary.setId(DateUtil.getID());
				tdictionary.setDtime(DateUtil.GetDates());
				tdictionary.setDpid(tu.getUserpid());
				num = dao.saveTdictionaryDao(tdictionary);
				if(num > 0 ){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增数据字典成功！");
				}else{
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增数据字典失败！");
				}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据字典为空！");
		}
		
		
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 查询
	 */
	@Override
	public List<Tdictionary> queryTdictionaryService(Tdictionary tdictionary) {
		List<Tdictionary> list = null;
//		Tsuser tsuser = DateUtil.GetTsuser();
//		String pid = tsuser.getUserpid();
//		if("000".equals(pid)){
			//是000查询所有
//			list = dao.queryTdictionaryDao(tdictionary);
//		}else{
			//未实例化list,用null判断，list=[]实例化后，用list.size()>0判断
//			tdictionary.setDpid(pid);
			list = dao.queryTdictionaryDao(tdictionary);
//		}
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 删除字典
	 */
	@Override
	public ResponseModel deleteTdictionaryService(Tdictionary tdictionary) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		if(tdictionary != null){
			if(tdictionary.getId() != null && !"".equals(tdictionary.getId())){
				num = dao.deleteTdictionaryDao(tdictionary);
				if(num > 0 ){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("删除一条数据字典成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除字典失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("id数据字典数据为空！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("数据字典数据为空！");
		}
		
		// TODO Auto-generated method stub
		return remodel;
	}

}
