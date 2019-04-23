package com.OuSoft.system.controller.Hssfworkbook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.hssfworkbook.hssfworkbookService;


@Controller
@RequestMapping(value="/workbook")
public class HssfworkbookController {

	@Autowired hssfworkbookService service;
	
	
	@RequestMapping(value="/outwork")
	@ResponseBody
	public void HssfworkbookImplController(HttpServletResponse response ){
		//返回的数据
		List<Tsuser> user = service.queryTsuserService();
		
		//生成excel
		
		// 创建工作簿
				HSSFWorkbook workbook = new HSSFWorkbook();
				// 创建表
				HSSFSheet sheet = workbook.createSheet("用户信息");
				// 创建行
				HSSFRow row = sheet.createRow(0);
				// 创建单元格样式
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				// 表头
				String[] head = {"姓名", "年龄"};
				HSSFCell cell;
				// 设置表头
				for(int iHead=0; iHead<head.length; iHead++) {
			    	cell = row.createCell(iHead);
			    	cell.setCellValue(head[iHead]);
			    	cell.setCellStyle(cellStyle);
			    }
				 // 设置表格内容
			    for(int iBody=0; iBody<user.size(); iBody++) {
			    	row = sheet.createRow(iBody+1);
			    	Tsuser u = user.get(iBody);
			    	String[] userArray = new String[2];
			    	userArray[0]=u.getUsername();
			    	userArray[1]=u.getAge() + "";
			    	for(int iArray=0; iArray<userArray.length; iArray++) {
			    		row.createCell(iArray).setCellValue(userArray[iArray]);
			        } 	
			    }
			    // 生成Excel文件
			     createFile(response, workbook); 
			}
	  
	public static void createFile(HttpServletResponse response, HSSFWorkbook workbook){
		String fileName ="用户信息";
	    try {
	    	// 捕获内存缓冲区的数据，转换成字节数组
	    	ByteArrayOutputStream out = new ByteArrayOutputStream();
	    	workbook.write(out);
	    	// 获取内存缓冲中的数据
	    	byte[] content = out.toByteArray();
	    	// 将字节数组转化为输入流
	    	InputStream in = new ByteArrayInputStream(content);
	    	//通过调用reset（）方法可以重新定位。         	
	    	response.reset();
	        // 如果文件名是英文名不需要加编码格式，如果是中文名需要添加"iso-8859-1"防止乱码
	        response.setHeader("Content-Disposition", "attachment; filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        response.addHeader("Content-Length", "" + content.length);
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");       	
	        ServletOutputStream outputStream = response.getOutputStream();
	        BufferedInputStream bis = new BufferedInputStream(in);
	        BufferedOutputStream bos = new BufferedOutputStream(outputStream);    
	        byte[] buff = new byte[8192];
	        int bytesRead;
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	            bos.write(buff, 0, bytesRead);
	        }
	        bis.close();
	        bos.close();
	        outputStream.flush();
	        outputStream.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	
	
	
}
	
