package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;

import java.util.List;

public interface IFurnitureService {
    void addFurniture(Furniture furniture);
    void deleteFurniture(int furnitureId);
    void updateFurniture(Furniture furniture);
    Furniture getById(int furnitureId) throws FurnitureNotFoundException;

    List<Furniture> findByMaterial(String material) throws FurnitureNotFoundException;
    List<Furniture> findByRoomType(String type) throws FurnitureNotFoundException;
    List<Furniture> findByCategory(String name) throws FurnitureNotFoundException;
    List<Furniture> findByStyle(Style style) throws FurnitureNotFoundException;
    List<Furniture> findByBrand(String brand) throws FurnitureNotFoundException;
    List<Furniture> findByStorageAvailable(boolean storage) throws FurnitureNotFoundException;

    List<Furniture> findFurnitureByAnything(Furniture furniture) throws FurnitureNotFoundException;
    // Custom query
    List<Furniture> findByPriceRange(double minPrice,double maxPrice) throws FurnitureNotFoundException;
    List<Furniture> findByMatAndBrand(String material,String brand) throws FurnitureNotFoundException;
    List<Furniture> findByRoomAndCategory(String roomType,String category) throws FurnitureNotFoundException;

    //
    Integer findTotal();
    // named
    Integer findCategoryCost(String category);
}
