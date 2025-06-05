package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Leads;
import com.jeeva.storemateapi.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/leads")
public class LeadsController {

    @Autowired
    private LeadService leadService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Leads API";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Leads>> getAllLeads() {
        List<Leads> leads = leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }

    @PostMapping("/add")
    public ResponseEntity<Leads> createLead(@RequestBody Leads lead) {
        if (lead.getLeadId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Leads savedLead = leadService.saveLead(lead);
        return ResponseEntity.ok(savedLead);
    }
}
