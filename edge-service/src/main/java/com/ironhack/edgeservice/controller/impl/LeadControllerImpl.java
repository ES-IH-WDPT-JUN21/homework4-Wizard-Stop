package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.LeadController;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import com.ironhack.edgeservice.service.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    private LeadService leadService;
}
