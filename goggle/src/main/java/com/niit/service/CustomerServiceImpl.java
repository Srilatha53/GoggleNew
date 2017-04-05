package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public String addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
	}

	public Customer getCustomerByUserId(String userid) {
			return customerDao.getCustomerByUserId(userid);
	}

/*	public void editUserDetails(Customer usr) {
		customerDao.editUserDetails(usr);
		
	}*/
	
	
}
