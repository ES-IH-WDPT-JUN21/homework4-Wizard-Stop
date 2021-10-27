package com.homework4leadservice.leadservice.controller.interfaces;

import com.homework4leadservice.leadservice.controller.DTO.LeadDTO;
import com.homework4leadservice.leadservice.model.Lead;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface LeadController {
    Lead getLeadById(long id);
    List<Lead> getAllLeads();
    LeadDTO saveNewLead(LeadDTO leadDTO);
    String deleteLeadById(long id);


}
