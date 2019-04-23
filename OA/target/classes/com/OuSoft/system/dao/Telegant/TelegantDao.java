package com.OuSoft.system.dao.Telegant;

import com.OuSoft.system.entity.Telegant;
import groovy.util.logging.Commons;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@Commons(value="telegant")
public interface TelegantDao {

    //查询风采信息
    List<Telegant> queryElegantDao(Telegant telegant);

    //新增风采信息
    int insertElegantDao(Telegant telegant);

    //删除风采信息
    int deleteElegantByidDao(Telegant telegant);


    //修改风采信息
    int updateElegantByidDao(Telegant telegant);

    //查询点赞
    List<Telegant> queryDzTelegantuserRequestDao(Telegant telegant);

}
