package com.nav.shopcart.service.impl;

import com.nav.shopcart.dao.ProductDao;
import com.nav.shopcart.model.Product;
import com.nav.shopcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;

@Service
@Singleton
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public Product save(Product product) {
        return null;
    }
}
