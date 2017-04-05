package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductSurvey {

	@Id
	private String surveyid;
	private String customerid;
	private String custordhisid;
	private String productid;
	private int rating;
	private String feedback;
	
	public String getSurveyid() {
		return surveyid;
	}
	public void setSurveyid(String surveyid) {
		this.surveyid = surveyid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustordhisid() {
		return custordhisid;
	}
	public void setCustordhisid(String custordhisid) {
		this.custordhisid = custordhisid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
		
}
