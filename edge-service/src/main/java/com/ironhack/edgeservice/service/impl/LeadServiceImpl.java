package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.client.LeadServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.model.*;
import com.ironhack.edgeservice.service.interfaces.LeadService;
import com.netflix.discovery.converters.Auto;
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

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;


    private final Logger logger = LoggerFactory.getLogger(LeadServiceImpl.class);

    // find by id
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

    // delete by id
    @CircuitBreaker(name = "deleteById", fallbackMethod = "deleteByIdFallback")
    public String deleteById(Long id) {

        return leadServiceClient.deleteLeadById(id);

    }

    public String deleteByIdFallback(Long id, Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "The service you are trying to call is now unavailable. Try later";
    }

// save new lead
    @CircuitBreaker(name = "save", fallbackMethod = "saveFallback")
    public LeadDTO save(LeadDTO leadDTO)  {

        Long salesRep = leadDTO.getSalesRep();

        if (salesRepServiceClient.getSalesRepById(salesRep) != null) {
            leadServiceClient.saveNewLead(leadDTO);
        }else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The SalesRep id provided doesn't exists the Database");
        }

        return leadDTO;
    }

    public LeadDTO saveFallback(LeadDTO leadDTO, Exception e){
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        LeadDTO newLeadDTO = new LeadDTO((long)4, "Marco Antonio", "555446688","marcoantonio@emperador.es", "Emperadores SA", (long)5);

        return newLeadDTO;
    }

    // get all leads
        @CircuitBreaker(name = "getAll", fallbackMethod = "getAllFallback")
        public List<Lead> getAll () {
            return leadServiceClient.getAllLeads();
        }

        public List<Lead> getAllFallback (Exception e){
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



        public void convertLead () {


            //LLAMADA A MICROSERVICIO LEAD
            //LLAMADA A MICROSERVICIO CONTACT
            //LLAMADA A MICROSERVICIO ACCOUNT
            //LLAMADA A MICROSERVICIO OPPORTUNITY
        }
    }

