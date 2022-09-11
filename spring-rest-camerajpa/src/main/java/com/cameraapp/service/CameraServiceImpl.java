package com.cameraapp.service;

import com.cameraapp.model.Camera;
import com.cameraapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CameraServiceImpl implements ICameraService{
    private ICameraRepository cameraRepository;
    @Autowired
    public void setCameraRepository(ICameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public Camera addCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
        cameraRepository.deleteById(cameraId);
    }

    @Override
    public Camera getById(int cameraId) {
        return cameraRepository.findById(cameraId).get();
    }

    @Override
    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) {
        return cameraRepository.findByBrandAndPrice(brand, price);
    }

    @Override
    public List<Camera> getByLensType(String lensType) {
        return cameraRepository.findByLensType(lensType);
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) {
        return cameraRepository.findByCameraType(cameraType);
    }

    @Override
    public List<Camera> getByLesserPrice(double price) {
        return cameraRepository.findByPriceLessThan(price);
    }
}
