package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.model.Lead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("lead-service")
public interface LeadServiceClient {
    @GetMapping("/leads/{id}")
    public Lead getLeadById(@PathVariable(name = "id") long id);

    @GetMapping("/leads")
    public List<Lead> getAllLeads();


    @PostMapping("/leads")
    public LeadDTO saveNewLead(@RequestBody LeadDTO leadDTO);

    @DeleteMapping("/leads/{id}")
    public String deleteLeadById(@PathVariable(name = "id") long id);
}
