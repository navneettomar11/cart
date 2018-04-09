package com.nav.shopcart.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productImage")
public class ProductImage extends Base{

    private String image;

    private String description;

    @DBRef
    private Product product;
}
