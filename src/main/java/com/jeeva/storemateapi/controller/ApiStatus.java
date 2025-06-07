package com.jeeva.storemateapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// This class provides an endpoint to check the status of the API

@CrossOrigin(origins = "*") // Allow all origins for CORS
@RestController
@RequestMapping("/api/status")
public class ApiStatus {

    @GetMapping
    public ResponseEntity<Boolean> getStatus() {
        return ResponseEntity.ok(true);
    }
}