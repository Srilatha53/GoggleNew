package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.ProductSurvey;
import com.niit.model.UserDetails;
import com.niit.model.UserOrder;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.UserDetailsService;
import com.niit.service.UserOrderService;

import org.springframework.ui.Model;

@Controller
public class OrderController {
		
	@Autowired
	private CustomerService cs;
	@Autowired
	private UserDetailsService us;
	@Autowired
	private CartService cas;	
	@Autowired
	private UserOrderService uos;

		@RequestMapping("/order/{cartId}")
		public String displayCheckOut(@PathVariable String cartId,Model m,Principal principal){
			UserDetails ud=us.getUserDetailsById(principal.getName());
			Customer customer1=cs.getCustomerByUserId(ud.getUserid());
			Cart cart1=customer1.getCart();
			int cartsize = cas.getCartSize(cart1);	
			System.out.println("\nCartid in checkout : " + cartId);
			m.addAttribute("cartsi", cartsize);
			
			return "redirect:/checkout?cartId="+cartId;
		}
	
		@RequestMapping("/reqShowCustOrderHistory")
		public String displayOrderHistory(@RequestParam("uid")String userid, Model m){
			Customer cus = cs.getCustomerByUserId(userid);
			List<UserOrder> orders = uos.custOrders(cus.getCustomerid());
			m.addAttribute("customerid",cus.getCustomerid());
			System.out.print("\nOrders : " + orders);
			m.addAttribute("ordrs", orders);
			return "showOrders";
		}
		
		@RequestMapping("/reqAddProductRating/{productid}")
		public String rateProduct(@PathVariable String productid, @RequestParam("rating") int rating,HttpSession hsession){
			ProductSurvey prod = new ProductSurvey();
			prod.setCustomerid(cs.getCustomerByUserId(hsession.getAttribute("loginid").toString()).getCustomerid());
			prod.setCustordhisid("na");
			prod.setRating(rating);
			prod.setProductid(productid);
			prod.setFeedback("ok");
			uos.addProductReview(prod);
			return null;
		}

}
