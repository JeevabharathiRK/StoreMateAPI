package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;


@Data
@Entity
@Table(name = "Barcodes")
public class Barcodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer barcodeID;
    
    private Long barcode;

    @OneToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products product;
}