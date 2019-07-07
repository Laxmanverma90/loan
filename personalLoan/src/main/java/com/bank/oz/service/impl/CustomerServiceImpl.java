package com.bank.oz.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.oz.bean.CustomerBean;
import com.bank.oz.model.Customer;
import com.bank.oz.repository.CustomerRepository;
import com.bank.oz.service.CustomerService;

/**
 * @author Laxman
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Object crateAccount(CustomerBean customerBean) {
		String returnMessage = null;
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerBean, customer);
		if(customerRepo.save(customer)!=null) {
			returnMessage = "Congrats! Customer's account created.";
		} else {
			returnMessage = "Sorry! Customer's account not created.";
		}
		return returnMessage;
	}

	@Override
	public Customer findByCustId(int custId) {
		return customerRepo.findByCustId(custId);
	}

}
