package com.jeeva.storemateapi.service;

import com.jeeva.storemateapi.model.Customers;
import com.jeeva.storemateapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customers> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customers> getCustomerByContact(String customerContact) {
        return customerRepository.findByCustomerContact(customerContact);
    }

    @Override
    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customers updateCustomer(Integer id, Customers updatedCustomer) {
        return customerRepository.findById(id).map(existing -> {
            existing.setCustomerFirstName(updatedCustomer.getCustomerFirstName());
            existing.setCustomerLastName(updatedCustomer.getCustomerLastName());
            existing.setCustomerContact(updatedCustomer.getCustomerContact());
            existing.setCustomerEmail(updatedCustomer.getCustomerEmail());
            existing.setCustomerAddress(updatedCustomer.getCustomerAddress());
            existing.setCustomerDOB(updatedCustomer.getCustomerDOB());
            return customerRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
