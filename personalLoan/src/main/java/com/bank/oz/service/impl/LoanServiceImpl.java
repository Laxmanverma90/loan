package com.bank.oz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bank.oz.bean.LoanBean;
import com.bank.oz.exception.CustomException;
import com.bank.oz.model.Customer;
import com.bank.oz.model.Loan;
import com.bank.oz.repository.LoanRepository;
import com.bank.oz.service.CustomerService;
import com.bank.oz.service.EmiService;
import com.bank.oz.service.EmployeeService;
import com.bank.oz.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmiService emiService;
	
	@Value("${intrest.rate}")
	private int intrestRate;
	
	@Override
	public Object applyLoan(LoanBean loanBean) {
		String returnMessage = null;
		Customer customer = customerService.findByCustId(loanBean.getCustId());
		if(customer != null) {
			Loan loan = new Loan();
			BeanUtils.copyProperties(loanBean, loan);
			loan.setCustomer(customer);
			loan.setApplyDate(new Date());
			loan.setStatus("NEW");
			loan.setDeleteFlag(0);
			if(loanRepository.save(loan)!= null) {
				returnMessage = "Congrats! successfully applied for loan.";
			} else {
				returnMessage = "sorry, not applied for loan";
			}
		} else {
			returnMessage = "Sorry, Customer doesn't exist.";
		}
		return returnMessage;
	}

	@Override
	public Object findAll() {
		Object returnObject = null;
		List<Loan> loans = loanRepository.findAll();
		if(!loans.isEmpty()) {
			returnObject = loans;
		} else {
			returnObject = "Sorry, No record found";
		}
		return returnObject;
	}

	@Override
	public Object approveLoan(LoanBean loanBean) {
		Object returnObject = null;
		Customer customer = customerService.findByCustId(loanBean.getCustId());
		Loan loan = loanRepository.findByLoanId(loanBean.getLoanId());
		
//		LocalDate today = LocalDate.now();
//		LocalDate dob = customer.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		Period p = Period.between(dob, today);
//		System.out.println(p.getMonths());
		if(customer!=null) {
			if(customer.getScore()<900) {
				loan.setApprovalDate(new Date());
				loan.setStatus("Rejected");
				loan.setBankEmployee(employeeService.getEmployee("Manager"));
				throw new CustomException("Credit score is less!");
			} else if(customer.getExpInMonths()< 24) {
				loan.setApprovalDate(new Date());
				loan.setStatus("Rejected");
				loan.setBankEmployee(employeeService.getEmployee("Manager"));
				throw new CustomException("Work experience is less!");
//			} else if(p.getYears()<22 || p.getYears()>55) {
//				throw new CustomException("Age criteria is not matching.");
			} else {
				loan.setApprovalDate(new Date());
				loan.setStatus("APPROVED");
				loan.setBankEmployee(employeeService.getEmployee("Manager"));
				
				double amount = loan.getLoanAmount()*( 1 + (intrestRate * loan.getInstallment())/(100.0*12));
				double monthlyEmi = amount/loan.getInstallment();
				if(loanRepository.save(loan)!=null && emiService.createEmi(amount, monthlyEmi, loan)) {
					returnObject =loan;
				}else {
					returnObject = "Record not updated.";
				}
			}
		} else {
			returnObject = "Customer not found.";
		}
		return returnObject;
	}

	@Override
	public Object deleteLoan(int loanId, String status) {
		return loanRepository.updateByLoanIdAndStatus(loanId, status);
	}

	@Override
	public Object findLoanByStatus(String status) {
		return loanRepository.findByStatus(status);
	}

}