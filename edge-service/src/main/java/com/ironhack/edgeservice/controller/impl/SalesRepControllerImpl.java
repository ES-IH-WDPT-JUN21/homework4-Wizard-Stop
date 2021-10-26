package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.SalesRepController;
import com.ironhack.edgeservice.service.interfaces.OpportunityService;
import com.ironhack.edgeservice.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesRepControllerImpl implements SalesRepController {


    @Autowired
    private SalesRepService salesRepService;
}
