package com.OuSoft.system.service.Tcompany.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.Tcompany.TcompanyDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tcompany;
import com.OuSoft.system.service.Tcompany.TcompanyService;
import com.OuSoft.utils.DateUtil;
/**
 * 公司
 * @author pengyueli
 * @date 2018年12月18日
 */
@Service
public class TcompanyImplService implements TcompanyService{

	@Autowired
	TcompanyDao dao;
	
	/**
	 * 添加公司信息  后台给：-创建时间createtime，- createuserid创建人
	 * 添加第一个公司时，-splitnamecode 公司登记编码为001，- totalcompanyid总公司id为当前公司编码， 
	 * 添加分公司时，-公司编码为（获取上一个公司下的公司编码并且拼接001，如果是平级则是001002，），-公司编码为集团公司id,-创建时间，创建人
	 * 		       说明：
			分公司创建，参数： 
	  			 公司等级编码   : splitnamecode
			 	总公司id : totalcompanyid
			新公司创建，参数：
			totalname：公司名称 
			splitnamecode：公司编码， 
			 remark 备注
			ctype 公司类型
			cdescribe ：公司描述
			crange ：公司经营范围
			cscale ：公司规模
			verbstate ：公司运营状态	
			methodusername ：公司法人姓名
			methoduserphone 法人手机号
	 */
	@Override
	public ResponseModel saveTcompanyService(Tcompany tcompany) {
		ResponseModel remodel = new ResponseModel();
		int num = 0;
		//判断对象是否为null
		if(!DateUtil.getObjCheckIsNull(tcompany)){
			//公用变量
			String uuid = DateUtil.getID();//获取UUID
			tcompany.setId(uuid);//主键id
			tcompany.setCreatetime(DateUtil.GetDates());//新增时间
			tcompany.setCreateuserid(DateUtil.getUserid());//创建人
			
			// 分公司创建，新增时查看，是否有公司等级编码，如果有值则是分公司，无值则是新公司
			if(tcompany.getSplitnamecode() != null && tcompany.getTotalcompanyid() != null ){//不等于null则是创建分公司
				//创建分公司时，分公司的上一级的等级编码，
				String code = tcompany.getSplitnamecode();
				//等级编码数，+3
				String number = (Integer.valueOf(code.length())+3)+"";
				//查询当前公司都有哪些公司等级编码
				Tcompany company = new Tcompany();//已经做好排序
				company.setTotalcompanyid(tcompany.getTotalcompanyid());//总公司id,
				company.setSplitnamecode(code);//等级编码
				company.setNum(number);//等级编码数 +3
				System.out.println("查询公司信,等级编码为： " +number+" ，登记编码为： " + code + " ，总公司id为： " +tcompany.getTotalcompanyid());
				List<Tcompany> list = new ArrayList<Tcompany>();
				list = dao.queryTcompanyDao(company);//根据总公司id，等级编码splitnamecode，编码数+3 : num查出所有公司信息
				//如果为空则是第一次,null和空（集合）有区别
				if(list.size() == 0 ){
					code = code+"001";
					System.out.println("新创建的等级编码为： " + code);
				//不是空则是有数据
				}else{
					//因为排序好，获取第一条数据，等级编码加1
					Tcompany tcom = list.get(0);
					//将公司编码加1后设置新分公司等级编码中
					String Splitnamecode = tcom.getSplitnamecode();
					//取出最后一个等级编码，然后加1,因为开始有00所以加1后再拼接为00
					int numbers = Integer.valueOf(Splitnamecode)+1;
					code = "00"+numbers;
					System.out.println("增加前code: " +Splitnamecode+ "增加后： " + code );
				}
				if(code != null && tcompany.getTotalcompanyid() != null){
					//分公司等级编码创建
					tcompany.setSplitnamecode(code);
					num = dao.saveTcompanyDao(tcompany);
					if(num > 0){
						remodel.setCode("200");
						remodel.setResult("success");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("001");
						remodel.setMsg("新增公司成功！");
					}else{
						remodel.setCode("400");
						remodel.setResult("fali");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("0053");
						remodel.setMsg("新增公司失败！");
					}
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("公司数据不正确！");
				}
				
				
			// 新公司创建
			}else if(tcompany.getSplitnamecode() == null && tcompany.getTotalcompanyid() == null ) {
				tcompany.setTotalcompanyid(uuid);//创建新公司，新公司主键id和集团公司id一样
				tcompany.setSplitnamecode("001");//创建新公司，等级编码为001
				num = dao.saveTcompanyDao(tcompany);
				if(num > 0){
					remodel.setCode("200");
					remodel.setResult("success");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("001");
					remodel.setMsg("新增公司成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("新增公司失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("公司数据信息错误，请假差公司编码和总公司主键！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("公司参数为空！");
		}
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 删除一个公司
	 */
	@Override
	public ResponseModel deleteTcompanyService(Tcompany tcompany) {
		int num = 0;
		ResponseModel remodel = new ResponseModel();
		if(tcompany != null){
			if(tcompany.getId() != null && !"".equals(tcompany.getId())){
				num = dao.deleteTcompanyDao(tcompany);
				if(num>0){
						remodel.setCode("200");
						remodel.setResult("success");
						remodel.setTime(System.currentTimeMillis()+"");
						remodel.setToken("001");
						remodel.setMsg("删除公司成功！");
				}else{
					remodel.setCode("400");
					remodel.setResult("fali");
					remodel.setTime(System.currentTimeMillis()+"");
					remodel.setToken("0053");
					remodel.setMsg("删除公司失败！");
				}
			}else{
				remodel.setCode("400");
				remodel.setResult("fali");
				remodel.setTime(System.currentTimeMillis()+"");
				remodel.setToken("0053");
				remodel.setMsg("id参数为空！");
			}
		}else{
			remodel.setCode("400");
			remodel.setResult("fali");
			remodel.setTime(System.currentTimeMillis()+"");
			remodel.setToken("0053");
			remodel.setMsg("参数为空！");
			
		}
		
		
		// TODO Auto-generated method stub
		return remodel;
	}

	/**
	 * 查询公司信息，
	 * 查询所有公司信息：等级编码：splitnamecode
	 * 查询公司下级公司的所有信息： 后台给等级编码位数num,总公司id:totalcompanyid，上级公司等级编码：splitnamecode
	 */
	@Override
	public List<Tcompany> queryTcompanyService(Tcompany tcompany) {
		List<Tcompany> list  = dao.queryTcompanyDao(tcompany);
		// TODO Auto-generated method stub
		return list;
	}
	
	}

	
	
	
	
	
