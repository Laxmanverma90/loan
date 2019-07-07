package com.bank.oz.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.bank.oz.bean.CustomerBean;
import com.bank.oz.model.Customer;
import com.bank.oz.repository.CustomerRepository;
import com.bank.oz.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestCreateAccount {

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void testCrateAccount() {
		String expectedResult = "Congrats! Customer's account created.";
		CustomerBean customerBean = new CustomerBean(1, "Laxman", "Verma", new Date(), "HCL", 36, 990, "HCL Bangalore");
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerBean, customer);
		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(customer);
		Object actualResult = customerServiceImpl.crateAccount(customerBean);
		assertEquals(expectedResult, actualResult);
	}
	
}
