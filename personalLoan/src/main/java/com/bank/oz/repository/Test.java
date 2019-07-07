package com.bank.oz.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bank.oz.model.LoanEmi;

public class Test {

	public static void main(String[] args) {

//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.DAY_OF_MONTH, 5);
////	    c.setTime(sdf.parse(date));
//		for(int i=1; i<=5; i++) {
//			c.add(Calendar.MONTH, 1);
//			Date date = c.getTime();
//			System.out.println(date);
//		}
		
		/*double amount = 100;
		double monthlyEmi =10;
		List<LoanEmi> loanEmi = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		
		for(int i=1; i<=10; i++) {
			LoanEmi emi = new LoanEmi();
			calendar.add(Calendar.MONTH, 1);
			emi.setEmiPaymentDate(calendar.getTime());
			emi.setMonthylyEmi(monthlyEmi);
			emi.setPendingAmount(amount =amount-monthlyEmi);
			System.out.println(emi);
			loanEmi.add(emi);
		}
		System.out.println("loanEmi : "+loanEmi);*/
	    double loanAmount =20000;
	    int intrestRate =12;
	    int installment =16;
		double amount = loanAmount*( 1 + ((intrestRate * installment)/(100.0*12)));
		double monthlyEmi = amount/installment;
		System.out.println("amount : "+amount+", monthlyEmi : "+monthlyEmi);
	}

}
