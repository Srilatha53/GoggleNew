package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserOrderHistory {

	@Id
	private String odrhistoryid;
	
	private String productid;
	private String supplierid;
	private int price;
	private int quantity;
	private int total;
	private boolean reviewgiven;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private UserOrder userOrder;

	
	public String getOdrhistoryid() {
		return odrhistoryid;
	}

	public void setOdrhistoryid(String odrhistoryid) {
		this.odrhistoryid = odrhistoryid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isReviewgiven() {
		return reviewgiven;
	}

	public void setReviewgiven(boolean reviewgiven) {
		this.reviewgiven = reviewgiven;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}



}
