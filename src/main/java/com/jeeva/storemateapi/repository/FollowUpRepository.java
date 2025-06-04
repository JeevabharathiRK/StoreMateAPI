package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.FollowUps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing FollowUp entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface FollowUpRepository extends JpaRepository<FollowUps, Integer> {
}