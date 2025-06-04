package com.jeeva.storemateapi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.service.ProductService;
import com.jeeva.storemateapi.model.Products;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/stocks")
public class StocksController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Stocks API";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
