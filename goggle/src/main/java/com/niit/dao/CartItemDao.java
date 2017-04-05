package com.niit.dao;

import com.niit.model.CartItem;

public interface CartItemDao {

	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItem(String cartItemId);
	public abstract void removeCartItem(String itemID);
	public abstract void removeAllCartItems(String customerid);
}
