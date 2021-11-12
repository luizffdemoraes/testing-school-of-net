package com.schoolofnet.Testing;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(controllers = HelloWordController.class)
class TestingApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
	}

	@Test
	public void testHelloWorld() throws Exception {
		this.mockMvc
		.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello World"));
	
	}

}
