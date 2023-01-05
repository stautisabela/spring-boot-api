package com.stautisabela.completespringbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stautisabela.completespringbootapi.model.Person;
import com.stautisabela.completespringbootapi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(value="all")
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Person findById(@PathVariable String id) {
		return service.findById(id);
	}
}
