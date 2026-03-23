package br.com.storeflow.srv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.storeflow.srv.catalog.domain.Product;
import java.util.Optional;  

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findById(Long id);

}
