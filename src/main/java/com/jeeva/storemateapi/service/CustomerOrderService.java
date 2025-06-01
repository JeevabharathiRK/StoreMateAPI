package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerOrders;
import java.util.Iterable;

public interface CustomerOrderService {
    Iterable<CustomerOrders> getAllCustomerOrders();
    CustomerOrders saveCustomerOrder(CustomerOrders customerOrders);
    CustomerOrders getCustomerOrderById(Long id);
}