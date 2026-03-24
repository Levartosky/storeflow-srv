package br.com.storeflow.srv.catalog.service.mapper;

import br.com.storeflow.srv.catalog.domain.Product;
import br.com.storeflow.srv.catalog.dto.ProductResponse;

public class ProductMapper {

    public ProductResponse toResponse(Product product){
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            product.getActive(),
            product.getCreatedAt(),
            product.getCategory().getId()
        );
    }
}
