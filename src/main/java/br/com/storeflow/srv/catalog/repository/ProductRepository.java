package br.com.storeflow.srv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.storeflow.srv.catalog.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
