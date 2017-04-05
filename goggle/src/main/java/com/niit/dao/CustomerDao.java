package com.niit.dao;

import com.niit.model.Customer;

public interface CustomerDao {

	public abstract String addCustomer(Customer cust);
	public abstract Customer getCustomerByUserId(String userid);
	//public abstract void editUserDetails(Customer usr);
}
