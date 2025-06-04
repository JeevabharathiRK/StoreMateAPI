package com.jeeva.storemateapi.service;
import com.jeeva.storemateapi.model.Leads;
import java.util.List;
import java.util.Optional;

public interface LeadService {
    List<Leads> getAllLeads();
    Optional<Leads> getLeadById(Integer leadId);
    Leads saveLead(Leads lead);
}