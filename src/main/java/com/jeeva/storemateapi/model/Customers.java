package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    
    private String customerFirstName;
    private String customerLastName;
    private String customerContact;
    private String customerEmail;
    private String customerAddress;

    @Temporal(TemporalType.DATE)
    private Date customerDOB;
}