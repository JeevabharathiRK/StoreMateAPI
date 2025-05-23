package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name = "CustomerPayments")
public class CustomerPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private CustomerOrders order;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    private BigDecimal paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private BigDecimal emiAmount;

    @Temporal(TemporalType.DATE)
    private Date emiStartDate;
}
