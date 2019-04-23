package com.OuSoft.system.dao.Remuneration;

import com.OuSoft.system.entity.CompensationRules;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.entity.performance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Component(value = "CompensationRules")
public interface CompensationRulesDao {
    //查询全部
    List<CompensationRules> QueryCompensationRulesList();
    //根据id删除
    int DelCr(@Param("id") String id);

    //新增规则
    int  InsertCr(@RequestBody CompensationRules cr);

   //根据id修改
    int UpdateCr(@RequestBody CompensationRules Cr);

    //根据级别查询
    CompensationRules QueryCr(@Param("rank")String rank);


    List<performance> Querycompendao(performance pe);

    CompensationRules QueryCompensationRulesMeritpay(@Param("num" )int num);
}
