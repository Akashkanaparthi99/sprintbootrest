package com.cameraapp.controller;

import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("camera-api")
public class CameraController {
    private ICameraService cameraService;
    @Autowired
    public void setCameraService(ICameraService cameraService) {
        this.cameraService = cameraService;
    }

    @PostMapping("/cameras")
    public Camera addCamera(@RequestBody Camera camera){
        return cameraService.addCamera(camera);
    }

    @PutMapping("/cameras")
    public void updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
    }

    @DeleteMapping("/cameras/cameraId/{cameraid}")
    public void deleteCamera(@PathVariable("cameraid")int cameraId){
        cameraService.deleteCamera(cameraId);
    }


    @GetMapping("/cameras")
    public List<Camera> showCameras(){
        return cameraService.getAll();
    }

    @GetMapping("/cameras/cameraType/{cameratype}")
    public List<Camera> showCameraType(@PathVariable("cameratype")String cameraType){
        return cameraService.getByCameraType(cameraType);
    }

    @GetMapping("/cameras/lensType/{lenstype}")
    public List<Camera> showLensType(@PathVariable("lenstype")String lensType){
        return cameraService.getByLensType(lensType);
    }

    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public List<Camera> showBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
        return cameraService.getByBrandAndPrice(brand, price);
    }

    @GetMapping("/cameras/price/{price}")
    public List<Camera> showLesserPrice(@PathVariable("price")double price){
        return cameraService.getByLesserPrice(price);
    }

    @GetMapping("/cameras/id/{cameraId}")
    public Camera showLesserPrice(@PathVariable("cameraId")int cameraId){
        return cameraService.getById(cameraId);
    }


}
