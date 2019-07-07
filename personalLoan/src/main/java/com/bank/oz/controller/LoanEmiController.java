package com.bank.oz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.oz.service.EmiService;

@RestController
@RequestMapping("/bank")
public class LoanEmiController {

	@Autowired
	private EmiService emiService;
	
	@GetMapping("/emi")
	public ResponseEntity<Object> findAllEmi(){
		return new ResponseEntity<>(emiService.findAllEmi(), HttpStatus.OK);
	}
}
