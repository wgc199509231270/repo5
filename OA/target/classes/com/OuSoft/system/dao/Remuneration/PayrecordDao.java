package com.OuSoft.system.dao.Remuneration;

import com.OuSoft.system.entity.Payrecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Component(value = "Payrecord")
public interface PayrecordDao {
    /**
     * 查询薪资记录
     * @return
     */
    List<Payrecord> QuerypayrecordDao(Payrecord pa);

    /**
     * 薪资调薪记录
     * @param pr
     * @return
     */
    int InsertpayrecordDao(Payrecord pr);
}
