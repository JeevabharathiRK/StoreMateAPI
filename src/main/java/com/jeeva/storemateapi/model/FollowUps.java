package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name = "FollowUps")
public class FollowUps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followUpId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date followUpDate;

    private String purpose;
    private String status;
}
