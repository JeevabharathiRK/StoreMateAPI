package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.CustomerOrders;

public interface CustomerOrderService {
    Iterable<CustomerOrders> getAllCustomerOrders();
    CustomerOrders saveCustomerOrder(CustomerOrders customerOrders);
    CustomerOrders getCustomerOrderById(Integer id);
}