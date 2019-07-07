package com.bank.oz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.oz.bean.LoanBean;
import com.bank.oz.service.LoanService;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("/bank")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping("/loans")
	public ResponseEntity<Object> applyLoan(@RequestBody LoanBean loanBean){
		return new ResponseEntity<>(loanService.applyLoan(loanBean), HttpStatus.CREATED);
	}
	
	@GetMapping("/loans")
	public ResponseEntity<Object> getAllLoans(){
		return new ResponseEntity<>(loanService.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/loans")
	public ResponseEntity<Object> approveLoan(@RequestBody LoanBean loanBean){
		return new ResponseEntity<>(loanService.approveLoan(loanBean), HttpStatus.OK);
	}
	
	@PutMapping("/loans/{loanId}")
	public ResponseEntity<Object> deleteLoan(@PathVariable int loanId){
		return new ResponseEntity<>(loanService.deleteLoan(loanId,"Rejected"),HttpStatus.OK);
	}
	
	@GetMapping("/loans/{status}")
	public ResponseEntity<Object> findLoanByStatus(@PathVariable String status){
		return new ResponseEntity<>(loanService.findLoanByStatus(status), HttpStatus.OK);
	}
}
