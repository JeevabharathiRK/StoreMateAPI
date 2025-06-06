package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Customers;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //Create operations
    Customers createCustomer(Customers customer);

    // Read operations
    List<Customers> getAllCustomers();
    Optional<Customers> getCustomerByContact(String customerContact);
    Optional<Customers> getCustomerById(Integer id);

    // Update operations
    Customers updateCustomer(Customers updatedCustomer);

    // Delete operations
    void deleteCustomer(Integer id);
}
