package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing Customers entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findByCustomerFirstNameContainingIgnoreCase(String name);
}
