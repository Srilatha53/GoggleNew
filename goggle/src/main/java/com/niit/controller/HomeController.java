package com.niit.controller;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;
import com.niit.model.UserDetails;
import com.niit.model.Vw_Xmap_Ps;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;
import com.niit.service.UserDetailsService;
import com.niit.service.ViewProductsService;

@Controller
public class HomeController {

	@Autowired
	private ProductService ps;
	@Autowired
	private UserDetailsService userdetailsservice;
	@Autowired
	private ViewProductsService vps;
	@Autowired 
	private CustomerService customerservice;
	
	@RequestMapping("/")
	public String displayHomePage(Model m){
	//	m.addAttribute("userObject", new UserDetails());
		Customer cust=new Customer();
		ShippingAddress sadd=new ShippingAddress();
		UserDetails usd=new UserDetails();
		cust.setUserDetails(usd);
		cust.setShippingAddress(sadd);
		m.addAttribute("customerObject", cust);
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		//List<Vw_Xmap_Ps> psdata = vps.getVwPs(); 
				List<Vw_Xmap_Ps> psdata = vps.getBestVwPs(); 
				m.addAttribute("psdata", psdata);
						return "home";
	}
	
	@RequestMapping("/home")
	public String displayHomePage1(Model m){
		//m.addAttribute("userObject", new UserDetails());

		
		Customer cust=new Customer();
		ShippingAddress sadd=new ShippingAddress();
		UserDetails usd=new UserDetails();
		//List<Product> pr=ps.getProducts();
		
		cust.setUserDetails(usd);
		cust.setShippingAddress(sadd);
		
		m.addAttribute("customerObject", cust);
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		
		List<Vw_Xmap_Ps> psdata = vps.getBestVwPs();
		m.addAttribute("psdata", psdata);

		return "home";
	}
	
	/*@RequestMapping("/reqspringloginpage")
	public String displaySpringLoginPage(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model m,HttpSession hses){
		if(error!=null)
			m.addAttribute("error", "Invalid USER ID and PASSWORD.. Please enter valid details");
		if(logout!=null){
			m.addAttribute("logout","Loggedout Successfully..");
		hses.setAttribute("userlogedin", null);
		hses.setAttribute("userlogin", null);
		return "redirect:/home";
	}
		return "springloginpage";
	}*/
	
	
	@RequestMapping("/loginCheck")
	public String loginCheck(Principal principal,HttpSession hsession,Model m){
		System.out.println("\n HOME controller- LOGIN CHECK()");
		System.out.println("\n Name : " + principal.getName());
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userrole=authentication.getAuthorities().toString().substring(1, 10);
		System.out.println("\nRole :" +userrole);
		
		UserDetails ud=(UserDetails)userdetailsservice.getUserDetailsById(principal.getName());
		Customer cust=customerservice.getCustomerByUserId(ud.getUserid());
	
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		
		/*hsession.setAttribute("loginname", cust.getCustlname());
		hsession.setAttribute("loginid", ud.getUserid());
		hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
		hsession.setAttribute("loginimage", cust.getImagefile());*/
		
		//m.addAttribute("userlogedin",ud.getCustomer().getCustlname());
		//m.addAttribute("userlogin",ud.getUserid());
		//m.addAttribute("userimage",ud.getUserid());
		
		
		if(userrole.equals("ROLE_USER")){
			
			
			m.addAttribute("loginname", cust.getCustlname());
			
			m.addAttribute("cartsize", cust.getCart());
			m.addAttribute("loginimage", cust.getImagefile());
			m.addAttribute("loginid", ud.getCustomer().getCustomerid());
			hsession.setAttribute("loginid", ud.getUserid());				
			hsession.setAttribute("loginimage", cust.getImagefile());
			hsession.setAttribute("loginname", cust.getCustlname());
		
			int cs = cust.getCart().getCartItems().size();
			hsession.setAttribute("cartsi",cs );
		
			return "loginsuccessuser";
		}
		
		
			else if(userrole.equals("ROLE_ADMI")){
				//UserDetails us=new UserDetails();
				m.addAttribute("admin", principal.getName());
				hsession.setAttribute("admin",principal.getName());	
				return "loginsuccessadmin";
			}
			else
				return "loginpage";
				}
	
	@RequestMapping(value={"/reqForLoginPage"}) // to display loginpage
	public String displaySpringLoginPage(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model m,HttpSession hses){
		if(error!=null)
			m.addAttribute("error", "Invalid USER ID and PASSWORD.. Please enter valid details");
		if(logout!=null){
			m.addAttribute("logout","You have Loggedout Successfully.THANK YOU");
		hses.setAttribute("loginname", null);
		hses.setAttribute("loginid", null);
		List<Vw_Xmap_Ps> psdata = vps.getBestVwPs();
		m.addAttribute("psdata", psdata);
		return "home";
	}
		return "loginpage";
	}
	
	@RequestMapping("/reqForSignupPage") // to display signuppage
	public String displaySignuppage(Model m){
		m.addAttribute("customerObject", new Customer());
		return "signuppage";
	}
	
	@RequestMapping(value="/reqSendSignUpData")
	public String addUser(@Valid @RequestBody(required = true)  @ModelAttribute("custObject")Customer cus, Model m,BindingResult res){
		if(res.hasErrors())
			return "signuppage";
		BillingAddress ba=new BillingAddress();
		ba.setHouseno(cus.getShippingAddress().getHouseno());
		ba.setStreet(cus.getShippingAddress().getStreet());
		ba.setArea(cus.getShippingAddress().getArea());
		ba.setCity(cus.getShippingAddress().getCity());
		ba.setState(cus.getShippingAddress().getState());
		ba.setCountry(cus.getShippingAddress().getCountry());
		ba.setPincode(cus.getShippingAddress().getPincode());
		cus.setBillingAddress(ba);
		cus.setCart(new Cart());
		
		String cusid = customerservice.addCustomer(cus);
		m.addAttribute("message", " You have Signed Up is successfully.Your userid is : " + cusid + "\nPlease login again");
		UserDetails t=new UserDetails();
		m.addAttribute("userObject", t);
		ShippingAddress sa=new ShippingAddress();
		cus.setUserDetails(t);
		cus.setShippingAddress(sa);
		m.addAttribute("customerObject", cus);
		m.addAttribute("imagenum",RandomController.randomNumberGeneration());
		return "loginpage";
		
	}
	
	/*@RequestMapping("/reqLoginCheck")
	public String authenticate(@ModelAttribute("userObject")UserDetails ud,Model m,HttpSession hsession){
		List<UserDetails> data = userdetailsservice.getUserDetails();
		m.addAttribute("users",new UserDetails());
		UserDetails result = userdetailsservice.loginCheck(ud);
		if(result==null){
			m.addAttribute("message", "Login Failed...Retry");
			return "loginpage";
		}
		else { // login success
			if(result.getRole().equals("ROLE_ADMIN")){
				hsession.setAttribute("userlogin", result.getUserid());
				m.addAttribute("userimage", result.getUserid());
				hsession.setAttribute("userlogedin",result.getLastname());
				m.addAttribute("username", result.getLastname());
				m.addAttribute("user", ud);
				return "loginsuccessadmin";}
			else
				hsession.setAttribute("userlogin", result.getUserid());
				m.addAttribute("userimage", result.getUserid());
				hsession.setAttribute("userlogedin",result.getLastname());
				m.addAttribute("username", result.getLastname());
				m.addAttribute("user", ud);
				return "loginsuccessuser";
	
		}
		
	}*/

	/*@RequestMapping("/reqLogout")
	public String logout(HttpSession hsession,Model m){
		hsession.setAttribute("loginname", null);
		hsession.setAttribute("loginid", null);
		//m.addAttribute("message", " You have Logged Out is successfully.THANK YOU");
		return "redirect:/home";
	}*/
	
	@RequestMapping("/reqchangepassword")
	public String changepassword(HttpSession hsession,Model m, @ModelAttribute("passwordObject")UserDetails u){
			/*m.addAttribute("userimage",hsession.getAttribute("userimage"));*/
				return "changepassword";
	}
}
