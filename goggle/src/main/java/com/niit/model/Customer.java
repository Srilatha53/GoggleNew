package com.niit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Customer implements Serializable{

	
	@Id
	private String customerid;
	
	@NotEmpty(message="*SurName is Mandatory")
	private String custfname;

	@NotEmpty(message="*Name is Mandatory")
	private String custlname;
	
	@NotEmpty(message="*Select Male or Female")
	private String gender;
	
	@NotEmpty(message="*Please Enter Email ID")
	@Email(message="*Please Enter Valid Email ID")
	private String custemailid;
	
	@NotEmpty(message="*Please Enter Mobile Number")
	@Length(max=10,min=10)
	private String custmobileno;
	
	@Transient
	private MultipartFile imagefile;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	@Valid
	private UserDetails userDetails;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingaddressid")
	private BillingAddress billingAddress;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingaddressid")
	private ShippingAddress shippingAddress;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;
	
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustfname() {
		return custfname;
	}

	public void setCustfname(String custfname) {
		this.custfname = custfname;
	}

	public String getCustlname() {
		return custlname;
	}

	public void setCustlname(String custlname) {
		this.custlname = custlname;
	}
	
	

	public String getCustemailid() {
		return custemailid;
	}

	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}

	public String getCustmobileno() {
		return custmobileno;
	}

	public void setCustmobileno(String custmobileno) {
		this.custmobileno = custmobileno;
	}

	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
	

	
