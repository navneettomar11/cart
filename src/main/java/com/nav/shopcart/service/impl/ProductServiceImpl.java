package com.nav.shopcart.service.impl;

import com.nav.shopcart.dao.ProductDao;
import com.nav.shopcart.model.Product;
import com.nav.shopcart.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@Singleton
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> getCategoryProduct(String categoryId) {
        return mongoTemplate.find(Query.query(where("category.$id").is(new ObjectId(categoryId))), Product.class);
    }

    @Override
    public Product getProduct(@NotNull  String productId) {
        Optional<Product> productOptional = productDao.findById(productId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product insert(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean delete(String productId) {
        productDao.deleteById(productId);
        return !productDao.existsById(productId);
    }
}
