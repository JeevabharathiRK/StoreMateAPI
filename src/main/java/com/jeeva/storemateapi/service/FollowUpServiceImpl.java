package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.FollowUps;
import com.jeeva.storemateapi.service.FollowUpService;
import com.jeeva.storemateapi.repository.FollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FollowUpServiceImpl implements FollowUpService{

    @Autowired
    private FollowUpRepository followUpRepository;

    @Override
    public List<FollowUps> getAllFollowUps() {
        return followUpRepository.findAll();
    }
    @Override
    public Optional<FollowUps> getFollowUpById(Integer followUpId) {
        return followUpRepository.findById(followUpId);
    }
    @Override
    public FollowUps saveFollowUp(FollowUps followUp) {
        return followUpRepository.save(followUp);
    }
    @Override
    public void deleteFollowUp(Integer followUpId) {
        followUpRepository.deleteById(followUpId);
    }
}