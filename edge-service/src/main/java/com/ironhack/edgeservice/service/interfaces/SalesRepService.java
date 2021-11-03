package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.SalesRep;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface SalesRepService {
    void save(SalesRep salesRep) throws ExistentElementException;

    SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    SalesRep createSalesRep();

    List<SalesRep> getAll();

    List<Object[]> showLeadsBySalesRep();

}
