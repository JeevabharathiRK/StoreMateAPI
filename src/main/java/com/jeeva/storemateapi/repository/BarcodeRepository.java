package com.jeeva.storemateapi.repository;

import com.jeeva.storemateapi.model.Barcodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcodes, Integer> {
    Optional<Barcodes> findByBarcode(Long barcode);
    Optional<Barcodes> findByProductProductId(Integer productId);
}