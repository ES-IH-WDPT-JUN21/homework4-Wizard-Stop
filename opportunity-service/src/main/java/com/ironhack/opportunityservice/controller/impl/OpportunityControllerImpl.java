package com.ironhack.opportunityservice.controller.impl;

import com.ironhack.opportunityservice.controller.DTO.OpportunityDTO;
import com.ironhack.opportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import com.ironhack.opportunityservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/opportunity/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAll(){
        return opportunityService.getAll();
    }

    @GetMapping("/opportunity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity getById(@PathVariable(name = "id") Long opportunityId) throws ResponseStatusException {
        return opportunityService.getById(opportunityId);
    }

    @PostMapping("/opportunity/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity add(@Valid @RequestBody OpportunityDTO opportunity){
        return opportunityService.add(opportunity);
    }

}
