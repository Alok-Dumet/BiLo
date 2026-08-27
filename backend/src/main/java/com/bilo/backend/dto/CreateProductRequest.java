package com.bilo.backend.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    String name,

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    String description,

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price cannot be negative")
    @DecimalMax(value = "999999.99", message = "Price cannot exceed 999,999.99")
    Double price
) {}