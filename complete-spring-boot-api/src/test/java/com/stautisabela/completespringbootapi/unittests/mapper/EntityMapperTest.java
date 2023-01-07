package com.stautisabela.completespringbootapi.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.mapper.EntityMapper;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.unittests.mapper.mocks.MockUser;

public class EntityMapperTest {
	
	MockUser mock;
	
	@BeforeEach
	public void setUp() {
		mock = new MockUser();
	}
	
	@Test
	public void parseObjectToVOTest() {
		User inputUser = mock.mockUser(0);
		UserVO outputUser = EntityMapper.parseObjectToVO(inputUser);
		
		assertEquals(inputUser.getId(), outputUser.getId());
		assertEquals("First Name0", outputUser.getFirstName());
		assertEquals("Last Name0", outputUser.getLastName());
		assertEquals("Address0", outputUser.getAddress());
		assertEquals("01-06-2023", outputUser.getBirthdate());
	}
	
	@Test
	public void parseVOToObjectTest() {
		UserVO inputUser = mock.mockUserVO(0);
		User outputUser = EntityMapper.parseVOToObject(inputUser);
		
		assertEquals("ID0", outputUser.getId());
		assertEquals("First Name0", outputUser.getFirstName());
		assertEquals("Last Name0", outputUser.getLastName());
		assertEquals("Address0", outputUser.getAddress());
		assertEquals("01-06-2023", outputUser.getBirthdate());
	}
	
	/*@Test
	public void parseObjectListToVOListTest() {
		
	}
	
	@Test
	public void parseVOListToObjectListTest() {
		
	}*/

}
