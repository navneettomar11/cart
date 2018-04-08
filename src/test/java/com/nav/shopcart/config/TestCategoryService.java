package com.nav.shopcart.config;


import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class TestCategoryService  {

    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    public List<Category> getSubCategories(String parentId) {
        return null;
    }

    public Category insert(Category category) {
        return null;
    }

    public Category update(Category category) {
        return null;
    }
  public boolean delete(String id) {
        return false;
    }
}
