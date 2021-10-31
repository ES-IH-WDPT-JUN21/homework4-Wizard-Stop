package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.model.Opportunity;

import java.util.List;

public interface OpportunityController {

    List<Opportunity> getAll();

    Opportunity findById(Long id);

    String closeLost(Long id);

    String closeWon(Long id);
}
