package com.ironhack.opportunityservice.controller.interfaces;

import com.ironhack.opportunityservice.model.Opportunity;

import java.util.List;

public interface OpportunityController {

    List<Opportunity> getAll();
    Opportunity getById(Long opportunityId);
    Opportunity add(Opportunity opportunity);
}
