package org.acme.cache.repositories;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.cache.entities.Category;

@ApplicationScoped
public class CategoryRepository {

    private List<Category> categories;

    public CategoryRepository() {
        this.initalData();
    }

    private void initalData() {
        this.categories = Arrays.asList(
                new Category(1, "Categoria 1"),
                new Category(2, "Categoria 2"),
                new Category(3, "Categoria 3"),
                new Category(4, "Categoria 4"),
                new Category(5, "Categoria 5"),
                new Category(6, "Categoria 6"),
                new Category(7, "Categoria 7"),
                new Category(8, "Categoria 8"),
                new Category(9, "Categoria 9"))

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
