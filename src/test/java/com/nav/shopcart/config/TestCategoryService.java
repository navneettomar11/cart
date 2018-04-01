package com.nav.shopcart.config;


import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class TestCategoryService implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @Override
    public List<Category> getSubCategories(String parentId) {
        return null;
    }

    @Override
    public Category insert(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
