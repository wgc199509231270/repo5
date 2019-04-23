package com.OuSoft.mobileCommerce.dao.CircleofFriends;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.mobileCommerce.entity.CircleofFriendsModel;
import com.OuSoft.system.entity.Mood;
import com.OuSoft.system.entity.Tatt;

@Mapper
@Component(value = "MCircleofFriends")
public interface CircleofFriendsDao {
  
	List<CircleofFriendsModel> queryCircleofFriends(Mood mood);
	//循环查询每个数据的图片
	List<Tatt> querytattAll(CircleofFriendsModel model);
}
