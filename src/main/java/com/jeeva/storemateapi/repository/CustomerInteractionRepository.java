package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.CustomerInteractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing CustomerInteraction entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CustomerInteractionRepository extends JpaRepository<CustomerInteractions, Integer> {
    List<CustomerInteractions> findByCustomerCustomerId(Integer customerId);
}
