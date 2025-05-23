package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name = "ReturnOrders")
public class ReturnOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer returnId;

    @ManyToOne
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    private CustomerOrders order;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products product;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    private Integer quantityReturned;
    private String reason;
    private String returnStatus;
    private BigDecimal refundAmount;
}
