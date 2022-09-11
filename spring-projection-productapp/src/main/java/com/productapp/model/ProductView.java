package com.productapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductView {
    @Column(name = "productid")
    @Id
    @ToString.Exclude
    private Integer productId;
    private String name;
    private String brand;
    private double price;
}
