package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.controller.dto.SalesRepDTO;
import com.ironhack.edgeservice.model.Lead;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.model.SalesRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("salesrep-service")
public interface SalesRepServiceClient {

    @GetMapping("/salesrep/{id}")
    public SalesRep getSalesRepById(@PathVariable Long id);

    @GetMapping("/salesrep/all")
    public List<SalesRep> getAllSalesRep();

    @PostMapping("/salesrep")
    public void addSalesRep(@RequestBody SalesRepDTO salesRepDTO);

    @PutMapping("/salesrep")
    public void updateSalesRep(@RequestBody SalesRepDTO salesRepDTO);

    @DeleteMapping("/salesrep/{id}")
    public void deleteSalesRep(@PathVariable Long id);



}
