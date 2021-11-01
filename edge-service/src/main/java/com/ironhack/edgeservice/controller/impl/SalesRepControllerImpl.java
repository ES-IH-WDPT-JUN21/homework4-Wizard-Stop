package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.SalesRepController;
import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.SalesRep;
import com.ironhack.edgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public SalesRep getSalesRepById(@PathVariable Long id){
        return salesRepService.findById(id);
    }

    @GetMapping("/salesrep/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<SalesRep> getAllSalesRep(){
        return salesRepService.getAll();
    }

    @PostMapping("/salesrep")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSalesRep(@RequestBody SalesRep salesRep) throws ExistentElementException {
        salesRepService.save(salesRep);
    }

    @DeleteMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSalesRep(@PathVariable Long id){
        salesRepService.delete(id);
    }
}
