package org.acme.cache.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.cache.entities.Category;
import org.acme.cache.services.CategoryService;

@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CategoryResource {

    @Inject
    private CategoryService service;

    @GET
    @Path("")
    public List<Category> getALl() {
        return this.service.getAll();
    }

    @GET
    @Path("{id}")
    public Category getById(@PathParam("id") Integer id) {
        return this.service.getById(id);
    }

}
