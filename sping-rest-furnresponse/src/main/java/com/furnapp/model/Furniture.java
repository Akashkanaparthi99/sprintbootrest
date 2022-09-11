package com.furnapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "furniture")
@NamedQuery(name = "findByCategoryCost",query = "from Furniture f ")
public class Furniture {
    @Column(length = 30)
    private String name ;// 4 seater dining table
    @Column(length = 30)
    private String category; // chair , table , bed
    @Column(length = 30)
    private String roomType; // living, dining, study
    @Column(length = 30)
    private String material; // wood , steel, plastic
    @Id
    @GeneratedValue(generator = "furniture_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "furniture_generator",sequenceName = "furniture_sequence",initialValue = 2396,allocationSize = 2)
    private Integer furnitureId;
    @Column(length = 30)
    private String brand;
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private Style style;// contemporary, modern, traditional
    @Column(length = 30)
    private double price;
    @Column(length = 30)
    private Boolean storageAvailable;

    public Furniture(String name, String category, String roomType, String material, String brand, Style style, double price, boolean storageAvailable) {
        this.name = name;
        this.category = category;
        this.roomType = roomType;
        this.material = material;
        this.brand = brand;
        this.style = style;
        this.price = price;
        this.storageAvailable = storageAvailable;
    }
}
