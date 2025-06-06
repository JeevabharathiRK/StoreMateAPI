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

    // ------------------------------------------  CRUD ---------------------------------------//

    //Create operations
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    //Read operations
    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }
    
    //Update operations
    @Override
    public Products updateProduct(Products product) {
        return productRepository.findById(product.getProductId()).map(existing -> {
            if (product.getProductName() != null)
                existing.setProductName(product.getProductName());
            if (product.getProductDescription() != null)
                existing.setProductDescription(product.getProductDescription());
            if (product.getProductPrice() != null)
                existing.setProductPrice(product.getProductPrice());
            if (product.getProductStock() != null)
                existing.setProductStock(product.getProductStock());
            return productRepository.save(existing);
        }).orElse(null);
    }

    //Delete operations
    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}