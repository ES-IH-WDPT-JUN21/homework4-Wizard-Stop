package com.ironhack.customerservice.controller.interfaces;

import com.ironhack.customerservice.controller.dto.OpportunityDTO;
import com.ironhack.customerservice.model.Opportunity;

import java.util.List;

public interface OpportunityController {
    List<Opportunity> getAll() throws InterruptedException;
    Opportunity getById(Long opportunityId) throws InterruptedException;
    Opportunity add(OpportunityDTO opportunity);
    String closeLost(Long id);
    String closeWon(Long id);
}
