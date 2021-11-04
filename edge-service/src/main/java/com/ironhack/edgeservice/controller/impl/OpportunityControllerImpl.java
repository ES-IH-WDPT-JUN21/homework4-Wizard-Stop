package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.controller.interfaces.OpportunityController;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import com.ironhack.edgeservice.service.interfaces.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity save(@Valid @RequestBody OpportunityDTO opportunity) {
        return opportunityService.save(opportunity);
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

    @GetMapping("/opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showOpportunitiesBySalesRep() {
        return opportunityService.showOpportunitiesBySalesRep();
    }

    @GetMapping("/closewon_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
        return opportunityService.showClosedWonOpportunitiesBySalesRep();
    }

    @GetMapping("/closelost_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
        return opportunityService.showClosedLostOpportunitiesBySalesRep();
    }

    @GetMapping("/open_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showOpenOpportunitiesBySalesRep() {
        return opportunityService.showOpenOpportunitiesBySalesRep();
    }

    @GetMapping("/opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByProduct() {
        return opportunityService.opportunitiesByProduct();
    }

    @GetMapping("/open_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByProduct() {
        return opportunityService.openOpportunitiesByProduct();
    }

    @GetMapping("/closewon_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByProduct() {
        return opportunityService.wonOpportunitiesByProduct();
    }

    @GetMapping("/closelost_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByProduct() {
        return opportunityService.lostOpportunitiesByProduct();
    }

    @GetMapping("/opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByCountry() {
        return opportunityService.opportunitiesByCountry();
    }

    @GetMapping("/open_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByCountry() {
        return opportunityService.openOpportunitiesByCountry();
    }

    @GetMapping("/closewon_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByCountry() {
        return opportunityService.wonOpportunitiesByCountry();
    }

    @GetMapping("/closelost_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByCountry() {
        return opportunityService.lostOpportunitiesByCountry();
    }

    @GetMapping("/opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByCity() {
        return opportunityService.opportunitiesByCity();
    }

    @GetMapping("/open_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByCity() {
        return opportunityService.openOpportunitiesByCity();
    }

    @GetMapping("/closewon_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByCity() {
        return opportunityService.wonOpportunitiesByCity();
    }

    @GetMapping("/closelost_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByCity() {
        return opportunityService.lostOpportunitiesByCity();
    }

    @GetMapping("/opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByIndustry() {
        return opportunityService.opportunitiesByIndustry();
    }

    @GetMapping("/open_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByIndustry() {
        return opportunityService.openOpportunitiesByIndustry();
    }

    @GetMapping("/closewon_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByIndustry() {
        return opportunityService.wonOpportunitiesByIndustry();
    }

    @GetMapping("/closelost_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByIndustry() {
        return opportunityService.lostOpportunitiesByIndustry();
    }
}
