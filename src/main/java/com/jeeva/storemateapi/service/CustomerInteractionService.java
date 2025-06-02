package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerInteractions;

public interface CustomerInteractionService {

    Iterable<CustomerInteractions> getAllCustomerInteractions();
    CustomerInteractions createCustomerInteractions(CustomerInteractions customerInteractions);
    CustomerInteractions updateCustomerInteractions(Integer id, CustomerInteractions customerInteractions);
    CustomerInteractions saveCustomerInteractions(CustomerInteractions customerInteractions);
    CustomerInteractions getCustomerInteractionsById(Integer id);
    void deleteCustomerInteractionsById(Integer id);
}