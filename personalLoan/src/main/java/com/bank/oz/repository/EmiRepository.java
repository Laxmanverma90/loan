package com.bank.oz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.oz.model.LoanEmi;

@Repository
public interface EmiRepository extends JpaRepository<LoanEmi, Integer> {

}
