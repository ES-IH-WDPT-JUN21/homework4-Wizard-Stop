package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.OpportunityController;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import com.ironhack.edgeservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAll() {
        return opportunityService.getAll();
    }

    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity findById(@PathVariable (name = "id") Long id) {
        return opportunityService.findById(id);
    }

    @GetMapping("/opportunities/closelost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String closeLost(@PathVariable (name = "id")Long id) {
        return opportunityService.closeLost(id);
    }

    @GetMapping("/opportunities/closewon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String closeWon(@PathVariable (name = "id")Long id) {
        return opportunityService.closeWon(id);
    }
}
