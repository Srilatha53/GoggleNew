package com.niit.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	public void addProducts(Product pr) {
		productDao.addProducts(pr);
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
	}


	public void deleteProduct(String proid) {
		productDao.deleteProduct(proid);
		
	}

	public Product getProductById(String pid) {
		return productDao.getProductById(pid);
	}

	public void editProduct(Product prd) {
		productDao.editProduct(prd);
		
	}

	
}
