package com.OuSoft.system.service.Remuneration;

import com.OuSoft.system.entity.Payrecord;
import com.OuSoft.system.entity.ResponseModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PayrecordService {
    /**
     * 查询薪资记录
     * @return
     */
    List<Payrecord> Querypayrecord(Payrecord pa );

    /**
     * 薪资调薪记录
     * @param pr
     * @return
     */
    ResponseModel Insertpayrecord(@RequestBody Payrecord pr);
}
