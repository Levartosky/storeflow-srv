package br.com.storeflow.srv.catalog.service;

import org.springframework.stereotype.Service;

import br.com.storeflow.srv.catalog.dto.CreateCategoryRequest;
import br.com.storeflow.srv.catalog.repository.*;
import br.com.storeflow.srv.catalog.dto.CategoryResponse;
import br.com.storeflow.srv.catalog.domain.Category;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }   

    public CategoryResponse create(CreateCategoryRequest request) {
        categoryRepository.findByNameIgnoreCase(request.name())
        .ifPresent(category -> {
            throw new IllegalArgumentException("Category already exists");  
        });

        Category category = new Category();
        category.setName(request.name());
        category.setCreatedAt(LocalDateTime.now());

        Category savedCategory = categoryRepository.save(category);

        return toResponse(savedCategory);
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
    }

    private CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getCreatedAt()
        );
    }
}
