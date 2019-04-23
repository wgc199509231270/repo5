package com.OuSoft.system.dao.Contract;

import com.OuSoft.system.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="Contract")
public interface ContractDao {
    /**
     * 查询全部结果
     * @return
     */
    List<Contract> queryContract(Contract contract);
    //新增
    int InsertContract(Contract contract);
    //修改
    int UpdateContract(Contract contract);

    //删除
    int DelContract(String id);
}
