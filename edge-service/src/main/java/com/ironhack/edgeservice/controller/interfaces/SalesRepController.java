package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.SalesRepDTO;
import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.SalesRep;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SalesRepController {

    SalesRep getSalesRepById(Long id);
    List<SalesRep> getAllSalesRep();
    void addSalesRep(SalesRepDTO salesRepDTO) throws ExistentElementException;
    void deleteSalesRep(Long id);
    void updateSalesRep(SalesRepDTO salesRepDTO);
}
