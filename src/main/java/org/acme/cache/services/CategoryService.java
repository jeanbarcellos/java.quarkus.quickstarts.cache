package org.acme.cache.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.cache.dto.CategoryRequest;
import org.acme.cache.entities.Category;
import org.acme.cache.repositories.CategoryRepository;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class CategoryService {

    public final String CACHE_NAME = "category-cache";

    @Inject
    private CategoryRepository repository;

    @CacheResult(cacheName = CACHE_NAME)
    public List<Category> getAll() {
        return this.repository.findAll();
    }

    @CacheResult(cacheName = CACHE_NAME)
    public Category getById(Integer id) {
        return this.repository.findById(id);
    }

    public Category insert(CategoryRequest request) {
        return this.repository.insert(Category.of(request.getName()));
    }

    // @CacheInvalidate(cacheName = CACHE_NAME)
    public void delete(Integer id) {
        this.repository.delete(id);
    }

}
