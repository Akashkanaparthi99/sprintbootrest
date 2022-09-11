package com.productapp.controller;


import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.*;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

	private IProductService productService;


	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/products")
	public ResponseEntity<Void> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
		return responseEntity;
	}
	@PutMapping("/products")
	public ResponseEntity<Void> updateProduct(@RequestBody Product product){
		productService.updateProduct(product);
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
		return responseEntity;
	}

	@DeleteMapping("/products/productId/{productid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productid")int productId){
		productService.deleteProduct(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","deleting one product by Id");
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.OK).build();
		return responseEntity;
	}

	@GetMapping("/products/productId/{productId}")
	ResponseEntity<Product> getById(@PathVariable("productId") int productId){
		Product product = productService.getById(productId);
		ResponseEntity<Product> responseEntity = ResponseEntity.ok().body(product);
		return responseEntity;
	}


//	@GetMapping("/products")
//	ResponseEntity<List<Product>> getAll(){
//		List<Product> products = productService.getAll();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc","getting all products");
//		headers.add("info","get all Method called");
//		ResponseEntity<List<Product>> productResponse = new ResponseEntity<>(products,headers, HttpStatus.OK);
//		return productResponse;
//	}

	@GetMapping("/products/category/{category}")
	ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category) throws ProductNotFoundException{
		List<Product> products = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by Category"+category);
		return ResponseEntity.ok().headers(headers).body(products);

	}
//	@GetMapping("/products/brand/{brand}")
//	ResponseEntity<List<Product>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
//		List<Product> products = productService.getByBrand(brand);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc","Get by brand"+brand);
//		return ResponseEntity.ok().headers(headers).body(products);
//
//	}
	@GetMapping("/products/price/{price}")
	ResponseEntity<List<Product>> getByLesserPrice(@PathVariable("price") double price) throws ProductNotFoundException{
		List<Product> products = productService.getByLesserPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by lesser price"+price);
		return ResponseEntity.ok().headers(headers).body(products);

	}
	@GetMapping("/products/brandStart/{brand}")
	ResponseEntity<List<Product>> getByBrandStarting(@PathVariable("brand")String brand) throws ProductNotFoundException{
		System.out.println(brand);
		List<Product> products = productService.getByBrandStarting(brand);
		ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().body(products);
		return productResponse;
	}
	@GetMapping("/products/choice/{choice}")
	ResponseEntity<List<Product>> getByChoice(@PathVariable("choice") String choice){
		List<Product> products = productService.getByChoice(choice);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by choice"+choice);
		return ResponseEntity.ok().headers(headers).body(products);
	}

//	@GetMapping("/products/brand/{brand}")
//	ResponseEntity<List<ProductDTO>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
//		List<ProductDTO> products = productService.getByBrand(brand);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc","Get by brand"+brand);
//		return ResponseEntity.ok().headers(headers).body(products);
//
//	}

	@GetMapping("/products/category/{category}/price/{price}")
	ResponseEntity<List<CategoryDTO>> getByCatNPrice(@PathVariable("category") String category,@PathVariable("price") double price) throws ProductNotFoundException{
		List<CategoryDTO> products = productService.getByCategoryLessPrice(category,price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by Category"+category);
		return ResponseEntity.ok().headers(headers).body(products);

	}


	@GetMapping("/products/name/{name}")
	ResponseEntity<BrandView> getByName(@PathVariable("name") String category) throws ProductNotFoundException{
		BrandView products = productService.findByName(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by Category"+category);
		return ResponseEntity.ok().headers(headers).body(products);

	}

//	@GetMapping("/products/brand/{brand}")
//	ResponseEntity<List<ProductView>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
//		List<ProductView> products = productService.getByBrand(brand);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc","Get by brand"+brand);
//		return ResponseEntity.ok().headers(headers).body(products);
//
//	}

//	@GetMapping("/products")
//	ResponseEntity<List<ProductView>> getAll(){
//		List<ProductView> products = productService.getAll();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc","getting all products");
//		headers.add("info","get all Method called");
//		ResponseEntity<List<ProductView>> productResponse = new ResponseEntity<>(products,headers, HttpStatus.OK);
//		return productResponse;
//	}

	@GetMapping("/products")
	ResponseEntity<List<ProductBrandView>> getAll(){
		List<ProductBrandView> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","getting all products");
		headers.add("info","get all Method called");
		ResponseEntity<List<ProductBrandView>> productResponse = new ResponseEntity<>(products,headers, HttpStatus.OK);
		return productResponse;
	}

	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<ProductBrandView>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		List<ProductBrandView> products = productService.getByBrandView(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand"+brand);
		return ResponseEntity.ok().headers(headers).body(products);

	}

	@GetMapping("/products/brand_details/{brand}")
	ResponseEntity<List<String>> findByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		List<ProductDetailsEx> products = productService.findByBrand(brand);
		List<String> pdata = new ArrayList<>();
		for (ProductDetailsEx st : products){
			String data = st.getProducts();
			pdata.add(data);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand"+brand);
		return ResponseEntity.ok().headers(headers).body(pdata);

	}

	@GetMapping("/products/show")
	ResponseEntity<List<Product>> showProducts() throws ProductNotFoundException{
		List<Product> products = productService.SHOW_PRODUCTS();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand");
		return ResponseEntity.ok().headers(headers).body(products);

	}
	@GetMapping("/products/get_all")
	ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException{
		List<Product> products = productService.getAllProducts();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand");
		return ResponseEntity.ok().headers(headers).body(products);

	}

	@GetMapping("/products/read_brand/{brand}")
	ResponseEntity<List<Product>> readByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		List<Product> products = productService.readByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand"+brand);
		return ResponseEntity.ok().headers(headers).body(products);

	}

	@GetMapping("/products/cost_brand/{brand}")
	ResponseEntity<Double> costByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		double products = productService.getTotalCost(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand"+brand);
		return ResponseEntity.ok().headers(headers).body(products);

	}


}
