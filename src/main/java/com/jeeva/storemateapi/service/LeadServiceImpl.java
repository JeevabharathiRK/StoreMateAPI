package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Leads;
import com.jeeva.storemateapi.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public List<Leads> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Optional<Leads> getLeadById(Integer leadId) {
        return leadRepository.findById(leadId);
    }

    @Override
    public Leads saveLead(Leads lead) {
        return leadRepository.save(lead);
    }
}