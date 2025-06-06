package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Barcodes;
import java.util.List;
import java.util.Optional;

public interface BarcodeService {
    Optional<Barcodes> getByBarcode(Long barcode);
    Optional<Barcodes> getByProductId(Integer productId);
    Barcodes createBarcode(Barcodes barcode);
    Barcodes updateBarcode(Integer id, Barcodes updatedBarcode);
    void deleteBarcode(Integer id);
}