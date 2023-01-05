package com.stautisabela.completespringbootapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.stautisabela.completespringbootapi.model.Person;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Finding person...");
		return mockPerson(1);
	}
	
	public List<Person> findAll() {
		
		logger.info("Finding all people...");
		List<Person> persons = new ArrayList<>();
		for(int i=0; i<8; i++) {
			persons.add(mockPerson(i));
		}
		return persons;
	}
	
	public Person mockPerson(int i) {
		return new Person("John" +i, "Doe" +i, "1910 Marshes Glenn Dr", "12-05-1989");
	}

}
