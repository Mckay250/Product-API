package com.decema.myCommerce.service;

import com.decema.myCommerce.model.Category;
import com.decema.myCommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category addCategory(Category category) {
        Optional<Category> existingCategory = repository.findByName(category.getName());
        if (existingCategory.isPresent()) {
            return existingCategory.orElse(null);
        }
        else {
        repository.save(category);
        return category;}
    }

    public List<Category> addCategories(List<Category> categories) {
        return repository.saveAll(categories);
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryByName(String category) { return repository.findByName(category).orElse(null);}

    public void deleteCategory(String name) {
        repository.deleteByName(name);
    }

    public Category updateCategory(Category category) {
        Category existingCategory = repository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        return repository.save(existingCategory);
    }



}
