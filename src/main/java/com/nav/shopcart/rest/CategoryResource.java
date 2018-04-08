package com.nav.shopcart.rest;

import com.nav.shopcart.model.Category;
import com.nav.shopcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllCategories(){
        return Response.ok(categoryService.getAllCategories()).build();
    }

    @GET
    @Path("/{categoryId}/subcategories")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSubCategories(@PathParam("categoryId") String parentId){
        return Response.ok(categoryService.getSubCategories(parentId)).build();
    }

    @GET
    @Path("{categoryId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category getCategory(@NotNull @PathParam("categoryId") String categoryId){
        return categoryService.getCategoryById(categoryId);
    }
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category insert(Category category){
        return categoryService.insert(category);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category update(Category category){
         return categoryService.update(category);
    }

    @DELETE
    @Path("{categoryId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("categoryId") String categoryId){
        return Response.ok(categoryService.delete(categoryId)).build();
    }
}
