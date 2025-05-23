package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CustomerTags")
public class CustomerTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTagId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    private String tag;
}
