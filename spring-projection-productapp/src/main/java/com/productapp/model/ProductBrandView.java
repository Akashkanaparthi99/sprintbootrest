package com.productapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductBrandView {
    @Column(name = "productid")
    @Id
    @ToString.Exclude
    private Integer productId;
    private String name;
    private String brand;
    private double price;
}
