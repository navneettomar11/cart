package com.nav.shopcart.service.impl;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import java.util.List;

@Service
@Singleton
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
         return categoryDao.findAll();
    }

    @Override
    public List<Category> getSubCategories(String parentId) {
        return categoryDao.getSubCategories(parentId);
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
        categoryDao.deleteById(id);
        return  categoryDao.existsById(id)? false : true;
    }
}
