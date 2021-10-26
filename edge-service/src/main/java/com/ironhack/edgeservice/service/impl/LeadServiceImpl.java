package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.LeadServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.model.Lead;
import com.ironhack.edgeservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadServiceClient leadServiceClient;

    @Autowired
    SalesRepServiceClient salesRepServiceClient;

    public Lead findById(Long id){
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }

    public void deleteById(Long id)  {
        //LLAMADA A MICROSERVICIO LEAD
    }

    public void save(Lead lead)  {
        //LLAMADA A MICROSERVICIO LEAD
    }

    public List<Lead> getAll() {
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }

    public Lead createLead() {
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }
}
