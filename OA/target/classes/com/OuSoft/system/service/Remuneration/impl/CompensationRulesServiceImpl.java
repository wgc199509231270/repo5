package com.OuSoft.system.service.Remuneration.impl;

import com.OuSoft.system.dao.Remuneration.CompensationRulesDao;
import com.OuSoft.system.entity.*;
import com.OuSoft.system.service.Remuneration.CompensationRulesService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class CompensationRulesServiceImpl implements CompensationRulesService {


    @Autowired
    CompensationRulesDao crd;


    @Override
    public List<CompensationRules> QueryCompensationRulesList() {
        List<CompensationRules> list=new ArrayList<CompensationRules>();
        list=crd.QueryCompensationRulesList();
        return list;
    }

    @Override
    public ResponseModel deleteIdCr(String id) {
        ResponseModel remodel = new ResponseModel();
        if(id!="" & id!=null ){
            int num = crd.DelCr(id);
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

    @Override
    public ResponseModel insertCrDao(CompensationRules cr) {
        ResponseModel remodel = new ResponseModel();

        if(!DateUtil.getObjCheckIsNull(cr) ){
            int num =  crd.InsertCr(cr);
            System.out.println("num:"+num);
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
    public ResponseModel updateCr(CompensationRules Cr) {
        ResponseModel remodel = new ResponseModel();
        if(!DateUtil.getObjCheckIsNull(Cr) ){
            int num = crd.UpdateCr(Cr);
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
    public CompensationRules QueryCr(String rank) {
        CompensationRules Cr1=new CompensationRules();
        Cr1=crd.QueryCr(rank);
        return Cr1;
    }
    @Override
    public CompensationRules QueryCompensationRulesMeritpay(int num) {
        System.out.println("num和："+num);
        return crd.QueryCompensationRulesMeritpay(num);
    }


    @Override
    public List<Tsuser> QuerycompenService(performance pe) {

        List<Tsuser> tsusers=new ArrayList<Tsuser>();
        String GetDateGY3 = DateUtil.GetDateGY3();//三个月前月初 年月日
        String currentMonthStartTime = DateUtil.getCurrentMonthStartTime();//当月月初 年月日
        pe.setGetDateGY3(GetDateGY3);
        pe.setCurrentMonthStartTime(currentMonthStartTime);
        List<performance> list = crd.Querycompendao(pe);
        String id="";
        String id1="";


        int num=0;
        for(int i=0;i<list.size(); i++){
            Tsuser ts=new Tsuser();
            id1=list.get(i).getUserid();
            if(i==0){
                id=id1;
            }
            if(id1.equals(id)){
                num +=  parseInt(list.get(i).getPfmnumber());
                int n=i+1;
                if(n ==list.size()){
                    //System.out.println("a id"+i+":"+num);
                    int nums=(num/3);
                    CompensationRules compensationRules = QueryCompensationRulesMeritpay(nums);
                    //System.out.println(compensationRules.getMeritpay());
                    ts.setUsername(list.get(i).getUsername());
                     ts.setPosiname(list.get(i).getPosiname());
                     ts.setMeritpay(compensationRules.getMeritpay());
                    ts.setGrzdeparname(list.get(i).getGrzdeparnames());
                    ts.setRemuneration(list.get(i).getRemuneration());
                    tsusers.add(ts);
                }
            }else{
                    i-=1;
                    id=id1;
                    Integer nums=(num/3);
                        CompensationRules compensationRules = QueryCompensationRulesMeritpay(nums);
                        //System.out.println(compensationRules.getMeritpay());
                    ts.setUsername(list.get(i).getUsername());
                    ts.setPosiname(list.get(i).getPosiname());
                    ts.setMeritpay(compensationRules.getMeritpay());
                    ts.setGrzdeparname(list.get(i).getGrzdeparnames());
                    ts.setRemuneration(list.get(i).getRemuneration());
                tsusers.add(ts);
                num=0;

            }

        }

        return tsusers;

    }



}
