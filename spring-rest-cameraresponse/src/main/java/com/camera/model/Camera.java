package com.camera.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Camera {
    @Column(name = "cameraid")
    @Id
    @GeneratedValue(generator = "camera_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "camera_gen",sequenceName = "camera_sequence",initialValue = 5,allocationSize = 10)
    @ToString.Exclude
    private Integer cameraId;
    @Column(length = 40)
    private String model;
    @Column(length = 40)
    private String cameraType;
    @Column(length = 40)
    private String lensType;
    @Column(length = 40)
    private double price;
    @Column(length = 40)
    private String brand;

    public Camera(String model, String cameraType, String lensType, double price, String brand) {
        this.model = model;
        this.cameraType = cameraType;
        this.lensType = lensType;
        this.price = price;
        this.brand = brand;
    }
}
