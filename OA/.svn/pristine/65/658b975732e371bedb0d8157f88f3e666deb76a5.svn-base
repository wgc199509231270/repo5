package com.OuSoft.system.service.Contract.impl;

import com.OuSoft.system.dao.Contract.ContractDao;
import com.OuSoft.system.entity.Contract;
import com.OuSoft.system.entity.Performanceparm;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Contract.ContractService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractServiceImpl  implements ContractService {

        @Autowired
        ContractDao cd;

    @Override
    public List<Contract> queryContract(Contract contract) {
        List<Contract> contracts = cd.queryContract(contract);
        return contracts;
    }

    @Override
    public ResponseModel InsertContract(Contract contract) {

        ResponseModel remodel = new ResponseModel();

        if(!DateUtil.getObjCheckIsNull(contract) ){
            contract.setId(DateUtil.getID());
            contract.setCreatetime(DateUtil.GetDate());
            int num =  cd.InsertContract(contract);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("新增成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("新增失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("新增数据为空！");
        }
        return remodel;
    }

    @Override
    public ResponseModel UpdateContract(Contract contract) {
        ResponseModel remodel = new ResponseModel();
        if(!DateUtil.getObjCheckIsNull(contract) ){
            int num = cd.UpdateContract(contract);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("修改个人信息成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("修改个人信息失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("个人信息数据为空！");
        }
        return remodel;
    }

    @Override
    public ResponseModel DelContract(String id) {
        ResponseModel remodel = new ResponseModel();
        if(id!="" & id!=null ){
            int num = cd.DelContract(id);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("删除成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("删除失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("删除为空！");
        }
        return remodel;
    }


    public List<Contract> q2ueryContract(List<Performanceparm> list) {
        List list1=new ArrayList();
        Map m=new HashMap();
        for(int i=0;i<list.size(); i++){
            int num=0;
            String id=list.get(i).getId();
            for(int j=i+1;i<list.size();j++){
                num=Integer.parseInt(list.get(i).getPfmnumber());
                if(list.get(j).getId()==id){
                    num+=Integer.parseInt(list.get(j).getPfmnumber());
                }
            }
            m.put("pfmnumber",num);
        }
        list1.add(m);
        return list1;
    }


}
