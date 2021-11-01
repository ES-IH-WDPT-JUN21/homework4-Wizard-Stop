package com.homework4leadservice.leadservice.controller.impl;

import com.homework4leadservice.leadservice.controller.DTO.LeadDTO;
import com.homework4leadservice.leadservice.controller.interfaces.LeadController;
import com.homework4leadservice.leadservice.model.Lead;
import com.homework4leadservice.leadservice.repository.LeadRepository;
import com.homework4leadservice.leadservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.FileAlreadyExistsException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead getLeadById(@PathVariable(name = "id") long id) {
        return leadService.getLeadById(id);
    }

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List <Lead> getAllLeads(){
        return leadService.getAllLeads();
    }

    // esto hay que revisarlo en el edge para validar el id del salesrep al crear lead
    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public LeadDTO saveNewLead(@RequestBody LeadDTO leadDTO) throws ResponseStatusException {
        return leadService.saveNewLead(leadDTO);
    }

    @DeleteMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteLeadById(@PathVariable(name = "id") long id) {
        return leadService.deleteLeadById(id);
    }


}
