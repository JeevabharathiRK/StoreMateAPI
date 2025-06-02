package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerPayments;
import com.jeeva.storemateapi.repository.CustomerPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPaymentServiceImpl implements CustomerPaymentService {

    @Autowired
    private CustomerPaymentRepository customerPaymentRepository;

    @Override
    public Iterable<CustomerPayments> getAllCustomerPayments() {
        return customerPaymentRepository.findAll();
    }

    @Override
    public CustomerPayments saveCustomerPayments(CustomerPayments customerPayments) {
        return customerPaymentRepository.save(customerPayments);
    }

    @Override
    public CustomerPayments updateCustomerPayments(Integer id, CustomerPayments updatedPayment) {
        return customerPaymentRepository.findById(id).map(existing -> {
            existing.setCustomer(updatedPayment.getCustomer());
            existing.setOrder(updatedPayment.getOrder());
            existing.setPaymentDate(updatedPayment.getPaymentDate());
            existing.setPaymentAmount(updatedPayment.getPaymentAmount());
            existing.setPaymentMethod(updatedPayment.getPaymentMethod());
            existing.setPaymentStatus(updatedPayment.getPaymentStatus());
            existing.setEmiAmount(updatedPayment.getEmiAmount());
            existing.setEmiStartDate(updatedPayment.getEmiStartDate());
            return customerPaymentRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public CustomerPayments getCustomerPaymentsById(Integer id) {
        return customerPaymentRepository.findById(id).orElse(null);
    }
}