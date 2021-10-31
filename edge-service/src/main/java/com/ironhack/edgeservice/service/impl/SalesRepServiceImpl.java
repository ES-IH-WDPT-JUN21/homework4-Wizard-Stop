package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.model.SalesRep;
import com.ironhack.edgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepServiceClient salesRepServiceClient;

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

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

    public List<SalesRep> getAll(){
        return salesRepServiceClient.getAllSalesRep();
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
