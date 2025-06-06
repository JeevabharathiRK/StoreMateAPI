package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Products;
import java.util.List;

public interface ProductService {

    // Create operations
    Products saveProduct(Products product);

    // Read operations
    List<Products> getAllProducts();
    Products getProductById(Integer productId);
    
    // Update operations
    Products updateProduct(Products product);

    // Delete operations
    void deleteProduct(Integer productId);
    
}