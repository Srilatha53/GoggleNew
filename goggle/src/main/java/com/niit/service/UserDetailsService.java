package com.niit.service;

import java.util.List;

import com.niit.model.Customer;
import com.niit.model.UserDetails;

public interface UserDetailsService {
	public abstract String addUser(UserDetails ud);
	public abstract UserDetails loginCheck(UserDetails ud);
	public abstract UserDetails getUserDetailsById(String uid);
	public abstract void editUserDetails(UserDetails usr);
	public abstract List<UserDetails> getAllUsers();
	public abstract void enableUser(String uid);
	public abstract void disableUser(String uid);
	public abstract Customer getCustomerById(String cid);
	public abstract void editPassword(UserDetails us);
}
