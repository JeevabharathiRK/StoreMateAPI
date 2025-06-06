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
    public Customers updateCustomer(Customers updatedCustomer) {
        return customerRepository.findById(updatedCustomer.getCustomerId()).map(existing -> {

            if (updatedCustomer.getCustomerFirstName() != null)
                existing.setCustomerFirstName(updatedCustomer.getCustomerFirstName());

            if (updatedCustomer.getCustomerLastName() != null)
                existing.setCustomerLastName(updatedCustomer.getCustomerLastName());

            if (updatedCustomer.getCustomerContact() != null)
                existing.setCustomerContact(updatedCustomer.getCustomerContact());

            if (updatedCustomer.getCustomerEmail() != null)
                existing.setCustomerEmail(updatedCustomer.getCustomerEmail());

            if (updatedCustomer.getCustomerAddress() != null)
                existing.setCustomerAddress(updatedCustomer.getCustomerAddress());

            if (updatedCustomer.getCustomerDOB() != null)
                existing.setCustomerDOB(updatedCustomer.getCustomerDOB());

            return customerRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
