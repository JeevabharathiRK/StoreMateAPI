package com.jeeva.storemateapi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.service.BarcodeService;
import com.jeeva.storemateapi.service.CustomerService;
import com.jeeva.storemateapi.model.Barcodes;
import com.jeeva.storemateapi.model.Products;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BarcodeService barcodeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Billing API";
    }

    @GetMapping(params = "barcode")
    public ResponseEntity<Barcodes> getByBarcode(@RequestParam("barcode") Long barcode) {
        return barcodeService.getProductIdByBarcode(barcode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomerByContact(@RequestParam("customerContact") String customerContact) {
        return customerService.getCustomerByContact(customerContact)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}