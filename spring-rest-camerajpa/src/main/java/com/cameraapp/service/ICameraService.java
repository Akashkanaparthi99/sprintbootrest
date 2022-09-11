package com.cameraapp.service;

import com.cameraapp.model.Camera;

import java.util.List;

public interface ICameraService {

    Camera addCamera(Camera camera);
    void updateCamera(Camera camera);
    void deleteCamera(int cameraId);
    Camera getById(int cameraId);
    List<Camera> getAll();

    List<Camera> getByBrandAndPrice(String brand, double price);
    List<Camera> getByLensType(String lensType);
    List<Camera> getByCameraType(String cameraType);
    List<Camera> getByLesserPrice(double price);



}
