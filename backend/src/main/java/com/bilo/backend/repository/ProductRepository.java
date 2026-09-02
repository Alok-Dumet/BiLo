package com.bilo.backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bilo.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}