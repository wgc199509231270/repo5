package com.OuSoft.system.dao.fileUpload;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tatt;


@Mapper
@Component(value = "Tatt")
public interface FileUploadDao {

	/**
	 * 删除图片
	 * @author pyl
	 * @date 2018年9月27日
	 */
	int deleteIdTattDao(Tatt tat);

	/**
	 * 删除头像
	 * @param tat
	 * @return
	 */
	int deletImgTattDao(Tatt tat);
	//图片数据数据
	int insertTattDao(Tatt tatt);
	
	//插入tatt数据
	int setFileUploadDao(Tatt tatt);
	
	
	//查询数据
	List<Tatt> queryFileUploadDao(String itemid);
	
}
