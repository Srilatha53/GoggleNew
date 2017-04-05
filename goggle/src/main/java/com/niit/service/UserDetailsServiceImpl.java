package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDetailsDao;
import com.niit.model.Customer;
import com.niit.model.UserDetails;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	

	@Autowired
	private UserDetailsDao userdetails;
	public String addUser(UserDetails ud) {
		System.out.println("before SErvice");
		return userdetails.addUser(ud);
	}

	public UserDetails loginCheck(UserDetails ud) {
		return userdetails.loginCheck(ud);
	}

	public UserDetails getUserDetailsById(String uid) {
		
		return userdetails.getUserDetailsById(uid);
	}

	public void editUserDetails(UserDetails usr) {
		userdetails.editUserDetails(usr);
		
	}

	public void enableUser(String uid) {
		userdetails.enableUser(uid);
		
	}

	public void disableUser(String uid) {
		userdetails.disableUser(uid);
		
	}

	public List<UserDetails> getAllUsers() {
		return userdetails.getAllUsers();
	}

	public void editPassword(UserDetails us) {
		userdetails.editPassword(us);
	}

	public Customer getCustomerById(String cid) {
		return userdetails.getCustomerById(cid);
	}

}
