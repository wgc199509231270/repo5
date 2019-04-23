package com.OuSoft.system.controller.FileUpload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;
import com.OuSoft.system.service.fileUpload.attFileUploadService;
import com.OuSoft.utils.CommUtil;
import com.OuSoft.utils.DateUtil;

@Controller
@RequestMapping("/file")
public class BusinessController {

	@Autowired
	attFileUploadService service;

	
	/**
	 * 图片删除
	 * @author pyl
	 * @date 2018年9月27日
	 */
	@ResponseBody
	@RequestMapping("/deleteFileupload")
	public ResponseModel deleteIdTattService(Tatt tatt){
		return service.deleteIdTattService(tatt);
	}
    /**
     * 删除头像
     * @author pyl
     * @date 2018年9月27日
     */
    @ResponseBody
    @RequestMapping("/deleteImgupload")
    public ResponseModel deletImgTattService(Tatt tatt){
        return service.deletImgTattService(tatt);
    }
	/**
	 * 图片上传，可传入图片数组
	 * @author pyl
	 * @date 2018年12月11日
	 */
	@ResponseBody
	@RequestMapping("/saveFileupload")
    public ResponseModel filesUpload(@RequestParam("file") MultipartFile[] files, Tatt tatt, HttpServletRequest request) {
		//requestParam要写才知道是前台的那个数组
        tatt.setItemid(request.getParameter("itemid"));
        System.out.println("未知："+request.getParameter("itemid"));
        //tatt.setItemtype("tuser");

        tatt.setAttfrom("01");
        deletImgTattService(tatt);
		//传入的值
//		tatt.setItemid("123321");
//		tatt.setItemtype("tuser"); 
//		tatt.setCustomname("touxiang");
//		tatt.setAttfrom("01");
//        String filetype = "";
		
		ResponseModel responModel = new ResponseModel();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                System.out.println(" files : " + files[i]);
                // 保存文件
                responModel = saveFile(request, file, tatt);
            }
        }else{
        	responModel.setCode("404");
			responModel.setResult("fali");
			responModel.setTime(System.currentTimeMillis()+"");
			responModel.setToken("0053");
			responModel.setMsg("插入失败!");
        }
	//        for (int i = 0; i < list.size(); i++) {
	//            System.out.println("集合里面的数据 " + list.get(i));
	//        }
        	return responModel; 
    }


	/**
	 * 保存文件
	 * @author pyl
	 * @date 2018年10月12日
	 */
    private ResponseModel saveFile(HttpServletRequest request, MultipartFile file, Tatt att) {
    	ResponseModel responModel = new ResponseModel();
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
                // )
                String filePath = request.getSession().getServletContext()
                        .getRealPath("/") + "static/fileupload/" + file.getOriginalFilename();
                String filename = file.getOriginalFilename();
                System.out.println("filepath1 : " + filePath);
                System.out.println("filepath2 : " + filename);
                //存入数据库
                att.setId(CommUtil.getID());
                att.setFilename(filename);
                att.setOriginalfilename(System.currentTimeMillis()+filename);
                att.setCreattime(DateUtil.GetDates());
                File saveDir = new File(filePath);
                //文件有没有
                if (!saveDir.getParentFile().exists()) 
                	//没有则创建
                    saveDir.getParentFile().mkdirs();
                //转存文件
                file.transferTo(saveDir);
                //返回数据
                responModel = service.insertTattService(att);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件存入失败！");
            }
        } 
        return responModel;
    }



}
