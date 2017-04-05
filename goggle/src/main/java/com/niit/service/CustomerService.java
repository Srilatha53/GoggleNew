package com.niit.service;

import com.niit.model.Customer;

public interface CustomerService {

	public abstract String addCustomer(Customer cust);
	public abstract Customer getCustomerByUserId(String userid);
	//public abstract void editUserDetails(Customer usr);

}
