package com.jeeva.storemateapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerEngagementDTO {
    private long newCustomers;
    private long existingCustomers;
    private long leads;
}
