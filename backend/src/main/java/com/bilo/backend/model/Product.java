package com.bilo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Getter
    private UUID id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Column(length = 1000)
    @Getter
    @Setter
    private String description;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price cannot be negative")
    @DecimalMax(value = "999999.99", message = "Price cannot exceed 999,999.99")
    @Column(nullable = false)
    @Getter
    private Double price;

    public void setPrice(Double price) {
        if (price != null && price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
}