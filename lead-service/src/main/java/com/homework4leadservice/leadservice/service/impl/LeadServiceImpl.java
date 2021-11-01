package com.homework4leadservice.leadservice.service.impl;

import com.homework4leadservice.leadservice.controller.DTO.LeadDTO;
import com.homework4leadservice.leadservice.model.Lead;
import com.homework4leadservice.leadservice.repository.LeadRepository;
import com.homework4leadservice.leadservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.FileAlreadyExistsException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    // pendiente de verificar el id del salesrep en el edge
    @Override
    public LeadDTO saveNewLead(LeadDTO leadDTO) throws ResponseStatusException {
        if (leadDTO.getId() != null) {
            if (leadDTO.getId() < 1) {
                throw new InvalidParameterException();
            }
            Optional<Lead> optionalLead = leadRepository.findById(leadDTO.getId());
            if (optionalLead.isPresent()) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The ID" + leadDTO.getId() + "already exists in the leads Database");


            } else {


                Lead lead = new Lead();
                lead.setId(leadDTO.getId());
                lead.setName(leadDTO.getName());
                lead.setPhoneNumber(leadDTO.getPhoneNumber());
                lead.setEmail(leadDTO.getEmail());
                lead.setCompanyName(leadDTO.getCompanyName());
                lead.setSalesRep(leadDTO.getSalesRep());
                leadRepository.save(lead);


            }
        }

        return leadDTO;
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public String deleteLeadById(long id) throws ResponseStatusException  {
        if(id < 1){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The ID provided must be 1 or greater");
        }
        leadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any lead"));
        leadRepository.deleteById(id);
        return "Lead with id " + id + " deleted";
    }




    @Override
    public Lead getLeadById(long id) throws ResponseStatusException {
        if (id < 1)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The ID provided must be 1 or greater");
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            return optionalLead.get();
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any lead");

    }


}

