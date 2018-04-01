package com.nav.shopcart.dao;

import com.nav.shopcart.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends MongoRepository<Category, String>{

    @Query("{'parentId':?0}")
    List<Category> getSubCategories(String parentId);

}

