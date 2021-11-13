package com.schoolofnet.Testing.service;

import java.util.List;

import com.schoolofnet.Testing.models.Person;

public interface PeopleService {

	public Person create(Person person);

	public List<Person> findAll();

}
