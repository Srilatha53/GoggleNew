package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	public abstract void addProducts(Product pr);
	public abstract List<Product> getProducts();
	public abstract void deleteProduct(String proid);
	public abstract Product getProductById(String pid);
	public abstract void editProduct(Product prd);

}
