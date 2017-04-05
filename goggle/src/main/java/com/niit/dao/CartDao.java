package com.niit.dao;

import java.io.IOException;

import com.niit.model.Cart;

public interface CartDao {

	public abstract Cart getCart(String cartid); 
	public abstract int getCartSize(Cart cart);
	public abstract void updateCart(Cart cart);
	public abstract Cart validate(String cartid) throws IOException;
}
