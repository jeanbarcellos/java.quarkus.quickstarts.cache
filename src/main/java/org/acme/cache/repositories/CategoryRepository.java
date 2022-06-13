package org.acme.cache.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;

import org.acme.cache.entities.Category;

@ApplicationScoped
public class CategoryRepository {

    private List<Category> categories = new ArrayList<Category>();

    public CategoryRepository() {
        this.initalData();
    }

    private void initalData() {
        this.categories.add(new Category(1, "Categoria 1"));
        this.categories.add(new Category(2, "Categoria 2"));
        this.categories.add(new Category(3, "Categoria 3"));
        this.categories.add(new Category(4, "Categoria 4"));
        this.categories.add(new Category(5, "Categoria 5"));
        this.categories.add(new Category(6, "Categoria 6"));
        this.categories.add(new Category(7, "Categoria 7"));
        this.categories.add(new Category(8, "Categoria 8"));
        this.categories.add(new Category(9, "Categoria 9"));

        ;
    }

    public Category findById(Integer id) {
        demore();
        return this.categories.stream()
                .filter(category -> category.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<Category> findAll() {
        demore();
        return this.categories;
    }

    public Category insert(Category category) {
        category.setId(this.getLastId() + 1);
        this.categories.add(category);
        return category;
    }

    public void delete(Integer id) {
        this.categories.removeIf(category -> category.getId().equals(id));

    }

    private Integer getLastId() {
        return this.categories
                .stream()
                .mapToInt(category -> category.getId())
                .max().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Simular demora no banco de dados
     */
    private void demore() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
