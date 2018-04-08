package com.nav.shopcart.service.impl;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import java.util.List;


import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@Singleton
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Category> getAllCategories() {
         return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(String categoryId) {
        logger.debug("Get Category by Id : ", categoryId);
        return mongoTemplate.findById(categoryId, Category.class);
    }

    @Override
    public List<Category> getSubCategories(String categoryId) {
        logger.debug("Get Sub Categories : ", categoryId);
        return mongoTemplate.find(query(where("parent.$id").is(new ObjectId(categoryId))), Category.class);
    }

    @Override
    public Category insert(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public Category update(Category category) {
         return categoryDao.save(category);
    }

    @Override
    public boolean delete(String id) {
        logger.debug("Deletig Categegory by Id : ", id);
        categoryDao.deleteById(id);
        return !(categoryDao.existsById(id));
    }
}
