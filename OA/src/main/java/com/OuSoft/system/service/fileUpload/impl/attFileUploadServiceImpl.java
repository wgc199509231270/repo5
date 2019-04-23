package com.OuSoft.system.service.fileUpload.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.fileUpload.FileUploadDao;
import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.service.fileUpload.attFileUploadService;
import com.OuSoft.utils.CommUtil;
import com.opensymphony.xwork2.ActionContext;

@Service
public class attFileUploadServiceImpl implements attFileUploadService{
	  
			@Autowired
			FileUploadDao dao;
			
			/**
			 * 上传图片
		     * file:图片
		     * fileName:上传时的文件名称
		     * itemId:上传项目的id
		     * itemType:上传项目的标识，已办用来标识表名
		     * customname:用户自定义名称
		     * remark:备注
		     * tattfrom:来源1pc2手机
		     * itemfrom:类型，图片，视频，音频,文件
		     * 
			 * @author pyl
			 * @date 2018年9月6日
			 */
			@Override
			public List<Tatt> setFileUploadService(File file, Tatt model) {
				int count = 0;
				List<Tatt> tatt = null;
				ResponseModel responModel = new ResponseModel();
				//时间
//		        Calendar now = Calendar.getInstance();  
//		        String year = now.get(Calendar.YEAR)+"";
//		        String month = (now.get(Calendar.MONTH) + 1) + "";
//		        String days = now.get(Calendar.DAY_OF_MONTH)+"";
//		        String hours = now.get(Calendar.HOUR_OF_DAY)+"";
//		        String minute = now.get(Calendar.MINUTE)+"";
//		        String second = now.get(Calendar.SECOND)+""; 
		    	String realpath = ServletActionContext.getServletContext().getRealPath("/fileupload");
		    	String showpath ="fileupload/"+model.getFilename();
		        System.out.println("realpath======== "+realpath);
		        
		        if(file != null){
		        	File savefile = new File(new File(realpath), model.getFilename());
		        	System.out.println("1111====="+savefile);
		        	System.out.println("222====="+savefile.getParentFile());
		        	System.out.println("3333"+showpath);
		        	String name = "";
		        	//类型
		        	if(model.getItemfrom() == null && model.getItemfrom() == ""){
		        		String type = model.getFilename().substring(model.getFilename().lastIndexOf(".")+1);
		        		System.out.println("44444type:" + type);
		        		if(type == "jgp" || type == "png"){
		        			name = "图片";
		        		}else if(type == "mp4"){
		        			name = "视频";
		        		}else if(type == "amr"){
		        			name = "音频";
		        		}
		        	}
		        	
		        	if(savefile.getParentFile().exists()){
		        		try {
							savefile.getParentFile().mkdirs();
							FileUtils.copyFile(file, savefile);
					    	//插入数据库
							model.setId(CommUtil.getID());
							model.setOriginalfilename(showpath);//上传服务器的名称
							model.setItemfrom(name);
							model.setCreattime(new SimpleDateFormat("yyyy/mm/dd HH:MM:ss").format(new Date().getTime()));
							System.out.println("55555时间：" + new SimpleDateFormat("yyyy/mm/dd HH:MM:ss").format(new Date().getTime()));
							count = dao.setFileUploadDao(model);//插入数据
							if(count > 0){
								//查询插入的数据并返回数据
								tatt = dao.queryFileUploadDao(model.getItemid());
								responModel.setCode("200");
								responModel.setResult("success");
								responModel.setTime(System.currentTimeMillis()+"");
								responModel.setToken("001");
								responModel.setMsg("插入成功！");
							}else{
								responModel.setCode("404");
								responModel.setResult("fali");
								responModel.setTime(System.currentTimeMillis()+"");
								responModel.setToken("0053");
								responModel.setMsg("插入失败!");
								Tatt t = new Tatt();
								t.setMsg("插入图片失败!");
//								tatt.add(t);
							}
							
					    }catch (IOException e) {
							e.printStackTrace();
						}
		        		ActionContext.getContext().put("message", "文件上传成功");
		        	}
		        }
		        return tatt;
			}

			/**
			 * 
			 * 图片数据保存
			 */
			@Override
			public ResponseModel insertTattService(Tatt tatt) {
				ResponseModel responModel = new ResponseModel();
				//前端传文件类型，不传则筛选010203图片视频音频
                String filetype = "";
                if(tatt != null){
	                if(tatt.getFiletype() == null){
		                //判断类型01图片02视频03音频04文件
		                String filename = tatt.getFilename();
		                String filenames = filename.substring(filename.indexOf("."), filename.length());
		                System.out.println("filenames : " + filenames);
		                if(filenames.equals(".png") || filenames.equals(".jpg")){
		                	filetype = "01";
		                }else if(filenames.equals(".mp4")) {
		                	filetype = "02";
		                }else if(filenames.equals(".amr") || filenames.equals(".mp3")){
		                	filetype = "03";
		                	
		                }else if(filenames.equals(".docx") || filenames.equals(".xlsx") || filenames.equals(".xls") ||  filenames.equals(".doc") ) {
		                	filetype = "04";
		                }else{
		                	filetype = "05";
		                }
		                tatt.setFiletype(filetype);
	                }
                }
				int count = dao.insertTattDao(tatt);
				if(count > 0){
					responModel.setCode("200");
					responModel.setResult("success");
					responModel.setTime(System.currentTimeMillis()+"");
					responModel.setToken("001");
					responModel.setMsg("图片上传成功！");
				}else{
					responModel.setCode("404");
					responModel.setResult("fali");
					responModel.setTime(System.currentTimeMillis()+"");
					responModel.setToken("0053");
					responModel.setMsg("图片插入失败!");
					Tatt t = new Tatt();
					t.setMsg("插入图片失败!");
				}
				
				// TODO Auto-generated method stub
				return responModel;
			}

			/**
			 * 删除图片
			 */
			@Override
			public ResponseModel deleteIdTattService(Tatt tat) {
				ResponseModel responModel = new ResponseModel();
				if(tat.getItemid() != null && tat.getItemid() != ""  
						&& tat.getItemtype() != null && tat.getItemtype() != "" && tat.getFilename() != null && tat.getFilename() != "" ){
					int count = dao.deleteIdTattDao(tat);
					if(count > 0){
						responModel.setCode("200");
						responModel.setResult("success");
						responModel.setTime(System.currentTimeMillis()+"");
						responModel.setToken("001");
						responModel.setMsg("图片删除成功！");
					}else{
						responModel.setCode("404");
						responModel.setResult("fali");
						responModel.setTime(System.currentTimeMillis()+"");
						responModel.setToken("0053");
						responModel.setMsg("图片删除失败!");
						
					}
				}
				return responModel;
			}
			/**
			 * 删除头像
			 */
			@Override
			public ResponseModel deletImgTattService(Tatt tat) {
				ResponseModel responModel = new ResponseModel();
				if(tat.getItemid() != null && tat.getItemid() != ""
						&& tat.getItemtype() != null && tat.getItemtype() != "" ){
					int count = dao.deletImgTattDao(tat);
					if(count > 0){
						responModel.setCode("200");
						responModel.setResult("success");
						responModel.setTime(System.currentTimeMillis()+"");
						responModel.setToken("001");
						responModel.setMsg("图片删除成功！");
					}else{
						responModel.setCode("404");
						responModel.setResult("fali");
						responModel.setTime(System.currentTimeMillis()+"");
						responModel.setToken("0053");
						responModel.setMsg("图片删除失败!");

					}
				}
				return responModel;
			}
			/**
			 * 查询图片
			 */
			@Override
			public List<Tatt> queryFileUploadService(String itemid) {
				 List<Tatt> list = null;
				if(itemid != null){
					list = dao.queryFileUploadDao(itemid);
				}else{
					System.out.println("图片itemid为空！");
				}
				// TODO Auto-generated method stub
				return list;
			}
	 
			
			

}
