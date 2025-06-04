package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.FollowUps;
import java.util.List;
import java.util.Optional;

public interface FollowUpService {
    List<FollowUps> getAllFollowUps();
    Optional<FollowUps> getFollowUpById(Integer followUpId);
    FollowUps saveFollowUp(FollowUps followUp);
    void deleteFollowUp(Integer followUpId);
}