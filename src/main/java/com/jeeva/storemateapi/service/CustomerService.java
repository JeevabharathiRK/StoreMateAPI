package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Customers;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customers> getAllCustomers();
    Optional<Customers> getCustomerByContact(String customerContact);
    Optional<Customers> getCustomerById(Integer id);
    Customers createCustomer(Customers customer);
    Customers updateCustomer(Integer id, Customers updatedCustomer);
    void deleteCustomer(Integer id);
}
