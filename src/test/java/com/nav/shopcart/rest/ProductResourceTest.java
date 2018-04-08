package com.nav.shopcart.rest;

import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.dao.ProductDao;
import com.nav.shopcart.model.Category;
import com.nav.shopcart.model.Product;
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

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    private Category category;

    @Before
    public void setUp() throws Exception {
        categoryDao.deleteAll();
        productDao.deleteAll();
        category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
    }

    @Test
    public void testGetAllCategoryProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add((new Product("Test Product 01","Test Product Description 01", category)));
        productList.add(new Product("Test Product 02","Test Product Description 02", category));
        productList.add(new Product("Test Product 03","Test Product Description 03", category));
        productDao.insert(productList);

        ResponseEntity<String> entity = this.restTemplate.getForEntity("/product/"+category.getId(),
                String.class);
        assertTrue(entity.getStatusCode()== HttpStatus.OK);
    }

    @Test
    public void testProductInsert(){
        Product product = new Product("Test Product 01","Test Product Description 01", category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(product);
        ResponseEntity<String> entity = this.restTemplate.exchange("/product", HttpMethod.POST, productHttpEntity, String.class);

        assertTrue(entity.getStatusCode()==HttpStatus.OK);

    }
}
