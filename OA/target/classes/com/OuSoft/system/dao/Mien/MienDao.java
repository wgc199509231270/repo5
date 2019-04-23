package com.OuSoft.system.dao.Mien;
/**
 * Mien持久层接口
 */
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Mien;

@Mapper
@Component(value = "Tmien")
public interface MienDao {
	
	//新增风采
	int insertMienDao(Mien mien);
	//删除风采
	int deleteIdMienDao(String id);
	//根据id修改风采内容
	Integer updateIdMienDao(Mien mien);
	//风采列表
	List<Mien> queryAllListMienDao(Mien mien);
	//风采详情列表
	Mien detailListMienDao(String id);
	//单条风采评论列表
	List <Mien> commentListMienDao(String itemid);
	
	
}
