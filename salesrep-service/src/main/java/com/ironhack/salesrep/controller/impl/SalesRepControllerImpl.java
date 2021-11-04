package com.ironhack.salesrep.controller.impl;
import com.ironhack.salesrep.controller.interfaces.SalesRepController;
import com.ironhack.salesrep.dto.SalesRepDTO;
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
    @ResponseStatus(HttpStatus.OK)
    public SalesRep getSalesRepById(@PathVariable Long id){
       return salesRepService.findById(id);
    }

    @GetMapping("/salesrep/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> getAllSalesRep(){
        return salesRepService.getAll();
    }

    @PostMapping("/salesrep")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSalesRep(@RequestBody SalesRepDTO salesRepDTO){
        salesRepService.addSalesRep(salesRepDTO);
    }

    @PutMapping("/salesrep")
    @ResponseStatus(HttpStatus.OK)
    public void updateSalesRep(@RequestBody SalesRepDTO salesRepDTO){
        salesRepService.changeSalesRep(salesRepDTO);
    }

    @DeleteMapping("/salesrep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSalesRep(@PathVariable Long id){
        salesRepService.delete(id);
    }




}
