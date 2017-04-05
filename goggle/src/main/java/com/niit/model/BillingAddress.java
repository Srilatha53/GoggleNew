package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress implements Serializable{

	@Id
	private String billingaddressid;
	@NotEmpty(message="Please Enter House No")
	private String houseno;
	
	@NotEmpty(message="Please Enter street")
	private String street;
	
	@NotEmpty(message="Please Enter area")
	private String area;
	
	@NotEmpty(message="Please Enter city")
	private String city;
	
	@NotEmpty(message="Please Enter state")
	private String state;
	
	@NotEmpty(message="Please Enter country")
	private String country;
	
	@NotEmpty(message="Please Enter pincode")
	private String pincode;
	
	@OneToOne(mappedBy="billingAddress")
	private Customer customer;

	public String getBillingaddressid() {
		return billingaddressid;
	}

	public void setBillingaddressid(String billingaddressid) {
		this.billingaddressid = billingaddressid;
	}

	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
