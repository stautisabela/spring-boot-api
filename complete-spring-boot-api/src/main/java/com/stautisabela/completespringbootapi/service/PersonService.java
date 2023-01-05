package com.stautisabela.completespringbootapi.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.exceptions.ResourceNotFoundException;
import com.stautisabela.completespringbootapi.model.Person;
import com.stautisabela.completespringbootapi.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Finding person...");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found."));
	}
	
	public List<Person> findAll() {
		
		logger.info("Finding all people...");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		
		logger.info("Creating person...");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		Person existingPerson = findById(person.getId());
		logger.info("Updating person...");
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setAddress(person.getAddress());
		existingPerson.setBirthdate(person.getBirthdate());
		return repository.save(existingPerson);
	}
	
	public void delete(String id) {
		
		Person person = findById(id);
		repository.delete(person);
	}
}
