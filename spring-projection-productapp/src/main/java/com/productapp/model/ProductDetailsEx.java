package com.productapp.model;

import org.springframework.beans.factory.annotation.Value;
/*
*  Open projection
* target
*
*/
public interface ProductDetailsEx {
    @Value("#{target.name+' Rs:'+target.price+'/-'}")
    String getProducts();

}
