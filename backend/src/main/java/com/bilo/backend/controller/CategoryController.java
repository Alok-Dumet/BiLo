package com.bilo.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilo.backend.dto.CreateCategoryRequest;
import com.bilo.backend.model.Category;
import com.bilo.backend.repository.CategoryRepository;

import jakarta.validation.Valid;


@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    @PostMapping("/categories")
    public Category createCategories(@Valid @RequestBody CreateCategoryRequest request){
        Category category = new Category();
        category.setName(request.name());
        return categoryRepository.save(category);
    }
}
