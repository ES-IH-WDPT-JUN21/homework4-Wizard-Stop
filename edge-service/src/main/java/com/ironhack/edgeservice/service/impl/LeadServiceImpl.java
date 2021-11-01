package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.LeadServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.model.*;
import com.ironhack.edgeservice.service.interfaces.LeadService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadServiceClient leadServiceClient;

    @Autowired
    SalesRepServiceClient salesRepServiceClient;

    private final Logger logger = LoggerFactory.getLogger(LeadServiceImpl.class);

    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Lead findById(Long id) {
        return leadServiceClient.getLeadById(id);
    }

    public Lead findByIdFallback(Long id, Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        Lead newLead = new Lead("Tomás", "345987456", "tomaso@gmail.com", "LoadBalancer");
        newLead.setId(24L);
        return newLead;
    }

    public String deleteById(Long id)  {
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }

    public LeadDTO save(LeadDTO lead)  {
        //LLAMADA A MICROSERVICIO SALESREP ya que no se puede crear un Lead sin asignarle un sales Rep
        //hay que comprobar que el ID del Sales rep sea valido antes de crear el lead
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }

    @CircuitBreaker(name = "getAll", fallbackMethod = "getAllFallback")
    public List<Lead> getAll() {
        return leadServiceClient.getAllLeads();
    }

    public List<Lead> getAllFallback(Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        Lead newLead = new Lead("Fiona", "357087245", "fio_na@gmail.com", "Meredith");
        newLead.setId(2L);
        List<Lead> list = new ArrayList<>();
        list.add(newLead);
        return list;
    }

    public Lead createLead() {
        //LLAMADA A MICROSERVICIO LEAD
        return null;
    }

    public void convertLead() {
        //LLAMADA A MICROSERVICIO LEAD
        //LLAMADA A MICROSERVICIO CONTACT
        //LLAMADA A MICROSERVICIO ACCOUNT
        //LLAMADA A MICROSERVICIO OPPORTUNITY
    }
}
