package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier {
	@Id
	private String supplierid;
	
	@NotEmpty(message="Supplier Name is Mandatory")
	private String suppliername;
	
	@NotEmpty(message="Supplier Description is Mandatory")
	private String supplierdesc;
	
	@NotNull(message="Choose an option")
	private boolean issupplieravailable;
	
	@Transient // only for model, will not effect in DB
	private MultipartFile supimagefile;
	
	
	
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	
	public String getSupplierdesc() {
		return supplierdesc;
	}
	public void setSupplierdesc(String supplierdesc) {
		this.supplierdesc = supplierdesc;
	}
	public boolean isIssupplieravailable() {
		return issupplieravailable;
	}
	public void setIssupplieravailable(boolean issupplieravailable) {
		this.issupplieravailable = issupplieravailable;
	}
	public MultipartFile getSupimagefile() {
		return supimagefile;
	}
	public void setSupimagefile(MultipartFile supimagefile) {
		this.supimagefile = supimagefile;
	}
	

}
