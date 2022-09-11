package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService{
    private IFurnitureRepository furnitureRepository;
    @Autowired
    public void setFurnitureRepository(IFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }


    @Override
    public void addFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        furnitureRepository.deleteById(furnitureId);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
      return furnitureRepository.findById(furnitureId).orElseThrow(()-> new FurnitureNotFoundException("Furniture Not Found"));
    }

    @Override
    public List<Furniture> findByMaterial(String material) throws FurnitureNotFoundException {

        List<Furniture> furnitures = furnitureRepository.findByMaterial(material);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByRoomType(String type) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByRoomType(type);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByCategory(String name) throws FurnitureNotFoundException {
        List<Furniture> furnitures =furnitureRepository.findByCategory(name);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByStyle(Style style) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByStyle(style);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByBrand(String brand) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByBrand(brand);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByStorageAvailable(boolean storage)  throws FurnitureNotFoundException{

        List<Furniture> furnitures = furnitureRepository.findByStorageAvailable(storage);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findFurnitureByAnything(Furniture furniture) throws FurnitureNotFoundException {
        return null;
    }

    @Override
    public List<Furniture> findByPriceRange(double minPrice, double maxPrice) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByPriceRange(minPrice, maxPrice);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByMatAndBrand(String material, String brand) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByMatAndBrand(material, brand);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public List<Furniture> findByRoomAndCategory(String roomType, String category) throws FurnitureNotFoundException {
        List<Furniture> furnitures = furnitureRepository.findByRoomAndCategory(roomType, category);
        if (furnitures.isEmpty())
            throw new FurnitureNotFoundException("Furniture Not Found");
        return furnitures;
    }

    @Override
    public Integer findTotal() {
        return furnitureRepository.findTotal();
    }

    @Override
    public Integer findCategoryCost(String category) {
        return null;
    }
}
