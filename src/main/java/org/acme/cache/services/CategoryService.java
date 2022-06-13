package org.acme.cache.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.cache.entities.Category;
import org.acme.cache.repositories.CategoryRepository;

@ApplicationScoped
public class CategoryService {

    @Inject
    private CategoryRepository repository;

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category getById(Integer id) {
        return this.repository.findById(id);
    }

}
