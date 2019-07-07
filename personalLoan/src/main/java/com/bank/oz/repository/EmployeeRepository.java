package com.bank.oz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.oz.model.BankEmployee;

public interface EmployeeRepository extends JpaRepository<BankEmployee, Integer> {

	public BankEmployee findByDesigination(String desigination);
}
