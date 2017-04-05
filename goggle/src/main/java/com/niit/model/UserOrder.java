package com.niit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class UserOrder implements Serializable{

	
	@Id
	private String orderid;


	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billaddid")
	private BillingAddress billAdd;
	
	@OneToOne
	@JoinColumn(name="shiaddid")
	private ShippingAddress shiAdd;
	
	@OneToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	
	@OneToMany(mappedBy="userOrder", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<UserOrderHistory> custOHis;
	
	private Date orderDate;
	
	private String custmerid;
	
	private String shippedaddress;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillAdd() {
		return billAdd;
	}

	public void setBillAdd(BillingAddress billAdd) {
		this.billAdd = billAdd;
	}

	public ShippingAddress getShiAdd() {
		return shiAdd;
	}

	public void setShiAdd(ShippingAddress shiAdd) {
		this.shiAdd = shiAdd;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<UserOrderHistory> getCustOHis() {
		return custOHis;
	}

	public void setCustOHis(List<UserOrderHistory> custOHis) {
		this.custOHis = custOHis;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustmerid() {
		return custmerid;
	}

	public void setCustmerid(String custmerid) {
		this.custmerid = custmerid;
	}

	public String getShippedaddress() {
		return shippedaddress;
	}

	public void setShippedaddress(String shippedaddress) {
		this.shippedaddress = shippedaddress;
	}
	
	


}
