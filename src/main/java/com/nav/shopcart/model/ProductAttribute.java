package com.nav.shopcart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productAttribute")
public class ProductAttribute extends Base{

    private String attributeName;

    private String attributeValue;

    private Double attributePrice;

    private String pricePrefix;

    @DBRef
    private Product product;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Double getAttributePrice() {
        return attributePrice;
    }

    public void setAttributePrice(Double attributePrice) {
        this.attributePrice = attributePrice;
    }

    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
