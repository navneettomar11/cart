package com.nav.shopcart.dao;

import com.nav.shopcart.model.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    private Category category;

    @Before
    public void init() throws Exception{
        categoryDao.deleteAll();
        this.category = new Category("Test Category 01", "Test Catrgory description 01 ", null);
        categoryDao.insert(this.category);
    }

    @Test
    public void testGetAllCategories(){
        List<Category> allCategories = categoryDao.findAll();
        assertEquals(1,allCategories.size());
    }

    @After
    public void destroy() throws  Exception{
        categoryDao.delete(this.category);
    }

}

