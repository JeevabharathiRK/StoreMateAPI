package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Repository interface for managing Products entities.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByCategoryCategoryId(Integer categoryId);
    List<Products> findByProductNameContaining(String productName);
    List<Products> findByProductNameContainingAndCategoryCategoryId(String productName, Integer categoryId);
}