package com.stautisabela.completespringbootapi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.model.User;

@Service
public class EntityMapper {

	public UserVO parseObjectToVO(User user) {
		UserVO userVO = new UserVO();
		userVO.setUserId(user.getUserId());
		userVO.setFirstName(user.getFirstName());
		userVO.setLastName(user.getLastName());
		userVO.setAddress(user.getAddress());
		userVO.setBirthDate(user.getBirthDate());
		return userVO;
	}
	
	public User parseVOToObject(UserVO userVO) {
		User user = new User();
		user.setUserId(userVO.getUserId());
		user.setFirstName(userVO.getFirstName());
		user.setLastName(userVO.getLastName());
		user.setAddress(userVO.getAddress());
		user.setBirthDate(userVO.getBirthDate());
		return user;
	}
	
	public List<UserVO> parseObjectListToVOList(List<User> users) {
		List<UserVO> parsedList = new ArrayList<>();
		for(User user : users) {
			UserVO parsedUser = parseObjectToVO(user);
			parsedList.add(parsedUser);
		}
		return parsedList;
	}
	
	public List<User> parseVOListToObjectList(List<UserVO> users) {
		List<User> parsedList = new ArrayList<>();
		for(UserVO user : users) {
			User parsedUser = parseVOToObject(user);
			parsedList.add(parsedUser);
		}
		return parsedList;
	}
}