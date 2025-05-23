package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing Lead entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface LeadRepository extends JpaRepository<Leads, Integer> {
    List<Leads> findByLeadId(Integer LeadId);
}