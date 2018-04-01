package com.nav.shopcart;

import com.nav.shopcart.config.MongoConfig;
import com.nav.shopcart.dao.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
		classes = { NcartApplicationTests.class })
public class NcartApplicationTests {

	@Test
	public void contextLoads() {
	}

}
