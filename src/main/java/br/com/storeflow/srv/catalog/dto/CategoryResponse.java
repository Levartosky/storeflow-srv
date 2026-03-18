package br.com.storeflow.srv.catalog.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
    Long id,
    String name,
    LocalDateTime createdAt) {    
    
}
