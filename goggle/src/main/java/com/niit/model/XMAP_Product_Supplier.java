package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

//import org.hibernate.validator.constraints.Range;

@Entity
public class XMAP_Product_Supplier implements Serializable{
@Id
private String psid;
private String productid;
private String supplierid;

@Min (value=500)
private int psprice;


private boolean ispsavailable;

@Min (value=5)
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
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public int getPsprice() {
	return psprice;
}
public void setPsprice(int psprice) {
	this.psprice = psprice;
}
public boolean isIspsavailable() {
	return ispsavailable;
}
public void setIspsavailable(boolean ispsavailable) {
	this.ispsavailable = ispsavailable;
}
public int getPsstock() {
	return psstock;
}
public void setPsstock(int psstock) {
	this.psstock = psstock;
}

}
