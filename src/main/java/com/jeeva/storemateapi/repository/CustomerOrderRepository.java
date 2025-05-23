package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
/**
 * Repository interface for managing CustomerOrders entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrders, Integer> {
    List<CustomerOrders> findByCustomerCustomerId(Integer customerId);
}
