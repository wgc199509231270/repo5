package com.OuSoft.system.dao.Remuneration;

import com.OuSoft.system.entity.Remunerationflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "Remunerationflow")
public interface RemunerationflowDao {
    /**
     * 查询申请记录
     * @param
     * @return
     */
    List<Remunerationflow> QueryRemunerationflowDao();

    /**
     * 根据id修改
     * @param model
     * @return
     */
    int  UpdateRemunerationflowDao(Remunerationflow model);

    /**
     * 新增申请记录
     * @param model
     * @return
     */
    int InsertRemunerationflowDao(Remunerationflow model);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int DelRemunerationflowDao(@Param("id") String id);
}
