package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.CustomerPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayments, Integer> {
    List<CustomerPayments> findByCustomerCustomerId(Integer customerId);
}