package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerPayments;

public interface CustomerPaymentService {
    Iterable<CustomerPayments> getAllCustomerPayments();
    CustomerPayments updateCustomerPayments(Integer id, CustomerPayments customerPayments);
    CustomerPayments saveCustomerPayments(CustomerPayments customerPayments);
    CustomerPayments getCustomerPaymentsById(Integer id);
}