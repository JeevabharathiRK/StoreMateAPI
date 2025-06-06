package com.jeeva.storemateapi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.service.BarcodeService;
import com.jeeva.storemateapi.service.CustomerService;
import com.jeeva.storemateapi.service.OrderItemService;
import com.jeeva.storemateapi.service.ProductService;
import com.jeeva.storemateapi.service.CustomerOrderService;
import com.jeeva.storemateapi.model.Barcodes;
import com.jeeva.storemateapi.model.Customers;
import com.jeeva.storemateapi.model.Products;
import com.jeeva.storemateapi.model.CustomerOrders;
import com.jeeva.storemateapi.model.OrderItems;
import org.springframework.web.bind.annotation.*;

/* 
Note : This code is part of a Spring Boot application that provides
RESTful endpoints for billing operations, including barcode, customer management and to add orders. 
*/

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BarcodeService barcodeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Billing API";
    }

    // Endpoint to get product details by barcode
    @GetMapping(params = "barcode")
    public ResponseEntity<Barcodes> getByBarcode(@RequestParam("barcode") Long barcode) {
        return barcodeService.getByBarcode(barcode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomerByContact(@RequestParam("customerContact") String customerContact) {
        return customerService.getCustomerByContact(customerContact)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/customers")
    public Customers createCustomer(@RequestBody Customers customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/customerOrders")
    public ResponseEntity<CustomerOrders> createCustomerOrder(@RequestBody CustomerOrders customerOrder) {
        CustomerOrders savedOrder = customerOrderService.saveCustomerOrder(customerOrder);
        if (savedOrder != null) {
            return ResponseEntity.ok(savedOrder);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/orderItems")
    public ResponseEntity<OrderItems> createOrderItem(@RequestBody OrderItems orderItem) {
        OrderItems savedOrderItem = orderItemService.saveOrderItem(orderItem);
        if (savedOrderItem != null) {
            return ResponseEntity.ok(savedOrderItem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Products> updateProduct(@RequestBody Products product) {
        Products updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}