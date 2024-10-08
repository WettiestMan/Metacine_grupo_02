package com.grupo02.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class MetacineApplicationTests {

	@Autowired
	private MockMvc mocker;

	@Test
	void contextLoads() {
	}

	@Test
	public void getHello() throws Exception{
		mocker.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
		                    .andExpect(status().isOk())
							.andExpect(content().string(equalTo("Greetings")));
	}

}
