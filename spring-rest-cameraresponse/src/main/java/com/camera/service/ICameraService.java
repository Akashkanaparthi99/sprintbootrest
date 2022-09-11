package com.camera.service;

import com.camera.exception.CameraNotFoundException;
import com.camera.model.Camera;

import java.util.List;

public interface ICameraService {

    void addCamera(Camera camera);
    void updateCamera(Camera camera);
    void deleteCamera(int cameraId);
    Camera getById(int cameraId) throws CameraNotFoundException;
    List<Camera> getAll();

    List<Camera> getByBrandAndPrice(String brand, double price) throws CameraNotFoundException;
    List<Camera> getByLensType(String lensType) throws CameraNotFoundException;
    List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException;
    List<Camera> getByLesserPrice(double price) throws CameraNotFoundException;


}
