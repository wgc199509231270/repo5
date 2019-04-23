package com.OuSoft.system.service.Tactivity.Impl;


import com.OuSoft.system.dao.Tactivity.TactivityDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tactivity;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tactivity.TactivityService;
import com.OuSoft.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class TactivityImplService implements TactivityService{

    @Autowired
    TactivityDao tactivityDao;
    @Override
    public ResponseModel insertTactivityService(Tactivity tactivity) {
        ResponseModel remodel= new ResponseModel();
        int num = 0;
        if(tactivity != null){
            Tsuser tu = DateUtil.GetTsuser();
            tactivity.setId(DateUtil.getID());
            tactivity.setCreattime(DateUtil.GetDates());
            tactivity.setPromulgatorid(tu.getId());
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            String starttime=tactivity.getStarttime();
            String endtime=tactivity.getEndtime();
            try {
                if(sdf.parse(date).getTime()<sdf.parse(starttime).getTime()){
                    tactivity.setStatus("01");
                }else if(sdf.parse(starttime).getTime()<=sdf.parse(date).getTime() && sdf.parse(date).getTime()<=sdf.parse(endtime).getTime()){
                    tactivity.setStatus("02");
                }else if(sdf.parse(date).getTime()>=sdf.parse(endtime).getTime()){
                    tactivity.setStatus("03");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            num = tactivityDao.insertTactivityDao(tactivity);
            if(num>0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("新增活动成功！");
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("新增活动失败！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("活动数据为空！");
        }

        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public List<Tactivity> queryListActivityService(Tactivity tactivity) {
            List<Tactivity> list = null;
            Tsuser tu = DateUtil.GetTsuser();
            tactivity.setUserid(tu.getId());
            if("00".equals(tactivity.getStatus())){
                tactivity.setStatus("");
            }else if("02".equals(tactivity.getAlluser())){
                if("01".equals(tactivity.getStatus())){
                    tactivity.setStatus("");
                }else if("02".equals(tactivity.getStatus())){
                    tactivity.setStatus("03");
                }
            }
           list=tactivityDao.queryListActivityDao(tactivity);
            for(int i=0;i<list.size();i++){
                if(!"03".equals(list.get(i).getStatus())){
                    if("01".equals(list.get(i).getStatus())){
                        if(list.get(i).getStarttime().compareTo(DateUtil.GetDates2())<=0 && list.get(i).getEndtime().compareTo(DateUtil.GetDates2())>0){
                            Tactivity tactivity1=new Tactivity();
                            tactivity1.setId(list.get(i).getId());
                            tactivity1.setStatus("02");
                            list.get(i).setStatus("02");
                            updateTactivityService(tactivity1);
                        }else if(list.get(i).getEndtime().compareTo(DateUtil.GetDates2())<=0){
                            Tactivity tactivity1=new Tactivity();
                            tactivity1.setId(list.get(i).getId());
                            tactivity1.setStatus("03");
                            list.get(i).setStatus("03");
                            updateTactivityService(tactivity1);
                        }
                    }else if("02".equals(list.get(i).getStatus())){
                        if(list.get(i).getEndtime().compareTo(DateUtil.GetDates2())<=0){
                            Tactivity tactivity1=new Tactivity();
                            tactivity1.setId(list.get(i).getId());
                            tactivity1.setStatus("03");
                            list.get(i).setStatus("03");
                            updateTactivityService(tactivity1);
                        }
                    }
                }
            }
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public ResponseModel delTactivityService(String id) {
        ResponseModel remodel = new ResponseModel();
        int num = 0;
        if(id != null){
            if(id != null && !"".equals(id)){
                num = tactivityDao.delTactivityDao(id);
                if(num>0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("删除活动成功！");
                }else{
                    remodel.setCode("400");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("删除活动失败！");
                }
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("删除活动id为空！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("删除活动数据为空！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public ResponseModel updateTactivityService(Tactivity tactivity) {
        ResponseModel remodel = new ResponseModel();
        int num = 0;
        if(tactivity != null){
            if(tactivity.getId() != null && !"".equals(tactivity.getId())){
                num = tactivityDao.updateTactivityDao(tactivity);
                if(num>0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("修改活动成功！");
                }else{
                    remodel.setCode("400");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("修改活动失败！");
                }
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("修改活动id数据为空！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("数据为空！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public ResponseModel insertTactivityUserService(Tactivity tactivity) {
        ResponseModel remodel= new ResponseModel();
        int num = 0;
        if(tactivity != null){
            Tsuser tu = DateUtil.GetTsuser();
            tactivity.setId(DateUtil.getID());
            tactivity.setCreattime(DateUtil.GetDates());
            tactivity.setStatus("01");
            num = tactivityDao.insertTactivityUserDao(tactivity);
            if(num>0){
                remodel.setCode("200");
                remodel.setResult("success");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("001");
                remodel.setMsg("新增活动成功！");
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("新增活动失败！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("活动数据为空！");
        }

        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public List<Tactivity> queryListRegActivityService(Tactivity tactivity) {
        List<Tactivity> list = null;
        list=tactivityDao.queryListRegActivityDao(tactivity);
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public ResponseModel delTactivityUserService(String id) {
        ResponseModel remodel = new ResponseModel();
        int num = 0;
        if(id != null){
            if(id != null && !"".equals(id)){
                num = tactivityDao.delTactivityUserDao(id);
                if(num>0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("删除活动成功！");
                }else{
                    remodel.setCode("400");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("删除活动失败！");
                }
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("删除活动id为空！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("删除活动数据为空！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public ResponseModel updateTactivityUserService(Tactivity tactivity) {
        ResponseModel remodel = new ResponseModel();
        int num = 0;
        if(tactivity != null){
            if(tactivity.getId() != null && !"".equals(tactivity.getId())){
                num = tactivityDao.updateTactivityUserDao(tactivity);
                if(num>0){
                    remodel.setCode("200");
                    remodel.setResult("success");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("001");
                    remodel.setMsg("修改活动成功！");
                }else{
                    remodel.setCode("400");
                    remodel.setResult("fali");
                    remodel.setTime(System.currentTimeMillis()+"");
                    remodel.setToken("0053");
                    remodel.setMsg("修改活动失败！");
                }
            }else{
                remodel.setCode("400");
                remodel.setResult("fali");
                remodel.setTime(System.currentTimeMillis()+"");
                remodel.setToken("0053");
                remodel.setMsg("修改活动id数据为空！");
            }
        }else{
            remodel.setCode("400");
            remodel.setResult("fali");
            remodel.setTime(System.currentTimeMillis()+"");
            remodel.setToken("0053");
            remodel.setMsg("数据为空！");
        }
        // TODO Auto-generated method stub
        return remodel;
    }

    @Override
    public List<Tactivity> queryDzTactivityuserRequestDao(Tactivity tactivity) {
        List<Tactivity> list = null;
        Tsuser tu = DateUtil.GetTsuser();
        tactivity.setUserid(tu.getId());
        list=tactivityDao.queryDzTactivityuserRequestDao(tactivity);
        // TODO Auto-generated method stub
        return list;
    }
}
