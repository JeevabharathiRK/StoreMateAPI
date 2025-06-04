package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Products;
import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();
    Products getProductById(Integer productId);
    Products saveProduct(Products product);
}