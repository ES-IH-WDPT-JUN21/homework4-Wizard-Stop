package com.ironhack.opportunityservice.service.impl;

import com.ironhack.opportunityservice.controller.DTO.OpportunityDTO;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import com.ironhack.opportunityservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    public List<Opportunity> getAll() {
        return opportunityRepository.findAll();
    }

    public Opportunity getById(Long opportunityId) throws ResponseStatusException {
        if (opportunityId < 1)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The ID provided must be 1 or greater");
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);
        if (optionalOpportunity.isPresent()) {
            return optionalOpportunity.get();
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + opportunityId + " does not match with any lead");
    }

    public Opportunity add(OpportunityDTO opportunity) throws ResponseStatusException {

        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunity.getId());
        if (optionalOpportunity.isPresent()){
            return optionalOpportunity.get();
        }else{
            Opportunity opportunityNew = new Opportunity();

            opportunityNew.setId(opportunity.getId());
            opportunityNew.setStatus(opportunity.getStatus());
            opportunityNew.setProduct(opportunity.getProduct());
            opportunityNew.setQuantity(opportunity.getQuantity());
            opportunityNew.setSalesRep(opportunity.getSalesRepId());
            opportunityNew.setAccountId(opportunity.getAccountId());
            opportunityNew.setDecisionMakerId(opportunity.getDecisionMakerId());

            return opportunityRepository.save(opportunityNew);
        }
    }

}
