package com.stautisabela.completespringbootapi.unittests.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
		fail("Not yet implemented");
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

	/*
	@Test
	void testDelete() {
		
	}
	*/

}
