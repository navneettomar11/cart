package com.nav.shopcart.rest;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Category category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
        categoryDao.insert(new Category("Test Category 01_01", "Test Category Description 01_01", category.getId()));

        ResponseEntity<String> entity = this.restTemplate.getForEntity("/category/"+category.getId(),
                String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);
    }

    @Test
    public void testInsertCateogry(){

    }

    @Test
    public void testUpdateCateogry(){

    }

    @Test
    public void testDeleteCategory(){

    }
}
