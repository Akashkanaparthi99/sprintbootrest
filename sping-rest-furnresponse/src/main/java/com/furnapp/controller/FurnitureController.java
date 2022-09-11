package com.furnapp.controller;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.service.IFurnitureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
    private IFurnitureService furnitureService;
    @Autowired
    public void setFurnitureService(IFurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/furnitures")
    ResponseEntity<Void> addFurniture(@RequestBody Furniture furniture){
        furnitureService.addFurniture(furniture);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/furnitures/furnId/{furnId}")
    ResponseEntity<Void> deleteFurniture(@PathVariable("furnId") int furnitureId){
        furnitureService.deleteFurniture(furnitureId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/furnitures")
    ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture){
        furnitureService.updateFurniture(furniture);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/furnitures/furnId/{furnId}")
    ResponseEntity<Furniture> getById(@PathVariable("furnId") int furnitureId) throws FurnitureNotFoundException{
        Furniture furniture = furnitureService.getById(furnitureId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by ID");
        return ResponseEntity.ok().headers(headers).body(furniture);
    }
    @GetMapping("/furnitures/material")
    ResponseEntity<List<Furniture>> findByMaterial(@RequestParam("material")String material){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by Material"+material);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByMaterial(material));
    }
    @GetMapping("/furnitures/room_type/{roomtype}")
    ResponseEntity<List<Furniture>> findByRoomType(@PathVariable("roomtype")String type){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by room type"+ type);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByRoomType(type));
    }
    @GetMapping("/furnitures/category/{category}")
    ResponseEntity<List<Furniture>> findByCategory(@PathVariable("category")String name){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by category"+ name);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByCategory(name));
    }
    @GetMapping("/furnitures/style/{style}")
    ResponseEntity<List<Furniture>> findByStyle(@PathVariable("style")Style style){ HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by Style"+ style);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByStyle(style));
    }
    @GetMapping("/furnitures/brand/{brand}")
    ResponseEntity<List<Furniture>> findByBrand(@PathVariable("brand")String brand){ HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by brand"+ brand);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByBrand(brand));
    }
    @GetMapping("/furnitures/storage_available/{store}")
    ResponseEntity<List<Furniture>> findByStorageAvailable(@PathVariable("store")boolean storage){ HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by storage availability"+ storage);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByStorageAvailable(storage));
    }


    // Custom query
    @GetMapping("/furnitures/min_price/{min}/max_price/{max}")
    ResponseEntity<List<Furniture>> findByPriceRange(@PathVariable("min")double minPrice,@PathVariable("max")double maxPrice){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture between price min-"+minPrice+"max-"+maxPrice);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByPriceRange(minPrice, maxPrice));
    }
    @GetMapping("/furnitures/material/{mat}/brand/{brand}")
    ResponseEntity<List<Furniture>> findByMatAndBrand(@PathVariable("mat")String material,@PathVariable("brand")String brand){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture with material"+material+"and brand"+brand);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByMatAndBrand(material, brand));

    }
    @GetMapping("/furnitures/room_type/{type}/category/{cat}")
    ResponseEntity<List<Furniture>> findByRoomAndCategory(@PathVariable("type")String roomType,@PathVariable("cat")String category){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture for room type "+roomType+"and Category"+category);
        return ResponseEntity.ok().headers(headers).body(furnitureService.findByRoomAndCategory(roomType, category));
    }

    //
    @GetMapping("/furnitures/total")
    ResponseEntity<Integer> findTotal(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by category");
        return ResponseEntity.ok().headers(headers).body(furnitureService.findTotal());

    }
}
