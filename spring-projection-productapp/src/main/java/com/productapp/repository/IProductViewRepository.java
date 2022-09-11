package com.productapp.repository;

import com.productapp.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Repository
public interface IProductViewRepository extends JpaRepository<ProductView,Integer> {
    // VIEW
    List<ProductView> getByBrand(String brand);

}
