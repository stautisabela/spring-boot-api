package com.stautisabela.completespringbootapi.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.model.User;

public class MockUser {
	
	public User mockUser(Integer num) {
		User user = new User("First Name"+num, "Last Name"+num, "Address"+num, "01-06-2023", true);
		user.setUserId("ID"+num);
		return user;
	}
	
	public UserVO mockUserVO(Integer num) {
		UserVO user = new UserVO("ID"+num, "First Name"+num, "Last Name"+num, "Address"+num, "01-06-2023", true);
		return user;
	}
	
	public List<User> mockUserList() {
		List<User> users = new ArrayList<User>();
		for (int i=0; i<5; i++) {
			users.add(mockUser(i));
		}
		return users;
	}
	
	public List<UserVO> mockUserVOList() {
		List<UserVO> users = new ArrayList<UserVO>();
		for (int i=0; i<5; i++) {
			users.add(mockUserVO(i));
		}
		return users;
	}
}
