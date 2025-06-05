package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.FollowUps;
import com.jeeva.storemateapi.model.Customers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.service.FollowUpService;
import com.jeeva.storemateapi.service.CustomerService;
import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/followups")
public class FollowUpsController {

    @Autowired
    private FollowUpService followUpService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Follow-Ups API";
    }

    @GetMapping("/all")
    public ResponseEntity<List<FollowUps>> getAllFollowUps() {
        List<FollowUps> followUps = followUpService.getAllFollowUps();
        return ResponseEntity.ok(followUps);
    }

    @GetMapping("/customers")
    public ResponseEntity<Customers> getCategoryById(@RequestParam("customerId") Integer customerId){
        Optional<Customers> customer = customerService.getCustomerById(customerId);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<FollowUps> addFollowUp(@RequestBody FollowUps followUp) {
        FollowUps createdFollowUp = followUpService.saveFollowUp(followUp);
        return ResponseEntity.ok(createdFollowUp);
    }
}