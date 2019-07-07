package com.bank.oz.service;

import com.bank.oz.bean.LoanBean;

public interface LoanService {

	Object applyLoan(LoanBean loanBean);

	Object findAll();

	Object approveLoan(LoanBean loanBean);

	Object deleteLoan(int loanId,String status);

	Object findLoanByStatus(String status);

}
