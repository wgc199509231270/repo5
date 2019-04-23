package com.OuSoft.mobileCommerce.service.Login;


import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import org.springframework.stereotype.Service;


public interface MLoginService {

	//修改用户token
    ResponseModel upTsuserTokenService (Tsuser tsu);

    //查询用户token
    Tsuser QueryUserTokenService(Tsuser tsu);
    
}
