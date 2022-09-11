package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.*;
import com.productapp.repository.IProductBrandViewRepository;
import com.productapp.repository.IProductRepository;
import com.productapp.repository.IProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

	 private IProductRepository productRepository;
	private IProductViewRepository productViewRepository;
	@Autowired
	public void setProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Autowired
	public void setProductViewRepository(IProductViewRepository productViewRepository) {
		this.productViewRepository = productViewRepository;
	}
	@Autowired
	IProductBrandViewRepository productBrandViewRepository;


	    @Override
	    public void addProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void updateProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void deleteProduct(int productId) {
	        productRepository.deleteById(productId);
	    }

//	    @Override
//	    public List<ProductView> getAll() {
//	        return productViewRepository.findAll();
//	    }

	    @Override
	    public Product getById(int productId){
	        return productRepository.findById(productId).get();//orElseThrow(() -> new ProductNotFoundException("Invalid Id"));
	    }

//	    @Override
//	    public List<Product> getByBrand(String brand) throws ProductNotFoundException {
//	        return productRepository.getByBrand(brand);
//	    }

	    @Override
	    public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
	        return productRepository.readByPriceLessThan(price);
	    }

	    @Override
	    public List<Product> getByBrandStarting(String brand) throws ProductNotFoundException {
			System.out.println(brand);
			return productRepository.getByBrandStartingWith("%"+brand+"%");
	    }


		@Override
		public List<Product> getByCategory(String category) throws ProductNotFoundException {
			// TODO Auto-generated method stub
			return productRepository.findByCategory(category);
		}


		@Override
		public List<Product> getByChoice(String choice){
			// TODO Auto-generated method stub
			return productRepository.findByChoice(choice);
		}

//	@Override
//	public List<ProductDTO> getByBrand(String brand) {
//		return productRepository.findByBrand(brand);
//	}

	@Override
	public List<CategoryDTO> getByCategoryLessPrice(String category, double price) {
		return productRepository.findByCategoryPrice(category, price);
	}

	@Override
	public BrandView findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<ProductView> getByBrand(String brand) {
		return productViewRepository.getByBrand(brand);
	}

	@Override
	public List<ProductBrandView> getAll() {
		return productBrandViewRepository.findAll();
	}

	@Override
	public List<ProductBrandView> getByBrandView(String brand) {
		return productBrandViewRepository.findByBrand(brand);
	}

	@Override
	public List<ProductDetailsEx> findByBrand(String brand) {
		return productRepository.getByBrand(brand);
	}

	@Override
	@Transactional
	public List<Product> SHOW_PRODUCTS() {
		return productRepository.SHOW_PRODUCTS();
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	@Transactional
	public List<Product> readByBrand(String brand) {
		return productRepository.readByBrand(brand);
	}

	@Override
	@Transactional
	public double getTotalCost(String brand) {
		return productRepository.getTotalCost(brand);
	}


//
//	   
//
//	    @Override
//	    public List<Product> getByBrandName(String brand, String name) {
//	        return productRepository.findByBrandName(brand, name);
//	    }
//
//	    @Override
//	    public List<Product> findByBetweenPrice(double minPrice, double maxPrice) {
//	        return productRepository.findByBetweenPrice(minPrice, maxPrice);
//	    }
//
//	    @Override
//	    @Transactional
//	    public void updateProductCost(int productId, double price) {
//	        productRepository.updateProductCost(productId, price);
//	    }
//
//	    @Override
//	    public List<Product> getByNewBrands(String brand) {
//	        return productRepository.getByNewBrands(brand);
//	    }
//
//	    @Override
//	    public List<Product> getByNewBrandshow(String brand, double cost) {
//	        return productRepository.getByNewBrandshow(brand,cost);
//	    }
//
//
//		@Override
//		public List<Product> getByCategory(String category) throws ProductNotFoundException {
//			// TODO Auto-generated method stub
//			return productRepository.findByCategory(category);
//		}
//
//
//		@Override
//		public List<Product> getByCatBrand(String category, String brand) {
//			// TODO Auto-generated method stub
//			return productRepository.findByCatBrand(category, brand);
//		}

}
