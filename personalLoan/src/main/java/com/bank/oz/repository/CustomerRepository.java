package com.bank.oz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.oz.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByCustId(int custId);
}
