package com.jeeva.storemateapi.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;


@Data
@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    
    private String categoryName;

}
