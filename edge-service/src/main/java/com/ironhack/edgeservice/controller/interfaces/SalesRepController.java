package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.SalesRep;

import java.util.List;

public interface SalesRepController {

    List<Object[]> showOpportunitiesBySalesRep();
    SalesRep getSalesRepById(Long id);
    List<SalesRep> getAllSalesRep();
    void addSalesRep(SalesRep salesRep) throws ExistentElementException;
    void deleteSalesRep(Long id);
}
