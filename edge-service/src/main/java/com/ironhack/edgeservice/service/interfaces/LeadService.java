package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.Lead;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface LeadService {
    Lead findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void deleteById(Long id) throws InvalidParameterException, NoSuchElementException;

    void save(Lead lead) throws InvalidParameterException, ExistentElementException;

    List<Lead> getAll();

    Lead createLead();
}
