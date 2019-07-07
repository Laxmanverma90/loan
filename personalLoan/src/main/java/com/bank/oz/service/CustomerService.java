package com.bank.oz.service;

import com.bank.oz.bean.CustomerBean;
import com.bank.oz.model.Customer;

public interface CustomerService {

	Object crateAccount(CustomerBean customerBean);
	
	Customer findByCustId(int custId);

}
