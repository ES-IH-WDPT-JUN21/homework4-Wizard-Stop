package com.ironhack.opportunityservice.service.interfaces;


import com.ironhack.opportunityservice.controller.DTO.OpportunityDTO;
import com.ironhack.opportunityservice.model.Opportunity;

import java.util.List;

public interface OpportunityService {

    List<Opportunity> getAll();
    Opportunity getById(Long opportunityId);
    Opportunity add(OpportunityDTO opportunity);

}
