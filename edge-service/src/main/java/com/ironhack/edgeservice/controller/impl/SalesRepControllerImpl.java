package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.SalesRepController;
import com.ironhack.edgeservice.service.interfaces.OpportunityService;
import com.ironhack.edgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesRepControllerImpl implements SalesRepController {


    @Autowired
    private SalesRepService salesRepService;

    @GetMapping("/opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showOpportunitiesBySalesRep() {
        return salesRepService.showOpportunitiesBySalesRep();
    }
}
