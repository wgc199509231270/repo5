package com.OuSoft.system.dao.Login;


import java.util.List;

import com.OuSoft.system.entity.Tsuser;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "Tuser")
public interface LoginDao {

    Tsuser QueryUser(Tsuser tsuser);
    
    int insertUserDao(Tsuser tsuser);
    
    //查询用户名
    List<Tsuser> queryNameTuserDao(Tsuser tsu);
    
    //修改tattip中的ip
    int updateTattipIpDao(String ip);
    
    //查询是否有重复的用户名
    List<Tsuser> queryLoginname( String loginname);
    
    
}
