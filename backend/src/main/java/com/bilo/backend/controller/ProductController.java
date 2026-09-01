package com.bilo.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilo.backend.dto.CreateProductRequest;
import com.bilo.backend.model.Category;
import com.bilo.backend.model.Product;
import com.bilo.backend.repository.CategoryRepository;
import com.bilo.backend.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //Might have to implement GraphQL or query parameters to stop additional fetches for categories
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody CreateProductRequest request){
        Category category = categoryRepository.findById(request.primaryCategoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Product product = new Product();
        product.setDescription(request.description());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setPrimaryCategory(category);
        return productRepository.save(product);
    }
}
