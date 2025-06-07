package com.jeeva.storemateapi.controller;

import com.jeeva.storemateapi.dto.CustomerEngagementDTO;
import com.jeeva.storemateapi.repository.CustomerRepository;
import com.jeeva.storemateapi.repository.LeadRepository;
import com.jeeva.storemateapi.repository.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.temporal.IsoFields;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/engagement/year")
    public CustomerEngagementDTO getYearlyEngagement() {
        LocalDate now = LocalDate.now();
        LocalDate startOfYear = now.withDayOfYear(1);
        return fetchEngagementBetween(startOfYear, now);
    }

    @GetMapping("/engagement/month")
    public CustomerEngagementDTO getMonthlyEngagement() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = now.withDayOfMonth(1);
        return fetchEngagementBetween(startOfMonth, now);
    }

    @GetMapping("/engagement/week")
    public CustomerEngagementDTO getWeeklyEngagement() {
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.with(DayOfWeek.MONDAY);
        return fetchEngagementBetween(startOfWeek, now);
    }

    @GetMapping("/engagement/day")
    public CustomerEngagementDTO getDailyEngagement() {
        LocalDate today = LocalDate.now();
        return fetchEngagementBetween(today, today);
    }

    @GetMapping("/sales/{filter}")
    public Map<String, List<Map<String, Object>>> getSalesPerformance(@PathVariable String filter) {
        List<Map<String, Object>> salesData = new ArrayList<>();

        switch (filter.toLowerCase()) {
            case "year":
                salesData = List.of(
                    Map.of("name", "Jan", "value", 4),
                    Map.of("name", "Feb", "value", 6),
                    Map.of("name", "Mar", "value", 8),
                    Map.of("name", "Apr", "value", 10),
                    Map.of("name", "May", "value", 12),
                    Map.of("name", "Jun", "value", 9),
                    Map.of("name", "Jul", "value", 11),
                    Map.of("name", "Aug", "value", 14),
                    Map.of("name", "Sep", "value", 13),
                    Map.of("name", "Oct", "value", 15),
                    Map.of("name", "Nov", "value", 10),
                    Map.of("name", "Dec", "value", 16)
                );
                break;
            case "month":
                salesData = List.of(
                    Map.of("name", "Week 1", "value", 5),
                    Map.of("name", "Week 2", "value", 9),
                    Map.of("name", "Week 3", "value", 12),
                    Map.of("name", "Week 4", "value", 15)
                );
                break;
            case "week":
                salesData = List.of(
                    Map.of("name", "Mon", "value", 5),
                    Map.of("name", "Tue", "value", 7),
                    Map.of("name", "Wed", "value", 6),
                    Map.of("name", "Thu", "value", 9),
                    Map.of("name", "Fri", "value", 10),
                    Map.of("name", "Sat", "value", 4),
                    Map.of("name", "Sun", "value", 3)
                );
                break;
            case "day":
                salesData = List.of(
                    Map.of("name", "10AM", "value", 5),
                    Map.of("name", "12PM", "value", 5),
                    Map.of("name", "2PM", "value", 5),
                    Map.of("name", "4PM", "value", 5),
                    Map.of("name", "6PM", "value", 5),
                    Map.of("name", "8PM", "value", 5)
                );
                break;
            default:
                salesData = List.of();
                break;
        }

        return Map.of("data", salesData);
    }

    @GetMapping("/topSelling/{filter}")
    public Map<String, List<Map<String, Object>>> getTopSellingPerformance(@PathVariable String filter) {
        List<Map<String, Object>> salesData = new ArrayList<>();

        switch (filter.toLowerCase()) {
            case "year":
                salesData = List.of(
                    Map.of("name", "Laptop", "value", 20),
                    Map.of("name", "Smartphone", "value", 18),
                    Map.of("name", "T-Shirt", "value", 15)
                );
                break;
            case "month":
                salesData = List.of(
                    Map.of("name", "Laptop", "value", 5),
                    Map.of("name", "Smartphone", "value", 4),
                    Map.of("name", "T-Shirt", "value", 4)
                );
                break;
            case "week":
                salesData = List.of(
                    Map.of("name", "Laptop", "value", 2),
                    Map.of("name", "Smartphone", "value", 2),
                    Map.of("name", "T-Shirt", "value", 1)
                );
                break;
            case "day":
                salesData = List.of(
                    Map.of("name", "Laptop", "value", 1),
                    Map.of("name", "Smartphone", "value", 1),
                    Map.of("name", "T-Shirt", "value", 1)
                );
                break;
            default:
                salesData = List.of();
                break;
        }
        return Map.of("data", salesData);
    }

    @GetMapping("/profitLoss/{filter}")
public Map<String, List<Map<String, Object>>> getProfitLossRatio(@PathVariable String filter) {
    List<Map<String, Object>> data = new ArrayList<>();

    switch (filter.toLowerCase()) {
        case "year":
            data = List.of(
                Map.of("subject", "Profit", "A", 100),
                Map.of("subject", "Loss", "A", 40),
                Map.of("subject", "Stocked", "A", 60),
                Map.of("subject", "Clearance", "A", 90)
            );
            break;
        case "month":
            data = List.of(
                Map.of("subject", "Profit", "A", 60),
                Map.of("subject", "Loss", "A", 20),
                Map.of("subject", "Stocked", "A", 45),
                Map.of("subject", "Clearance", "A", 70)
            );
            break;
        case "week":
            data = List.of(
                Map.of("subject", "Profit", "A", 30),
                Map.of("subject", "Loss", "A", 15),
                Map.of("subject", "Stocked", "A", 25),
                Map.of("subject", "Clearance", "A", 35)
            );
            break;
        case "day":
            data = List.of(
                Map.of("subject", "Profit", "A", 10),
                Map.of("subject", "Loss", "A", 5),
                Map.of("subject", "Stocked", "A", 8),
                Map.of("subject", "Clearance", "A", 12)
            );
            break;
        default:
            data = List.of();
            break;
    }

    return Map.of("data", data);
}

    private CustomerEngagementDTO fetchEngagementBetween(LocalDate start, LocalDate end) {
        Date startDate = java.sql.Date.valueOf(start);
        Date endDate = java.sql.Date.valueOf(end.plusDays(1)); // include the end day

        long newCustomers = customerRepository.countByCreatedAtBetween(startDate, endDate);
        long totalCustomers = customerRepository.count();
        long existingCustomers = totalCustomers - newCustomers;
        long leads = leadRepository.count();

        return new CustomerEngagementDTO(newCustomers, existingCustomers, leads);
    }
}
