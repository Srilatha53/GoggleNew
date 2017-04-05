package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.UserDetails;
import com.niit.model.Vw_Xmap_Ps;
import com.niit.model.XMAP_Product_Supplier;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.UserDetailsService;
import com.niit.service.ViewProductsService;
import com.niit.service.XmapPSService;

@Controller
public class CartItemController {

	
	@Autowired
	private CartItemService cts;
	@Autowired
	private CustomerService cs;
	@Autowired
	private XmapPSService xmapService;
	@Autowired
	private CartService cartService;	
	@Autowired
	private ViewProductsService vwpsservice;
	@Autowired
	private UserDetailsService us;
	
	@RequestMapping("/reqAddItemToCart/{psid}")
	public String addItemToCart(@PathVariable("psid")String psid, @RequestParam("qty")int qty,Principal principal,HttpSession hsession,Model m){
		System.out.println("psid : "+psid + "  qty : " + qty);
		
		/*Autentication authentication = principal.
		UserDetails1 user= (UserDetails1)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
*/
		String userid=principal.getName();
		System.out.println(userid);
		//Customer customer=customerService.getCustomerByUserId(userid);
	
		XMAP_Product_Supplier xmapProduct = xmapService.getProdSuppById(psid);
		
		CartItem cartitem = new CartItem();		
		UserDetails ud=us.getUserDetailsById(principal.getName());
		Customer cust=cs.getCustomerByUserId(ud.getUserid());
		Cart cart=cust.getCart();
		
		
		cartitem.setCart(cart);
		//cartitem.setXmap_product_supplier(xmapProduct); 
		cartitem.setxPS(xmapProduct);
		cartitem.setQuantity(qty);
		cartitem.setItemwisetotal(xmapProduct.getPsprice()*qty);
		
		cts.addCartItem(cartitem);
		
		Customer customer1=cs.getCustomerByUserId(userid);
		Cart cart1=customer1.getCart();
		int cartsize = cartService.getCartSize(cart1);	
		
		List<CartItem> cartitems = cart.getCartItems();
		int sum=0;
		for(CartItem critem :cartitems)
			sum+= critem.getItemwisetotal();
		
		cart.setGrandtotal(sum);
		cartService.updateCart(cart);
			
		
		List<Vw_Xmap_Ps> psdata = vwpsservice.getBestVwPs();
		
		m.addAttribute("psdata", psdata);
		//model.addAttribute("imagenum", RandomController.randomNumberGeneration());
		//model.addAttribute("loginame",hsession.getAttribute("loginname"));
		//model.addAttribute("loginid",hsession.getAttribute("loginid"));
		//UserDetails ud=us.getUserDetailsById(principal.getName());
		//Customer cust=cs.getCustomerByUserId(ud.getUserid());
		
		m.addAttribute("loginname", cust.getCustlname());
		m.addAttribute("loginid", ud.getCustomer().getCustomerid());
		m.addAttribute("cartsize", cust.getCart());
		m.addAttribute("loginimage", cust.getImagefile());
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		hsession.setAttribute("loginimage", cust.getImagefile());
		hsession.setAttribute("loginname", cust.getCustlname());
		hsession.setAttribute("loginid", ud.getUserid());
		//hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
		m.addAttribute("cartsi", cartsize);
		/*m.addAttribute("loginame", hsession.getAttribute("loginname"));
		m.addAttribute("loginid", hsession.getAttribute("loginid"));
		m.addAttribute("cartsi",hsession.getAttribute("cartsize"));
		m.addAttribute("loginimage",hsession.getAttribute("loginimage"))*/;
		m.addAttribute("cartmessage","Item added to cart Successfully");
		
		hsession.setAttribute("cartsize", cartsize);
		
		System.out.println("cart size :" + cartsize);
		
		
		return "displayproductsuser";
		
	//return "redirect:/reqDisplayProductsUser";
	}
	
	@RequestMapping("/reqShowCart")
	public String displayCart(HttpSession hsession,Model m,Principal principal){
		UserDetails ud=us.getUserDetailsById(principal.getName());
	
		Customer cust=cs.getCustomerByUserId(ud.getUserid());
		//Customer cust = customerService.getCustomerByUserId(hsession.getAttribute("loginid").toString());
		Cart cart = cust.getCart();
		int cartsize = cartService.getCartSize(cart);
		List<CartItem> cartitems = cart.getCartItems();
		int sum=0;
		for(CartItem critem :cartitems){
			sum+= critem.getItemwisetotal();
		}
		/*double s=cart.getGrandtotal();
		cart.setGrandtotal(s);*/
		cart.setGrandtotal(sum);
		cartService.updateCart(cart);	
		

		
		//m.addAttribute("cartsize",cust.getCart().getCartItems().size());
		//m.addAttribute("loginimage", cust.getImagefile());
		//m.addAttribute("loginid", ud.getCustomer().getCustomerid());
		//hsession.setAttribute("loginid", ud.getUserid());				
		//hsession.setAttribute("loginimage", cust.getImagefile());
		//hsession.setAttribute("loginname", cust.getCustlname());
		//hsession.setAttribute("cartsi", cartsize);
		//m.addAttribute("cartsize", cartsize);

		m.addAttribute("loginname", cust.getCustlname());
		m.addAttribute("loginid", ud.getCustomer().getCustomerid());
		m.addAttribute("cartsize", cust.getCart());
		m.addAttribute("loginimage", cust.getImagefile());
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		hsession.setAttribute("loginimage", cust.getImagefile());
		hsession.setAttribute("loginname", cust.getCustlname());
		hsession.setAttribute("loginid", ud.getUserid());
		//hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
		m.addAttribute("cartsi", cust.getCart());
		m.addAttribute("grandtotal",cart.getGrandtotal());
		m.addAttribute("cartitems", cartitems);	
		m.addAttribute("customerid",cust.getCustomerid());
		m.addAttribute("customer", cust);
		return "showCartItems";
	}
	
	@RequestMapping("/reqDeleteCartItem/{cartitemid}")
	public String deleteCartItem(@PathVariable("cartitemid")String cartitemid,Principal principal ){
		cts.removeCartItem(cartitemid);		
		return "redirect:/reqShowCart";
	}
	
	@RequestMapping("/reqDeleteCartItems/{customerid}")
	public String deleteProduct(@PathVariable("customerid")String customerid,HttpSession hsession,Model m,Principal principal){
		UserDetails ud=us.getUserDetailsById(principal.getName());
		Customer cust=cs.getCustomerByUserId(ud.getUserid());
		m.addAttribute("customerid",cust.getCustomerid());
		cts.removeAllCartItems(customerid);
		hsession.setAttribute("cartsize", 0);
		return "redirect:/reqDisplayProductsUser";
	}
	
}
