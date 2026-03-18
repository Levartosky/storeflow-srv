package br.com.storeflow.srv.catalog.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public record CreateProductRequest( 

    @NotBlank(message = "Product name is required")
    @Size(max = 200, message = "Product name must have at most 200 characters")
    String name,

    @Size(max = 500, message = "Product description must have at most 500 characters")
    String description,

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be a positive value")
    BigDecimal price,

    @NotNull(message = "Product stock is required")
    @Min(value = 0, message = "Product stock must be a non-negative value") 
    Integer stock,

    @NotNull
    @NonNull
    Long categoryId) {
   
}
