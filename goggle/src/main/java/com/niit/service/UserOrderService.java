package com.niit.service;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.ProductSurvey;
import com.niit.model.UserOrder;

public interface UserOrderService {
	public abstract void addUserOrder(Cart cart);
	public List<UserOrder> custOrders(String custmerid);
	public void addProductReview(ProductSurvey psur);

}
