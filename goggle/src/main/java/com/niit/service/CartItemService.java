package com.niit.service;

import com.niit.model.CartItem;



public interface CartItemService {

	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItem(String cartItemId);
	public abstract void removeCartItem(String itemID);
	public abstract void removeAllCartItems(String customerid);

}
