package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.ReturnOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReturnOrderRepository extends JpaRepository<ReturnOrders, Integer> {
    List<ReturnOrders> findByOrderOrderId(Integer orderId);
    List<ReturnOrders> findByProductProductId(Integer productId);
    List<ReturnOrders> findByCustomerCustomerId(Integer customerId);
    List<ReturnOrders> findByReturnId(Integer returnId);
}