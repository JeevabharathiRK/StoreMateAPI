package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    private String supplierName;
    private String supplierContact;
    private String supplierAddress;
    private String supplierEmail;
}
