package com.ironhack.salesrep.service.interfaces;

import com.ironhack.salesrep.dto.SalesRepNameDTO;
import com.ironhack.salesrep.model.SalesRep;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface SalesRepService {

    SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    void addSalesRep(SalesRepNameDTO salesRepNameDTO);

    void changeSalesRep(Long id, SalesRepNameDTO salesRepNameDTO);

    List<SalesRep> getAll();

}
