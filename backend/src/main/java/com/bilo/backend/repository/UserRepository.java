package com.bilo.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilo.backend.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    boolean existsByEmail(String email);
}
