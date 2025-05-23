package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer>{
    List<Suppliers> findBySupplierNameContaining(String supplierName);
    List<Suppliers> findBySupplierNameContainingAndSupplierId(String supplierName, Integer supplierId);
    List<Suppliers> findBySupplierName(String supplierName);
    List<Suppliers> findBySupplierId(Integer supplierId);
}