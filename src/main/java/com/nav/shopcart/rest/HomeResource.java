package com.nav.shopcart.rest;

import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;

@Component
@Path("/")
public class HomeResource {

    @Autowired
    private CategoryService categoryService;

    @Path("index")
    @GET
    public String index(){
        Collection<Category> categories = categoryService.getAllCategories();

        return "Working Jersey and Spring Boot Project";
    }
}
