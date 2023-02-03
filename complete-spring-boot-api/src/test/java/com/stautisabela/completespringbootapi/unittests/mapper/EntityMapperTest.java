package com.stautisabela.completespringbootapi.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.mapper.EntityMapper;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.unittests.mapper.mocks.MockUser;

public class EntityMapperTest {
	
	MockUser mock;
	EntityMapper mapper;
	
	@BeforeEach
	public void setUp() {
		mock = new MockUser();
		mapper = new EntityMapper();
	}
	
	@Test
	public void parseObjectToVOTest() {
		User inputUser = mock.mockUser(0);
		UserVO outputUser = mapper.parseObjectToVO(inputUser);
		
		assertEquals(inputUser.getUserId(), outputUser.getUserId());
		assertEquals(inputUser.getFirstName(), outputUser.getFirstName());
		assertEquals(inputUser.getLastName(), outputUser.getLastName());
		assertEquals(inputUser.getAddress(), outputUser.getAddress());
		assertEquals(inputUser.getBirthDate(), outputUser.getBirthDate());
		assertEquals(inputUser.getActive(), outputUser.getActive());
	}
	
	@Test
	public void parseVOToObjectTest() {
		UserVO inputUser = mock.mockUserVO(0);
		User outputUser = mapper.parseVOToObject(inputUser);
		
		assertEquals(inputUser.getUserId(), outputUser.getUserId());
		assertEquals(inputUser.getFirstName(), outputUser.getFirstName());
		assertEquals(inputUser.getLastName(), outputUser.getLastName());
		assertEquals(inputUser.getAddress(), outputUser.getAddress());
		assertEquals(inputUser.getBirthDate(), outputUser.getBirthDate());
		assertEquals(inputUser.getActive(), outputUser.getActive());
	}
	
	@Test
	public void parseObjectListToVOListTest() {
		List<User> inputList = mock.mockUserList();
		List<UserVO> outputList = mapper.parseObjectListToVOList(inputList);
		
		UserVO userZero = outputList.get(0);
		assertEquals(inputList.get(0).getUserId(), userZero.getUserId());
		assertEquals(inputList.get(0).getFirstName(), userZero.getFirstName());
		assertEquals(inputList.get(0).getLastName(), userZero.getLastName());
		assertEquals(inputList.get(0).getAddress(), userZero.getAddress());
		assertEquals(inputList.get(0).getBirthDate(), userZero.getBirthDate());
		assertEquals(inputList.get(0).getActive(), userZero.getActive());
		
		UserVO userTwo = outputList.get(2);
		assertEquals(inputList.get(2).getUserId(), userTwo.getUserId());
		assertEquals(inputList.get(2).getFirstName(), userTwo.getFirstName());
		assertEquals(inputList.get(2).getLastName(), userTwo.getLastName());
		assertEquals(inputList.get(2).getAddress(), userTwo.getAddress());
		assertEquals(inputList.get(2).getBirthDate(), userTwo.getBirthDate());
		assertEquals(inputList.get(2).getActive(), userTwo.getActive());
		
		UserVO userFour = outputList.get(4);
		assertEquals(inputList.get(4).getUserId(), userFour.getUserId());
		assertEquals(inputList.get(4).getFirstName(), userFour.getFirstName());
		assertEquals(inputList.get(4).getLastName(), userFour.getLastName());
		assertEquals(inputList.get(4).getAddress(), userFour.getAddress());
		assertEquals(inputList.get(4).getBirthDate(), userFour.getBirthDate());
		assertEquals(inputList.get(4).getActive(), userFour.getActive());
	}
	
	@Test
	public void parseVOListToObjectListTest() {
		List<UserVO> inputList = mock.mockUserVOList();
		List<User> outputList = mapper.parseVOListToObjectList(inputList);
		
		User userZero = outputList.get(0);
		assertEquals(inputList.get(0).getUserId(), userZero.getUserId());
		assertEquals(inputList.get(0).getFirstName(), userZero.getFirstName());
		assertEquals(inputList.get(0).getLastName(), userZero.getLastName());
		assertEquals(inputList.get(0).getAddress(), userZero.getAddress());
		assertEquals(inputList.get(0).getBirthDate(), userZero.getBirthDate());
		assertEquals(inputList.get(0).getActive(), userZero.getActive());
		
		User userTwo = outputList.get(2);
		assertEquals(inputList.get(2).getUserId(), userTwo.getUserId());
		assertEquals(inputList.get(2).getFirstName(), userTwo.getFirstName());
		assertEquals(inputList.get(2).getLastName(), userTwo.getLastName());
		assertEquals(inputList.get(2).getAddress(), userTwo.getAddress());
		assertEquals(inputList.get(2).getBirthDate(), userTwo.getBirthDate());
		assertEquals(inputList.get(2).getActive(), userTwo.getActive());
		
		User userFour = outputList.get(4);
		assertEquals(inputList.get(4).getUserId(), userFour.getUserId());
		assertEquals(inputList.get(4).getFirstName(), userFour.getFirstName());
		assertEquals(inputList.get(4).getLastName(), userFour.getLastName());
		assertEquals(inputList.get(4).getAddress(), userFour.getAddress());
		assertEquals(inputList.get(4).getBirthDate(), userFour.getBirthDate());
		assertEquals(inputList.get(4).getActive(), userFour.getActive());
	}
}
