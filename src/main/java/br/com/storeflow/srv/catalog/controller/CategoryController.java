package br.com.storeflow.srv.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.storeflow.srv.catalog.service.*;
import br.com.storeflow.srv.catalog.dto.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@Valid @RequestBody CreateCategoryRequest request) {
        return categoryService.create(request);
    }  

    @GetMapping
    public List<CategoryResponse> findAll(){
        return categoryService.findAll();
    }
}