package com.jeeva.storemateapi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.model.Barcodes;
import com.jeeva.storemateapi.model.Products;
import com.jeeva.storemateapi.model.Suppliers;
import com.jeeva.storemateapi.model.Categories;
import com.jeeva.storemateapi.service.BarcodeService;
import com.jeeva.storemateapi.service.ProductService;
import com.jeeva.storemateapi.service.SupplierService;
import com.jeeva.storemateapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/stocks")
public class StocksController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BarcodeService barcodeService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Stocks API";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<Suppliers> getSupplierById(@RequestParam("id") Integer id) {
        Optional<Suppliers> supplier = supplierService.getSupplierById(id);
        if (supplier.isPresent()) {
            return ResponseEntity.ok(supplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/categories")
    public ResponseEntity<Categories> getCategoryByName(@RequestParam("name") String name) {
        Optional<Categories> category = categoryService.getCategoryByName(name);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Post Methods
    @PostMapping("/products")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products savedProduct = productService.saveProduct(product);
        if (savedProduct == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedProduct);
    }

    @PostMapping("/barcodes")
    public ResponseEntity<Barcodes> createBarcode(@RequestBody Barcodes barcode){
        Barcodes savedBarcode = barcodeService.createBarcode(barcode);
        if(savedBarcode == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedBarcode);
    }



}
