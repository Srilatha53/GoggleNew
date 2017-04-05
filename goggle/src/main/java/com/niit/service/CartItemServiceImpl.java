package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;


@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartitemdao;
	
	public void addCartItem(CartItem cartItem) {
		cartitemdao.addCartItem(cartItem);
	}

	public CartItem getCartItem(String cartItemId) {
		return cartitemdao.getCartItem(cartItemId);
	}

	public void removeCartItem(String itemID) {
		cartitemdao.removeCartItem(itemID);
	}

	public void removeAllCartItems(String customerid) {
		cartitemdao.removeAllCartItems(customerid);
	}

	

}
