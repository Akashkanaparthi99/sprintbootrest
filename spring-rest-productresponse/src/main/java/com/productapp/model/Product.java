package com.productapp.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Column(name = "productid")
    @Id
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    private Integer productId;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String category;
    @Column(length = 20)
    private String brand;
    @Column(length = 20)
    private double price;
    @Column(columnDefinition = "varchar(255) default 'puppy'")
    private String type;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(String name, String category, String brand, double price, String type) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.type = type;
    }
}
