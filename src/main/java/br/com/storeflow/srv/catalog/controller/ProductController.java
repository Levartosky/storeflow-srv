package br.com.storeflow.srv.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.storeflow.srv.catalog.service.*;
import br.com.storeflow.srv.catalog.dto.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody @Valid CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProducts();
    }
    
}
