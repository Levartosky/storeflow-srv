package br.com.storeflow.srv.catalog.service;

import org.springframework.stereotype.Service;

import br.com.storeflow.srv.catalog.repository.*;
import br.com.storeflow.srv.catalog.domain.Category;
import java.time.LocalDateTime;
import br.com.storeflow.srv.catalog.dto.ProductResponse;
import br.com.storeflow.srv.catalog.dto.CreateProductRequest;
import br.com.storeflow.srv.catalog.domain.Product;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;        
    }

    public ProductResponse createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
        .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(category);
        
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        return new ProductResponse(
            savedProduct.getId(),
            savedProduct.getName(),
            savedProduct.getDescription(),
            savedProduct.getPrice(),
            savedProduct.getStock(),
            savedProduct.getActive(),
            savedProduct.getCreatedAt(),
            savedProduct.getCategory().getId()
        );
    }     
    
    public List<ProductResponse> getAllProducts()
{
    return productRepository.findAll()
    .stream()
    .map(product -> new ProductResponse(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getStock(),
        product.getActive(),
        product.getCreatedAt(),
        product.getCategory().getId()
      )).toList();
    }
}
