package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.*;

import java.util.List;


public interface IProductService {

	 void addProduct(Product product);
	    void updateProduct(Product product);
	    void deleteProduct(int productId);
//	    List<Product> getAll();
	    Product getById(int productId);
	    List<Product> getByCategory(String category) throws ProductNotFoundException;
//	    List<Product> getByBrand(String brand) throws ProductNotFoundException;
	    List<Product> getByLesserPrice(double price) throws ProductNotFoundException;
	    List<Product> getByBrandStarting(String brand) throws ProductNotFoundException;
	    List<Product> getByChoice(String choice);

//		List<ProductDTO> getByBrand(String brand);
	List<CategoryDTO> getByCategoryLessPrice(String category, double price);
	BrandView findByName(String Name);
	List<ProductView> getByBrand(String brand);

//	List<ProductView> getAll();
List<ProductBrandView> getAll();

	List<ProductBrandView> getByBrandView(String brand);


	List<ProductDetailsEx> findByBrand(String brand);

	List<Product> SHOW_PRODUCTS();

	List<Product> getAllProducts();

	List<Product> readByBrand(String brand);

	double getTotalCost(String brand);


}
