package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.SalesRepDTO;
import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.SalesRep;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface SalesRepService {


    SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    void addSalesRep(SalesRepDTO salesRepDTO);

    void changeSalesRep(SalesRepDTO salesRepDTO);

    List<SalesRep> getAll();

}
