package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;


@Data
@Entity
@Table(name = "OrderItems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private CustomerOrders order;

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Products product;

    private String something;
    private Integer quantity;
    private BigDecimal price;
}
