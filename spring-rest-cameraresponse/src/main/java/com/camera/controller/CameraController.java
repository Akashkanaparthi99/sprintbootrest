package com.camera.controller;

import com.camera.model.Camera;
import com.camera.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> addCamera(@RequestBody Camera camera){
        cameraService.addCamera(camera);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera has been added");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @PutMapping("/cameras")
    public ResponseEntity<Void> updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera has been Updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/cameras/cameraId/{cameraid}")
    public ResponseEntity<Void> deleteCamera(@PathVariable("cameraid")int cameraId){
        cameraService.deleteCamera(cameraId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera has been Deleted");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }


    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> showCameras(){
        List<Camera> cameras = cameraService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","ALL Camera's");
        return ResponseEntity.ok().headers(headers).body(cameras);
    }

    @GetMapping("/cameras/cameraType/{cameratype}")
    public ResponseEntity<List<Camera>> showCameraType(@PathVariable("cameratype")String cameraType){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Cameras by type");
        return ResponseEntity.ok().headers(headers).body(cameraService.getByCameraType(cameraType));

    }

    @GetMapping("/cameras/lensType/{lenstype}")
    public ResponseEntity<List<Camera>> showLensType(@PathVariable("lenstype")String lensType){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera's by Len's Type ");
        return ResponseEntity.ok().headers(headers).body(cameraService.getByLensType(lensType));
    }

    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public ResponseEntity<List<Camera>> showBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera's of Brand "+brand+" and in price less than "+price);
        return ResponseEntity.ok().headers(headers).body(cameraService.getByBrandAndPrice(brand, price));
    }

    @GetMapping("/cameras/price/{price}")
    public ResponseEntity<List<Camera>> showLesserPrice(@PathVariable("price")double price){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera of Price Less than - "+price);
        return ResponseEntity.ok().headers(headers).body(cameraService.getByLesserPrice(price));
    }

    @GetMapping("/cameras/id/{cameraId}")
    public ResponseEntity<Camera> showById(@PathVariable("cameraId")int cameraId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera with Id "+cameraId);
        return ResponseEntity.ok().headers(headers).body(cameraService.getById(cameraId));
    }
}
