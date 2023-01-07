package com.stautisabela.completespringbootapi.mapper;

import java.util.ArrayList;
import java.util.List;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.model.User;

public class EntityMapper {

	public static UserVO parseObjectToVO(User user) {
		UserVO userVO = new UserVO();
		userVO.setId(user.getId());
		userVO.setFirstName(user.getFirstName());
		userVO.setLastName(user.getLastName());
		userVO.setAddress(user.getAddress());
		userVO.setBirthdate(user.getBirthdate());
		return userVO;
	}
	
	public static User parseVOToObject(UserVO userVO) {
		User user = new User();
		user.setId(userVO.getId());
		user.setFirstName(userVO.getFirstName());
		user.setLastName(userVO.getLastName());
		user.setAddress(userVO.getAddress());
		user.setBirthdate(userVO.getBirthdate());
		return user;
	}
	
	public static List<UserVO> parseObjectListToVOList(List<User> users) {
		List<UserVO> parsedList = new ArrayList<>();
		for(User user : users) {
			UserVO parsedUser = parseObjectToVO(user);
			parsedList.add(parsedUser);
		}
		return parsedList;
	}
	
	public static List<User> parseVOListToObjectList(List<UserVO> users) {
		List<User> parsedList = new ArrayList<>();
		for(UserVO user : users) {
			User parsedUser = parseVOToObject(user);
			parsedList.add(parsedUser);
		}
		return parsedList;
	}
}
