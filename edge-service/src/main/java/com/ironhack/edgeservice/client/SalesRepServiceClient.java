package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.controller.dto.SalesRepNameDTO;
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
    public void addSalesRep(@RequestBody SalesRepNameDTO salesRepNameDTO);

    @PatchMapping("/salesrep/{id}")
    public void patchSalesRep(@PathVariable Long id, @RequestBody SalesRepNameDTO salesRepNameDTO);

    @DeleteMapping("/salesrep/{id}")
    public void deleteSalesRep(@PathVariable Long id);

    @PatchMapping("/salesrep/addlead")
    public void addLead(@RequestBody LeadDTO leadDTO);

    @PatchMapping("/salesrep/addopportunity")
    public void addOpportunity(@RequestBody OpportunityDTO opportunityDTO);

    @GetMapping("/salesrep/leadsbysalesrep/{id}")
    public List<Lead> leadsBySalesRep(@PathVariable("id") Long id);

    @GetMapping("/salesrep/opportunitiesbysalesrep/{id}")
    public List<Opportunity> opportunitiesBySalesRep(@PathVariable("id") Long id);

    @GetMapping("/salesrep/reportleads")
    public List<Object[]> reportLeadsBySalesRep();

    @GetMapping("/salesrep/reportopportunities")
    public List<Object[]> reportOpportunitiesBySalesRep();

    @GetMapping("/salesrep/closedwon")
    public List<Object[]> reportClosedWonBySalesRep();

    @GetMapping("/salesrep/closedlost")
    public List<Object[]> reportClosedLostBySalesRep();

    @GetMapping("/salesrep/open")
    public List<Object[]> reportOpenBySalesRep();

}
