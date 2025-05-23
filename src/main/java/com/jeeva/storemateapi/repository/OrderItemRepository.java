package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing OrderItems entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderOrderId(Integer orderId);
    List<OrderItems> findByProductProductId(Integer productId);
}