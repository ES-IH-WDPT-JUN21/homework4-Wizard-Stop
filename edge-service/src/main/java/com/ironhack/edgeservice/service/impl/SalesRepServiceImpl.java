package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Lead;
import com.ironhack.edgeservice.model.Opportunity;
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

    private final Logger logger = LoggerFactory.getLogger(OpportunityServiceImpl.class);

    public void save(SalesRep salesRep) {
        //LLAMADA A MICROSERVICIO SALESREP
    }

    public SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException {
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
    }

    public void delete(Long id) throws InvalidParameterException, NoSuchElementException {
        //LLAMADA A MICROSERVICIO SALESREP
    }

    public SalesRep createSalesRep() {
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
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

        Lead lead = new Lead("Homer", "23678987", "homerjs@gmial.com", "Springfield");
        List<Lead> listLeads = new ArrayList<>();
        listLeads.add(lead);

        Contact contact = new Contact("Marge", "34567976", "margesimp@gmail.com", "Pretzel");
        Opportunity opportunity = new Opportunity(Product.BOX, 23, contact);
        List<Opportunity> listOpportunities= new ArrayList<>();
        listOpportunities.add(opportunity);

        SalesRep salesRep = new SalesRep("Gloria", listLeads, listOpportunities);
        salesRep.setId(1L);
        List<SalesRep> list = new ArrayList<>();
        list.add(salesRep);
        return list;
    }

    public List<Object[]> showLeadsBySalesRep(){
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
    }
    public List<Object[]> showOpportunitiesBySalesRep(){
        List<Object[]> opportunitiesList = contAccOppServiceClient.showOpportunitiesBySalesRep();
        // Aquí debería ir llamada al microservicio de Salesrep para rescatar el nombre del SalesRep con el id
        return opportunitiesList;

    }
    public List<Object[]> showClosedWonOpportunitiesBySalesRep(){
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
    }
    public List<Object[]> showClosedLostOpportunitiesBySalesRep(){
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
    }
    public List<Object[]> showOpenOpportunitiesBySalesRep(){
        //LLAMADA A MICROSERVICIO SALESREP
        return null;
    }
}
