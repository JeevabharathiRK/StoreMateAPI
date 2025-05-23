package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "CustomerInteractions")
public class CustomerInteractions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interactionId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date interactionDate;

    private String interactionType;
    private String direction;
    private String notes;
}
