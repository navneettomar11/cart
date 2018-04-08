package com.nav.shopcart.rest;

import com.nav.shopcart.model.Product;
import com.nav.shopcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GET
    @Path("/{category}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllCategoryProducts(@PathParam("category") String categoryId){
        return Response.ok(productService.getCategoryProduct(categoryId)).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product insert(Product product){
        return productService.insert(product);
    }
}
