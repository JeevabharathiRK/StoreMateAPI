package com.jeeva.storemateapi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/billing")
public class BillingController {

    static class TestObject {
        public String productName = "Test Product";
        public String productDescription = "This is a test product description.";
        public String category = "Test Category";
        public Double price = 100.0;
        public String barcode = "123456789";
    }

    @GetMapping("")
    public String home() {
        return "Welcome to the Billing API";
    }

    @GetMapping(params = "barcode")
    public ResponseEntity<TestObject> getByBarcode(@RequestParam("barcode") Long barcode) {
        TestObject testObject = new TestObject();
        if (testObject.barcode == null || !testObject.barcode.equals(barcode.toString())) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(testObject);
        }
    }
}