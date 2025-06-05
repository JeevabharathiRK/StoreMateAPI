package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.OrderItems;
import com.jeeva.storemateapi.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Iterable<OrderItems> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItems saveOrderItem(OrderItems orderItem) {
        return orderItemRepository.save(orderItem);
    }
}