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
}
