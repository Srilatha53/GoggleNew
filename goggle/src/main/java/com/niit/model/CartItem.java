package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItem implements Serializable {

	@Id
	private String cartitemid;
	private int quantity;
	private int itemwisetotal;
	
	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="psid")
	private XMAP_Product_Supplier xPS;

	public String getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemwisetotal() {
		return itemwisetotal;
	}

	public void setItemwisetotal(int itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public XMAP_Product_Supplier getxPS() {
		return xPS;
	}

	public void setxPS(XMAP_Product_Supplier xPS) {
		this.xPS = xPS;
	}

	
	
}
