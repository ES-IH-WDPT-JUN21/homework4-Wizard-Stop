package com.ironhack.opportunityservice.controller.impl;

import com.ironhack.opportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @GetMapping("/opportunity/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAll(){
        return opportunityRepository.findAll();
    }

    @GetMapping("/opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity getById(@PathVariable(name = "id") Long opportunityId){
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);
        return optionalOpportunity.isPresent() ? optionalOpportunity.get() : null;
    }


    @PostMapping("/opportunity/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity add(@Valid @RequestBody Opportunity opportunity){
        return opportunityRepository.save(opportunity);
    }

}
