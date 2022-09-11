package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Column(name = "productid")
    @Id
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    private Integer productId;
    private String productName;
    private String category;
    private String brand;
    private double price;
    private String type;
    private String description;
    private double rating;
    private String productImg;


}
