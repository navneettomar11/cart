package com.nav.shopcart.service;

import com.nav.shopcart.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> getSubCategories(String parentId);

    Category getCategoryById(String categoryId);

    Category insert(Category category);

    Category update(Category category);

    boolean delete(String id);
}
