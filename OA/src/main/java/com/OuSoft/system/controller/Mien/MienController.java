package com.OuSoft.system.controller.Mien;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Mien;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.service.Mien.MienService;
import com.OuSoft.utils.DateUtil;
/**
 * 风采控制层
 * @author asus
 *
 */
@Controller
@RequestMapping(value = "/mien")
public class MienController {
	
	@Autowired
	private MienService mienService;
	/**
	 * 新增风采
	 */
	@ResponseBody
	@RequestMapping(value = "/saveMien")
	public ResponseModel saveMienController(Mien mien){
		
		ResponseModel model = new ResponseModel();
		model = mienService.insertMienService(mien);
		return model;
		
	}
	/**
	 * 修改风采内容
	 * @param id 风采id
	 * @param mienTitle 风采标题
	 * @param mienText 风采内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateMien")
	public ResponseModel updateMienController(Mien mien) {
		
		ResponseModel model = new ResponseModel();
		model = mienService.updateIdMienService(mien);
		return model;
	}
	/**
	 * 删除风采
	 * @param id 风采的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteMien")
	public ResponseModel deleteMienController(Mien mien) {
		ResponseModel model = new ResponseModel();
		System.err.println(mien.getId());
		model = mienService.deleteIdMienService(mien);
		return model;
	}
	/**
	 * 查询全部风采
	 * @param mien
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectAllMien")
	public List<Mien> selectAllMienController(Mien mien){
		List<Mien> data =mienService.queryAllListMienService(mien);
		return data;
	}
	
	/**
	 * 风采详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/detailListMien")
	public Mien detailListMienController(Mien mien){
		return mienService.detailListMienDao(mien);
	}
	/**
	 * 每条风采评论列表
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/commentListMien")
	public List<Mien> commentListMienController(Mien mien){
		return mienService.commentListMienDao(mien);
	}

}
