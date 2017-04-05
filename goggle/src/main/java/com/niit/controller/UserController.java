package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;
import com.niit.model.UserDetails;
import com.niit.model.Vw_Xmap_Ps;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.UserDetailsService;
import com.niit.service.ViewProductsService;

@Controller
public class UserController {
	@Autowired
	private ViewProductsService vps;
	@Autowired
	private UserDetailsService user;
	@Autowired
	private CustomerService custom;
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(Principal principal,Model m,HttpSession hsession){
		
		UserDetails ud=user.getUserDetailsById(principal.getName());
		Customer cust=custom.getCustomerByUserId(ud.getUserid());
		Cart cart = cust.getCart();
		int cartsize = cartService.getCartSize(cart);
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
		//m.addAttribute("loginid", hsession.getAttribute("loginid"));
		m.addAttribute("cartsi",hsession.getAttribute("cartsize"));
		m.addAttribute("loginimage",hsession.getAttribute("loginimage"));
		m.addAttribute("grandtotal",cart.getGrandtotal());*/
		
		/*m.addAttribute("loginname", cust.getCustlname());
		m.addAttribute("loginid", ud.getCustomer().getCustomerid());
		m.addAttribute("cartsize", cust.getCart());
		m.addAttribute("loginimage", cust.getImagefile());
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		hsession.setAttribute("loginimage", cust.getImagefile());
		hsession.setAttribute("loginname", cust.getCustlname());
		hsession.setAttribute("loginid", ud.getUserid());
		hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());*/
			
		//List<Vw_Xmap_Ps> psdata = vps.getVwPs(); 
		List<Vw_Xmap_Ps> psdata = vps.getBestVwPs(); 
		/*//m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));*/
		m.addAttribute("psdata", psdata);
		
		return "displayproductsuser";
	}
	
	@RequestMapping("/reqAllSuppProducts")
	public String displayAllSuppProducts(@RequestParam("pid")String pid,Model m,HttpSession hsession){		
		List<Vw_Xmap_Ps> data = vps.getAllSuppProducts(pid);
		m.addAttribute("products", data);
		m.addAttribute("productid", data.get(0).getProductid());
		m.addAttribute("productname", data.get(0).getProductname());		
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		m.addAttribute("loginname",hsession.getAttribute("loginname"));
		m.addAttribute("loginid",hsession.getAttribute("loginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		return "showSuppliers";
	}
	@RequestMapping("/reqEditUser")
	public String getCustomerByUserId(@RequestParam("cid")String cid,Model m,HttpSession hsession,Principal principal){
		Customer cust=user.getCustomerById(cid);
		//cust.setImagefile(cust.getImagefile());
		
		m.addAttribute("custObject",cust);
		m.addAttribute("loginid",cid);
		hsession.setAttribute("loginid", cid);
		return "edituser";
	}	
	
	@RequestMapping("/reqEditUserToDb")
	public String editUserDetails(@ModelAttribute("custObject")UserDetails usr,HttpSession hsession,Model m){
		//Customer cust=custom.getCustomerByUserId(usr.getUserDetails().getUserid());
	
//m.addAttribute("custObject", cust);
		
		//m.addAttribute("logineid", cust.getUserDetails().getUserid());
		//hsession.setAttribute("logineid", cust.getUserDetails().getUserid());
		/*m.addAttribute("loginid", cust.getCustomerid());
		hsession.setAttribute("loginid", cust.getCustomerid());*/
		user.editUserDetails(usr);
		Customer cust=custom.getCustomerByUserId(usr.getCustomer().getCustomerid());
		//m.addAttribute("loginid",cust.getCustomerid());
		//hsession.setAttribute("loginid", cust.getCustomerid());

		m.addAttribute("loginid", usr.getUserid());
		
		
		m.addAttribute("custObject", usr);
		//m.addAttribute("imagenum",RandomController.randomNumberGeneration());
		return "loginsuccessuser";
		
	}
	@RequestMapping("/reqEditPassword")
	public String editpassword(Model m,HttpSession hsession,Principal principal){
		UserDetails ud=user.getUserDetailsById(principal.getName());
		Customer cust=custom.getCustomerByUserId(ud.getUserid());
		m.addAttribute("loginname", cust.getCustlname());
		m.addAttribute("loginid", ud.getCustomer().getCustomerid());
		m.addAttribute("cartsize", cust.getCart());
		m.addAttribute("loginimage", cust.getImagefile());
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		hsession.setAttribute("loginimage", cust.getImagefile());
		hsession.setAttribute("loginname", cust.getCustlname());
		hsession.setAttribute("loginid", ud.getUserid());
		hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
		UserDetails t=new UserDetails();
		m.addAttribute("userObject", t);
		return "changepassword";
	
	}
	@RequestMapping("/reqEditPasswordtoDB")
	public String editpasswordtoDB(@ModelAttribute("passwordObject")UserDetails usr,HttpSession hsession,Model m){
		
		user.editPassword(usr);
		
	return "displayproductsuser";
	}
}
