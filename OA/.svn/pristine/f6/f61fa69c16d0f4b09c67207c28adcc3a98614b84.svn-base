package com.OuSoft.system.service.fileUpload;

import java.io.File;
import java.util.List;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tatt;

public interface attFileUploadService {
	
	
	/**
	 * 图片删除
	 * @author pyl
	 * @date 2018年9月27日
	 */
	ResponseModel deleteIdTattService(Tatt tat);

	/**
	 * 头像删除
	 * @param tat
	 * @return
	 */
	ResponseModel deletImgTattService(Tatt tat);
	/**
	 * 上传图片
     * file:图片   
     * fileName:上传时的文件名称
     * itemId:上传项目的id
     * itemType:上传项目的标识，已办用来标识表名
     * customname:用户自定义名称
     * remark:备注
     * tattfrom:来源1pc2手机
     * itemfrom:类型：图片，视频，音频。
     * 必传：file,filename
	 * @author pyl
	 * @date 2018年9月6日
	 */
	List<Tatt> setFileUploadService(File file, Tatt tatt);
	
	/**
	 * 图片上传数据
	 * @author pyl
	 * @date 2018年9月27日
	 */
	ResponseModel insertTattService(Tatt tatt);
	
	/**
	 * 查询图片
	 * @author pyl
	 * @date 2018年10月18日
	 */
	List<Tatt> queryFileUploadService(String itemid);
	
}
