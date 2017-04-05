package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	private String productid;
	
	@NotEmpty(message="Product Name is Mandatory")
	private String productname;
	
	@NotEmpty(message="Product Description is Mandatory")
	private String productdesc;
	
	@NotNull(message="Choose an option")
	private String isproductavailable;
	
	@Transient // only for model, will not effect in DB
	private MultipartFile imagefile;
	
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public String getIsproductavailable() {
		return isproductavailable;
	}
	public void setIsproductavailable(String isproductavailable) {
		this.isproductavailable = isproductavailable;
	}
	
	

}
