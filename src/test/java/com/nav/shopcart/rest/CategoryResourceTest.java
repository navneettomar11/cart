package com.nav.shopcart.rest;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryResourceTest{

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryDao categoryDao;



    @Before
    public void setUp() throws Exception {
        categoryDao.deleteAll();
    }

    @Test
    public void testGetAllCategories(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Test Category 01","Test Category Description 01", null));
        categoryList.add(new Category("Test Category 02","Test Category Description 02", null));
        categoryList.add(new Category("Test Category 03", "Test Category Description 03", null));
        categoryDao.insert(categoryList);

        ResponseEntity<String> entity = this.restTemplate.getForEntity("/category",
                String.class);
        assertTrue(entity.getStatusCode()==HttpStatus.OK);
    }

    @Test
    public void testGetSubCategories(){
        Category parentCategory = new Category("Test Category 01", "Test Category Description 01", null);
        categoryDao.insert(parentCategory);
        categoryDao.insert(new Category("Test Category 01_01", "Test Category Description 01_01", parentCategory));

        ResponseEntity<String> entity = this.restTemplate.getForEntity("/category/"+parentCategory.getId()+"/subcategories",
                String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);
    }

    @Test
    public void testGetCategoryById(){
        Category category = new Category("Test Category 01", "Test Category Description 01", null);
        categoryDao.insert(category);
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/category/"+category.getId(),
                String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);
    }

    @Test
    public void testInsertCateogry(){
        Category category = new Category("Test Category 01", "Test Category Description 01", null);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        HttpEntity<Category> categoryHttpEntity = new HttpEntity<>(category);
        ResponseEntity<String> entity = this.restTemplate.exchange("/category", HttpMethod.POST, categoryHttpEntity, String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);

    }

    @Test
    public void testUpdateCateogry(){
        Category category = new Category("Test Category 01", "Test Category Description 01", null);
        categoryDao.insert(category);
        category.setName("Test Category Rename 01");
        HttpEntity<Category> categoryHttpEntity = new HttpEntity<>(category);
        ResponseEntity<String> entity = this.restTemplate.exchange("/category", HttpMethod.PUT, categoryHttpEntity, String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);

        assertEquals("Test Category Rename 01", category.getName());
    }

    @Test
    public void testDeleteCategory(){
        Category category = new Category("Test Category 01", "Test Category Description 01", null);
        categoryDao.insert(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        ResponseEntity<String> entity = this.restTemplate.exchange("/category/"+category.getId(), HttpMethod.DELETE, null, String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);

    }
}
