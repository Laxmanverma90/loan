package com.bank.oz.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bank.oz.bean.CustomerBean;
import com.bank.oz.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TestCustomerController {

	@Mock
	private CustomerServiceImpl customerServiceImpl;
	
	@InjectMocks
	private CustomerController customerController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build(); 
	}
	
	@Test
	public void testCreateAccount() throws JsonProcessingException, Exception {
		String expectedResultString = "Congrats! Customer's account created.";
		ResponseEntity<Object> expectedResult = new ResponseEntity<>(expectedResultString, HttpStatus.CREATED);
		CustomerBean customerBean = new CustomerBean(1, "Laxman", "Verma", new Date(), "HCL", 36, 990, "HCL Bangalore");
		ObjectMapper objectMapper = new ObjectMapper();
		Mockito.when(customerServiceImpl.crateAccount(customerBean)).thenReturn(new ResponseEntity<>(expectedResultString, HttpStatus.CREATED));
		mockMvc.perform(post("/bank/customer").contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(customerBean))).andExpect(status().isCreated());
		ResponseEntity<Object> actualResult = (ResponseEntity<Object>) customerServiceImpl.crateAccount(customerBean);
		assertEquals(expectedResult.getStatusCode(), actualResult.getStatusCode());
	}
}
