package br.com.storeflow.srv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.storeflow.srv.catalog.domain.*;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);
    
}
