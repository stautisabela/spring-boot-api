package com.stautisabela.completespringbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stautisabela.completespringbootapi.data.vo.UserVO;
import com.stautisabela.completespringbootapi.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/all",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public List<com.stautisabela.completespringbootapi.data.vo.UserVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value="/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO findById(@PathVariable String id) {
		return service.findById(id);
	}
	
	@PostMapping(value="/new",
				 produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserVO create(@RequestBody UserVO user) {
		return service.create(user);
	}
	
	@PutMapping(value="/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserVO update(@RequestBody UserVO user) {
		return service.update(user);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
