package com.OuSoft.system.service.Contract;

import com.OuSoft.system.entity.Contract;
import com.OuSoft.system.entity.ResponseModel;

import java.util.List;

public interface ContractService {
    /**
     * 查询全部结果
     * @return
     */
    List<Contract> queryContract(Contract contract);
    //新增
    ResponseModel InsertContract(Contract contract);
    //修改
    ResponseModel UpdateContract(Contract contract);

    //删除
    ResponseModel DelContract(String id);
}
