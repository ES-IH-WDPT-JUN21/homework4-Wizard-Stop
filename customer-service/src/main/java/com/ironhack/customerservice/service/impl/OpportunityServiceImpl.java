package com.ironhack.customerservice.service.impl;

import com.ironhack.customerservice.controller.dto.OpportunityDTO;
import com.ironhack.customerservice.enums.Status;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.model.Contact;
import com.ironhack.customerservice.model.Opportunity;
import com.ironhack.customerservice.repository.AccountRepository;
import com.ironhack.customerservice.repository.ContactRepository;
import com.ironhack.customerservice.repository.OpportunityRepository;
import com.ironhack.customerservice.service.interfaces.OpportunityService;
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

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    public List<Opportunity> getAll() {
        return opportunityRepository.findAll();
    }

    public Opportunity getById(Long opportunityId)  {
        if (opportunityId < 1)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The ID provided must be 1 or greater");
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);
        if (optionalOpportunity.isPresent()) {
            return optionalOpportunity.get();
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + opportunityId + " does not match with any lead");
    }

    public Opportunity add(OpportunityDTO opportunity) {

        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunity.getId());
        if (optionalOpportunity.isPresent()){
            return optionalOpportunity.get();
        }else{
            Opportunity opportunityNew = new Opportunity();
            Account account = accountRepository.getById(opportunity.getAccountId());
            Contact contact = contactRepository.getById(opportunity.getDecisionMakerId());
            opportunityNew.setId(opportunity.getId());
            opportunityNew.setStatus(opportunity.getStatus());
            opportunityNew.setProduct(opportunity.getProduct());
            opportunityNew.setQuantity(opportunity.getQuantity());
            opportunityNew.setsalesRepId(opportunity.getSalesRepId());
            opportunityNew.setAccount(account);
            opportunityNew.setDecisionMaker(contact);

            return opportunityRepository.save(opportunityNew);
        }
    }

    @Override
    public String closeLost(Long id) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);
        if (optionalOpportunity.isPresent()){
            if (optionalOpportunity.get().getStatus().equals(Status.OPEN)) {
                optionalOpportunity.get().setStatus(Status.CLOSED_LOST);
                opportunityRepository.save(optionalOpportunity.get());
                return ("Opportunity " + id + " has been changed to Close-Lost");
            } else {
                return ("Opportunity " + id + " status cannot be changed");
            }
        }else{
            return ("Opportunity " + id + " not found");
        }
    }

    @Override
    public String closeWon(Long id) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);
        if (optionalOpportunity.isPresent()){
            if (optionalOpportunity.get().getStatus().equals(Status.OPEN)) {
                optionalOpportunity.get().setStatus(Status.CLOSED_WON);
                opportunityRepository.save(optionalOpportunity.get());
                return ("Opportunity " + id + " has been changed to Close-Lost");
            } else {
                return ("Opportunity " + id + " status cannot be changed");
            }
        }else{
            return ("Opportunity " + id + " not found");
        }
    }
}
