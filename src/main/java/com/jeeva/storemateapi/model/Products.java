package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
    private Suppliers supplier;

    private BigDecimal productPrice;
    private Integer productStock;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStockAt;
}
