package com.ironhack.customerservice.service.interfaces;

import com.ironhack.customerservice.controller.dto.OpportunityDTO;
import com.ironhack.customerservice.model.Opportunity;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface OpportunityService {

    List<Opportunity> getAll();
    Opportunity getById(Long opportunityId);
    Opportunity add(OpportunityDTO opportunity);
    String closeLost(Long id);
    String closeWon(Long id);
}
