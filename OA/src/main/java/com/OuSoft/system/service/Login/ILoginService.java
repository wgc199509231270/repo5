package com.OuSoft.system.service.Login;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;

public interface ILoginService {

    ResponseModel QueryUserService(Tsuser tsuser,  HttpServletRequest request );
   
    ResponseModel insertUserService(Tsuser tsuser);
    
    //查询用户名
    List<Tsuser> queryNameTuserService(Tsuser tsu);
    
    ResponseModel updateTattipIpService(String ip);

    
}
