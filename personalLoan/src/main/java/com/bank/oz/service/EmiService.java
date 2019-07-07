package com.bank.oz.service;

import java.util.List;

import com.bank.oz.model.Loan;
import com.bank.oz.model.LoanEmi;

public interface EmiService {
	
	public boolean createEmi(double amount, double emi, Loan loan);
	
	public List<LoanEmi> findAllEmi();
}
