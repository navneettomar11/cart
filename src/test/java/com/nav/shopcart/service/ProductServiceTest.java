package com.nav.shopcart.service;

import com.mongodb.BulkWriteOperation;
import com.mongodb.DBCollection;
import com.nav.shopcart.dao.CategoryDao;
import com.nav.shopcart.dao.ProductDao;
import com.nav.shopcart.model.Category;
import com.nav.shopcart.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductService productService;

    private Category category;

    @Before
    public void tearDown(){
        categoryDao.deleteAll();
        productDao.deleteAll();
        category = categoryDao.insert(new Category("Test Category 01", "Test Category Description 01", null));
    }

    @Test
    public void testGetCategoryProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add((new Product("Test Product 01","Test Product Description 01", category)));
        productList.add(new Product("Test Product 02","Test Product Description 02", category));
        productList.add(new Product("Test Product 03","Test Product Description 03", category));
        productDao.insert(productList);

        List<Product> actualProductList = productService.getCategoryProduct(category.getId());
        Assert.assertNotNull(actualProductList);
        Assert.assertEquals(productList.size(), actualProductList.size());
    }

    @Test
    public void testGetProductByProductIdForExistProductId(){
        Product dbProduct = productDao.insert((new Product("Test Product 01","Test Product Description 01", category)));

        Product actualProduct = productService.getProduct(dbProduct.getId());

        Assert.assertNotNull(actualProduct);
        Assert.assertEquals(dbProduct.getId(), actualProduct.getId());
    }

    @Test
    public void testGetProductByProductIdForNotExistProductId(){
        Product actualProduct = productService.getProduct("id_not_exists");
        Assert.assertNull(actualProduct);
    }

    @Test
    public void testInsertProduct(){
        Product actualProduct = productService.insert(new Product("Test Product 01","Test Product Description 01", category));
        Assert.assertNotNull(actualProduct);
        Assert.assertNotNull(actualProduct.getId());
    }

    @Test
    public void testUpdateProduct(){
        Product dbProduct = productDao.insert((new Product("Test Product 01","Test Product Description 01", category)));
        dbProduct.setPname("Test Product Update 01");
        Product actualProduct = productService.update(dbProduct);
        Assert.assertNotNull(actualProduct);
        Assert.assertEquals("Test Product Update 01",actualProduct.getPname());
    }

    @Test
    public void testDeleteProduct(){
        Product dbProduct = productDao.insert((new Product("Test Product 01","Test Product Description 01", category)));
        Assert.assertTrue(productService.delete(dbProduct.getId()));

    }
}
