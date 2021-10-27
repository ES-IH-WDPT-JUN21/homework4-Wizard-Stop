package com.homework4leadservice.leadservice.service.interfaces;

import com.homework4leadservice.leadservice.controller.DTO.LeadDTO;
import com.homework4leadservice.leadservice.model.Lead;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface LeadService {
    LeadDTO saveNewLead(LeadDTO leadDTO);
    List<Lead> getAllLeads();
    String deleteLeadById(long id);
    Lead getLeadById(long id);

}
