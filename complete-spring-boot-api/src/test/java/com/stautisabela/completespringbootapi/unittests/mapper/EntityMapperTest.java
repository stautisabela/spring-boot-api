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
		
		assertEquals(inputUser.getId(), outputUser.getId());
		assertEquals("First Name0", outputUser.getFirstName());
		assertEquals("Last Name0", outputUser.getLastName());
		assertEquals("Address0", outputUser.getAddress());
		assertEquals("01-06-2023", outputUser.getBirthdate());
	}
	
	@Test
	public void parseVOToObjectTest() {
		UserVO inputUser = mock.mockUserVO(0);
		User outputUser = mapper.parseVOToObject(inputUser);
		
		assertEquals("ID0", outputUser.getId());
		assertEquals("First Name0", outputUser.getFirstName());
		assertEquals("Last Name0", outputUser.getLastName());
		assertEquals("Address0", outputUser.getAddress());
		assertEquals("01-06-2023", outputUser.getBirthdate());
	}
	
	@Test
	public void parseObjectListToVOListTest() {
		List<User> inputList = mock.mockUserList();
		List<UserVO> outputList = mapper.parseObjectListToVOList(inputList);
		
		UserVO userZero = outputList.get(0);
		assertEquals(inputList.get(0).getId(), userZero.getId());
		assertEquals("First Name0", userZero.getFirstName());
		assertEquals("Last Name0", userZero.getLastName());
		assertEquals("Address0", userZero.getAddress());
		assertEquals("01-06-2023", userZero.getBirthdate());
		
		UserVO userTwo = outputList.get(2);
		assertEquals(inputList.get(2).getId(), userTwo.getId());
		assertEquals("First Name2", userTwo.getFirstName());
		assertEquals("Last Name2", userTwo.getLastName());
		assertEquals("Address2", userTwo.getAddress());
		assertEquals("01-06-2023", userTwo.getBirthdate());
		
		UserVO userFour = outputList.get(4);
		assertEquals(inputList.get(4).getId(), userFour.getId());
		assertEquals("First Name4", userFour.getFirstName());
		assertEquals("Last Name4", userFour.getLastName());
		assertEquals("Address4", userFour.getAddress());
		assertEquals("01-06-2023", userFour.getBirthdate());
	}
	
	@Test
	public void parseVOListToObjectListTest() {
		List<UserVO> inputList = mock.mockUserVOList();
		List<User> outputList = mapper.parseVOListToObjectList(inputList);
		
		User userZero = outputList.get(0);
		assertEquals("ID0", userZero.getId());
		assertEquals("First Name0", userZero.getFirstName());
		assertEquals("Last Name0", userZero.getLastName());
		assertEquals("Address0", userZero.getAddress());
		assertEquals("01-06-2023", userZero.getBirthdate());
		
		User userTwo = outputList.get(2);
		assertEquals("ID2", userTwo.getId());
		assertEquals("First Name2", userTwo.getFirstName());
		assertEquals("Last Name2", userTwo.getLastName());
		assertEquals("Address2", userTwo.getAddress());
		assertEquals("01-06-2023", userTwo.getBirthdate());
		
		User userFour = outputList.get(4);
		assertEquals("ID4", userFour.getId());
		assertEquals("First Name4", userFour.getFirstName());
		assertEquals("Last Name4", userFour.getLastName());
		assertEquals("Address4", userFour.getAddress());
		assertEquals("01-06-2023", userFour.getBirthdate());
	}
}
