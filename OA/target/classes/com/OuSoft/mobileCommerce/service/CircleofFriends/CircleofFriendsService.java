package com.OuSoft.mobileCommerce.service.CircleofFriends;

import java.util.List;

import com.OuSoft.mobileCommerce.entity.CircleofFriendsModel;
import com.OuSoft.system.entity.Mood;
import org.springframework.stereotype.Service;


public interface CircleofFriendsService {
	
	List<CircleofFriendsModel> queryCircleofFriends(Mood mood);
}
