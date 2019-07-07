package com.bank.oz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.oz.bean.CustomerBean;
import com.bank.oz.model.Customer;
import com.bank.oz.service.CustomerService;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("bank")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Object> createAccount(@RequestBody CustomerBean customerBean){
		return new ResponseEntity<>(customerService.crateAccount(customerBean), HttpStatus.CREATED);
	}
}
