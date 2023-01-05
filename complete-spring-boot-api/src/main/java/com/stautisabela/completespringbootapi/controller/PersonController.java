package com.stautisabela.completespringbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stautisabela.completespringbootapi.model.Person;
import com.stautisabela.completespringbootapi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(value="all",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value="/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable String id) {
		return service.findById(id);
	}
	
	@PostMapping(value="{id}",
				 produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@PutMapping(value="{id}",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
}
