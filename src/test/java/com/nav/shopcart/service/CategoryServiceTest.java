package com.nav.shopcart.service;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDao categoryDao;

    @Before
    public void setUp(){
        categoryDao.deleteAll();
    }

    @Test
    public void testGetAllCategories(){

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Test Category 01","Test Category Description 01", null));
        categoryList.add(new Category("Test Category 02","Test Category Description 02", null));
        categoryList.add(new Category("Test Category 03", "Test Category Description 03", null));
        categoryDao.insert(categoryList);

        List<Category> actualCategoryList = categoryService.getAllCategories();
        assertEquals(categoryList.size(), actualCategoryList.size());
    }

    @Test
    public  void testGetSubCategories(){
        Category category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
        categoryDao.insert(new Category("Test Category 01_01", "Test Category Description 01_01", category.getId()));

        List<Category> subCategoryList = categoryService.getSubCategories(category.getId());
        assertEquals(1, subCategoryList.size());
    }

    @Test
    public void testInsertCategory(){
        Category category = categoryService.insert(new Category("Test Category 01", "Test Category Description 01", null));
        Assert.assertNotNull(category);
        Assert.assertNotNull(category.getId());
        assertEquals("Test Category 01", category.getName());

    }

    @Test
    public void testUpdateCategory(){
        Category category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
        category.setName("Test Category 0101");
        category = categoryService.update(category);
        Assert.assertNotNull(category);
        Assert.assertNotNull(category.getId());
        assertEquals("Test Category 0101", category.getName());

    }

    @Test
    public void testDeleteCategory(){
        Category category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
        boolean deleted = categoryService.delete(category.getId());
        assertTrue(deleted);
    }
}
