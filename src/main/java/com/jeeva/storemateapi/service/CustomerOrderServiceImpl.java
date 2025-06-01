package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerOrders;
import com.jeeva.storemateapi.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterable;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public Iterable<CustomerOrders> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public CustomerOrders saveCustomerOrder(CustomerOrders customerOrders) {
        return customerOrderRepository.save(customerOrders);
    }

    @Override
    public CustomerOrders getCustomerOrderById(Long id) {
        return customerOrderRepository.findById(id).orElse(null);
    }
}