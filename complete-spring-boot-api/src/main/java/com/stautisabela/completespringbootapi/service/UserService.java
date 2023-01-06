package com.stautisabela.completespringbootapi.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.exceptions.ResourceNotFoundException;
import com.stautisabela.completespringbootapi.mapper.DozerMapper;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	private Logger logger = Logger.getLogger(UserService.class.getName());
	
	public UserVO findById(String id) {
		
		logger.info("Finding user...");
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		return DozerMapper.parseObject(user, UserVO.class);
	}
	
	public List<UserVO> findAll() {
		
		logger.info("Finding all users...");
		return DozerMapper.parseObjectsList(repository.findAll(), UserVO.class);
	}
	
	public UserVO create(UserVO user) {
		
		logger.info("Creating user...");
		User newUser = DozerMapper.parseObject(user, User.class); // converting VO to model so it can be saved in the database
		return DozerMapper.parseObject(repository.save(newUser), UserVO.class);
	}
	
	public UserVO update(UserVO user) {
		
		User existingUser = repository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		logger.info("Updating user...");
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAddress(user.getAddress());
		existingUser.setBirthdate(user.getBirthdate());
		return DozerMapper.parseObject(repository.save(existingUser), UserVO.class);
	}
	
	public void delete(String id) {
		
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		repository.delete(user);
	}
}
