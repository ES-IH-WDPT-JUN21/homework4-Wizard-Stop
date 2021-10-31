package com.ironhack.customerservice.controller.impl;

import com.ironhack.customerservice.controller.dto.OpportunityDTO;
import com.ironhack.customerservice.controller.interfaces.OpportunityController;
import com.ironhack.customerservice.model.Opportunity;
import com.ironhack.customerservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OpportunityControllerImpl implements OpportunityController {
    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAll(){
        return opportunityService.getAll();
    }

    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity getById(@PathVariable(name = "id") Long opportunityId){
        return opportunityService.getById(opportunityId);
    }

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity add(@Valid @RequestBody OpportunityDTO opportunity){
        return opportunityService.add(opportunity);
    }

    @GetMapping("/opportunities/closelost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String closeLost(@PathVariable(name = "id") Long id) {
        return opportunityService.closeLost(id);
    }

    @GetMapping("/opportunities/closewon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String closeWon(@PathVariable(name = "id") Long id) {
        return opportunityService.closeWon(id);
    }
}
