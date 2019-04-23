package com.OuSoft.system.controller.Telegant;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Telegant;
import com.OuSoft.system.service.Telegant.TelegantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/telegant")
public class TelegantController {
    @Autowired
    TelegantService telegantService;

    /**
     * 新增风采信息
     * @param telegant
     * @return
     */
    @RequestMapping(value="/insertElegant")
    @ResponseBody
    public ResponseModel insertElegantController(Telegant telegant){
        return telegantService.insertElegantService(telegant);
    }

    /**
     * 删除风采信息
     * 接收：id
     */
    @RequestMapping(value="/deleteTelegant")
    @ResponseBody
    public ResponseModel deleteTelegantController(Telegant telegant){
        return telegantService.deleteElegantByidService(telegant);
    }

    /**
     * 查询用户风采信息.
     * 接收：用户id:userid
     */
    @RequestMapping(value="/queryTuserByIdTelegant")
    @ResponseBody
    public List<Telegant> queryTuserByIdTelegantController(Telegant telegant){
        return telegantService.queryElegantService(telegant);
    }

    /**
     * 修改用户风采信息.
     * 接收：id userid jobid
     */
    @RequestMapping(value="/updateTuserByIdTelegant")
    @ResponseBody
    public ResponseModel updateTuserByIdTelegant(Telegant telegant){
        return telegantService.updateElegantByidService(telegant);
    }
    /**
     * 查询点赞信息
     * @param telegant
     * @return
     */
    @RequestMapping(value="/queryDzTelegantuserRequest")
    @ResponseBody
    public List<Telegant> queryDzTelegantuserRequest(Telegant telegant){
        List<Telegant> list = telegantService.queryDzTelegantuserRequestService(telegant);
        return list;
    }

}
