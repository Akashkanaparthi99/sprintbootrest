package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

import java.util.List;


public interface IProductService {

	 void addProduct(Product product);
	    void updateProduct(Product product);
	    void deleteProduct(int productId);
	    List<Product> getAll();
	    Product getById(int productId);
	    List<Product> getByCategory(String category) throws ProductNotFoundException;
	    List<Product> getByBrand(String brand) throws ProductNotFoundException;
	    List<Product> getByLesserPrice(double price) throws ProductNotFoundException;
	    List<Product> getByBrandStarting(String brand) throws ProductNotFoundException;
	    List<Product> getByChoice(String choice);
}
