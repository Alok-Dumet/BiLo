package com.bilo.backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bilo.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    
}
