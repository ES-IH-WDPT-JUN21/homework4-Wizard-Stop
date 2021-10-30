package com.ironhack.customerservice.service.interfaces;

import com.ironhack.customerservice.controller.dto.OpportunityDTO;
import com.ironhack.customerservice.model.Opportunity;

import java.util.List;

public interface OpportunityService {

    List<Opportunity> getAll();
    Opportunity getById(Long opportunityId);
    Opportunity add(OpportunityDTO opportunity);
}
