package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.ConvertLeadDTO;
import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.controller.interfaces.LeadController;
import com.ironhack.edgeservice.model.Lead;
import com.ironhack.edgeservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead getLeadById(@PathVariable(name = "id") long id) {
        return leadService.findById(id);
    }

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> getAllLeads(){
        return leadService.getAll();
    }

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public LeadDTO saveNewLead(@RequestBody LeadDTO leadDTO) {
        return leadService.save(leadDTO);
    }

    @DeleteMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteLeadById(@PathVariable(name = "id") long id) {
        return leadService.deleteById(id);
    }


    @PostMapping("/leads-opportunity{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String convertLead(@PathVariable(name = "id") long id){
        return leadService.convertLead(id);
    }

    @PostMapping("/lead/opportunity")
    @ResponseStatus(HttpStatus.OK)
    public void convertLeadToOpportunity(@RequestBody ConvertLeadDTO convertLeadDTO) {
        leadService.convertLeadToOpportunity(convertLeadDTO);
    }


}
