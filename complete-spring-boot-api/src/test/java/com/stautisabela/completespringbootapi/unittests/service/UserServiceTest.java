package com.stautisabela.completespringbootapi.unittests.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.exceptions.RequiredObjectIsNullException;
import com.stautisabela.completespringbootapi.mapper.EntityMapper;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.repository.UserRepository;
import com.stautisabela.completespringbootapi.service.UserService;
import com.stautisabela.completespringbootapi.unittests.mapper.mocks.MockUser;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	MockUser mock;
	
	@InjectMocks
	private UserService service;
	
	@Mock
	UserRepository repository;
	
	@Mock
	EntityMapper mapper;
	
	@BeforeEach
	void setUp() throws Exception {
		mock = new MockUser();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		User inputUser = mock.mockUser(0);
		UserVO inputUserVO = mock.mockUserVO(0);
		
		when(repository.findById(inputUser.getUserId())).thenReturn(Optional.of(inputUser));
		when(mapper.parseObjectToVO(inputUser)).thenReturn(inputUserVO);
		
		var outputUser = service.findById(inputUser.getUserId());
		assertNotNull(outputUser);
		assertNotNull(outputUser.getUserId());
		assertNotNull(outputUser.getLinks());
		
		assertTrue(outputUser.toString().contains("links: [</v1/user/ID0>;rel=\"self\"]"));
		assertEquals(inputUser.getFirstName(), outputUser.getFirstName());
		assertEquals(inputUser.getLastName(), outputUser.getLastName());
		assertEquals(inputUser.getAddress(), outputUser.getAddress());
		assertEquals(inputUser.getBirthDate(), outputUser.getBirthDate());
	}

	@Test
	void testFindAll() {
		List<User> inputUserList = mock.mockUserList();
		List<UserVO> inputUserVOList = mock.mockUserVOList();
		
		when(repository.findAll()).thenReturn(inputUserList);
		when(mapper.parseObjectListToVOList(inputUserList)).thenReturn(inputUserVOList);
		
		var outputUserList = service.findAll();
		assertNotNull(outputUserList);
		assertEquals(5, outputUserList.size());
		
		var outputUserZero = outputUserList.get(0);
		assertNotNull(outputUserZero);
		assertNotNull(outputUserZero.getUserId());
		assertNotNull(outputUserZero.getLinks());
		assertTrue(outputUserZero.toString().contains("links: [</v1/user/ID0>;rel=\"self\"]"));
		assertEquals(inputUserList.get(0).getFirstName(), outputUserZero.getFirstName());
		assertEquals(inputUserList.get(0).getLastName(), outputUserZero.getLastName());
		assertEquals(inputUserList.get(0).getAddress(), outputUserZero.getAddress());
		assertEquals(inputUserList.get(0).getBirthDate(), outputUserZero.getBirthDate());
		
		var outputUserThree = outputUserList.get(3);
		assertNotNull(outputUserThree);
		assertNotNull(outputUserThree.getUserId());
		assertNotNull(outputUserThree.getLinks());
		assertTrue(outputUserThree.toString().contains("links: [</v1/user/ID3>;rel=\"self\"]"));
		assertEquals(inputUserList.get(3).getFirstName(), outputUserThree.getFirstName());
		assertEquals(inputUserList.get(3).getLastName(), outputUserThree.getLastName());
		assertEquals(inputUserList.get(3).getAddress(), outputUserThree.getAddress());
		assertEquals(inputUserList.get(3).getBirthDate(), outputUserThree.getBirthDate());
		
		var outputUserFour = outputUserList.get(4);
		assertNotNull(outputUserFour);
		assertNotNull(outputUserFour.getUserId());
		assertNotNull(outputUserFour.getLinks());
		assertTrue(outputUserFour.toString().contains("links: [</v1/user/ID4>;rel=\"self\"]"));
		assertEquals(inputUserList.get(4).getFirstName(), outputUserFour.getFirstName());
		assertEquals(inputUserList.get(4).getLastName(), outputUserFour.getLastName());
		assertEquals(inputUserList.get(4).getAddress(), outputUserFour.getAddress());
		assertEquals(inputUserList.get(4).getBirthDate(), outputUserFour.getBirthDate());
	}

	@Test
	void testCreate() {
		User inputUser = mock.mockUser(0);
		UserVO inputUserVO = mock.mockUserVO(0);
		
		when(repository.save(inputUser)).thenReturn(inputUser);
		when(mapper.parseVOToObject(inputUserVO)).thenReturn(inputUser);
		when(mapper.parseObjectToVO(inputUser)).thenReturn(inputUserVO);
		
		var outputUser = service.create(inputUserVO);
		assertNotNull(outputUser);
		assertNotNull(outputUser.getUserId());
		assertNotNull(outputUser.getLinks());
		
		assertTrue(outputUser.toString().contains("links: [</v1/user/ID0>;rel=\"self\"]"));
		assertEquals(inputUser.getFirstName(), outputUser.getFirstName());
		assertEquals(inputUser.getLastName(), outputUser.getLastName());
		assertEquals(inputUser.getAddress(), outputUser.getAddress());
		assertEquals(inputUser.getBirthDate(), outputUser.getBirthDate());
	}
	
	@Test
	void testCreateWithNullObject() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "Cannot save a null object.";
		String outputMessage = exception.getMessage();

		assertTrue(outputMessage.contains(expectedMessage));
	}

	@Test
	void testUpdate() {
		User inputUser = mock.mockUser(0);
		UserVO inputUserVO = mock.mockUserVO(0);
		
		when(repository.findById(inputUser.getUserId())).thenReturn(Optional.of(inputUser));
		when(repository.save(inputUser)).thenReturn(inputUser);
		when(mapper.parseObjectToVO(inputUser)).thenReturn(inputUserVO);
		
		var outputUser = service.update(inputUserVO);
		assertNotNull(outputUser);
		assertNotNull(outputUser.getUserId());
		assertNotNull(outputUser.getLinks());
		
		assertTrue(outputUser.toString().contains("links: [</v1/user/ID0>;rel=\"self\"]"));
		assertEquals(inputUser.getFirstName(), outputUser.getFirstName());
		assertEquals(inputUser.getLastName(), outputUser.getLastName());
		assertEquals(inputUser.getAddress(), outputUser.getAddress());
		assertEquals(inputUser.getBirthDate(), outputUser.getBirthDate());
	}
	
	@Test
	void testUpdateWithNullObject() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "Cannot save a null object.";
		String outputMessage = exception.getMessage();

		assertTrue(outputMessage.contains(expectedMessage));
	}


	/*
	@Test
	void testDelete() {
		
	}
	*/

}
