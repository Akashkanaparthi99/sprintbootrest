package com.furnapp.repository;

import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture,Integer> {
    // derived queries
    List<Furniture> findByMaterial(String material);
    List<Furniture> findByRoomType(String type);
    List<Furniture> findByCategory(String name);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByStorageAvailable(boolean storage);
//
//    List<Furniture> findFurnitureByAnything(Furniture furniture);
//    // Custom query
    @Query("from Furniture f where f.price > ?1 and f.price < ?2")
    List<Furniture> findByPriceRange(double minPrice,double maxPrice);
    @Query("from Furniture f where f.material = ?1 and f.brand = ?2")
    List<Furniture> findByMatAndBrand(String material,String brand);
    @Query("from Furniture f where f.roomType = ?1 and f.brand =  ?2")
    List<Furniture> findByRoomAndCategory(String roomType,String category);

//    //
    @Query(value = "select count(*) from furniture",nativeQuery = true)
    Integer findTotal();
//    // named
//    @Query(name = "")
//    Integer findCategoryCost(String category);
}
