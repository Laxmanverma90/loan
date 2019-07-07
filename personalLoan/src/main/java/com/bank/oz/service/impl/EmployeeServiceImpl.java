package com.bank.oz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.oz.model.BankEmployee;
import com.bank.oz.repository.EmployeeRepository;
import com.bank.oz.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public BankEmployee getEmployee(String desigination) {
		return empRepository.findByDesigination(desigination);
	}

}
