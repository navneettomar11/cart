package com.nav.shopcart.dao;

import com.nav.shopcart.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends MongoRepository<Category,String>{


}

