package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name = "Leads")
public class Leads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId;

    private String leadName;
    private String contact;
    private String email;
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
