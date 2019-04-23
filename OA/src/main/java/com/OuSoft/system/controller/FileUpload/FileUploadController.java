package com.OuSoft.system.controller.FileUpload;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.service.fileUpload.attFileUploadService;


@RequestMapping(value="/file")
@Controller
public class FileUploadController {
	
	@Autowired
	attFileUploadService service;
	
	/**
	 * 图片查询
	 * @author pyl
	 * @date 2018年10月18日
	 */
	@RequestMapping(value="/queryitemidtatt")
	@ResponseBody
	public List<Tatt> queryFileUploadService(String itemid){
		return service.queryFileUploadService(itemid);
	}
	
	/**
	 * 图片上传方法
	 * @author pyl
	 * @date 2018年9月7日
	 */
	@RequestMapping(value="/fileupload")
	@ResponseBody
	public List<Tatt> fileUploadController(File file, Tatt tatt){
		System.out.println("fileupload");
		List<Tatt> tattList = null;
//		System.out.println("上传图片itemId：" + tatt.getItemid());
		System.out.println("上传图片file：" + file);
//		System.out.println("上传图片filename：" + tatt.getFilename());
		//itemid = 111
		Tatt att = new Tatt();
		
		if(file.exists() && file.length() == 0 && tatt == null ) {  
			att.setMsg("文件和文件名称为空，请从新上传");
		    tattList.add(att);
			System.out.println("文件为空！"); 
		}else{
			tattList = service.setFileUploadService(file, tatt);
		}
		
		return tattList;
	}
	

}
