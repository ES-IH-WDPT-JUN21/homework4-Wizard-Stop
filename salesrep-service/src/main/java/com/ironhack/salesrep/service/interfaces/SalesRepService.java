package com.ironhack.salesrep.service.interfaces;

import com.ironhack.salesrep.dto.SalesRepDTO;
import com.ironhack.salesrep.model.SalesRep;

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
