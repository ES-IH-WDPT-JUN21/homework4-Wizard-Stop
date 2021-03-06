package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.client.LeadServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.controller.dto.SalesRepDTO;
import com.ironhack.edgeservice.model.SalesRep;
import com.ironhack.edgeservice.service.interfaces.SalesRepService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepServiceClient salesRepServiceClient;

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

    @Autowired
    LeadServiceClient leadServiceClient;

    private final Logger logger = LoggerFactory.getLogger(SalesRepServiceImpl.class);


    public SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException {

        return salesRepServiceClient.getSalesRepById(id);
    }

    public void delete(Long id) throws InvalidParameterException, NoSuchElementException {
        salesRepServiceClient.deleteSalesRep(id);
    }

    public void addSalesRep(SalesRepDTO salesRepDTO) {
        salesRepServiceClient.addSalesRep(salesRepDTO);
    }

    public void changeSalesRep(SalesRepDTO salesRepDTO) {
        salesRepServiceClient.updateSalesRep(salesRepDTO);
    }


    @CircuitBreaker(name = "getAll", fallbackMethod = "getAllFallback")
    public List<SalesRep> getAll(){
        return salesRepServiceClient.getAllSalesRep();
    }

    public List<SalesRep> getAllFallback(Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        SalesRep salesRep = new SalesRep("Dummy");
        salesRep.setId(-1L);
        List<SalesRep> list = new ArrayList<>();
        list.add(salesRep);
        return list;
    }



}
