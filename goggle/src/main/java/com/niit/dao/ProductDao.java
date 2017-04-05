package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
public abstract void addProducts(Product p);
public abstract List<Product> getProducts();
public abstract void deleteProduct(String proid);
public abstract Product getProductById(String pid);
public abstract void editProduct(Product prd);
}
