package com.OuSoft.system.service.Remuneration;

import com.OuSoft.system.entity.CompensationRules;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompensationRulesService {
    //查询全部
    List<CompensationRules> QueryCompensationRulesList();
    //根据id删除
    ResponseModel deleteIdCr(String id);

    //新增规则
    ResponseModel insertCrDao(@RequestBody CompensationRules cr);

    //根据id修改
    ResponseModel updateCr(CompensationRules Cr);

    //根据级别查询
    CompensationRules QueryCr(@Param("rank") String rank);



    List<Tsuser> QuerycompenService(performance pe);

    CompensationRules QueryCompensationRulesMeritpay(@Param("num" )int num);
}
