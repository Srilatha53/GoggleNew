package com.niit.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Service
public class CartServiceImpl implements CartService {


	@Autowired
	private CartDao cartDao;
	
	public Cart getCart(String cartid) {
		return cartDao.getCart(cartid);
	}

	public int getCartSize(Cart cart) {
		return cartDao.getCartSize(cart);
	}

	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

	public Cart validate(String cartid) throws IOException {
		return cartDao.validate(cartid);
	}

	

}
