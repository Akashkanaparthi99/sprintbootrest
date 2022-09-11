package com.productapp.repository;

import com.productapp.model.Product;
import com.productapp.model.TypeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    //derived queries can startwith findBy, readBy, getBy
    List<Product> findByCategory(String category);
    List<Product> getByBrand(String brand);
    List<Product> findByType(String type);
    @Query("from Product p where p.brand like ?1")
    List<Product> getByBrandStartingWith(String brand);
    List<Product> readByPriceLessThan(double price);


    @Query("from Product p where p.category = ?1 or p.brand= ?1")
    List<Product> findByChoice(String choice);
    @Query("select distinct category from Product")
    List<String> getDistinctCategories();
//    use only derived queries for projections
    List<TypeView> findDistinctTypeByCategory(String category);




}
