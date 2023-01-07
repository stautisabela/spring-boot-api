package com.stautisabela.completespringbootapi.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.exceptions.ResourceNotFoundException;
import com.stautisabela.completespringbootapi.model.User;
import com.stautisabela.completespringbootapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	private Logger logger = Logger.getLogger(UserService.class.getName());
	
	public User findById(String id) {
		logger.info("Finding user...");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
	}
	
	public List<User> findAll() {
		logger.info("Finding all users...");
		
		return repository.findAll();
	}
	
	public User create(User user) {
		logger.info("Creating user...");
		
		return repository.save(user);
	}
	
	public User update(User user) {
		User existingUser = findById(user.getId());
		logger.info("Updating user...");
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAddress(user.getAddress());
		existingUser.setBirthdate(user.getBirthdate());
		return repository.save(existingUser);
	}
	
	public void delete(String id) {
		logger.info("Deleting user...");
		
		User user = findById(id);
		repository.delete(user);
	}
}
