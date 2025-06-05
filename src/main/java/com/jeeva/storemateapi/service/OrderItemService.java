package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.OrderItems;


public interface OrderItemService {
    Iterable<OrderItems> getAllOrderItems();
    OrderItems saveOrderItem(OrderItems orderItem);
}