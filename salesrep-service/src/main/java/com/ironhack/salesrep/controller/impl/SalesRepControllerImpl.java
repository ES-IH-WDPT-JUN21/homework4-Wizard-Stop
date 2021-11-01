package com.ironhack.salesrep.controller.impl;
import com.ironhack.salesrep.controller.interfaces.SalesRepController;
import com.ironhack.salesrep.dto.SalesRepNameDTO;
import com.ironhack.salesrep.model.SalesRep;
import com.ironhack.salesrep.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesRepControllerImpl implements SalesRepController {

    @Autowired
    private SalesRepService salesRepService;

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
    public void addSalesRep(@RequestBody SalesRepNameDTO salesRepNameDTO){
        salesRepService.addSalesRep(salesRepNameDTO);
    }

    @PatchMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchSalesRep(@PathVariable Long id, @RequestBody SalesRepNameDTO salesRepNameDTO){
        salesRepService.changeSalesRep(id, salesRepNameDTO);
    }

    @DeleteMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSalesRep(@PathVariable Long id){
        salesRepService.delete(id);
        //TODO should we delete the lead/opportunities associated with a salesrep that gets deleted?
    }




}
