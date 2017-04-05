package com.niit.controller;


//import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetails;
import com.niit.model.XMAP_Product_Supplier;
import com.niit.service.ProductService;
import com.niit.service.SupplierService;
import com.niit.service.UserDetailsService;
import com.niit.service.XmapPSService;


@Controller
public class AdminController {

	@Autowired
	private ProductService ps;
	
	@Autowired
	private SupplierService  sps;
	
	@Autowired
	private XmapPSService xps;
	
	@Autowired
	private UserDetailsService user;
	
	
	// Products
	
	@RequestMapping("/reqProductForm") 
	public String displayProductForm(Model m,HttpSession hsession){
		m.addAttribute("productObj", new Product());
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		
		
		return "addproduct";
	}
	
	@RequestMapping(value={"/addProductToDB"},method = RequestMethod.POST)
	public String addProductToDb(@Valid @ModelAttribute("productObj")Product prd,BindingResult result){		
		if(result.hasErrors())
			return "addproduct";
		ps.addProducts(prd);		
		return "redirect:/reqDisplayProductsAdmin";  // displays admins home page			
	}
	
	@RequestMapping("/reqDisplayProductsAdmin")
	public String displayProductsAdmin(@ModelAttribute("userObject")UserDetails ud,Model m,HttpSession hsession){
		List<Product> data = ps.getProducts();
		m.addAttribute("products",data);
		m.addAttribute("users", ud);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "displayproductsadmin";
	}
	@RequestMapping("/reqDeleteProduct")
	public String deleteProduct(@RequestParam("pid")String proid,HttpSession hsession,Model m){
		//System.out.println(supid);
		ps.deleteProduct(proid);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "redirect:/reqDisplayProductsAdmin";
	}
	
	@RequestMapping("/reqEditProductPage")
	public String editProduct(@RequestParam("pid")String pid,Model m,HttpSession hsession){		
		Product temp = ps.getProductById(pid);
		m.addAttribute("productObj", temp);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "editProductPage";
	}
	
	@RequestMapping("/reqEditProductToDb")
	public String editproducttodb(@ModelAttribute("productObj")Product prd){
		ps.editProduct(prd);
		return "redirect:/reqDisplayProductsAdmin";
	}
	
	// Supplier 

	@RequestMapping("/reqSupplierForm")
	public String displaySupplierForm(Model m,HttpSession hsession){
		m.addAttribute("supplierObj", new Supplier());
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "addsupplier";
	}
	
	@RequestMapping(value={"/addSupplierToDB"},method = RequestMethod.POST)
	public String addSupplierToDB(@Valid @ModelAttribute("supplierObj")Supplier sup,BindingResult result){	
		if(result.hasErrors())
			return "addsupplier";
		sps.addSuppliers(sup);		
		return "redirect:/reqDisplaySuppliersAdmin";  // displays admins home page			
	}
	
	@RequestMapping("/reqDisplaySuppliersAdmin")
	public String displaySuppliersAdmin(Model m,HttpSession hsession){
		List<Supplier> data = sps.getSuppliers();
		m.addAttribute("suppliers",data);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "displaysupplieradmin";
	}
	@RequestMapping("/reqDeleteSupplier")
	public String deleteSupplier(@RequestParam("sid")String supid,HttpSession hsession,Model m){
		//System.out.println(supid);
		sps.deleteSupplier(supid);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "redirect:/reqDisplaySuppliersAdmin";
	}
	
	@RequestMapping("/reqEditSupplierPage")
	public String editSupplier(@RequestParam("sid")String sid,Model m,HttpSession hsession){		
		Supplier temp = sps.getSupplierById(sid);
		m.addAttribute("supplierObj", temp);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "editSupplierPage";
	}
	
	@RequestMapping("/reqEditSupplierToDb")
	public String editsuppliertodb(@ModelAttribute("supplierObj")Supplier sup){
		sps.editSupplier(sup);
		return "redirect:/reqDisplaySuppliersAdmin";
	}
	
	
	// Product Supplier
	@RequestMapping("/reqPSForm") 
	public String displayPSForm(Model m,HttpSession hsession){
		List<Product> prod=ps.getProducts();
		List<Supplier> supp=sps.getSuppliers();
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		m.addAttribute("products", prod);
		m.addAttribute("suppliers",supp);
		m.addAttribute("xmapObj", new XMAP_Product_Supplier());
		return "addProdSupp";
	}
	@RequestMapping(value="/addPStoDB")
	public String addPStoDB(@Valid
			@ModelAttribute("psObj")XMAP_Product_Supplier x,BindingResult re){
		if(re.hasErrors())
			return "addProdSupp";
		xps.addXmapPs(x);
		return "redirect:/reqdisplayps";
	}
	@RequestMapping("/reqdisplayps")
	public String displayxps(Model m,HttpSession hsession){
		List<XMAP_Product_Supplier> xpsdata=xps.displayXmapPS();
		List<Product> pr=ps.getProducts();
		List<Supplier> su=sps.getSuppliers();
		m.addAttribute("xpsdata",xpsdata);
		m.addAttribute("products", pr);
		m.addAttribute("suppliers",su);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "displayxps";
	}
	@RequestMapping("/reqDeleteProdSupp")
	public String deleteProdSupp(@RequestParam("psid")String sprosupid,HttpSession hsession,Model m){
		//System.out.println(prosupid);
		xps.deleteProdSupp(sprosupid);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "redirect:/reqdisplayps";
	}
	
	@RequestMapping("/reqEditProdSuppPage")
	public String editProdSupp(@RequestParam("psid")String prsuid,Model m,HttpSession hsession){		
		XMAP_Product_Supplier temp = xps.getProdSuppById(prsuid);
		List<Product> pr=ps.getProducts();
		List<Supplier> su=sps.getSuppliers();
		m.addAttribute("prodsuppObj", temp);
		m.addAttribute("products", pr);
		m.addAttribute("suppliers",su);
		m.addAttribute("userimage",hsession.getAttribute("userlogin"));
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		return "editProdSuppPage";
	}
	
	@RequestMapping("/reqEditProdSuppToDb")
	public String editprodsupptodb(@ModelAttribute("prodsuppObj")XMAP_Product_Supplier sprosup){
		xps.editProdSupp(sprosup);
		return "redirect:/reqdisplayps";
	}

	@RequestMapping("/reqDisplayUsers")
	public String displayUsers(Model m){		
		List<UserDetails> userdata = user.getAllUsers();
		m.addAttribute("userdata", userdata);
		m.addAttribute("imagenum", RandomController.randomNumberGeneration());
		return "displayusers";
	}

	@RequestMapping("reqDisableUser")
	public String disableUser(@RequestParam("uid")String uid){
		user.disableUser(uid);
		return "redirect:/reqDisplayUsers";
	}
	
	@RequestMapping("reqEnableUser")
	public String enableUser(@RequestParam("uid")String uid){
		user.enableUser(uid);
		return "redirect:/reqDisplayUsers";
	}

}
