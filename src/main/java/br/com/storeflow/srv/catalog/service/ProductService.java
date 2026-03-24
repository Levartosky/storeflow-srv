package br.com.storeflow.srv.catalog.service;

import org.springframework.stereotype.Service;

import br.com.storeflow.srv.catalog.repository.*;
import br.com.storeflow.srv.catalog.domain.Category;
import java.time.LocalDateTime;
import br.com.storeflow.srv.catalog.dto.ProductResponse;
import br.com.storeflow.srv.catalog.dto.CreateProductRequest;
import br.com.storeflow.srv.catalog.domain.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.storeflow.srv.exception.ResourceNotFoundException;
import br.com.storeflow.srv.catalog.service.mapper.ProductMapper;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;        
    }

    public ProductResponse createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(category);
        
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }     
    
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));  
        return productMapper.toResponse(product);
    }

    public Page<ProductResponse> findAll(Long categoryId, Pageable pageable) {
        Page<Product> products;

        if(categoryId != null){
            products = productRepository.findByCategoryId(categoryId, pageable);
        }  else {
            products = productRepository.findAll(pageable);
        }
        return products.map(productMapper::toResponse);
    }
}
