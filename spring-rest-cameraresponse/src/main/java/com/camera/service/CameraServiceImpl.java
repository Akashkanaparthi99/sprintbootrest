package com.camera.service;

import com.camera.exception.CameraNotFoundException;
import com.camera.model.Camera;
import com.camera.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CameraServiceImpl implements ICameraService {
    private ICameraRepository cameraRepository;
    @Autowired
    public void setCameraRepository(ICameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void addCamera(Camera camera) {
         cameraRepository.save(camera);
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
    public Camera getById(int cameraId) throws CameraNotFoundException {
        return cameraRepository.findById(cameraId).orElseThrow(()-> new CameraNotFoundException("No Camera With ID -"+cameraId));
    }

    @Override
    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) throws CameraNotFoundException{
        List<Camera> cameras =  cameraRepository.findByBrandAndPrice(brand, price);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("No Camera with brand - "+brand+" and price - "+price+" is Found");
        return cameras;
    }

    @Override
    public List<Camera> getByLensType(String lensType) throws CameraNotFoundException{
        List<Camera> cameras =  cameraRepository.findByLensType(lensType);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("No Camera with lens - "+lensType+" is Found");
        return cameras;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException{
        List<Camera> cameras =  cameraRepository.findByCameraType(cameraType);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("No Camera with camera type - "+cameraType+" is Found");
        return cameras;
    }

    @Override
    public List<Camera> getByLesserPrice(double price) throws CameraNotFoundException{
        List<Camera> cameras = cameraRepository.findByPriceLessThan(price);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("No Camera Found with less than - "+price+" price");
        return cameras;
    }
}
