package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Barcodes;
import com.jeeva.storemateapi.repository.BarcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    @Autowired
    private BarcodeRepository barcodeRepository;

    @Override
    public Barcodes createBarcode(Barcodes barcode) {
        return barcodeRepository.save(barcode);
    }
    @Override
    public Barcodes updateBarcode(Integer id, Barcodes updatedBarcode) {
        return barcodeRepository.findById(id).map(existing -> {
            existing.setBarcode(updatedBarcode.getBarcode());
            existing.setProduct(updatedBarcode.getProduct());
            return barcodeRepository.save(existing);
        }).orElse(null);
    }
    @Override
    public void deleteBarcode(Integer id) {
        barcodeRepository.deleteById(id);
    }

    @Override
    public Optional<Barcodes> getByBarcode(Long barcode) {
        return barcodeRepository.findByBarcode(barcode);
    }
}