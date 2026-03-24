package br.com.storeflow.srv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.storeflow.srv.catalog.domain.Product;
import java.util.Optional;  
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findById(Long id);

    Page<Product> findByCategoryId(Long id, Pageable pageable);

}
