package com.OuSoft.system.service.Telegant.Impl;


import com.OuSoft.system.dao.Telegant.TelegantDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Telegant;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Telegant.TelegantService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegantImplService implements TelegantService{
    @Autowired
    TelegantDao telegantDao;


    @Override
    public List<Telegant> queryElegantService(Telegant telegant) {
        if("02".equals(telegant.getAlluser())){
            telegant.setUserid(DateUtil.getUserid());
        }
        if((!"".equals(telegant.getStarttime())&&telegant.getStarttime()!=null)||(!"".equals(telegant.getEndtime())&&telegant.getEndtime()!=null)){
            telegant.setStarttime(telegant.getStarttime().replaceAll("-","/")+" "+"00:00:00");
            telegant.setEndtime(telegant.getEndtime().replaceAll("-","/")+" "+"23:59:59");
        }
        return telegantDao.queryElegantDao(telegant);
    }

    @Override
    public ResponseModel insertElegantService(Telegant telegant) {
        ResponseModel remodel = new ResponseModel();
        if(!DateUtil.getObjCheckIsNull(telegant)){
            telegant.setId(DateUtil.getID());
            telegant.setCreatetime(DateUtil.GetDates());
            if("".equals(telegant.getUserid())||telegant.getUserid()==null){
                telegant.setUserid(DateUtil.getUserid());
            }
                int num = telegantDao.insertElegantDao(telegant);
                if(num > 0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("新增一条风采信息成功！");
                    remodel.setId(telegant.getId());
                }else{
                    remodel.setCode("404");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("新增一条风采信息失败！");
                }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("风采信息为空！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public ResponseModel deleteElegantByidService(Telegant telegant) {
        ResponseModel remodel = new ResponseModel();
        if(!DateUtil.getObjCheckIsNull(telegant) ){
            int num = telegantDao.deleteElegantByidDao(telegant);
            if(num > 0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("删除一条风采信息成功！");
            }else{
                remodel.setCode("404");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("删除一条风采信息失败！");
            }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("风采id为空，删除失败！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public ResponseModel updateElegantByidService(Telegant telegant) {
        ResponseModel remodel = new ResponseModel();
        if(!DateUtil.getObjCheckIsNull(telegant) ){
                int num = telegantDao.updateElegantByidDao(telegant);
                if(num > 0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("修改一条用户风采信息成功！");
                }else{
                    remodel.setCode("404");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("修改一条用户风采信息失败！");
                }
        }else{
            remodel.setCode("404");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("用户风采信息为空！");
        }
        return remodel;
    }

    @Override
    public List<Telegant> queryDzTelegantuserRequestService(Telegant telegant) {
        List<Telegant> list = null;
        Tsuser tu = DateUtil.GetTsuser();
        telegant.setUserid(tu.getId());
        list=telegantDao.queryDzTelegantuserRequestDao(telegant);
        // TODO Auto-generated method stub
        return list;
    }
}
