package br.com.storeflow.srv.exception;

public class ResourceNotFoundException extends RuntimeException {
 public ResourceNotFoundException(String message) {
    super(message);
 }
    
}
