package com.camera.repository;

import com.camera.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICameraRepository extends JpaRepository<Camera,Integer> {

    @Query("from Camera c where c.brand = ?1 and c.price <=?2")
    List<Camera> findByBrandAndPrice(String brand, double price);
    List<Camera> findByLensType(String lensType);
    List<Camera> findByCameraType(String cameraType);
    List<Camera> findByPriceLessThan(double price);


}
