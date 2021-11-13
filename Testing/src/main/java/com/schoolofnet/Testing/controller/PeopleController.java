package com.schoolofnet.Testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolofnet.Testing.models.Person;
import com.schoolofnet.Testing.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Long id) {
		this.peopleService.remove(id);
	}

	@GetMapping
	public List<Person> findAll(){
		return this.peopleService.findAll();
	}

	@PostMapping
	public Person create(@RequestBody Person person) {
		return this.peopleService.create(person);
	}
	

}
