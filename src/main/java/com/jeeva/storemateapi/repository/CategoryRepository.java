package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 * Repository interface for managing Category entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    List<Categories> findByCategoryNameContainingIgnoreCase(String name);
    Optional<Categories> findByCategoryName(String name);
}
