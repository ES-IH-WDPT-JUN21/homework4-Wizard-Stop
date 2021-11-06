package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.client.LeadServiceClient;
import com.ironhack.edgeservice.client.SalesRepServiceClient;
import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.controller.dto.ContactDTO;
import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.enums.Status;
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

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

        Lead newLead = new Lead("Tomás", "345987456", "tomaso@gmail.com", "LoadBalancer", (long) 25);
        newLead.getId();
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
    public LeadDTO save(LeadDTO leadDTO) {

        Long salesRep = leadDTO.getSalesRep();

        if (salesRepServiceClient.getSalesRepById(salesRep) != null) {
            leadServiceClient.saveNewLead(leadDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The SalesRep id provided doesn't exists the Database");
        }

        return leadDTO;
    }

    public LeadDTO saveFallback(LeadDTO leadDTO, Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        LeadDTO newLeadDTO = new LeadDTO("Marco Antonio", "555446688", "marcoantonio@emperador.es", "Emperadores SA", (long) 5);

        return newLeadDTO;
    }

    // get all leads
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

        Lead newLead = new Lead("Fiona", "357087245", "fio_na@gmail.com", "Meredith", (long) 25);
        newLead.getId();
        List<Lead> list = new ArrayList<>();
        list.add(newLead);
        return list;
    }

    //convert Lead
    @CircuitBreaker(name = "convertLead", fallbackMethod = "convertLeadFallback")
    public String convertLead(Long id) {
        Lead leadToDelete = leadServiceClient.getLeadById(id);

        Contact contact = leadToDelete.convertLead();
        ContactDTO contactDTO = new ContactDTO(contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getCompanyName(), contact.getId());

        AccountDTO accountDTO = new AccountDTO();
        Account account = contAccOppServiceClient.store(accountDTO);

        OpportunityDTO opportunityDTO = new OpportunityDTO(Product.BOX, 5, Status.OPEN, leadToDelete.getSalesRep(), account.getId(), (long) 5);
        Opportunity opportunity = contAccOppServiceClient.add(opportunityDTO);

        leadServiceClient.deleteLeadById(leadToDelete.getId());
        contAccOppServiceClient.store(accountDTO);
        contAccOppServiceClient.store(contactDTO);
        contAccOppServiceClient.add(opportunityDTO);

        return "Lead with id" + leadToDelete.getId() + "converted to Opportunity";
    }

    public String convertLeadFallback(Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "The service you are trying to call is now unavailable. Try later";
    }
}






