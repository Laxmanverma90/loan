package com.bank.oz.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.oz.model.Loan;
import com.bank.oz.model.LoanEmi;
import com.bank.oz.repository.EmiRepository;
import com.bank.oz.service.EmiService;

@Service
public class EmiServiceImpl implements EmiService {

	@Autowired
	private EmiRepository emiRepo;
	
	@Override
	public boolean createEmi(double amount, double monthlyEmi, Loan loan) {
		
		boolean returnFlag = false;
		List<LoanEmi> loanEmi = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		
		for(int i=1; i<=loan.getInstallment(); i++) {
			LoanEmi emi = new LoanEmi();
			calendar.add(Calendar.MONTH, 1);
			emi.setEmiPaymentDate(calendar.getTime());
			emi.setMonthylyEmi(monthlyEmi);
			emi.setPendingAmount(amount =amount-monthlyEmi);
			emi.setLoan(loan);
			loanEmi.add(emi);
		}
		if(emiRepo.saveAll(loanEmi)!= null) {
			returnFlag = true;
		}
		return returnFlag;
	}

	@Override
	public List<LoanEmi> findAllEmi() {
		return emiRepo.findAll();
	}
}
