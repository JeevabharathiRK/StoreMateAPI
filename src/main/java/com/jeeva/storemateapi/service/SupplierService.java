package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Suppliers;
import java.util.List;
import java.util.Optional;


public interface SupplierService {
    List<Suppliers> getAllSuppliers();
    Optional<Suppliers> getSupplierById(Integer id);
    Suppliers createSupplier(Suppliers supplier);
    Suppliers updateSupplier(Integer id, Suppliers supplier);
    void deleteSupplier(Integer id);
}