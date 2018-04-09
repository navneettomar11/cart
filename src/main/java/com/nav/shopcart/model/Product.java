package com.nav.shopcart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Document(collection = "product")
public class Product extends Base{

    private String pname;

    private String description;

    private Double price;

    @DBRef
    private Category category;

    @DBRef
    private List<ProductAttribute> productAttributeList = Collections.emptyList();

    private List<ProductImage> productImagesList = Collections.emptyList();

    public Product(){}

    @PersistenceConstructor
    public Product(String pname, String description, Category category){
        this.pname = pname;
        this.description = description;
        this.category = category;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<ProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<ProductImage> getProductImagesList() {
        return productImagesList;
    }

    public void setProductImagesList(List<ProductImage> productImagesList) {
        this.productImagesList = productImagesList;
    }
}
