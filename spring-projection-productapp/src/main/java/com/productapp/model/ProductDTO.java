package com.productapp.model;

import lombok.*;

// use only the properties that you want to return
// should have only parametrised constructor
// should have only getter methods
// should have only toString
// the properties name shou;d be same as tha domain model

@AllArgsConstructor
@ToString
@Getter
public class ProductDTO {
    String name;
    double price;
}
