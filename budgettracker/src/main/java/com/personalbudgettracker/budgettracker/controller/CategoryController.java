package com.personalbudgettracker.budgettracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.personalbudgettracker.budgettracker.model.Category;
import com.personalbudgettracker.budgettracker.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        try {
            Category savedCategory = categoryService.saveCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Category Data", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}