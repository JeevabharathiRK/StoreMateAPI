package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.FollowUps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeeva.storemateapi.service.FollowUpService;
import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/followups")
public class FollowUpsController {

    @Autowired
    private FollowUpService followUpService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Follow-Ups API";
    }

    @GetMapping("/all")
    public ResponseEntity<List<FollowUps>> getAllFollowUps() {
        List<FollowUps> followUps = followUpService.getAllFollowUps();
        return ResponseEntity.ok(followUps);
    }
}