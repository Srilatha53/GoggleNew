package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vw_Xmap_Ps {
@Id
private String psid;
private String productid;
private String productname;
private String supplierid;
private String suppliername;
private int psprice;
private int psstock;

public String getPsid() {
	return psid;
}
public void setPsid(String psid) {
	this.psid = psid;
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
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public int getPsprice() {
	return psprice;
}
public void setPsprice(int psprice) {
	this.psprice = psprice;
}
public int getPsstock() {
	return psstock;
}
public void setPsstock(int psstock) {
	this.psstock = psstock;
}


}
