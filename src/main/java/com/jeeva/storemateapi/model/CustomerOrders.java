package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import lombok.Data;


@Data
@Entity
@Table(name = "CustomerOrders")
public class CustomerOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private BigDecimal orderTotal;
    private String orderStatus;
}
