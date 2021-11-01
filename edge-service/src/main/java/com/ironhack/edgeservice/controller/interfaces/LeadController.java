package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.LeadDTO;
import com.ironhack.edgeservice.model.Lead;

import java.util.List;

public interface LeadController {

    Lead getLeadById(long id);
    List<Lead> getAllLeads();
    LeadDTO saveNewLead(LeadDTO leadDTO);
    String deleteLeadById(long id);

}
