package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Products;
import com.jeeva.storemateapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }
    @Override
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }
}