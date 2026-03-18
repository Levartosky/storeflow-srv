package br.com.storeflow.srv.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(

    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name must have at most 100 characters")
    String name) {
   

    
}
