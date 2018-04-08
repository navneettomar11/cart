package com.nav.shopcart.service;

import com.nav.shopcart.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getCategoryProduct(String categoryId);

    Product getProduct(String productId);

    Product insert(Product product);

    Product update(Product product);

    boolean delete(String productId);


}
