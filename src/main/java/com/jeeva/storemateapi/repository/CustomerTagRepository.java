package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.CustomerTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerTagRepository extends JpaRepository<CustomerTags, Integer> {
    List<CustomerTags> findByCustomerCustomerId(Integer customerId);
}