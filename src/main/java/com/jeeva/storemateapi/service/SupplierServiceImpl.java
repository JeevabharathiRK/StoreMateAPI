package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Suppliers;
import com.jeeva.storemateapi.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Suppliers> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Suppliers> getSupplierById(Integer id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Suppliers createSupplier(Suppliers supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Suppliers updateSupplier(Integer id, Suppliers supplier) {
        if (supplierRepository.existsById(id)) {
            supplier.setSupplierId(id);
            return supplierRepository.save(supplier);
        }
        return null;
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}