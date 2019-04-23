package com.OuSoft.system.service.Mien;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.OuSoft.system.entity.Mien;
import com.OuSoft.system.entity.ResponseModel;

/**
 * 风采业务层接口
 * @author asus
 *
 */
public interface MienService {
	
	//新增风采
	ResponseModel insertMienService(Mien mien);
	//根据id删除一条风采
	ResponseModel deleteIdMienService(Mien mien);
	//根据id修改风采内容
	ResponseModel updateIdMienService(Mien mien);
	//显示全部风采
	List<Mien> queryAllListMienService(Mien mien);
	//风采详情列表
	Mien detailListMienDao(Mien mien);
	//单条风采评论列表
	List <Mien> commentListMienDao(Mien mien);
	
}
