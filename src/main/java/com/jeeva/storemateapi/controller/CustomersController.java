package com.jeeva.storemateapi.controller;

import com.jeeva.storemateapi.model.Customers;
import com.jeeva.storemateapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customers createCustomer(@RequestBody Customers customer) {
        return customerService.createCustomer(customer);
    }

    
    @PutMapping("/update")
    public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customer) {
        Customers updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
