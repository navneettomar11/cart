package com.nav.shopcart.dao;

import com.nav.shopcart.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {

}
