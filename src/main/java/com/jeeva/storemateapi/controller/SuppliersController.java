package com.jeeva.storemateapi.controller;
import com.jeeva.storemateapi.model.Suppliers;
import com.jeeva.storemateapi.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable Integer id) {
        return supplierService.getSupplierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Suppliers> createSupplier(@RequestBody Suppliers supplier) {
        Suppliers createdSupplier = supplierService.createSupplier(supplier);
        if(createdSupplier != null) {
            return ResponseEntity.status(201).body(createdSupplier);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}