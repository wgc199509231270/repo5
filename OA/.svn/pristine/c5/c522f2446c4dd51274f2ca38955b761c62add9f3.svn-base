package com.OuSoft.system.controller.FileUpload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value="/file")
@Controller
public class FileController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(MultipartFile file,HttpServletRequest request) throws IOException{
		System.out.println("comming!");
		String path = request.getSession().getServletContext().getRealPath("/static/fileupload");
//		/OA/src/main/webapp/static/fileupload
		
		System.out.println("path>>"+path);
		System.out.println("------------------:  " + file.getSize());
		String fileName = file.getOriginalFilename();
		System.out.println("fileName>>"+fileName);
		
		File dir = new File(path, fileName);
		System.out.println("dir.exists()>>"+dir.exists());
		if(!dir.exists()){
			dir.mkdirs();
		}
		System.out.println("dir.exists()>>"+dir.exists());
//		MultipartFile自带的解析方法
		file.transferTo(dir);
		
		return "ok";
	}

	

}
