package com.productapp.repository;

import com.productapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    //derived queries can startwith findBy, readBy, getBy
    List<Product> findByCategory(String category);
//    List<Product> getByBrand(String brand);
    @Query("from Product p where p.brand like ?1")
    List<Product> getByBrandStartingWith(String brand);
    List<Product> readByPriceLessThan(double price);


    @Query("from Product p where p.category = ?1 or p.brand= ?1")
    List<Product> findByChoice(String choice);

        // PROJECTIONS
    List<ProductDTO> findByBrand(String brand);
    @Query("select new com.productapp.model.CategoryDTO(name,brand,price) from Product p where p.category = ?1 and p.price< ?2")
    List<CategoryDTO> findByCategoryPrice(String category,double price);
//    @Query("select new com.productapp.model.BrandView(brand,price) from Product p where p.name like ?1")
    BrandView findByName(String name);


    // open projections
    List<ProductDetailsEx> getByBrand(String brand);


    // stored procedures use @Procedure
    // use the same procedure name as method name but it has to be in capital letters
    @Procedure
    List<Product> SHOW_PRODUCTS();

//    @Procedure("SHOW_PRODUCTS")
//    @Procedure(value = "SHOW_PRODUCTS")
    @Procedure(procedureName = "SHOW_PRODUCTS")
    List<Product> getAllProducts();

    @Procedure("SHOW_BY_BRAND")
    List<Product> readByBrand(String brand);

    @Procedure("SUM_OF_PRODUCTS")
    double getTotalCost(String brand);
}
