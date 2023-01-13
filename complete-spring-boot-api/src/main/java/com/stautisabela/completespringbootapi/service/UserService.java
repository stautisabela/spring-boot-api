package com.stautisabela.completespringbootapi.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.exceptions.ResourceNotFoundException;
import com.stautisabela.completespringbootapi.mapper.EntityMapper;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	EntityMapper mapper;
	
	private Logger logger = Logger.getLogger(UserService.class.getName());
	
	public UserVO findById(String id) {
		logger.info("Finding user...");
		
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		return mapper.parseObjectToVO(user);
	}
	
	public List<UserVO> findAll() {
		logger.info("Finding all users...");
		
		return mapper.parseObjectListToVOList(repository.findAll());
	}
	
	public UserVO create(UserVO user) {
		logger.info("Creating user...");
		
		User newUser = mapper.parseVOToObject(user); // converting VO to model so it can be saved in the database
		return mapper.parseObjectToVO(repository.save(newUser));
	}
	
	public UserVO update(UserVO user) {
		User existingUser = repository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		logger.info("Updating user...");
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAddress(user.getAddress());
		existingUser.setBirthDate(user.getBirthDate());
		return mapper.parseObjectToVO(repository.save(existingUser));
	}
	
	public void delete(String id) {
		logger.info("Deleting user...");
		
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		repository.delete(user);
	}
}
