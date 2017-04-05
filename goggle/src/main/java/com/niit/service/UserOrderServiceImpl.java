package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserOrderDao;
import com.niit.model.Cart;
import com.niit.model.ProductSurvey;
import com.niit.model.UserOrder;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDao uao;
	
	public void addUserOrder(Cart cart) {
		uao.addUserOrder(cart);
	}

	public List<UserOrder> custOrders(String custmerid) {
		// TODO Auto-generated method stub
		return uao.custOrders(custmerid);
	}

	public void addProductReview(ProductSurvey psur) {
		uao.addProductReview(psur);
		
	}

}
