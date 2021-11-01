package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.Lead;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface LeadService {

    Lead findById(Long id);
    String deleteById(Long id);
    LeadDTO save(LeadDTO leadDTO);
    List<Lead> getAll();
//    Lead createLead();
    void convertLead();
}
