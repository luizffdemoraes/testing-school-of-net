package com.schoolofnet.Testing.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.schoolofnet.Testing.models.Person;
import com.schoolofnet.Testing.service.PeopleService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PeopleController.class)
public class PeopleControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private PeopleService peopleService;

	
	@Test
	public void findAll() throws Exception {
		Person leonan = new Person((long) 10, "Leonan", 22);
		List<Person> mockPeople = Arrays.asList(leonan);
		
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockPersonJSON = mapper.writeValueAsString(mockPeople);
		
	
		when(peopleService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/people")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(200))
		.andExpect(content().json(mockPersonJSON));
	}
	
	@Test
	public void createdNewPerson() throws Exception {
		//Simular requisição e comparar valores
		//Objeto mock ou objeto simulado
		// Simular uma resposta e utilizar o objeto simulado para validar a resposta
		Person mockPerson = new Person((long) 10, "Erik", 20);	
		
		when(peopleService.create(any(Person.class))).thenReturn(mockPerson);
		
		
		
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockPersonJSON = mapper.writeValueAsString(mockPerson);
		
		mock.perform(post("/people")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(mockPersonJSON))
				.andExpect(status().isOk())
				.andExpect(content().json(mockPersonJSON));	
		
		verify(peopleService).create(any(Person.class));
	}
	
	@Test
	public void removePerson() throws Exception {
		mock.perform(delete("/people" + "/{id}", new Long(1)))
		.andExpect(status().is(200));
	}
	
/*	
	@Test
	public void createNewAndFail() throws Exception {
		Person mockPerson = new Person((long) 9, "", 23);
		
		when(peopleService.create(any(Person.class))).thenReturn(mockPerson);
		
	
		
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockPersonJSON = mapper.writeValueAsString(mockPerson);
		
		mock.perform(post("/people")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(mockPersonJSON))
		.andExpect(status().is(400));
	}
*/
	
	

}
