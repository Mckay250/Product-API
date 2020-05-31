package com.decema.myCommerce.api;

import com.decema.myCommerce.model.Category;
import com.decema.myCommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/admin/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/api/admin/addCategories")
    public void addCategories(@RequestBody List<Category> categories) {
        categoryService.addCategories(categories);
    }

    @GetMapping("/api/user/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/api/admin/delete/{category}")
    public void deleteCategoryByName(@PathVariable String category) {
        categoryService.deleteCategory(category);
    }

    @PutMapping("/api/admin/updateCategories")
    public void updateCategory(@RequestBody Category categoryToUpdate) { categoryService.updateCategory(categoryToUpdate);
    }

}
